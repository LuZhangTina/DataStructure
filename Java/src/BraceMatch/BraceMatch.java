import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by tina on 2019/1/17.
 */
public class BraceMatch {
    private Stack<Character> stackChar;
    private Map<Character, Character> braceMap;

    public BraceMatch(){
        stackChar = new Stack<Character>();
        braceMap = new HashMap<Character, Character>();
        braceMap.put('{', '}');
        braceMap.put('[', ']');
        braceMap.put('(', ')');
    }

    public boolean braceMatch(String expression) {

        for (int index = 0; index < expression.length(); index++) {
            // if the current char is '{', '[' or '(', push it to stack
            if (braceMap.containsKey(expression.charAt(index))) {
                stackChar.push(expression.charAt(index));
            }
            // if the current char is '}', ']' or ')', compare it with the top element in stack
            else if (braceMap.containsValue(expression.charAt(index))) {
                if (stackChar.isEmpty()) {
                    return false;
                }else {
                    if(braceMap.get(stackChar.pop()) != expression.charAt(index)) {
                        stackChar.clear();
                        return false;
                    }
                }
            }
            // other character do nothing
            else {
                //do nothing
            }
        }//end of for

        if (!(stackChar.isEmpty())) {
            stackChar.clear();
            return false;
        }

        return true;
    }
}
