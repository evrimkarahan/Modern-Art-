package com.coursera.modernartui;



import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class ModernArtFragment extends Fragment {
	private LinearLayout mBox1, mBox2, mBox3, mBox4, mBox5;
	private SeekBar mSeekBar;
	

	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.modern_art_fragment, parent, false);
		mBox1 = (LinearLayout) v.findViewById(R.id.colorBox1);
		mBox2 = (LinearLayout) v.findViewById(R.id.colorBox2);
		mBox3 = (LinearLayout) v.findViewById(R.id.colorBox3);
		mBox4 = (LinearLayout) v.findViewById(R.id.colorBox4);
		mBox5 = (LinearLayout) v.findViewById(R.id.colorBox5);
		
	
		mSeekBar =(SeekBar) v.findViewById(R.id.seekBar1);
		mSeekBar.setProgress(1);
		mSeekBar.incrementProgressBy(1);
		mSeekBar.setMax(100);
		
		mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			

		int prevProgress =-1;
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				
				int delta = progress - prevProgress;
				prevProgress = progress;
					
				
				mBox1.setBackgroundColor(changeColor(getColor(mBox1), delta));
				mBox2.setBackgroundColor(changeColor(getColor(mBox2), delta));
				mBox3.setBackgroundColor(changeColor(getColor(mBox3), delta));
				mBox5.setBackgroundColor(changeColor(getColor(mBox5), delta));
						
			
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		return v;
	}
	
	
	public int changeColor(int color, int delta) {
	   
	    //change color function separates a hexadecimal color to its RGB values. 
		int r = (color & 0xFF0000) >> 16;
	    int g = (color & 0xFF00) >> 8;
	    int b = (color & 0xFF);
	    
	    
	    return Color.rgb(r,setValue(g,delta),b);
	}
	
	
	public int setValue(int value, int delta){
		//Each R,G,B gets a value between 0-255. Try to keep each R,G,B value in this range.
		
		int calc = value+delta;
		if(calc<=255){
			return calc;
		}else{
			return value;
		}
	}
	
	public int getColor(View v){
		
		//get LinearLayout's background color
		
		int color = ((ColorDrawable) v.getBackground()).getColor();
		return color;
	}
	
	

}
