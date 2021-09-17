import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class Algorithm1 {
    public static boolean BalancedBrackets(File f) throws Exception{
        Stack<Character> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new FileReader(f));
        int c;
        while ((c = br.read()) != -1){
            char character = (char) c;
            if(character == '(' || character == '{' || character == '[') {
                stack.push(character);
            }

            char checked;
            switch (character) {
                case '}' -> {
                    checked = stack.pop();
                    if (checked != '{') return false;
                }
                case ']' -> {
                    checked = stack.pop();
                    if (checked != '[') return false;
                }
                case ')' -> {
                    checked = stack.pop();
                    if (checked != '(') return false;
                }
            }
        }
        br.close();
        return stack.isEmpty();


    }
}
