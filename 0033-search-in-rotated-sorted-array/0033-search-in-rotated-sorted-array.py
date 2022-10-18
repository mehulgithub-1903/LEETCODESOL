class Solution(object):
    def search(self, nums, target):
        
        n=len(nums)-1
        l=0;
        h=n;
        
        while l<=h:
            m=l+(h-l)//2
            
            if nums[m]==target:
                return m
            else:
                if nums[l]<=nums[m]:
                    if target<nums[m] and target>=nums[l]:
                        h=m-1
                    else:
                        l=m+1
                elif nums[m]<=nums[h]:
                    if target<=nums[h] and target>nums[m]:
                        l=m+1
                    else:
                        h=m-1

        return -1
        