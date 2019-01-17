import java.util.Stack;

import static com.tina.stack.Operator.*;

/**
 * Created by tina on 2019/1/17.
 */
enum Operator {
    ADD,
    MINUS,
    MULTIPLY,
    DIVIDE
}

public class MyCaculator {
    private Stack<Integer> stackNumber;
    private Stack<Operator> stackOperator;

    public MyCaculator() {
        stackNumber = new Stack<Integer>();
        stackOperator = new Stack<Operator>();
    }

    private void calculateForCurrentStack() throws RuntimeException {
        if (stackNumber.size() < 2) {
            throw new RuntimeException();
        }

        if (stackOperator.size() < 1) {
            throw new RuntimeException();
        }

        int num2 = stackNumber.pop();
        int num1 = stackNumber.pop();
        Operator op = stackOperator.pop();

        switch (op) {
            case ADD:
                stackNumber.push(num1 + num2);
                return;
            case MINUS:
                stackNumber.push(num1 - num2);
                return;
            case MULTIPLY:
                stackNumber.push(num1 * num2);
                return;
            case DIVIDE:
                stackNumber.push(num1 / num2);
                return;
            default:
                return;
        }
    }

    private void operatorInStack(Operator operator) {
        Operator opInStackTop;

        if (stackOperator.isEmpty()) {
            stackOperator.push(operator);
            return;
        }

        opInStackTop = stackOperator.peek();
        if (operator == DIVIDE || operator == MULTIPLY) {
            if (opInStackTop == ADD || opInStackTop == MINUS) {
                stackOperator.push(operator);
                return;
            }else {
                calculateForCurrentStack();
                operatorInStack(operator);
            }
        }else {
            calculateForCurrentStack();
            operatorInStack(operator);
        }
    }

    public int caculator(String expression) throws RuntimeException {
        int index = 0;
        int number = 0;
        Operator operator;

        while(index < expression.length()) {
            if (expression.charAt(index) >= '0' && expression.charAt(index) <= '9') {
                number = number * 10 + (expression.charAt(index) - '0');
            }else{
                stackNumber.push(number);
                number = 0;

                switch (expression.charAt(index)) {
                    case '+':
                        operator = ADD;
                        break;
                    case '-':
                        operator = MINUS;
                        break;
                    case '*':
                        operator = MULTIPLY;
                        break;
                    case '/':
                        operator = DIVIDE;
                        break;
                    default:
                        throw new RuntimeException();
                }

                operatorInStack(operator);
            }
            index++;
        }

        stackNumber.push(number);
        number = 0;
        calculateForCurrentStack();

        if (stackNumber.size() == 2 && stackOperator.size() == 1) {
            calculateForCurrentStack();
            return stackNumber.pop();
        }else if (stackNumber.size() == 1 && stackOperator.isEmpty()) {
            return stackNumber.pop();
        }

        stackNumber.clear();
        stackOperator.clear();
        throw new RuntimeException();
    }
}
