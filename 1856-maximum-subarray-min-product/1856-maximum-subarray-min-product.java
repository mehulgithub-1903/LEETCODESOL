class Solution {
    public int maxSumMinProduct(int[] nums) {
        int arr[][]=previousAndNextSmaller(nums);
        int pse[]=arr[0];
        int nse[]=arr[1];
        int n=nums.length;
        long prefixSum[]=new long[n];
        long sum=0;
       
        int i=0;
        for(int e:nums)
        {   
            sum+=e;
            prefixSum[i++]=sum;
        }
        
        long ans=0;
        for(i=0;i<n;i++)
        {
            ans=Math.max(ans,(prefixSum[nse[i]-1]-prefixSum[pse[i]+1]+nums[pse[i]+1])*nums[i]);
        }
        return (int)(ans % 1000_000_007);
    }
    public int [][] previousAndNextSmaller(int []nums)
    {
        int n=nums.length;
        
        Stack<Integer> st=new Stack<Integer>();
        int arr[][]=new int[2][n];
        
        int pse[]=new int[n];
        int nse[]=new int[n];
        // Arrays.fill(nse,n);
        for(int i=0;i<n;i++)
        {
            nse[i]=n;
            while(!st.isEmpty() && nums[st.peek()]>=nums[i])
                    {
                        nse[st.peek()]=i;
                        st.pop();
                    }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
                
        }
        arr[0]=pse;
        arr[1]=nse;
        return arr;
    }

}