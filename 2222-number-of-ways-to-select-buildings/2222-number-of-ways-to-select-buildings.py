class Solution(object):
    def numberOfWays(self, s):
        n=len(s)
        lz=[0]*n
        rz=[0]*n
        lo=[0]*n
        ro=[0]*n

        lz[0] = (1 if s[0]=='0' else 0)
        lo[0] = (1 if s[0]=='1' else 0)

        # print(lz[0])
        for i in range(1,n):
            lz[i]=(lz[i-1]+1 if s[i]=='0' else lz[i-1])
            lo[i]=(lo[i-1]+1 if s[i]=='1' else lo[i-1])
        
        rz[n-1] = 1 if s[n-1]=='0' else 0
        ro[n-1] = 1 if s[n-1]=='1' else 0

        for i in range(n-2,-1,-1):
            rz[i]=rz[i+1]+1 if s[i]=='0' else rz[i+1]
            ro[i]=ro[i+1]+1 if s[i]=='1' else ro[i+1]
        ans=0
        # print(rz)
        # print(lz)
        for i in range(n):
            if s[i]=='1':
                ans+=lz[i]*rz[i]
            else:
                ans+=ro[i]*lo[i]
        
        return ans
        """
        :type s: str
        :rtype: int
        """