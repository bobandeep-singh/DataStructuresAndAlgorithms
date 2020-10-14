/**
 * 
 */
package boban.dsa.stack.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author "Bobandeep Singh"
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("([{}])"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("{({})}[(){}]"));
		
		System.out.println(isValid("([)"));
		System.out.println(isValid("()[][]]]]"));
		System.out.println(isValid("(){{]}}}"));
		System.out.println(isValid("()[][][]{{"));
		
	}
	
    public static boolean isValid(String s) {
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
        
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else {
                if(stack.size() == 0) return false;
                
                if( null != mappings.get(c) &&  mappings.get(c).equals(stack.pop()) )
                    continue;
                else
                    return false;
            }
            
        }

        return stack.size() == 0;
    }
}
