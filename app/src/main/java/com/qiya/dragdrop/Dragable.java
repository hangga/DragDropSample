package com.qiya.dragdrop;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class Dragable extends RelativeLayout{

	private int delta_x;
	private int delta_y;
	
	private int px;
	private int py;
	
	public int getPx() {
		return px;
	}

	public int getPy() {
		return py;
	}

	public Dragable(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public Dragable(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public Dragable(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		this.setOnTouchListener(onTouchListener);
	}

	OnTouchListener onTouchListener = new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			
			final int X = (int) event.getRawX();
			final int Y = (int) event.getRawY();
			
			switch (event.getAction() & MotionEvent.ACTION_MASK) {
			
			case MotionEvent.ACTION_DOWN:
				RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
				delta_x = X - lParams.leftMargin;
				delta_y = Y - lParams.topMargin;
				break;
			
			case MotionEvent.ACTION_MOVE:
				Log.d("SX", String.valueOf(event.getRawX()+"|"+event.getRawY()));
				
				RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
				px = X - delta_x;
				py = Y - delta_y;
				layoutParams.leftMargin = px;
				layoutParams.topMargin = py;
				layoutParams.rightMargin = -250;
				layoutParams.bottomMargin = -250;
				v.setLayoutParams(layoutParams);
	            break;
			}
			
			return true;
		}
	};

}
