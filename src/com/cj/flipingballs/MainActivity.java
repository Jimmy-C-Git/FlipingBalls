package com.cj.flipingballs;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		WindowManager windowManager = getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		int screenWidth = screenWidth = display.getWidth();
		int screenHeight = screenHeight = display.getHeight();

		// ·½·¨2
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		float width = dm.widthPixels * dm.density;
		float height = dm.heightPixels * dm.density;
		float width1=dm.xdpi;
		float height1=dm.ydpi;
		float width2=dm.widthPixels;
		float height2=dm.heightPixels;
		setContentView(new TwoDWorld(this));
		//setContentView(new MyView(this));
    }
}
