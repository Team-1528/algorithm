import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> results = new ArrayList<>();

    public int solution(int n, int[][] q, int[] ans) {
        for (int i : ans) {
            if (i == 5)
                return 1;
        }

        List<Integer> current = new ArrayList<>();
        getPassword(q, ans, current, n, 1);

        return results.size();
    }

    public void getPassword(int[][] q, int[] ans, List<Integer> current, int max, int n) {
        if (current.size() == 5) {
            if (isPossible(q, ans, current)) {
                results.add(current.toString());
            }
            return;
        }

        for (int i = n; i <= max; i++) {
            current.add(i);
            getPassword(q, ans, current, max, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public boolean isPossible(int[][] q, int[] ans, List<Integer> currentAns) {
        for (int k = 0; k < q.length; k++) {
            int num = 0;
            for (int j : q[k]) {
                if (currentAns.contains(j)) {
                    num += 1;
                    if (num > ans[k]) {
                        return false;
                    }
                }
            }

            if (num != ans[k])
                return false;
        }
        return true;
    }
}