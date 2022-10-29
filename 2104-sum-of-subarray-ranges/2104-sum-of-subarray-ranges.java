class Solution {
    public long subArrayRanges(int nums[])
{
    
//         nge -> next greater element 
//         nse  -> next smaller element
        
//          pse -> previous smaller element
        
//          pge -> previous greater element   
    int n=nums.length;
    long nge[]=nge(nums);
    long nse[]=nse(nums);
    long pge[]=pge(nums);
    long pse[]=pse(nums);

        
    long ans=0;
    for(int i=0;i<n;i++)
    {
        ans+=nums[i]*(((i-pge[i])*(nge[i]-i))-((i-pse[i])*(nse[i]-i)));
        
    }
    return ans;
}
public long[] nge(int nums[])
{
    int n=nums.length;
    Stack<Integer> st = new Stack<Integer>();
    long ans[]=new long[n];
    Arrays.fill(ans,n);

    for(int i=0;i<n;i++)
    {
        while(!st.isEmpty() && nums[i]>nums[st.peek()])
        {
            ans[st.pop()]=i;
        }
        st.push(i);
    }

    return ans;

}
public long[] nse(int nums[])
{
    int n=nums.length;
    Stack<Integer> st = new Stack<Integer>();
    long ans[]=new long[n];
    Arrays.fill(ans,n);

    for(int i=0;i<n;i++)
    {
        while(!st.isEmpty() && nums[i]<=nums[st.peek()])
        {
            ans[st.pop()]=i;
        }
        st.push(i);
    }


    return ans;

}
public long[] pse(int nums[])
{
    int n=nums.length;
    Stack<Integer> st = new Stack<Integer>();
    long ans[]=new long[n];
    Arrays.fill(ans,-1);

    for(int i=n-1;i>=0;i--)
    {
        while(!st.isEmpty() && nums[i]<nums[st.peek()])
        {
            ans[st.pop()]=i;
        }
        st.push(i);
    }


    return ans;

}
public long[] pge(int nums[])
{
    int n=nums.length;
    Stack<Integer> st = new Stack<Integer>();
    long ans[]=new long[n];
    Arrays.fill(ans,-1);

    for(int i=n-1;i>=0;i--)
    {
        while(!st.isEmpty() && nums[i]>=nums[st.peek()])
        {
            ans[st.pop()]=i;
        }
        st.push(i);
    }


    return ans;

}
}