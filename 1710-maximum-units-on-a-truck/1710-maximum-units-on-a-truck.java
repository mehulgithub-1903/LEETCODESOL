class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes,(a,b)-> b[1]-a[1]);
        
        int ans=0;
        for(int i=0;i<boxTypes.length;i++)
        {
            if(boxTypes[i][0]<=truckSize)
            {
                truckSize=truckSize-boxTypes[i][0];
                ans+=boxTypes[i][1]*boxTypes[i][0];
            }
            else
            {
                 ans+=boxTypes[i][1]*truckSize;
                 truckSize=0;
            }
        }
        
        return ans;
    }
}