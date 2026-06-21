class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int start = 1;
        List<List<Integer>> result = new ArrayList<>();
        helper(start, n , k,result, new ArrayList<>());
        return result;
    }

    private static void helper(int start, int end, int k, List<List<Integer>> result, ArrayList<Integer> processed) {
        if (processed.size() == k){
            result.add(new ArrayList<>(processed));
            return;
        }
        
        for (int i = start; i <= end; i ++){
            processed.add(i);
            helper(i + 1, end, k , result, processed);
            processed.removeLast();
        }
    }
}