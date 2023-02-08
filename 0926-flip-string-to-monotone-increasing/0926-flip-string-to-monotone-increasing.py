class Solution(object):
    def minFlipsMonoIncr(self, s):
    
        cs=0
        ts=s.count('1')
        n=len(s)
        ans=100000000
        for i in range(n):
            if s[i]=='1': cs+=1
            
            rs=ts-cs
            elements=n-(i+1)
            zeros=elements-rs
            flips=cs+zeros
            ans=min(flips,ans)
        
        ans=min(ans,ts)
        ans=min(ans,n-ts)

        return ans