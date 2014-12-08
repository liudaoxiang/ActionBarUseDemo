package com.example.actionbartest;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 自定义View 添加至Actionbar
 * @author longzhc
 *
 */
public class AddCustomViewActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		Button button = (Button) findViewById(R.id.btn);
		final Intent intent = new Intent(this, NaviListActivity.class);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.test, menu);
		return super.onCreateOptionsMenu(menu);
	}
}
