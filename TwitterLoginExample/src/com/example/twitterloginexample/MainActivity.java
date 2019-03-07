package com.example.twitterloginexample;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class MainActivity extends Activity {

	public static final String TAG = MainActivity.class.getSimpleName();

	TwitterLoginButton twitterLoginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		twitterLoginButton = (TwitterLoginButton) findViewById(R.id.twitterLoginButton);

		twitterLoginButton.setCallback(new Callback<TwitterSession>() {

			@Override
			public void success(Result<TwitterSession> result) {
			
				TwitterSession data = result.data;
				TwitterAuthToken authToken = data.getAuthToken();

				final String twitterUserId = data.getUserId() + "";
				final String twitterUserName = data.getUserName();
				final String twittersecret = authToken.secret;
				final String twittertoken = authToken.token;
				Log.e(TAG, "arg0 : -----------------------");
				
				Log.e(TAG, "twitterUserId : " + twitterUserId);
				Log.e(TAG, "twitterUserName : " + twitterUserName);
				Log.e(TAG, "twittersecret : " + twittersecret);
				Log.e(TAG, "twittertoken : " + twittertoken);

				Log.e(TAG, "arg0 : -----------------------");
//				Toast.makeText(MainActivity.this, twitterUserId,
//						Toast.LENGTH_LONG).show();
//				Toast.makeText(MainActivity.this, twitterUserName,
//						Toast.LENGTH_LONG).show();
//				Toast.makeText(MainActivity.this, twittersecret,
//						Toast.LENGTH_LONG).show();
//				Toast.makeText(MainActivity.this, twittertoken,
//						Toast.LENGTH_LONG).show();

			}

			@Override
			public void failure(TwitterException arg0) {
				Log.e(TAG, "arg0 : -----------------------");
				Log.e(TAG, "arg0 : " + arg0.getMessage());
				Log.e(TAG, "arg0 : -----------------------");
				Toast.makeText(MainActivity.this, arg0.getMessage(),
						Toast.LENGTH_LONG).show();
			}
		});

	}

}
