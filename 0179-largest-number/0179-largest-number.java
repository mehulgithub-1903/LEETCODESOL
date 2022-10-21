import java.util.Arrays;

class Solution  {
    
    public String largestNumber(int[] nums) {
        
    
        int n=nums.length;
        
        String numberString[]=new String[n];

        int i=0;
        for(int element : nums)
        {
            numberString[i]=String.valueOf(element);
            i++;
        }
        
        Arrays.sort(numberString,new Comparator<String>()
        {
            @Override
            public int compare(String s1,String s2) 
            {
                String temp1=s1+s2;
                String temp2=s2+s1;

                return temp2.compareTo(temp1);
            }
        });

        if(numberString[0].charAt(0)=='0') return "0";
        StringBuilder sb=new StringBuilder();

        for(String itr:numberString)
        {   
            // System.out.println(itr);
            sb.append(itr);
        }
        String ans=sb.toString();
        
        return ans;
    }
}