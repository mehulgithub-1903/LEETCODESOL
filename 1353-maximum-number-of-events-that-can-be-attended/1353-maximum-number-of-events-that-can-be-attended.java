class Solution {
    public int maxEvents(int[][] events) 
    {
        int count=0;
        int i=0;
        Arrays.sort(events,(e1,e2)->Integer.compare(e1[0],e2[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int day=1;day<=100000;day++)
        {
           while(i<events.length && events[i][0]==day)
           {
               pq.add(events[i][1]);
               i++;
           }             
           while(!pq.isEmpty() && pq.peek()<day) 
           {
               pq.poll();
           }
            if(!pq.isEmpty()) 
            {
              pq.poll();
              count++;
            }
        }
        return count;
    }
}