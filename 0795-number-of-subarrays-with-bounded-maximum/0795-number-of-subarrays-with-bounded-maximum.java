class Solution {
    public int numSubarrayBoundedMax(int[] arr, int left, int right) {
        int n=arr.length;
        int ng[]=nge(arr);
        int pg[]=pge(arr);

        int ans=0;

        for(int i=0;i<n;i++)
        {
            int x=arr[i];

            if(x>=left && x<=right)
            {
                ans+=(ng[i]-i)*(i-pg[i]);
            }           
        }

        return ans;

    }

    public int[] pge(int arr[])
    {
        int n=arr.length;
        int ans[]=new int[n];
        Arrays.fill(ans,-1);

        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--)
        {
            

            while(!st.isEmpty() && arr[st.peek()] < arr[i])
            {
                ans[st.pop()]=i;

            }

            st.push(i);

            
        }
        return ans;

    }
    public int[] nge(int arr[])
    {
        int n=arr.length;
        int ans[]=new int[n];
        Arrays.fill(ans,n);

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++)
        {
            

            while(!st.isEmpty() && arr[st.peek()] <= arr[i])
            {
                ans[st.pop()]=i;

            }

            st.push(i);

            
        }
        return ans;
    }
}