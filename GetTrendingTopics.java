package com.pari.poc;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public final class GetTrendingTopics {

    public static void main(String[] args) {

        try {

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("eLfAB87h9s9Knw1MQQuT1NvuY")
                    .setOAuthConsumerSecret("eUO2XYafc7tGWzA5ZKwfikVm5qegNZpyrMzDPvPeRHsT81hnL8")
                    .setOAuthAccessToken("331719639-1k9jxXdkU3eCo9uy4uNisdhVY5VhkyGbwGUIX5FF")
                    .setOAuthAccessTokenSecret("dteqiw3GIE1ysn4uuUzvd61qxx4qvtQRYmTYTPFYK4Swq");

            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            ResponseList<Location> locations;
            locations = twitter.getAvailableTrends();
          /*  System.out.println("locations = " + locations);
            Integer idTrendLocation = getTrendLocationId("spain");

            if (idTrendLocation == null) {
                System.out.println("Trend Location Not Found");
                System.exit(0);
            }*/

            Trends trends = twitter.getPlaceTrends(1);
            for (int i = 0; i < trends.getTrends().length; i++) {
                System.out.println(trends.getTrends()[i].getName());
            }

            System.exit(0);

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get trends: " + te.getMessage());
            System.exit(-1);
        }
    }

    private static Integer getTrendLocationId(String locationName) {

        int idTrendLocation = 0;

        try {

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true).setOAuthConsumerKey("yourConsumerKey").setOAuthConsumerSecret
                    ("yourConsumerSecret").setOAuthAccessToken("yourOauthToken").setOAuthAccessTokenSecret
                    ("yourOauthTokenSecret");

            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            ResponseList<Location> locations;
            locations = twitter.getAvailableTrends();

            for (Location location : locations) {
                if (location.getName().toLowerCase().equals(locationName.toLowerCase())) {
                    idTrendLocation = location.getWoeid();
                    break;
                }
            }

            if (idTrendLocation > 0) {
                return idTrendLocation;
            }

            return null;

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get trends: " + te.getMessage());
            return null;
        }

    }
}
