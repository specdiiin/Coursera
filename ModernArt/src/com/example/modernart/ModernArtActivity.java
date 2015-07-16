package com.example.modernart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ModernArtActivity extends Activity {

	
	
	 private SeekBar colorSekBar;
	 private LinearLayout yellowRectangle;
	 private LinearLayout yellowRectangle2;
	 private LinearLayout orangeRectangle;
	 private LinearLayout greyRectangle;
	 private LinearLayout greenRectangle;

	    @SuppressLint("NewApi")
		@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_modern_art);
	        yellowRectangle = (LinearLayout) findViewById(R.id.yellowRect1);
	   	 yellowRectangle2= (LinearLayout) findViewById(R.id.yellowRect2);
	   	 orangeRectangle= (LinearLayout) findViewById(R.id.orangeRect);
	   	 greyRectangle= (LinearLayout) findViewById(R.id.greyRect);
	   	 greenRectangle= (LinearLayout) findViewById(R.id.greenRect);
	   	 
	   	final int yellowInitial = ((ColorDrawable) yellowRectangle.getBackground()).getColor();
	   	final int yellow2Initial = ((ColorDrawable) yellowRectangle2.getBackground()).getColor();
	   	final int orangeInitial = ((ColorDrawable) orangeRectangle.getBackground()).getColor();
	   	final int greyInitial = ((ColorDrawable) greyRectangle.getBackground()).getColor();
	   	final int greenInitial = ((ColorDrawable) greenRectangle.getBackground()).getColor();

	        colorSekBar = (SeekBar) findViewById(R.id.colorSeekBar);
	        colorSekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
	            int progressChanged = 0;

	            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
	                progressChanged = progress;
	             
	                changeBackgroundColor(yellowRectangle, yellowInitial);
	                changeBackgroundColor(yellowRectangle2, yellow2Initial);
	                changeBackgroundColor(orangeRectangle, orangeInitial);
	                changeBackgroundColor(greyRectangle, greyInitial);
	                changeBackgroundColor(greenRectangle, greenInitial);
	            }

	            public void onStartTrackingTouch(SeekBar seekBar) {
	                // TODO Auto-generated method stub
	            }

	            public void onStopTrackingTouch(SeekBar seekBar) {

	            }

	            private void changeBackgroundColor(LinearLayout box, int OriginalBoxColor) {
	                float[] hsvColor = new float[3];
	                Color.colorToHSV(OriginalBoxColor, hsvColor);
	                hsvColor[0] = hsvColor[0] + progressChanged;
	                hsvColor[0] = hsvColor[0] % 360;
	                box.setBackgroundColor(Color.HSVToColor(Color.alpha(OriginalBoxColor), hsvColor));
	            }
	        });

	    }

	    @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.modern_art, menu);
			return true;
		}
	   


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_more_information) {
            DialogFragment moreInfoFragment = new MoreInfoDialog();
            moreInfoFragment.show(getFragmentManager(), "Info");
            return true;
        }

        return super.onOptionsItemSelected(item);
	}
}
	