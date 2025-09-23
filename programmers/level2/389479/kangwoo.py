import collections

def solution(players, m, k):
    answer = 0
    currentServer = 0
    prevServer = {}
    
    for idx in range(0, 24):
        player = players[idx]
        needServer = player // m - currentServer
        if needServer > 0: 
            answer += needServer
            currentServer += needServer
            prevServer[idx] = needServer
        else:
            prevServer[idx] = 0
        
        if idx - k + 1 >= 0: currentServer -= prevServer[idx - k + 1]

    return answer