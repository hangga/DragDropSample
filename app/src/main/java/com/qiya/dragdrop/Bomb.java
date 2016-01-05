package com.qiya.dragdrop;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class Bomb extends RelativeLayout{
	
	Bomb bomb;
	
	private Handler handler = new Handler();

	public Bomb(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public Bomb(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public Bomb(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		//bomb = this;
		//this.setOnTouchListener(onTouchListener);
		//this.removeOnAttachStateChangeListener(listener);
		//runnable.run();
	}
	
	OnTouchListener onTouchListener = new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			try {
				((RelativeLayout)v.getParent()).removeView(v);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return true;
		}
	};
	
	/*private Runnable runnable = new Runnable() 
	{
	    public void run() 
	    {
	         RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) bomb.getLayoutParams();
		 	 int left = lp.leftMargin + 1;
		 	 int top = lp.topMargin + 1;
		 	 lp.leftMargin = left;
		 	 lp.topMargin = top;
		 	 bomb.setLayoutParams(lp);
		 	 
	         handler.postDelayed(this, 1000);
	    }
	};*/

}
