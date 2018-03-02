package com.pari.poc;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;


public class TwitterTrendingTopics {
    public static void main(String[] args) throws IOException, TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("eLfAB87h9s9Knw1MQQuT1NvuY")
                .setOAuthConsumerSecret("eUO2XYafc7tGWzA5ZKwfikVm5qegNZpyrMzDPvPeRHsT81hnL8")
                .setOAuthAccessToken("331719639-1k9jxXdkU3eCo9uy4uNisdhVY5VhkyGbwGUIX5FF")
                .setOAuthAccessTokenSecret("dteqiw3GIE1ysn4uuUzvd61qxx4qvtQRYmTYTPFYK4Swq");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        Trends trends = twitter.getPlaceTrends(1);
        int count = 0;
        for (Trend trend : trends.getTrends()) {
            if (count < 10) {
                System.out.println(trend.getName());
                count++;
            }
        }




    }
}
