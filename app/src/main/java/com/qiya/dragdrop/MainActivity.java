package com.qiya.dragdrop;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	static String msg = "SX";
	Bomb bomb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView txtJarak = (TextView) findViewById(R.id.txtJarak);
		Dragable siji = (Dragable) findViewById(R.id.siji);
		Dragable loro = (Dragable) findViewById(R.id.loro);

	}
	
	class Task implements Runnable {
		@Override
		public void run() {
			try {
				
				
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) bomb.getLayoutParams();
		 	int left = lp.leftMargin + 1;
		 	int top = lp.topMargin + 1;
		 	lp.leftMargin = left;
		 	lp.topMargin = top;
		 	bomb.setLayoutParams(lp);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
