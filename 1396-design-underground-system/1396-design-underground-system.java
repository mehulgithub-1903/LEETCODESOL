class CheckIn
{
    String station;
    int time;
    
    public CheckIn(String station,int time)
    {
        this.station = station;
        this.time = time;
    }
}
class AverageTime
{
    int noOfTrips;
    double averageTime;
    
    public AverageTime(int noOfTrips,double averageTime)
    {
        this.noOfTrips=noOfTrips;
        this.averageTime=averageTime;   
    }
}
class UndergroundSystem {

    Map<Integer,CheckIn> records; 
    Map<String,AverageTime> records1;
    
    public UndergroundSystem() {
        
        records=new HashMap<Integer,CheckIn>();
        records1=new HashMap<String,AverageTime>();
   
    }
    
    public void checkIn(int id, String stationName, int t) {
        // make a entry to checkIn records
         records.put(id,new CheckIn(stationName,t));

    }
    
    public void checkOut(int id, String stationName, int t) {
        // check the entry in checkIn records
    
        CheckIn lastCheckIn=records.get(id);

        String startStation=lastCheckIn.station;
        int timeOfLastCheckIn=lastCheckIn.time;

        String endStation=stationName;
        int timeOfCheckOut=t;

        String key=makeKey(startStation,endStation);

        if(records1.containsKey(key))
        {
            AverageTime currentAverageTime=records1.get(key);
            int noOfTrips=currentAverageTime.noOfTrips;
            double averageTime=currentAverageTime.averageTime;
            int timeOfTrip=timeOfCheckOut-timeOfLastCheckIn;
            double newAverageTime=countNewAverageTime(timeOfTrip,averageTime,noOfTrips);
            
            records1.put(key,new AverageTime(noOfTrips+1,newAverageTime));
        }
        else
        {
            AverageTime averageTime=new AverageTime(1,timeOfCheckOut-timeOfLastCheckIn);
            records1.put(key,averageTime);

        }

    }
    
    public double getAverageTime(String startStation, String endStation) {
     return records1.get(makeKey(startStation,endStation)).averageTime;   
    }
    private String makeKey(String a,String b)
    {
        String s=a+" "+b;
        
        return s;
    }
    private double countNewAverageTime(int t1,double t2,int totalInterval)
    {
        double totalTime=t2*totalInterval;

        totalTime=totalTime+t1;

        return totalTime*1.0/(totalInterval+1)*1.0;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */