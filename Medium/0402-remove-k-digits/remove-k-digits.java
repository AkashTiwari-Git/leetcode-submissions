class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        String ans = "";
        for (int i = 0; i < num.length(); i++){
            char current = num.charAt(i);
            while(!stack.isEmpty() && k > 0 && stack.peek() - 48 > current - 48){
                stack.pop();
                k--;
            }
            stack.push(current);
        }
        while(k >0){
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        ans = new StringBuilder(ans).reverse().toString();
        
        int j=0;
        while(ans.length() > 0 && ans.charAt(j) == '0'){
            ans = ans.substring(1);
        }
        if (ans.isEmpty()){
            return "0";
        }

        return ans;
    }
}