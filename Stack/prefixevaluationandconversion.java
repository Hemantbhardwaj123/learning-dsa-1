package Stack;

import java.util.*;

public class prefixevaluationandconversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        Stack<Integer> vs = new Stack<>();
        Stack<String> is = new Stack<>();
        Stack<String> ps = new Stack<>();
        for (int i = exp.length() - 1; i > 0; i--) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int vs1 = vs.pop();
                int vs2 = vs.pop();
                int val = operation(vs1, vs2, ch);
                vs.push(val);

                String is1 = is.pop();
                String is2 = is.pop();
                String isval = "(" + is1 + ch + is2 + ")";
                is.push(isval);

                String ps1 = ps.pop();
                String ps2 = ps.pop();
                String psval = ps1 + ps2 + ch;
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
// dodnt know the poblem