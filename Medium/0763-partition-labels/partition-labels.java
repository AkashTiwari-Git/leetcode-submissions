class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        // finding the last occurrence of every character
        for (int i = 0; i < s.length(); i ++){
            map.put(s.charAt(i), i);
        }
        int left = 0; int right = map.get(s.charAt(left));
        for (int i = 0; i < s.length(); i++){

            right = Math.max(right, map.get(s.charAt(i)));
            if (i == right){
                ans.add(right - left + 1);
                left = i + 1;
            }
        }

        return ans;
    }
}