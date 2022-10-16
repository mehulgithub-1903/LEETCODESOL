class Solution {
    public int findMinFibonacciNumbers(int k) {
        
        ArrayList<Integer> al=makeFibonacci(k);
       // / System.out.println(al);/
        
        int start=al.size()-1;
        
        int count=0;
        while(k!=0)
        {
            while(al.get(start)>k) start--;
            k=k-al.get(start);
            count++;
        }
        
        return count;
        
        
    }
    public ArrayList<Integer> makeFibonacci(int k)

    {
        ArrayList<Integer> al=new ArrayList<Integer>();
        
        al.add(1);
        al.add(1);
        
        while(k>getLast(al))
        {
            al.add(getLast(al)+getSecondLast(al));
        }
        
        
        return al;
    }
    public int getLast(ArrayList<Integer> al)
    {
        return al.get(al.size()-1);
        
    }
    public int getSecondLast(ArrayList<Integer> al)
    {
        return al.get(al.size()-2);
        
    }
    }