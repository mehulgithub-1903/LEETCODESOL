class TimeMap {

    Map<String,TreeMap<Integer,String>> mp;
    public TimeMap() {
        mp=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key,new TreeMap<Integer,String>());
        mp.get(key).put(timestamp,value);

    }
    
    public String get(String key, int timestamp) {
        if(mp.containsKey(key))
        {
           TreeMap<Integer,String> tm=mp.get(key);
           Integer k=tm.floorKey(timestamp);
           if(k!=null) return tm.get(k);
        }

        return "";
    }
}

