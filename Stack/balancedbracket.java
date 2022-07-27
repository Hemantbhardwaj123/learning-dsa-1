package Stack;

import java.util.*;

public class balancedbracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch== '{' ||ch== '[') {
                st.push(ch);
            }else if(ch== ')'){
               boolean val= handleClosing(st,'(');
               if(val==false){
                System.out.println(val);
                return;
               }
            }else if(ch== '}'){
                boolean val=handleClosing(st,'{');
                if(val==false){
                    System.out.println(val);
                    return;
                }
            }else if(ch== ']'){
                boolean Val=!handleClosing(st,'[');
                 if(Val==false){
                    System.out.println(Val);
                    return;}
            }else{

            }
        }
        if(st.size()=='0'){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
    

    public static boolean handleClosing(Stack<Character> st ,char chooseochar){
        if(st.size()=='0'){
           return false;
        }else if(st.peek() != chooseochar){
            return false;
        }else {
            st.pop();
            return true ;
        }
    } 
}


// problem answer not sahi
