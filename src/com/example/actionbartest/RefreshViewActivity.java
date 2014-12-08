package com.example.actionbartest;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RefreshViewActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		Button button = (Button) findViewById(R.id.btn);
		button.setText("停止加载");
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setRefreshActionButtonState(false);
			}
		});
	}

	private Menu mOptionsMenu;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		mOptionsMenu = menu;
		getMenuInflater().inflate(R.menu.test1, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (R.id.menu_refresh == item.getItemId()) {
			setRefreshActionButtonState(true);
		}
		return super.onOptionsItemSelected(item);
	}

	public void setRefreshActionButtonState(boolean refreshing) {
		if (mOptionsMenu == null) {
			return;
		}

		final MenuItem refreshItem = mOptionsMenu.findItem(R.id.menu_refresh);
		if (refreshItem != null) {
			if (refreshing) {
				MenuItemCompat.setActionView(refreshItem, R.layout.actionbar_progress);
			} else {
				MenuItemCompat.setActionView(refreshItem, null);
			}
		}
	}

}
