package Stack;

import java.util.*;
import java.io.*;
public class infixevaluation {
    public static void main(String[] args) throws Exception {
       Scanner sc=new Scanner(System.in);
       String exp=sc.nextLine();
        Stack<Integer> opators=new Stack<>();
        Stack<Character> operands=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);

            if(ch == '('){
                opators.push(ch);
            }else if(ch == Character.isDigit(ch)){
                operands.push(ch-'0');
            }else if(ch == ')'){
                while(opators.peek() !='('){
                    int optor=opators.pop();
                    int v2=operands.pop();
                    int v1=operands.pop();
                    int opv=operation(v1,v2,opator);
                    opators.push(opv);
                }
                opators.pop();
            }else if(ch== '+' || ch=='-' || ch== '*' || ch=='/'){
                while(opators.size()>0 && precedence(ch)<=precedence(opators.peek())
                && opators.peek()=='('){
                    while(opators.peek() !='('){
                        int optor=opators.pop();
                        int v2=operands.pop();
                        int v1=operands.pop();
                        int opv=operation(v1,v2,opator);
                        opators.push(opv); 
                }
                opators.push(ch);
            }
            while(opators.peek() !='('){
                int optor=opators.pop();
                int v2=operands.pop();
                int v1=operands.pop();
                int opv=operation(v1,v2,opator);
                operands.push(opv); 
        }
            System.out.println(operands.peek());
    }
    }

    public static int precedence(char opator) {
        if (opator == '+') {
            return 1;
        } else if (opator == '-') {
            return 1;
        } else if (opator == '*') {
            return 2;
        } else if (opator == '/') {
            return 2;
        } else {
            return 0;
        }
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
