class Solution {
    public boolean isPalindrome(String str) {
        int s=0, e=str.length()-1;
        while(s<e){
            char start = str.charAt(s);
            char end = str.charAt(e);

            if(!Character.isLetterOrDigit(start)) s++;
            else if(!Character.isLetterOrDigit(end)) e--;
            else{
                char l1 = Character.toLowerCase(str.charAt(s));
                char l2 = Character.toLowerCase(str.charAt(e));

                if(l1!=l2) return false;
                s++;e--;
            }
            
        }
        return true;
    }
}
