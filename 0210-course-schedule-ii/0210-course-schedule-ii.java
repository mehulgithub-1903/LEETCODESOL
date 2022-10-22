class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        
        for(int i=0;i<=numCourses;i++)
        {
            al.add(new ArrayList<Integer>());
        }
        
        int [] indegree=new int[numCourses];
        for(int [] e:prerequisites)
        {
            al.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            
        }
    
        
        
        int arr[]=new int[numCourses];
        
        int index=0;
        int courses=0;
//      make directed graph    
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++)
        {
           if(indegree[i]==0)
           {
               
               courses++;
               q.add(i);
                arr[index++]=i;
           }
        }
        
        
        while(!q.isEmpty())
        {
            int s=q.size();
            while(s-->0)
            {
                int x=q.poll();
                for(int e:al.get(x))
                {
                    indegree[e]--;
                    if(indegree[e]==0)
                    {
                        q.add(e);
                        courses++;
                        arr[index++]=e;
                    }
                } 
            }
            
        }
        
        int [] emptyArr=new int[0];
        return (numCourses==courses?arr:emptyArr);
       
    }
}

    // class Solution {

