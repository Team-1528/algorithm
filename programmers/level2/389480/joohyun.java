import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] info, int n, int m) {
           int answer = -1;
        List<int[]> allSum = new ArrayList<>();
        allSum.add(new int[]{0, 0});
        for (int i = 0; i < info.length; i++) {
            List<int[]> newSum = new ArrayList<>();
            for (int[] set : allSum) {
                if(info[i][0] + set[0] < n) {
                    newSum.add(new int[]{info[i][0] + set[0], set[1]});
                }
                if(info[i][1] + set[1] < m) {
                    newSum.add(new int[]{set[0], info[i][1] + set[1]});
                }
            }
            allSum = newSum;
        }

        for (int[] i : allSum) {
            if (answer == -1 || answer > i[0]) {
                answer = i[0];
            }
        }

        return answer;
    }
}
