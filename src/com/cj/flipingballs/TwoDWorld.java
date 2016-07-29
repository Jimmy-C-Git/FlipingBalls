package com.cj.flipingballs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class TwoDWorld extends SurfaceView implements SurfaceHolder.Callback,Runnable{

	SurfaceHolder holder=null;  
    Paint paint;  
    Thread mThread;
    public TwoDWorld(Context context)
    {
    	super(context);
    	holder=getHolder();  
        holder.addCallback(this);  
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);  
        paint.setColor(Color.RED);  
        this.setFocusable(true); 
    }
	public TwoDWorld(Context context, AttributeSet attrs) {
		super(context, attrs);
		 holder=getHolder();  
         holder.addCallback(this);  
         paint=new Paint(Paint.ANTI_ALIAS_FLAG);  
         paint.setColor(Color.RED);  
         this.setFocusable(true); 
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		mThread=new Thread(this);  
        mThread.start();  
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		mThread.interrupt();
	}

	
	 private void paint(Paint paint) {  
         Canvas canvas=holder.lockCanvas();  
         //к╒фа    
         if(canvas==null)return ;
         canvas.drawColor(Color.BLACK);  
           
         canvas.drawCircle(x, y, 10, paint);  
           
         holder.unlockCanvasAndPost(canvas);  
     }  
       
     
     @Override  
     public void run() {
         while (!mThread.isInterrupted()) {
             paint(paint);  
             move();  
             try {  
                 Thread.sleep(50);  
             } catch (InterruptedException e) {  
                 // TODO Auto-generated catch block  
                 e.printStackTrace();  
             }  
               
         }  
     }  
       
     private int x,y;  
     private void move(){
         x+=2;  
         y+=2;  
     }
}
