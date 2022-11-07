class Pair
{
    int start;
    int end;

    public Pair(){};
    public Pair(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
}
class Solution {

    public List<Integer> partitionLabels(String s) {

     Map<Character,Pair> mp=new HashMap<Character,Pair>();


     int n=s.length();
     for(int i=0;i<n;i++)
     {
       char x=s.charAt(i);  
       if(mp.containsKey(x))
       {
           Pair e=mp.get(x);
           e.start=Math.min(e.start,i);
           e.end=Math.max(e.end,i);
       }   
       else
       {
           Pair e=new Pair(i,i);
           mp.put(x,e);
       }


     }
     ArrayList<Pair> al=new ArrayList();
     for(char e:mp.keySet())
     {
       
         al.add(mp.get(e));
     }
    
    Collections.sort(al,(Pair x,Pair y) ->  x.start-y.start);
     ArrayList<Integer> ans=new ArrayList();
    //  System.out.println(al);

     for(int i=0;i<al.size()-1;i++)
     {
         Pair a=al.get(i);
         Pair b=al.get(i+1);
         System.out.println(a.start+" "+a.end);
         
         System.out.println(b.start+" "+b.end);

         if(canMerge(a,b))
         {
             a.start=Math.min(a.start,b.start);
             a.end=Math.max(a.end,b.end);
             al.remove(i+1);
             i--;
         }
     }
    //  System.out.println(ans);
    //  System.out.println(al);
     
     for(int i=0;i<al.size();i++)
     {
         ans.add(al.get(i).end-al.get(i).start+1);
     }
     return ans;

    }
    public boolean canMerge(Pair a,Pair b)
    {
        if(b.start>a.end || a.start>b.end)
        {
            return false;

        }
        return true;

    }
}