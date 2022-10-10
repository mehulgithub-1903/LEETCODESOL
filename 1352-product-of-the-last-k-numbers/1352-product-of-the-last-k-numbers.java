
class ProductOfNumbers {
    
    private ArrayList<Integer> al;
    private int lastProduct;
    
    
    public ProductOfNumbers() {
        
        al=new ArrayList<Integer>();
        lastProduct=1;
    }
    
    public void add(int num) 
    {
        
       if(num==0)
       {
           lastProduct=1;
           al.clear();
           
       }
        else
        {
         lastProduct=lastProduct*num;
         al.add(lastProduct);
        }
        
    }
    
    public int getProduct(int k)
    {
        int index=al.size()-k;
        if(index==0)
        {
            return lastProduct;
        }
        if(index<0) return 0;
        else
        {
            return lastProduct/al.get(index-1);
        }
    }
}

