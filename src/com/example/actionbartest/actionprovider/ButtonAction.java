package com.example.actionbartest.actionprovider;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.actionbartest.MyAPP;
import com.example.actionbartest.R;

public class ButtonAction extends ActionProvider {
	private Context mContext;
	private LayoutInflater inflater;
	private View view;
	private Button button;

	public ButtonAction(Context context) {
		super(context);
		mContext = context;
		inflater = LayoutInflater.from(context);
		view = inflater.inflate(R.layout.myaction, null);
	}

	@Override
	public View onCreateActionView() {
		button = (Button) view.findViewById(R.id.tst);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				MyAPP.showToast("使用");
				
				//进行跳转
//				final Intent sSettingsIntent = new Intent(Settings.ACTION_SETTINGS);
//				context.startActivity(sSettingsIntent);
			}
		});
		return view;
	}
}
