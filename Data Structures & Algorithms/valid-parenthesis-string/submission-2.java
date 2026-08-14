class Solution {
    public boolean checkValidString(String s) {
        // int open = 0, close = 0, star = 0;
        // int diff;
        // for(int i=0;i<s.length();i++) {
        //     if(s.charAt(i) == '(')
        //     open++;
        //     else if(s.charAt(i) == ')')
        //     close++;
        //     else
        //     star++;
        // }
        // if(open > close) 
        //     diff = open-close;
        // else if(open == close)
        //     return true;
        // else
        //     diff = close-open;

        // if(star >= diff)
        // return true;

        // return false;

        int leftMin = 0, leftMax = 0;
        for(char c: s.toCharArray()) {
            if( c == '(')
            {
                leftMin++;
                leftMax++;
            } else if(c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if(leftMax < 0) 
                return false; // because this mean so far all the left paranthesis are balanced and there's one right paranthesis that is still open which can't be balanced anymore, no matter what chracaters come after it
            if(leftMin < 0) {
                leftMin = 0;
            }
            }
            return leftMin == 0;
        }
    }

