class Solution {
    public int partitionArray(int[] arr, int k) {
         int n=arr.length;
        
        //  for(int i=0;i<n;i++)arr[i]*=-1;
         Arrays.sort(arr);
         
        int i=0;
        int count=0;
        while(i<n)
        {
            count++;
            int j=i+1;
            while(j<n && arr[j]-arr[i]<=k)
            {
                j++;
            }
            i=j;
        }
        
        return count;
    }
}