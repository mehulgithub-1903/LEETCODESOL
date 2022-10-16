class Solution(object):
    def numTriplets(self, nums1, nums2):
        return self.helper(nums1,nums2)+self.helper(nums2,nums1)
    def helper(self,x,y):
        productFrequency={}
        
        for element in x:
            squareOfElement=element*element
            if  squareOfElement in productFrequency:
                productFrequency[squareOfElement]+=1
            else:
                productFrequency[squareOfElement]=1
        
        ans=0
        for element in productFrequency:
            mp={}
            for e in y:
               
                
                # print(key)
                if element%e==0 and element//e in mp:
                    key=element//e
                    ans+=mp[key]*productFrequency[element]
                    # print(ans)  
                if e in mp:
                    mp[e]+=1
                else:mp[e]=1
                # print(mp)
                    
        return ans
        
        