class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans=new ArrayList<>();
        solve(k,n,new ArrayList<Integer>(),0,1);
        return ans;
    }
    public void solve(int k,int n,ArrayList<Integer> al,int sum,int start)
        
    {
        if(sum>n) return;
        
        if(al.size()==k)
        {
            if(sum==n)
            {
                ans.add(new ArrayList<>(al));
            }
            return ;
        }
        
        for(int i=start;i<=9;i++)
        {
            sum+=i;
            al.add(i);
            solve(k,n,al,sum,i+1);
            sum-=i;
            al.remove(al.size()-1);
        }
    }
    
}