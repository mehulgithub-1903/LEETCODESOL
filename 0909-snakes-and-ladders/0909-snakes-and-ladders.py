from collections import deque
class Solution(object):
    def snakesAndLadders(self, board):
        
        mp={}
        n=len(board)
        for i in range(n-1,-1,-1):
            k=n-1-i
            for j in range(1,n+1,1):
                if k%2==0:
                    num=k*n+j
                    if board[i][j-1]!=-1:
                        mp[num]=board[i][j-1]
                else:
                    num=k*n+(n-j+1)
                    if board[i][j-1]!=-1:
                        mp[num]=board[i][j-1]          
        # print("he;llp")
        # print(mp)
        q=deque()
        q.append(1)
        level=0
        visited=set()
        visited.add(1)
        while len(q)!=0:
            s=len(q)
            level+=1
            for i in range(0,s):
                x=q.popleft()
                for j in range(1,7):
                    nc=x+j
                    if nc in mp:
                        nc=mp[nc]
                    
                    if nc==n*n:return level

                    if nc not in visited:
                            q.append(nc)
                            visited.add(nc)

        return -1                        