class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> mp=new HashMap<Integer, Integer>();

        for(int i=0; i<arr.length; i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        
        ArrayList<Integer> al=new ArrayList<Integer>();

        for(int e:mp.keySet()){
            al.add(mp.get(e));
        }

        Collections.sort(al,Collections.reverseOrder());

        int cnt=0;
        int hl=arr.length/2;
        int sum=0;
        for(int i=0;i<al.size();i++){
            sum+=al.get(i);
            cnt++;
            if(sum>=hl){
                return cnt;
            }            
        }
        
        return cnt;


    }
}