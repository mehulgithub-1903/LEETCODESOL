class Solution {
    public int longestSubarray(int[] nums, int limit) {

     int n=nums.length;
     int left=0;
     
     Deque<Integer> minq=new LinkedList<>();
     Deque<Integer> maxq=new LinkedList<>();
    
    
     minq.add(0);   
     maxq.add(0);

     int ans=1;
     for(int right=1;right<n;right++)
     {
        
        while(!minq.isEmpty() && nums[minq.peekLast()]>nums[right])
        {
            minq.pollLast();
        }
        while(!maxq.isEmpty() && nums[maxq.peekLast()]<nums[right])
        {
            maxq.pollLast();
        }
        minq.offer(right);
        maxq.offer(right);
        if(nums[maxq.peekFirst()]-nums[minq.peekFirst()]<=limit)
        {
            ans=Math.max(right-left+1,ans);
        }
        else
        {
            left++;
            if(left>minq.peekFirst())
            {
                minq.pollFirst();
            }
            if(left>maxq.peekFirst())
            {
                maxq.pollFirst();
            }
        }

     }   
     return ans;
    }
}