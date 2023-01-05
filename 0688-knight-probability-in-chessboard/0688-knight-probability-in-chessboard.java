class Solution {
    int dir[];
    int dic[];
    Map<String,Double> cache;
    int n;
    public double knightProbability(int n, int k, int row, int column) {

        this.n=n;
        dir=new int[]{+2,+2,+1,+1,-2,-2,-1,-1};
        dic=new int[]{-1,+1,-2,+2,-1,+1,-2,+2};
        cache=new HashMap<>();
        return rec(k,row,column);
    }

    public double rec(int k,int r,int c)
    {
        if(outOfBound(r,c)) return 0;

        if(k==0) return 1;
        
        String key=makeCacheKey(k,r,c);
        if(cache.containsKey(key))
        {
            return cache.get(key);
        }
        double result=0;
        for(int i=0;i<8;i++)
        {
            int nr=r+dir[i];
            int nc=c+dic[i];

            result+=rec(k-1,nr,nc);
        }
        
        // write in cache
        cache.put(key,result*0.125);
        return result*0.125;
    }

    public boolean outOfBound(int r,int c)
    {
        if(r>=n || r<0 || c>=n || c<0) return true;

        return false;
    }

    public String makeCacheKey(int k,int r,int c)
    {
        String key=k+" "+r+" "+c;
        return key;
    }

}