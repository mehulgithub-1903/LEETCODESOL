import java.util.ArrayList;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        ArrayList<Set<Integer>> adj = new ArrayList<Set<Integer>>();

        for(int i=0;i<n;i++)
        {
            adj.add(new HashSet<Integer>());
        }
        for(int e[]:roads)
        {
            adj.get(e[1]).add(e[0]);
            adj.get(e[0]).add(e[1]);
        }
        int result=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                {
                    if(adj.get(i).contains(j))
                    {
                     result =Math.max(result,adj.get(i).size()+adj.get(j).size()-1);   
                    }
                    else
                    {
                        result =Math.max(result,adj.get(i).size()+adj.get(j).size());
                    }
                }
            }
        }

        return result;

    }
}