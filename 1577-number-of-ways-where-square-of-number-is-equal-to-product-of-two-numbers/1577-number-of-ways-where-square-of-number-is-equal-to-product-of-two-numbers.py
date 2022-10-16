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
        for j in range(len(y)):
            for k in range(j+1,len(y)):
                
                product=y[j]*y[k]
                if product in productFrequency:
                    key=product
                    ans+=productFrequency[key]
        return ans
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """
        