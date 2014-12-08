package com.example.actionbartest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		
		/**
		 * 过时的添加Tab页方法
		 */
//		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//		Tab tab = actionBar
//				.newTab()
//				.setText("artist lucy")
//				.setTabListener(
//						new MyTabListener<ArtistFragment>(this, "artist", ArtistFragment.class));
//		actionBar.addTab(tab);
//
//		tab = actionBar
//				.newTab()
//				.setText("albums lisa")
//				.setTabListener(
//						new MyTabListener<AlbumFragment>(this, "album", AlbumFragment.class));
//		actionBar.addTab(tab);
		
		actionBar.setDisplayShowHomeEnabled(false);//隐藏LOGO
		setOverflowShowingAlways();//
	}

	public void onClick(View v){
		Intent intent = new Intent(this,AddCustomViewActivity.class);
		startActivity(intent);
	}
	
	public void onClick1(View v){
		Intent intent = new Intent(this,SplitActionBarActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);

		/**
		 * 搜索
		 */
		MenuItem searchItem = menu.findItem(R.id.action_search);
		searchItem.setOnActionExpandListener(new OnActionExpandListener() {
			@Override
			public boolean onMenuItemActionExpand(MenuItem item) {
				Log.d("TAG", "搜索框 展开  on expand");
				return true;
			}

			@Override
			public boolean onMenuItemActionCollapse(MenuItem item) {
				Log.d("TAG", "搜索框 关闭  on collapse");
				return true;
			}
		});

		/**
		 * 分享
		 */
		MenuItem shareItem = menu.findItem(R.id.action_share);
		ShareActionProvider provider = (ShareActionProvider) shareItem.getActionProvider();
		provider.setShareIntent(getShareImgIntent());

		return super.onCreateOptionsMenu(menu);
	}

	/**
	 * 定义需要分享的Intent类型
	 * 
	 * @return
	 */
	private Intent getShareImgIntent() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/*");
		return intent;
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// overflow菜单中显示图标
		setOverflowIconVisible(featureId, menu);
		return super.onMenuOpened(featureId, menu);
	}

	/**
	 * 让右边3点 永远显示
	 */
	private void setOverflowShowingAlways() {
		try {
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
			menuKeyField.setAccessible(true);
			menuKeyField.setBoolean(config, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 让下拉的菜单显示 ICON
	 * 
	 * @param featureId
	 * @param menu
	 */
	public void setOverflowIconVisible(int featureId, Menu menu) {
		if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
			if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
				try {
					Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
					m.setAccessible(true);
					m.invoke(menu, true);
				} catch (Exception e) {
				}
			}
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent upIntent = NavUtils.getParentActivityIntent(this);
			if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
				TaskStackBuilder.create(this)
						.addNextIntentWithParentStack(upIntent)
						.startActivities();
			} else {
				upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				NavUtils.navigateUpTo(this, upIntent);
			}
			break;
		case R.id.action_settings:
			Toast.makeText(this, "Menu Item action_settings selected",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_edit:
			Toast.makeText(this, "Menu Item edit selected", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.action_search:
			Toast.makeText(this, "Menu Item search selected",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_help:
			Toast.makeText(this, "Menu Item  action_help selected",
					Toast.LENGTH_SHORT).show();

			Intent intent = new Intent(this, AddCustomViewActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	@SuppressWarnings("deprecation")
	public class MyTabListener<T extends Fragment> implements TabListener {
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;

		public MyTabListener(Activity activity, String tag, Class<T> clz) {
			mActivity = activity;
			mTag = tag;
			mClass = clz;
		}

		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			if (mFragment == null) {
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment, mTag);
			} else {
				ft.attach(mFragment);
			}
		}

		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if (mFragment != null) {
				ft.detach(mFragment);
			}
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
		}

	}
}
