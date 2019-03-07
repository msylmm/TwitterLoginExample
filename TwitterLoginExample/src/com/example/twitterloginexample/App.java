package com.example.twitterloginexample;


import android.app.Application;
import android.util.Log;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;

public class App extends Application {

	@Override
	public void onCreate() {

		super.onCreate();
	
	    //Twitter
        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("8G9u5DOvIhb2U7XCyZxeV2u6M", "wDhC8oeR4z3Z0Ncg5sWkxQoV8hCeSPRnjmZswyWKmBrkGsAu4a"))
                .debug(true)
                .build();

        Twitter.initialize(config);

        Twitter.initialize(this);
        
        
        
        
	
	}

	


}
