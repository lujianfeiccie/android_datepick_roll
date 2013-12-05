package com.example.datepicker_roll;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity implements OnWheelChangedListener{

	private WheelView  wheel_cars;
	private TextView txt_msg;
	String data[]={"一项","两项","三项","四项","五项","六项","七项"};
	int currentItemIndex = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
		initData();
		initEvent();
	}

	private void initEvent() {
		wheel_cars.addChangingListener(this);
	}

	private void initData() {
		txt_msg.setText(data[currentItemIndex]);
		wheel_cars.setVisibleItems(5);
		ArrayWheelAdapter<String> cars_adapter = new ArrayWheelAdapter<String>(this, data);
		wheel_cars.setViewAdapter(cars_adapter);
		wheel_cars.setCurrentItem(currentItemIndex);
	}

	private void initView() {
		wheel_cars = (WheelView) findViewById(R.id.wheel_cars);
		txt_msg = (TextView)findViewById(R.id.txt_msg);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onChanged(WheelView wheel, int oldValue, int newValue) {
		log(String.format("oldValue=%s newValue=%s", oldValue,newValue));
		txt_msg.setText(data[newValue]);
	}
	void log(String msg){
		Log.d(getClass().getSimpleName(), msg);
	}
}
