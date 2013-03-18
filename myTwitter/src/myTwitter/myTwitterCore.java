/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myTwitter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import twitter4j.ResponseList;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *
 * @author wbarahona
 */
public class myTwitterCore {
    private final static String CONSUMER_KEY = "cn2ZHXEEJC4PCLVzqBqfFg";
    private final static String CONSUMER_KEY_SECRET ="XbpgkLP33gB0SDfsAhuMca1YeS41FDnBBVmRchuGo";

    public ResponseList start(String tweet) throws TwitterException, IOException {

            Twitter twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

            // here's the difference
            String accessToken = getSavedAccessToken();
            String accessTokenSecret = getSavedAccessTokenSecret();
            AccessToken oathAccessToken = new AccessToken(accessToken,
             accessTokenSecret);

            twitter.setOAuthAccessToken(oathAccessToken);
            // end of difference

            twitter.updateStatus(tweet);

            //System.out.println("\nMy Timeline:");

            // I'm reading your timeline
            ResponseList list = twitter.getHomeTimeline();
            return list;
            //System.out.println("Lista: " + list);


            /*for (Status each : list) {

                System.out.println("Sent by: @" + each.getUser().getScreenName()
                 + " - " + each.getUser().getName() + "\n" + each.getText()
                 + "\n");
            }*/

    }

    private String getSavedAccessTokenSecret() {
        // consider this is method to get your previously saved Access Token
        // Secret
        return "Bm3PidMZa82pANAOk23e15pE4QEAlo5Lxy8qwuLPenE";
    }

    private String getSavedAccessToken() {
        // consider this is method to get your previously saved Access Token
        return "287404313-iR9LM5bbGKFQ08bhjXsFFFw0i9qXBTXucgenAT9X";
    }

    public static void main(String[] args) throws Exception {
        new myTwitterCore().start("from main function");
    }
    
    public ResponseList tweetaction(String tweet) throws Exception{
        ResponseList var = new myTwitterCore().start(tweet);
        return var;
    }
}
