package com.example.videorectest;
import java.io.IOException;

import android.app.Activity;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	MediaRecorder recorder;
	
	SurfaceHolder holder;
	
	String path="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity); 
		
		recorder=new MediaRecorder();
		
		SurfaceView srf=(SurfaceView)findViewById(R.id.srf);
		
		holder=srf.getHolder();
		
		
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC); 
		recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
		
		
		CamcorderProfile prof=CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH);
		
		
		recorder.setProfile(prof);
		
		path="/storage/sdcard0/"+System.currentTimeMillis()+".mp4";
		recorder.setOutputFile(path);
		
		recorder.setPreviewDisplay(holder.getSurface());
		
		
		Button btnStart=(Button)findViewById(R.id.btnStart);
		Button btnStop=(Button)findViewById(R.id.btnStop);
		
		
		btnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		
				try {
					recorder.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				recorder.start();
				
				
				
			}
		});
		
		btnStop.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				recorder.stop();
			}
		});
		
		
		
		
		
		
		
		
		
		
	}
}