package com.example.actionbartest;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * 分离菜单
 * @author longzhc
 *
 */
public class SplitActionBarActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.split);
	}

	public void onClick(View v) {
		startActionMode(new MyActionMode());
	}

	class MyActionMode implements ActionMode.Callback {

		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			//添加菜单项目  MenuItemCompat为兼容低版本时使用
			MenuItemCompat.setShowAsAction(
					menu.add("Save").setIcon(R.drawable.ic_compose),
					MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			MenuItemCompat.setShowAsAction(
					menu.add("Search").setIcon(R.drawable.l0),
					MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			MenuItemCompat.setShowAsAction(
					menu.add("Edit").setIcon(android.R.drawable.ic_menu_edit),
					MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			MenuItemCompat.setShowAsAction(
					menu.add("Email").setIcon(android.R.drawable.ic_dialog_email),
					MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			MenuItemCompat.setShowAsAction(
					menu.add("Refresh").setIcon(R.drawable.ic_menu_refresh),
					MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			
			MenuItemCompat.setShowAsAction(
					menu.add("Save").setIcon(R.drawable.ic_compose),
					MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			MenuItemCompat.setShowAsAction(
					menu.add("Search").setIcon(R.drawable.l0),
					MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			MenuItemCompat.setShowAsAction(
					menu.add("Edit").setIcon(android.R.drawable.ic_menu_edit),
					MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			MenuItemCompat.setShowAsAction(
					menu.add("Email").setIcon(android.R.drawable.ic_dialog_email),
					MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
			MenuItemCompat.setShowAsAction(
					menu.add("Refresh").setIcon(R.drawable.ic_menu_refresh),
					MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);


			return true;
		}

		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			return false;
		}

		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

			MyAPP.showToast(item.getTitle().toString());
			
			return true;
		}

		@Override
		public void onDestroyActionMode(ActionMode mode) {

		}

	}
}
