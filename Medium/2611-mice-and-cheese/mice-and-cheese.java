class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i< reward2.length; i++){
            ans += reward2[i];
            maxHeap.offer(reward1[i] -reward2[i]);
        }

        for (int i = 0 ; i < k ;i++){
            ans += maxHeap.poll();
        }
        return ans;
    }
}