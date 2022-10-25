class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
       
        StringBuilder sb1=new StringBuilder(); 
//         dont use string as we have to perform a continous append;
        StringBuilder sb2=new StringBuilder();
        
        int itr1=0;
        int itr2=0;
        
        while(itr1!=word1.length || itr2!=word2.length)
        {
            if(itr1<word1.length)
            {
                sb1.append(word1[itr1]);
                itr1++;
            }
            if(itr2<word2.length)
            {
                sb2.append(word2[itr2]);
                itr2++;
            }
        }
        
        System.out.println(sb1);
        System.out.println(sb2);
        return sb1.toString().equals(sb2.toString());
            
        
    }
}