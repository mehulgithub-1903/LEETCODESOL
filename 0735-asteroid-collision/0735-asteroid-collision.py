from collections import deque
class Solution(object):
    def asteroidCollision(self, a):
        
        st=deque()
        for element in a:
            if len(st)==0:
                st.append(element)
            
            else:
                destroyed=False
                while len(st)!=0 and element*st[len(st)-1]<0 and element<0 and st[len(st)-1]>0 and abs(element)>=abs(st[len(st)-1]):
                    if abs(element)>abs(st[len(st)-1]):
                        st.pop()
                    elif abs(element)==abs(st[len(st)-1]):
                        st.pop()
                        destroyed=True
                        break
                if len(st)!=0 and element<0 and st[len(st)-1]>0:
                    destroyed=True

                if not destroyed :
                    st.append(element)
                
        # ans=[st]
        return st
                    
                
                
                
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        