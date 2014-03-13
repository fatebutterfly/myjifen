package com.baidu.mobads.demo.wall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.mobads.appoffers.OffersManager;

public class BaiduSdkWallDemo extends Activity {
	Button btnOpenWall;
	Button btnAddPoint;
	Button btnSubPoint;
	Button btnShowInView;
	TextView tv;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);
		
		tv=(TextView) findViewById(R.id.info);
		
		//代码设置APPSID与计费名，下面的设置方法与配置文件中的设置是等价的。
		//OffersManager.setAppSid(appSid);
		//OffersManager.setAppSec(appSec);
		
		//设置积分监听接口
//		OffersManager.setPointsChangeListener(new PointsChangeListener(){
//
//			@Override
//			public void onPointsChanged(int arg0) {
//				Log.d("onPointsChanged", "total points is: "+arg0);
//				tv.setText(""+arg0);
//			}
//			
//		});
		
		btnOpenWall = (Button) findViewById(R.id.action);
		btnOpenWall.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//打开积分墙
				OffersManager.showOffers(BaiduSdkWallDemo.this);
			}
		});
		btnAddPoint=(Button)this.findViewById(R.id.addTen);
		btnSubPoint=(Button)this.findViewById(R.id.subTwnty);
		btnAddPoint.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//增加10积分
				OffersManager.addPoints(BaiduSdkWallDemo.this, 10);
			}
		});
		btnSubPoint.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//减去20积分
				OffersManager.subPoints(BaiduSdkWallDemo.this, 20);
			}
		});

		btnShowInView=(Button)this.findViewById(R.id.inner);
		btnShowInView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(BaiduSdkWallDemo.this,ShowInActivity.class);
				startActivity(intent);
			}
		});
		
		int points=OffersManager.getPoints(this);
		tv.setText(""+points);
	}
}
