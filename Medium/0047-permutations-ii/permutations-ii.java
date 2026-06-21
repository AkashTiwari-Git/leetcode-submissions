class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] arr, boolean[] used, ArrayList<Integer> list, List<List<Integer>> result){
        if (list.size() == arr.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < arr.length; i++){
            if (used[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            list.add(arr[i]);
            backtrack(arr, used, list, result);
            used[i] = false;
            list.removeLast();
        }
    }

}