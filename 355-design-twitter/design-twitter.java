class Twitter {
    int globalTime = 0;
    class Post{
        int time;
        int val;
        public Post(int time, int val)
        {
            this.time = time;
            this.val =val;
        }
    }
    Map<Integer, List<Integer>> followers;  // followee -> list of follow
    Map<Integer, List<Post>> posts;      // user -> list of tweets

    public Twitter() {
        followers = new HashMap<>();
        posts = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Post newPost = new Post(globalTime++,tweetId);

        posts.computeIfAbsent(userId, k -> new ArrayList<>()).add(newPost);

        // List<Integer> currentFollowers = followers.getOrDefault(userId,new ArrayList<>());

        // for(int follower : currentFollowers)
        // {
        //     posts.get(follower).add(newPost);
        // }
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> pq = new PriorityQueue<>((a,b) ->  a.time - b.time);

        List<Post> usersPosts = new ArrayList<>(posts.getOrDefault(userId, new ArrayList<>()));
        for(Post p : usersPosts)
        {
            pq.offer(p);
            if(pq.size() > 10)
            {
                pq.remove();
            }
        }

        List<Integer> currFollowees = followers.getOrDefault(userId, new ArrayList<>());

        for (int followee : currFollowees) {
            for(Post p : posts.getOrDefault(followee, new ArrayList<>())){
                pq.offer(p);
                if(pq.size() > 10)
                pq.remove();
            }
        }

       
        List<Integer> feed = new ArrayList<>();
   
        while(!pq.isEmpty())
        {
            
            feed.add(pq.remove().val);
           
        }
        Collections.reverse(feed);
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, k -> new ArrayList<>());
        if (!followers.get(followerId).contains(followeeId)) {
            followers.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}
