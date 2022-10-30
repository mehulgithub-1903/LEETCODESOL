class Solution {
    Set<String> st;
    Map<String,Boolean> mp =new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
    
        
        st=new HashSet<>(wordDict);
        
        return rec(s);
    }
    public boolean rec(String s)
        
        
    {
        
        if(st.contains(s))
        {
            return true;
        }
        if(s.length()==0)
        {
            return true;
        }
        if(mp.containsKey(s)) return mp.get(s);
        boolean ans=false;
        for(int i=0;i<s.length();i++)
            
        {
            if(st.contains(s.substring(0,i+1)))
            {
                ans=ans||rec(s.substring(i+1));
            }
        }
        
        mp.put(s,ans);
        return ans;
    }
}