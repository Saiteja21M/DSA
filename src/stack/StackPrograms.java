package stack;

public class StackPrograms {

    public static String reverseString(String text) {
        
        Stack<Character> stack = new Stack<>();
        for(char c : text.toCharArray()){
            stack.push(c);
        }
        
        String reversedString = "";
        
        while(!stack.isEmpty()) {
            reversedString += stack.pop();
        }
        
        return reversedString;
    }
    
}
