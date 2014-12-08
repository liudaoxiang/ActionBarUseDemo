package com.example.actionbartest.actionprovider;

import com.example.actionbartest.MyAPP;
import com.example.actionbartest.R;
import com.example.actionbartest.R.drawable;

import android.content.Context;
import android.util.Log;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;

public class SubItemAction extends ActionProvider {

	protected static final String TAG = "MyActionProvider";
	private Context mContext;
	public SubItemAction(Context context) {
		super(context);
		mContext = context;
	}

	@Override
	public View onCreateActionView() {
		
		Button button = new Button(mContext);
		button.setText("使用");
		
		return button;
	}

	@Override
	public void onPrepareSubMenu(SubMenu subMenu) {
		subMenu.clear();
		subMenu.add("sub item 1").setIcon(R.drawable.ic_launcher)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						MyAPP.showToast("sub item 1");
						return true;
					}
				});
		subMenu.add("sub item 2").setIcon(R.drawable.ic_launcher)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						MyAPP.showToast("sub item 2");
						return false;
					}
				});
	}

	@Override
	public boolean hasSubMenu() {
		return true;
	}
}
