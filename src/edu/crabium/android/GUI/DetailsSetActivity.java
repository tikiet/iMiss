
package edu.crabium.android.GUI;

import edu.crabium.android.SettingProvider;
import edu.crabium.android.IMissActivity;
import edu.crabium.android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class DetailsSetActivity extends Activity {
	private Button BackButton;
	private ToggleButton ServiceSwitchToggleButton, InformSwitchToggleButton, StrangerSwitchToggleButton;
	private TextView ServiceSwitchTextView, InformSwitchTextView, StrangerSwitchTextView;
	private static String ServiceSwitch = "service_switch";
	private static String InformSwitch = "inform_switch";
	private static String StrangerSwitch = "stranger_switch";
	
	SettingProvider sp = SettingProvider.getInstance();
	
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.software_set);
		
		ServiceSwitchTextView = (TextView) findViewById(R.id.service_switch_textview);
		ServiceSwitchToggleButton = (ToggleButton) findViewById(R.id.service_switch_togglebutton);
		ServiceSwitchToggleButton.setChecked(sp.getSetting(ServiceSwitch).equals("true"));
		
    	if (ServiceSwitchToggleButton.isChecked()) {
    		ServiceSwitchTextView.setText("服务开启");
    	} else {
    		ServiceSwitchTextView.setText("服务关闭");
    	}
    	
		ServiceSwitchToggleButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
            	if (ServiceSwitchToggleButton.isChecked()) {
            		sp.addSetting(ServiceSwitch, "true");
            		ServiceSwitchTextView.setText("服务开启");
            	} else {
            		sp.addSetting(ServiceSwitch, "false");
            		ServiceSwitchTextView.setText("服务关闭");
            	}
			}
		});
		
		InformSwitchTextView = (TextView) findViewById(R.id.inform_switch_textview);
		InformSwitchToggleButton = (ToggleButton) findViewById(R.id.inform_switch_togglebutton);
		InformSwitchToggleButton.setChecked(sp.getSetting(InformSwitch).equals("true"));
		
    	if (InformSwitchToggleButton.isChecked()) {
    		InformSwitchTextView.setText("通知开启");
    	} else {
    		InformSwitchTextView.setText("通知关闭");
    	}
    	
		InformSwitchToggleButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
            	if (InformSwitchToggleButton.isChecked()) {
            		sp.addSetting(InformSwitch, "true");
            		InformSwitchTextView.setText("通知开启");
            	} else {
            		sp.addSetting(InformSwitch, "false");
            		InformSwitchTextView.setText("通知关闭");
            	}
			}
		});
		
		StrangerSwitchTextView = (TextView) findViewById(R.id.stranger_switch_textview);
		StrangerSwitchToggleButton = (ToggleButton) findViewById(R.id.stranger_switch_togglebutton);
		StrangerSwitchToggleButton.setChecked(sp.getSetting(StrangerSwitch).equals("true"));
		
    	if (StrangerSwitchToggleButton.isChecked()) {
    		StrangerSwitchTextView.setText("陌生人回复开启");
    	} else {
    		StrangerSwitchTextView.setText("陌生人回复关闭");
    	}
    	
		StrangerSwitchToggleButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
            	if (StrangerSwitchToggleButton.isChecked()) {
            		sp.addSetting(StrangerSwitch, "true");
            		StrangerSwitchTextView.setText("陌生人回复开启");
            	} else {
            		sp.addSetting(StrangerSwitch, "false");
            		StrangerSwitchTextView.setText("陌生人回复关闭");
            	}
			}
		});
		
		BackButton = (Button)findViewById(R.id.back_button);
		BackButton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(DetailsSetActivity.this, IMissActivity.class);
				startActivity(intent);
				DetailsSetActivity.this.finish();
			}
		});
		

	}
	
	public void DisplayToast(String str) {
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}
}
