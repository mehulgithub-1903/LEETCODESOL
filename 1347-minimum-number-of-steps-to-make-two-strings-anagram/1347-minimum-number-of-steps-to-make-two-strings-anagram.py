class Solution(object):
    def minSteps(self, s, t):
        
        mp={}
        for x in s:
            if x in mp:mp[x]+=1
            else:mp[x]=1
        ans=0
        
        for x in t:
            if x in mp and mp[x]!=0:
                mp[x]-=1
        for x in mp:
            ans+=mp[x]
        return ans
                