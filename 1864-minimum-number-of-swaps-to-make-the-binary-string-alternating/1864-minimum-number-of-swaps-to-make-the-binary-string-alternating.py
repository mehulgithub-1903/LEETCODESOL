class Solution(object):
    def minSwaps(self, s):
        n=len(s)
        if n%2==0:
            if s.count("1")==s.count("0"):
                ans=10000
                moves=0
                t1=str()
                t2=str()
                for i in range(n):
                    if i%2==0:
                        t1+="1"
                        t2+="0"
                    if i%2==1:
                        t1+="0"
                        t2+="1"
                
                for i in range(n):
                    if s[i]=='1' and t1[i]=='0':moves+=1
                ans=min(ans,moves)

                moves=0
                
                for i in range(n):
                    if s[i]=='1' and t2[i]=='0':moves+=1
                # print(moves)
                ans=min(ans,moves)
    
                return ans

            else:
                return -1
        if n%2==1:
            if abs(s.count("1")-s.count("0"))==1:
                ans=10000
                moves=0
                t1=str()
                t2=str()
                for i in range(n):
                    if i%2==0:
                        t1+="1"
                        t2+="0"
                    if i%2==1:
                        t1+="0"
                        t2+="1"
                
                if(t1.count("0")==s.count("0")):
                    for i in range(n):
                        if s[i]=='1' and t1[i]=='0':moves+=1
                    ans=min(ans,moves)
                    return ans
                if(t2.count("0")==s.count("0")):
                
                    for i in range(n):
                        if s[i]=='1' and t2[i]=='0':moves+=1
                    ans=min(ans,moves)
                    return ans

            else:
                return -1
        