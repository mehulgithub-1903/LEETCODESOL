class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<k+1;i++)
        {
            int temp[]=dist.clone();
            for(int [] edge:flights)
            {
                int from =edge[0];
                int to =edge[1];

                int weight=edge[2];

                if(dist[from]!=Integer.MAX_VALUE && dist[from]+weight<temp[to])
                {
                    System.out.println(from+" "+to+" "+weight);
                    temp[to]=dist[from]+weight;
                }

            }
            dist=temp;
        }
        if(dist[dst]==Integer.MAX_VALUE)
        {
            return -1;
        }
        else
        {
            return dist[dst];
        }

    }
}