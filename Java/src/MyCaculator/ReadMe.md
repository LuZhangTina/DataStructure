### Using Stack to implement a simple caculator.

The caculator only support unsigned int's add, minus, multiply, divide operator

eg: cal.caculator("10*2+20*3-80/2*5");  
    cal.caculator("102/2+20*3-80/2*5");  
    cal.caculator("102/02+20*3-80/2*5+5-2");  

Using two stacks to store data and operator separetely  
Befor the new operator is pushed into stack, we need to compare if the priority of the top operator in the stack is higher than or equal with the new one.  
If it's true, then caculate the value in the current stack, until the new operator can be pushed into stack.   
