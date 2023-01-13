class Solution {
    public int nthMagicalNumber(int n, int a, int b) {

     
     long left=Math.min(a,b);
     long right=(long)n*Math.min(a,b);

     long lcm=(long)((a*b)/gcd(a,b));
    //  System.out.println(lcm);
     long mod=((long) Math.pow(10,9)+7);
        
     while(left<right)
     {
        long mid=(left+right)/2;

        long currNum=(mid/a)+(mid/b)-(mid/lcm);
        // if(currNum==n) return mid;
        if(currNum>=n)
        {
            right=mid;
            
        }
        else
        {
            left=(mid+1);
            // left=left%1000000007;
        }
     }   
     
     return (int)(left%mod);
    }
    public static long gcd(int a,int b)
    {
        if(a==0) return b;
        if(b==0) return a;
        
        if(a>b) return gcd(b,a%b);
        if(a<b) return gcd(a,b%a);
        
        return a;
    }
}