class Solution(object):
    def largestOverlap(self, img1, img2):
        
            n=len(img1)
            
            a=[]
            b=[]
            
            for i in range(n):
                for j in range(n):
                    if img1[i][j] == 1:
                        a.append((i,j))
                    if img2[i][j] == 1:
                        b.append((i,j))
            
            mp={}
            ans=0
            for x in a:
                for y in b:
                    key=x[0]-y[0],x[1]-y[1]
                    if key in mp:
                        mp[key]+=1
                    else:mp[key]=1
                   
                    ans=max(ans,mp[key])
            
            return ans   
                    
            
        # """
        # :type img1: List[List[int]]
        # :type img2: List[List[int]]
        # :rtype: int
        # """
        