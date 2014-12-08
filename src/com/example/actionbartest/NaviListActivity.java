package com.example.actionbartest;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class NaviListActivity extends BaseActivity {
	private String[] strs;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		Button button = (Button) findViewById(R.id.btn);
		final Intent intent = new Intent(this, RefreshViewActivity.class);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
		strs = getResources().getStringArray(R.array.spinner);

		SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,
				R.array.spinner,
				R.layout.spinner_item);

		/**
		 * 过时的导航方式
		 */
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);// 导航模式必须设为NAVIGATION_MODE_LIST
		actionBar.setListNavigationCallbacks(mSpinnerAdapter,
				mOnNavigationListener);
	}
	

	private OnNavigationListener mOnNavigationListener = new OnNavigationListener() {

		@Override
		public boolean onNavigationItemSelected(int itemPosition, long itemId) {
			MyAPP.showToast(strs[itemPosition]);
			return false;
		}
	};
}
