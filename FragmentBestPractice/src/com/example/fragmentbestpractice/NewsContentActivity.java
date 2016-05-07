package com.example.fragmentbestpractice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class NewsContentActivity extends Activity {

	public static void actionStart(Context context, String newsTitle,
			String newsContent) {
		Intent intent = new Intent(context, NewsContentActivity.class);
		intent.putExtra("news_title", newsTitle);
		intent.putExtra("news_content", newsContent);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.news_content);
		String newsTitle = getIntent().getStringExtra("news_title");
		String newsContent = getIntent().getStringExtra("news_content");
		NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager()
				.findFragmentById(R.id.news_content_fragment);
		newsContentFragment.refresh(newsTitle, newsContent);
		
		//在这里如果不复用NewsContentFragment，而是直接加载news_content_frag这个layout也是可以的，亲测有效
		//但是这样代码的复用就差了
//		setContentView(R.layout.news_content_frag);
//		String newsTitle = getIntent().getStringExtra("news_title");
//		String newsContent = getIntent().getStringExtra("news_content");
//		View visibilityLayout = (View) findViewById(R.id.visibility_layout);
//		visibilityLayout.setVisibility(View.VISIBLE);
//		TextView newsTitleText = (TextView) findViewById(R.id.news_title);
//		TextView newsContentText = (TextView) findViewById(R.id.news_content);
//		newsTitleText.setText(newsTitle);
//		newsContentText.setText(newsContent);
	}
	

}
