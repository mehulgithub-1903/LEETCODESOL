// import java.lang.reflect.Array;
import java.util.Map;
import java.util.PriorityQueue;

class User
    {
        private int id;
        private ArrayList<Tweet> newsFeed;
        private Set<Integer> following;
        // private Set<Integer> following;
        
        public User()
        {
            newsFeed=new ArrayList<Tweet>();
            following=new HashSet<Integer>();
        }

        public int getId()
        {
            return id;
        }
        public void setId(int id)
        {
            this.id = id;
            following.add(this.id);
        }
        public ArrayList<Tweet> getFeed()
        {
            return this.newsFeed;
        }
        public void setNewsFeed(Tweet tweet)
        {
            this.newsFeed.add(tweet);
            // if(this.newsFeed.size()>10)
            // {
            //     this.newsFeed.poll();
            // }
            return;
        }
        
        public Set<Integer> getFollowers()
        {
            return this.following;
        }
        public void setFollowers(int followerId,int status)
        {
            if(status==1)
            {
                // follow
                this.following.add(followerId);
            }
            else
            {
                // unfollow
                this.following.remove(followerId);
            }
        }
        


    }
class Tweet
{
    int id;
    int ts;
    
    public Tweet(int id, int ts)
    {
        this.id = id;
        this.ts = ts;
    }
}
    
class Twitter {
    
    private Map<Integer,User> twitters;
    private int timeStamp;
    public Twitter() {
        
        this.timeStamp=0;
        this.twitters=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) 
    {
     
        int key=userId;
        if(!twitters.containsKey(key))
        {
            // create a user
            User newUser=new User();
            newUser.setId(key);
            twitters.put(key,newUser);
        }

        User user=twitters.get(key);
        Tweet tweet=new Tweet(tweetId,timeStamp++);
        user.setNewsFeed(tweet);
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        
        twitters.putIfAbsent(userId,new User());
        
        
        User user=twitters.get(userId);
        user.setId(userId);
       
        
        PriorityQueue<Tweet> finalList=new PriorityQueue<Tweet>((Tweet a,Tweet b)-> a.ts-b.ts); 
        
         System.out.println("Hello");
        for(int itr:user.getFollowers())
        {
            
            
            User follower=twitters.get(itr);
            // System.out.println(follower.getFeed().size());
            
            for(Tweet tweet:follower.getFeed())
            {
                finalList.add(tweet);
                if(finalList.size()>10)
                {
                    finalList.poll();
                }
            }
        
            
        }
        System.out.println(finalList.size());
        List<Integer> ans=new ArrayList<Integer>();
    
        while(!finalList.isEmpty())
        {
            ans.add(finalList.poll().id);
        }
        Collections.reverse(ans);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!twitters.containsKey(followerId))
        {
            User user =new User();
            user.setId(followerId);
            twitters.put(followerId,user);
        }
        if(!twitters.containsKey(followeeId))
        {
             User user =new User();
            user.setId(followeeId);
            twitters.put(followeeId,user);
        }
        
        User user=twitters.get(followerId);
//         get followers
        
        user.setFollowers(followeeId,1);
        }
    
    public void unfollow(int followerId, int followeeId) {
        // twitters.putIfAbsent(followeeId,new User());
        
        User user=twitters.get(followerId);
        user.setFollowers(followeeId,0);
        
    }
}

