
public class ParenthesisChecker{

    public static void isVaild(String input){
        String forward=input;
        String reverse="";
        int x=input.length();
        while(x>0){
            reverse+=input.substring(x-1,x);
            x--;
        }
        boolean changed=true;
        while (changed){
            changed =false;
            if (forward.length()<=1) break;
            String first=forward.substring(0,1);
            String needed="";
            if (first.equals("(")) needed=")";
            else if (first.equals("[")) needed="]";
            else if (first.equals("{")) needed="}";
            else break;
            intclosePos=reverse.indexOf(needed);
            if(closePos>=0){
                reverse=reverse.substring(0,closePos)+reverse.substring(closePos+1);
                int matchIndex=forward.length()-1-closePos;
                forward=forward.substring(0, matchIndex)+forward.substring(matchIndex+1);
                forward=forward.sunstring(1);
                reverse=reverse.substring(0,reverse.length()-1);
                changed=true;
            }
        }
        if (forward.length()==0){
            System.out,println("Valid");
        }else{
            System.out.println(Invalid");
        }
    }
    PublicStatic void main(String[] args){
        isValid("([{}])");
        isValid("[})})]");
        isValid("{[()]}()");
        isValid(")[]{})");
    }
}
