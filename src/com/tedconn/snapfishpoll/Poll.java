package com.tedconn.snapfishpoll;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class Poll extends Activity 
{
	public void onCreate(Bundle savedBundleInstance)
	{
		super.onCreate(savedBundleInstance);
		setContentView(new DrawTest(this));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(Menu.NONE, Menu.NONE, Menu.NONE, "Pie");
		menu.add(Menu.NONE, Menu.NONE, Menu.NONE, "Line");
		menu.add(Menu.NONE, Menu.NONE, Menu.NONE, "Chart");
		return true;
	}
	
	class DrawTest extends SurfaceView implements SurfaceHolder.Callback
	{

		public DrawTest(Context context)
		{
			super(context);
		}
		
		@Override 
		public void onDraw(Canvas canvas)
		{
			canvas.drawColor(Color.BLACK);
		}
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
		{
			// TODO Auto-generated method stub
		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			
		}
	}
}
