class Solution {
    Integer ans;
    String s;
    public int maxUniqueSplit(String s) {
        this.s=s;
        ans=Integer.MIN_VALUE;
        rec(0,new HashSet<String>());
        return ans;
    }
    public void rec(int start,Set<String> st){
        if(start==s.length()) {
           ans=Math.max(ans,st.size());
            return;
        }
        // Set<String> temp=new HashSet<String>();
        for(int end=start+1;end<=s.length();end++){
            
            if(st.contains(s.substring(start,end))) continue;
            else
            {
            st.add(s.substring(start,end));
            rec(end,st);
            st.remove(s.substring(start,end));    
            }
          
            
        }
        return;
    }
}