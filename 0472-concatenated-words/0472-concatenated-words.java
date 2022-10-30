class Solution {
    Set<String> dict;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        dict=new HashSet<String>();

        for(String e:words)
        {
            dict.add(e);
        }

        List<String> result = new ArrayList<String>();
        for(String word:words)
        {
            if(rec(word)>=2)
            {
                result.add(word);
            }
        }

        return result;
        
    }
    public int rec(String s)
    {

        if(s.length()==0)
        {
            return 0;
        }

        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            if(dict.contains(s.substring(0,i+1)))
            {
                ans=Math.max(ans,1+rec(s.substring(i+1,s.length())));
            }
        }

        return ans==0?Integer.MIN_VALUE:ans;
    }

}