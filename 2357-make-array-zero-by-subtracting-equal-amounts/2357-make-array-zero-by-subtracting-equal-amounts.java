class Solution {
    public int minimumOperations(int[] nums) {
      Set<Integer> st=new HashSet<>();
      for(int e:nums)
      {
        if(e!=0) st.add(e);
      }  
      return st.size();
     }
}