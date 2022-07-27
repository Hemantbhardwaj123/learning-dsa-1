package Stack;

import java.beans.Expression;
import java.util.*;

public class postfixevaluationandconversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        Stack<Integer> vs = new Stack<>();
        Stack<String> is = new Stack<>();
        Stack<String> ps = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int vs2 = vs.pop();
                int vs1 = vs.pop();
                int val = operation(vs1, vs2, ch);
                vs.push(val);

                String is2 = is.pop();
                String is1 = is.pop();
                String isval = "(" + is1 + ch + is2 + ")";
                is.push(isval);

                String ps2 = ps.pop();
                String ps1 = ps.pop();
                String psval = ch + ps1 + ps2;
                ps.push(psval);
            } else {
                vs.push(ch - '0');
                is.push(ch + "");
                ps.push(ch + "");
            }
        }
        System.out.println(vs.pop());
        System.out.println(is.pop());
        System.out.println(ps.pop());
    }

    public static int operation(int v1, int v2, char opator) {
        if (opator == '+') {
            return v1 + v2;
        } else if (opator == '-') {
            return v1 - v2;
        } else if (opator == '*') {
            return v1 * v2;
        } else if (opator == '/') {
            return v1 / v2;
        } else {
            return 0;
        }
    }
}
