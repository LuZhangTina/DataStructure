### Using Stack and Map to solve brace match problem

eg: in the string "hello{[de]}df(df)", '{', '[', '(' are matched with '}', ']', ')', result is true    
    in the string "hello{[de]}df(df}", the last '(' mismatches with '}', result is false  

Using a map to save the relation of '{', '}', '[', ']', '(', ')'    
['{', '}']  
['[', ']']  
['(', ')']  

Using stack to save '{', '[', '('  

scan the string, if the char is '{', '[', '(', push it to stack  
if the char is '}', ']', ')', pop the top char of stack  
using the top char as key to get the related value in map  
if the value equals to the current char in string, continue  
if not, the string is not a brace matched string  

after scanning the string, check if the stack is empty, if it's true, the string is a brace matched string.  
Otherwise, it's not a brace matched string.  
