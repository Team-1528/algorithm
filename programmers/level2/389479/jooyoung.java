class Solution {
    private static final int HOURS_IN_DAY = 24;
    
    public int solution(int[] players, int m, int k) {
        int[] expanded = new int[HOURS_IN_DAY];
        int answer = 0;
        
        for(int i = 0; i < HOURS_IN_DAY; i++) {
            int player = players[i];
            if (player < m) {
                continue;
            }
            
            int expects = (int) (player / m);
            if (expects <= expanded[i]) {
                continue;
            }
                    
            int needs = expects - expanded[i];
            answer += needs;
                
            for (int j = i; j < i + k; j++) {
                if (j >= HOURS_IN_DAY) { 
                    break;
                }
                expanded[j] += needs;
            }
            
        }
        
        return answer;
    }
}
