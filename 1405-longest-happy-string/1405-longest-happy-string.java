import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        return solve(a,b,c);
    }
    public String solve(int a,int b,int c)
    {
        PriorityQueue<Pair> pq =new  PriorityQueue<Pair>((Pair x,Pair y) ->y.freq-x.freq);

         Pair first=new Pair(a,'a');
         Pair second=new Pair(b,'b');
         Pair third=new Pair(c,'c');
        
        if(a!=0) pq.add(first);
        if(b!=0) pq.add(second);
        if(c!=0) pq.add(third);

        // System.out.println(pq);
       

    StringBuilder sb=new StringBuilder();
    
        while(!pq.isEmpty())
        {
            Pair x=pq.poll();
            if(sb.length()==0 || !(sb.charAt(sb.length()-1)==x.c && sb.charAt(sb.length()-2)==x.c))

            {
                if(x.freq>2)
                {
                    sb.append(x.c);
                    sb.append(x.c);
                    pq.add(new Pair(x.freq-2,x.c));

                }   
                else
                {
                    for(int i=0;i<x.freq;i++)
                    {
                        sb.append(x.c);
                    }
                    
                }
            }
            else
            {
                if(pq.isEmpty())
                {
                    break;
                }
                else
                {
                    Pair y=pq.poll();
                    sb.append(y.c);
                    
                    if(y.freq!=1) pq.add(new Pair(y.freq-1,y.c));
                }
                if(x.freq>2)
                {
                    sb.append(x.c);
                    sb.append(x.c);
                    pq.add(new Pair(x.freq-2,x.c));

                }   
                else
                {
                    for(int i=0;i<x.freq;i++)
                    {
                        sb.append(x.c);
                    }
                    
                }
                
                
            }
        }
        
        return sb.toString();
    }
}
class Pair
{
    char c;
    int freq;

    public Pair(int freq,char c)
    {
        this.c=c;
        this.freq= freq;
    }
}