class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(List.of(1));
        for (int i = 1; i < numRows; i++){
            ans.add(new ArrayList<>());
            List<Integer> prev = ans.get(i-1);

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ans.get(i).add(1);
                } else {
                    ans.get(i).add(prev.get(j-1) + prev.get(j));
                }
            }

        }
        return ans;

    }


}