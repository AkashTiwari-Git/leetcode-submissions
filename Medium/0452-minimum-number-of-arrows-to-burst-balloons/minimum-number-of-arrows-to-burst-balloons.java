class Solution {
    public int findMinArrowShots(int[][] points) {
        int arrow = 1;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        int arrowPosition = points[0][1];

        for (int i = 0; i < points.length; i++){
            while (points[i][0] > arrowPosition){
                arrow++;
                arrowPosition = points[i][1];
            }
        }
        return arrow;
    }
}