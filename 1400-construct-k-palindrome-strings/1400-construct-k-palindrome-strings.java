class Solution {
    public boolean canConstruct(String s, int k) {
     
        if(k>s.length())
        {
            return false;
        }
        int arr[]=new int[26];
        
        for(char e:s.toCharArray())
        {
            arr[e-'a']++;
        }
        int even=0;
        int odd=0;
        
        for(int e:arr)
        {
            if(e%2==0)
            {
                even++;
            }
            else
            {
                odd++;
            }
        }
        
//         logic
        return odd<=k;
    }
}