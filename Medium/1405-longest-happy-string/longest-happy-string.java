class Solution {
    static class Letter{
        char letter ;
        int value;

        Letter(char letter, int value){
            this.letter = letter;
            this.value = value;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
 PriorityQueue<Letter> heap = new PriorityQueue<>((x,y)->Integer.compare(y.value, x.value));
        if (a > 0) heap.add(new Letter('a', a));
        if (b > 0) heap.add(new Letter('b', b));
        if (c > 0) heap.add(new Letter('c', c));
        String ans = "";
        char last = '#';
        int consecutive = 0;

        while (!heap.isEmpty()) {
            Letter first = heap.poll();

            if (first.letter == last && consecutive == 2) {
                // Can't use first.
                if (heap.isEmpty()) break;

                Letter second = heap.poll();

                ans += second.letter;
                second.value--;

                if (second.value > 0)
                    heap.offer(second);

                heap.offer(first);

                last = second.letter;
                consecutive = 1;
            } else {
                ans += first.letter;
                first.value--;

                if (first.value > 0)
                    heap.offer(first);

                if (first.letter == last)
                    consecutive++;
                else {
                    last = first.letter;
                    consecutive = 1;
                }
            }
        }
        return ans;
    }
}