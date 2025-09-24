class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] count = new int[players.length];
        for(int i = 0; i < players.length; i++) {
            int temp = players[i] / m;
            if (temp > count[i]){
                int server = temp - count[i];
                answer = answer + server;
                for (int j = 0; j < k; j++) {
                    if (i + j < players.length) {
                        count[i + j] = count[i + j] + server;
                    }
                }
            }
        }

        return answer;
    }
}
