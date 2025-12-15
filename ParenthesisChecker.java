public class ParenthesisChecker{
//Daniel Tiso
//Date 11/8/25
//This program checks if parentheses in a string are valid.
//  Pre-condition: input contains only (), {}, []
 //  Post-condition: prints "Valid" or "Invalid" depending on if bracket sequence is properly matched.
    public static void isValid(String input){
        // Make a forward copy and a reverse copy
        String forward=input;
        String reverse="";
        int x=input.length();
        boolean changedPairs = true;
        while (changedPairs) {
        changedPairs = false;
        if (forward.contains("()")) { forward = forward.replace("()", ""); changedPairs = true; }
        if (forward.contains("[]")) { forward = forward.replace("[]", ""); changedPairs = true; }
        if (forward.contains("{}")) { forward = forward.replace("{}", ""); changedPairs = true; }
        }
        while(x>0){
            reverse+=input.substring(x-1,x);
            x--;
        }
        //This Loops until the string can’t change anymore
        boolean changed=true;
        while (changed){
            changed =false;
            if (forward.length()<=1) break;
            String first=forward.substring(0,1);
            String needed="";
            // Determine which closing bracket we expect
            if (first.equals("(")) needed=")";
            else if (first.equals("[")) needed="]";
            else if (first.equals("{")) needed="}";
            else break;
            // Look for that closing bracket's position in reverse string
            int closePos=reverse.indexOf(needed);
            if(closePos>=0){
                reverse=reverse.substring(0,closePos)+reverse.substring(closePos+1);
                int matchIndex=forward.length()-1-closePos;
                 //Remove closing bracket in forward
                forward=forward.substring(0, matchIndex)+forward.substring(matchIndex+1);
                // Remove the opening bracket from front
                forward=forward.substring(1);
                 // Remove the mirrored opening bracket in reverse
                reverse=reverse.substring(0,reverse.length()-1);
                changed=true;
            }
        }
        if (forward.length()==0){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
    //Testing
    public static void main(String[] args){
        isValid("([{}])");
        isValid("[})})]");
        isValid("{[()]}()");
        isValid(")[]{})");
    }
}
