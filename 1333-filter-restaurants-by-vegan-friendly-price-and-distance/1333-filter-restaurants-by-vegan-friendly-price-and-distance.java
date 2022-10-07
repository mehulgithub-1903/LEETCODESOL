class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int vegan, int maxPrice, int maxDistance) {
     ArrayList<int []> ans=new ArrayList<>();
        int n=restaurants.length;
      for(int i=0;i<n;i++)
      {
          
        if(vegan==1){
            if(restaurants[i][3]<=maxPrice && 
           restaurants[i][2]==vegan &&
          restaurants[i][4]<=maxDistance)
        {
            ans.add(restaurants[i]);
        }
        }
          else
          {
           if(restaurants[i][3]<=maxPrice &&
          restaurants[i][4]<=maxDistance)
        {
            ans.add(restaurants[i]);
        }     
          }
      }
        
        Collections.sort(ans,(a,b)->a[1]==b[1]?b[0]-a[0]:b[1]-a[1]);

        List<Integer> al=new ArrayList<>();
        
        for(int []e:ans) al.add(e[0]);
        
        return al;
    }
}