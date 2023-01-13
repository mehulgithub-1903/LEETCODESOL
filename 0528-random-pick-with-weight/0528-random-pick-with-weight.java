public class Solution {
    private final int[] weights;
    private final Random random = new Random();

    private final int[] cs;

    public Solution(int[] w) {
        this.weights = w;
        int sum = 0;
        
        cs=new int[w.length];
        int i=0;
        for (int weight : weights) {
            sum+=weight;
            cs[i++]=sum;
        }
    }

    public int pickIndex() {
        
        
        int randomNumber = random.nextInt(cs[cs.length-1]) + 1;
        // give you a random number from 1 to sum
        
        
        // largest number in cs just smaller than the random sum

        int left=0;
        int right=cs.length-1;

        while(left<=right)
        {
            int mid=(left+right)/2;

            int a=cs[left];
            int b=cs[mid];
            int c=cs[right];

            
            if(b==randomNumber) return mid;
            if(b>randomNumber)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }

            
        }
        return left;
        // int currentSum = 0;
        // for (int i = 0; i < weights.length; i++) {
        //     currentSum += weights[i];
        //     if (randomNumber <= currentSum) {
        //         return i;
        //     }
        // }

        // return -1;
    }
}