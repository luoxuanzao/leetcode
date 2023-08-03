import java.util.*;

public class LeetCode355 {
    class Twitter {

        static final int TWEET_COUNT = 10;

        class Tweet {
            int id;
            int time;

            Tweet next;

            public Tweet(int id) {
                this.id = id;
                this.time = globalTime;
                globalTime += 1;
            }
        }

        class User {
            int id;
            Set<Integer> followeeIds = new HashSet<>();

            Tweet head = null;

            public User(int id) {
                this.id = id;
                followeeIds.add(id);
            }

            public void follow(int followeeId) {
                followeeIds.add(followeeId);
            }

            public void unfollow(int followeeId) {
                followeeIds.remove(followeeId);
            }

            public void publish(int tweetId) {
                Tweet newHead = new Tweet(tweetId);
                newHead.next = this.head;
                head = newHead;
            }

            public Tweet getHead() {
                return this.head;
            }


        }

        int globalTime = 0;
        HashMap<Integer, User> userHashMap;

        public Twitter() {
            userHashMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            User user = userHashMap.getOrDefault(userId, new User(userId));
            user.publish(tweetId);
            userHashMap.put(userId, user);
        }

        public List<Integer> getNewsFeed(int userId) {
            if (!userHashMap.containsKey(userId)) {
                return null;
            }
            List<Integer> result = new ArrayList<>();

            User user = userHashMap.get(userId);
            PriorityQueue<Tweet> tweets = new PriorityQueue<>((Comparator.comparingInt(o -> -o.time)));
            for (Integer followeeId : user.followeeIds) {
                if (userHashMap.containsKey(followeeId)) {
                    User t = userHashMap.get(followeeId);
                    if (t.getHead() != null) {
                        tweets.add(t.getHead());
                    }
                }
            }
            while (result.size() < TWEET_COUNT && !tweets.isEmpty()) {
                Tweet peek = tweets.peek();
                tweets.remove(peek);
                result.add(peek.id);
                if (peek.next != null) {
                    tweets.add(peek.next);
                }
            }
            return result;
        }

        public void follow(int followerId, int followeeId) {
            User user = userHashMap.getOrDefault(followerId, new User(followerId));
            user.follow(followeeId);
            userHashMap.put(followerId, user);
        }

        public void unfollow(int followerId, int followeeId) {
            User user = userHashMap.getOrDefault(followerId, new User(followerId));
            user.unfollow(followeeId);
            userHashMap.put(followerId, user);
        }
    }

}
