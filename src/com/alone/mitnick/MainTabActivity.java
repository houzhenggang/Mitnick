package com.alone.mitnick;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MainTabActivity extends TabActivity {
	
	private TabHost tabHost;
	private TextView main_tab_new_message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); 
		setContentView(R.layout.activity_main_tab);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);  //titlebar标题栏的布局
		
		main_tab_new_message=(TextView) findViewById(R.id.main_tab_new_message);
        main_tab_new_message.setVisibility(View.VISIBLE);
        main_tab_new_message.setText("10");
        
        tabHost=this.getTabHost();
        TabHost.TabSpec spec;
        Intent intent;
        
        intent=new Intent().setClass(this, MainActivity.class);
        spec=tabHost.newTabSpec("首页").setIndicator("首页").setContent(intent);
        tabHost.addTab(spec);
        
        intent=new Intent().setClass(this,MoreActivity.class);
        spec=tabHost.newTabSpec("分类").setIndicator("分类").setContent(intent);
        tabHost.addTab(spec);
        
        intent=new Intent().setClass(this, MoreActivity.class);
        spec=tabHost.newTabSpec("喜欢").setIndicator("喜欢").setContent(intent);
        tabHost.addTab(spec);
        
     
        intent=new Intent().setClass(this, MoreActivity.class);
        spec=tabHost.newTabSpec("设置").setIndicator("设置").setContent(intent);
        tabHost.addTab(spec);
        tabHost.setCurrentTab(0);
        
        RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.main_tab_group);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
        	@Override
        	public void onCheckedChanged(RadioGroup group, int checkedId) {
        		// TODO Auto-generated method stub
        		switch (checkedId) {
        		case R.id.radio_button0:
        			tabHost.setCurrentTabByTag("首页");
        			break;
        		case R.id.radio_button1:
        			tabHost.setCurrentTabByTag("分类");
        			break;
        		case R.id.radio_button2:
        			tabHost.setCurrentTabByTag("喜欢");
        			break;
        		case R.id.radio_button3:
        			tabHost.setCurrentTabByTag("设置");
        			break;
        		default:
        			break;
        		}
        	}
		});
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main_tab, menu);
		return true;
	}

}
