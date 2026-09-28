class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int counter = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(ch);
                counter++;
            } else if (ch==')'){
                stack.pop(); counter--;
            }
            max = Math.max(max, counter);
        }
        return max;
    }
}