class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int time = 0;

        for(char letter: tasks){
            freq[letter - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num: freq){
            if (num > 0) maxHeap.offer(num);
        }

        while (!maxHeap.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i <= n; i++){
                if (!maxHeap.isEmpty()){
                    int f = maxHeap.poll();
                    f--;
                    if (f > 0){
                        list.add(f);
                    }
                }
                time ++;
                if (maxHeap.isEmpty() && list.isEmpty()) {
                    break;
                }
            }
            for (int f : list) {
                maxHeap.offer(f);
            }
        }
        return time;
    }

}