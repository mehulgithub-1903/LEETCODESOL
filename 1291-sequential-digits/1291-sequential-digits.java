class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        int digits=(int)Math.log10(low)+1;
        System.out.println(digits);
        
        
        int start=0;
        for(int i=1;i<=digits;i++)
        {
            start+=i*Math.pow(10,digits-i);
        }
        
        // System.out.println(start);
        // System.out.println(start<high);
        ArrayList<Integer> al=new ArrayList<>();
    
    while(start<=high)
    {
        int temp=start;
        while(temp<=high)
        {
           if(temp>=low) al.add(temp);
            if(temp%10==9) break;
            int n=(int)Math.log10(temp)+1;
            int remain=temp%(int)Math.pow(10,n-1);
            temp=remain*10+((temp%10)+1);
            
        }
        digits++;
        start=0;
        for(int i=1;i<=digits;i++)
        {
            start+=i*Math.pow(10,digits-i);
        }
        // if(start>1000000000)
        
    }
        return al;
        
    }
}