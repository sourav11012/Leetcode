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
    Map<Integer, List<Integer>> followers;  // follower -> list of followees
    Map<Integer, List<Post>> posts;      // user -> list of tweets

    public Twitter() {
        followers = new HashMap<>();
        posts = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        posts.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Post(globalTime++,tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Post> topPosts = new ArrayList<>(posts.getOrDefault(userId, new ArrayList<>()));

        List<Integer> currFollowees = followers.getOrDefault(userId, new ArrayList<>());

        for (int followee : currFollowees) {
            topPosts.addAll(posts.getOrDefault(followee, new ArrayList<>()));
        }

        Collections.sort(topPosts, new Comparator<Post>(){
            public int compare(Post a, Post b)
            {
                return b.time - a.time;
            }
        });
        List<Integer> feed = new ArrayList<>();
        int count = 0;
        for(Post p : topPosts)
        {
            if(count == 10) break;
            feed.add(p.val);
            count++;
        }
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
