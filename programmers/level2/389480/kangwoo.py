def solution(info, n, m):
    answer = -1
    check_dup = dict()
    def dfs(idx, clue_a, clue_b, steal):
        if clue_a >= n or clue_b >= m: return [clue_a, -1]
        if idx == len(info): return [clue_a, steal]
        if (clue_a, clue_b, steal) in check_dup: 
            return check_dup[(clue_a, clue_b, steal)]
        
        clue_ab, steal_b = dfs(idx+1, clue_a, clue_b + info[idx][1], steal+1)
        clue_aa, steal_a = dfs(idx+1, clue_a + info[idx][0], clue_b, steal+1)
        if steal_a > steal_b:
            check_dup[(clue_a, clue_b, steal)] =  [clue_aa, steal_a] 
            return [clue_aa, steal_a]
        if steal_b > steal_a:
            check_dup[(clue_a, clue_b, steal)] =  [clue_ab, steal_b]
            return [clue_ab, steal_b]
        check_dup[(clue_a, clue_b, steal)] = [min(clue_aa, clue_ab), steal_a]
        return [min(clue_aa, clue_ab), steal_a]
                
    clue_a, steal = dfs(0, 0, 0, 0)
    if steal <= 0: return -1
    return clue_a