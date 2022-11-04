class Node
{
    int status; 
    // 0 for start and 1 for end

    int value;
    int nop;

    public Node(){}
    public Node(int status,int value,int nop)
    {
        this.status=status;
        this.value=value;
        this.nop=nop;

    }
}
class Solution {
    
    public boolean carPooling(int[][] trips, int capacity) {
        
    PriorityQueue<Node> pq=new PriorityQueue<>((Node a,Node b)-> a.value==b.value?b.status-a.status:a.value-b.value);  

    int n=trips.length;
    for(int i=0;i<n;i++)
    {
        pq.add(new Node(0,trips[i][1],trips[i][0]));
        pq.add(new Node(1,trips[i][2],trips[i][0]));
        
    }
    int reqCap=0;
    int currCap=0;
    while(!pq.isEmpty())
    {
        Node x=pq.poll();
        if(x.status==0)
        {
            currCap+=x.nop;
            reqCap=Math.max(reqCap,currCap);
        }
        else
        {
            currCap-=x.nop;   
        }
    }

    return reqCap<=capacity;
    }
}
