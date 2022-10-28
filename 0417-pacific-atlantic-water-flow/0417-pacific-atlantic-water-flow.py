
from collections import deque
class Solution(object):
    def waterInOcean(self,ocean,heights,rows,cols,visited,q):
        dr=[0,0,1,-1]
        dc=[-1,1,0,0]
        while len(q)!=0:
            s=len(q)
            # print("Here")
            for i in range(s):
                # print("Hereww")
                x=q.pop()
                ocean[x[0]][x[1]]=True
                for i in range(4):
                    nr=x[0]+dr[i]
                    nc=x[1]+dc[i]

                    if nr<rows and nc<cols and nr>=0 and nc>=0 and (not visited[nr][nc]) and heights[nr][nc]>=heights[x[0]][x[1]]:
                        q.append((nr,nc))
                        visited[nr][nc]=True;



    def pacificAtlantic(self, heights):

        rows=len(heights)
        cols=len(heights[0])
        pacific=[[False for x in range(cols)] for y in range(rows)]
        atlantic=[[False for x in range(cols)] for y in range(rows)]
        visited=[[False for x in range(cols)] for y in range(rows)]
        q=deque()

        # q.append((0,0))
        # water in these cells will surely go in pacific
        for i in range(0,cols):
            q.append((0,i))
            visited[0][i]=True
        for i in range(0,rows):
            if not visited[i][0]:
                q.append((i,0))
                visited[i][0]=True

        self.waterInOcean(pacific,heights,rows,cols,visited,q)                    

        visited=[[False for x in range(cols)] for y in range(rows)]
        q=deque()
        # water in these cells wil surely go in atlantic
        for i in range(cols):
            q.append((rows-1,i))
            visited[rows-1][i]=True
        for i in range(rows):
            if not visited[i][cols-1]:
                q.append((i,cols-1))
                visited[i][cols-1]=True        

        self.waterInOcean(atlantic,heights,rows,cols,visited,q) 

        # ans will be the intersection of cells who are true in pacific matrix (meaning there water will flow in pacific)
        # and are also true in atlantic matrix (meaning there will also flow in atlantic)

        ans=[]
        for k in range(rows):
            for e in range(cols):
                if pacific[k][e]==True and atlantic[k][e]==True:
                    ans.append((k,e))

        return ans




