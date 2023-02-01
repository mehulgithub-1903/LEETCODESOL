class Solution {
    public int[] getOrder(int[][] t) {
        
        
    	
    	int n=t.length;
    	int []ans=new int[n];
    	PriorityQueue<int []> tq=new PriorityQueue<int []>((a,b)-> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
    	PriorityQueue<int []> wq=new PriorityQueue<int []>((a,b)-> a[1]==b[1]?a[2]-b[2]:a[1]-b[1]);
    	
    	for(int i=0;i<n;i++) {
    		tq.offer(new int[] {t[i][0],t[i][1],i});
    	}
    	
    	int ct=-1;
    	int ind=0;
    	
    	while(!tq.isEmpty() || !wq.isEmpty() ) {
    		while(!tq.isEmpty() && tq.peek()[0]<=ct) wq.offer(tq.poll());
    		
    		if(!wq.isEmpty()) {
                int task[]=wq.poll();
    			ct+=task[1];
    			ans[ind++]=task[2];
    		}
    		else {
    			 int[] task = tq.poll();
                 
                 ct = task[0] + task[1];
                 ans[ind++] = task[2];
    		}
    		
    		
    	}
    	return ans;
    	
    	
    
    }
}