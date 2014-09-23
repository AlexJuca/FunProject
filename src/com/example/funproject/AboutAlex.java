package com.example.funproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class AboutAlex extends Activity {

	protected ImageView aboutLogo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_alex);
		
		aboutLogo = (ImageView) findViewById(R.id.logo_about);
		YoYo.with(Techniques.BounceInDown).duration(900).playOn(aboutLogo);
		
		aboutLogo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(Intent.ACTION_VIEW, 
					       Uri.parse("https://github.com/AlexJuca/"));
					startActivity(i);
				
			}
		});
		
	}


}