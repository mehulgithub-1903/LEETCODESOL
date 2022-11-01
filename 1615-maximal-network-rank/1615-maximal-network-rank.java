import java.util.ArrayList;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int e[]:roads)
        {
            adj.get(e[1]).add(e[0]);
            adj.get(e[0]).add(e[1]);
        }
        int result=0;

        int degree[]=new int[n];

        for(int road[]:roads)
        {
            int f=road[0];
            int t=road[1];

            degree[f]++;
            degree[t]++;
        }
        
        // for(int e:degree) System.out.println(e);
        int md=-1;
        int smd=-1;
        for(int e:degree)
        {
            if(e>md)
            {
                smd=md;
                md=e;
                
            }
            else if(e>smd)
            {
                smd=e;
            }
        }
        
        // System.out.println(md);
        // System.out.println(smd);
        

        int cmd=0;
        int csmd=0;
        for(int e:degree)
        {
            if(e==md)
            {
              cmd++;  
            }
            if(e==smd)
            {
                csmd++;
            }
        }
        if(cmd==1)
        {
            // try to search for a node with degree = smd and is not connected to md node 
            int cc=0;
            for(int road[]:roads)
            {
                int f=road[0];
                int t=road[1];

               
                if((degree[f]==smd && degree[t]==md) || (degree[t]==smd && degree[f]==md))
                {
                    if(adj.get(f).contains(t))
                    {
                       cc++; 
                    }
                }
            }
                if(csmd>cc)
                {
                    return md+smd;
                }
                else
                {
                    return md+smd-1;
                }
            
        }
        else
        {
            int cc=0;
            for(int road[]:roads)
            {
                int f=road[0];
                int t=road[1];

                
                if(degree[f]==md && degree[t]==md)
                {
                    if(adj.get(f).contains(t))
                    {
                       cc++; 
                    }
                }
            }
                if((cmd*(cmd-1)/2)>cc)
                {
                    return md+md;
                }
                else
                {
                    return md+md-1;
                }
            
        }
        
    }
}