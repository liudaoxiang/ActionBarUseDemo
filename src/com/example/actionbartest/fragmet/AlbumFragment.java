package com.example.actionbartest.fragmet;

import com.example.actionbartest.AddCustomViewActivity;
import com.example.actionbartest.NaviListActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class AlbumFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		TextView textView = new TextView(getActivity());
		textView.setText("Album Fragment");
		textView.setGravity(Gravity.CENTER);
		textView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final Intent intent = new Intent(getActivity(), AddCustomViewActivity.class);
				startActivity(intent);
			}
		});
		LinearLayout layout = new LinearLayout(getActivity());
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.gravity = Gravity.CENTER;
		layout.addView(textView, params);
		return layout;
	}

}