package com.ib.mathapp.activity;

import java.io.InputStream;
import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ib.beans.MathsBean;
import com.ib.beans.QuestionsBean;
import com.ib.common.AppProperties;
import com.ib.common.Utils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class HomeActivity extends Activity implements OnClickListener{
	
private static final String LOG_TAG = "MathApp";
TextView zero,one,two,three,four,five,six,seven,eight,nine;
TextView txtInputShow,txtQuestion;
MediaPlayer numberPlayer;
ImageButton btnClear,btnAnswer;	

QuestionsBean currentQuestion;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		numberPlayer=new MediaPlayer();

		txtInputShow=(TextView) findViewById(R.id.txtInputShow);
		txtInputShow.setText("");
		
		zero=(TextView) findViewById(R.id.num0View);
		one=(TextView) findViewById(R.id.num1View);
		two=(TextView) findViewById(R.id.num2View);
		three=(TextView) findViewById(R.id.num3View);
		four=(TextView) findViewById(R.id.num4View);
		five=(TextView) findViewById(R.id.num5View);
		six=(TextView) findViewById(R.id.num6View);
		seven=(TextView) findViewById(R.id.num7View);
		eight=(TextView) findViewById(R.id.num8View);
		nine=(TextView) findViewById(R.id.num9View);

		btnAnswer=(ImageButton) findViewById(R.id.btnTick);
		btnClear=(ImageButton) findViewById(R.id.btnCross);
		btnAnswer.setOnClickListener(this);
		btnClear.setOnClickListener(this);
		
		zero.setOnClickListener(this);
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		
		
		txtQuestion=(TextView) findViewById(R.id.txtQuestion);
//		initMedia();
		initializeBackgrounds();
		
		
		
		////////////////////////////// POPULATING QUESTIONS
		InputStream in = getResources().openRawResource(R.raw.addition);
		String readFeed = Utils.convertStreamToString(in);
		XStream xStream = new XStream(new DomDriver());
		
		xStream.alias("math", MathsBean.class);
		xStream.alias("questions", QuestionsBean.class);
		xStream.alias("question", String.class);
		xStream.alias("answer", String.class);

		MathsBean questData=(MathsBean)xStream.fromXML(readFeed);
		AppProperties.setQuestionList(questData.getMath());
		///////////////////////////// DATA READY
		currentQuestion=AppProperties.getNextQuestion();
		txtQuestion.setText(currentQuestion.getQuestion().trim());
		System.out.println("333333333333333");
		
		}

 

	private void initializeBackgrounds() {
		Random rand=new Random();
		int min=0, max=2;
		int randomNum = rand.nextInt(max - min + 1) + min;
		int[] bgArray = AppProperties.starImagesArray;
		
		if(randomNum==0){
			bgArray = AppProperties.starImagesArray;			
		}
		if(randomNum==1){
			bgArray = AppProperties.heartImagesArray;			
		}
		if(randomNum==2){
			bgArray = AppProperties.circleImagesArray;			
		}
		
		
		zero.setBackgroundResource(bgArray[0]);
		one.setBackgroundResource(bgArray[1]);
		two.setBackgroundResource(bgArray[2]);
		three.setBackgroundResource(bgArray[3]);
		four.setBackgroundResource(bgArray[4]);
		five.setBackgroundResource(bgArray[5]);
		six.setBackgroundResource(bgArray[6]);
		seven.setBackgroundResource(bgArray[7]);
		eight.setBackgroundResource(bgArray[8]);
		nine.setBackgroundResource(bgArray[9]);
		
		
	}

	@Override
	public void onClick(View v) {
		
		if(v==zero){
			addToInput("0");
			startPlayingAudio(0);
		}else if(v==one){
			addToInput("1");
			startPlayingAudio(1);
		}else if(v==two){
			addToInput("2");
			startPlayingAudio(2);
		}else if(v==three){
			addToInput("3");
			startPlayingAudio(3);
		}else if(v==four){
			addToInput("4");
			startPlayingAudio(4);
		}else if(v==five){
			addToInput("5");
			startPlayingAudio(5);
		}else if(v==six){
			addToInput("6");
			startPlayingAudio(6);
		}else if(v==seven){
			addToInput("7");
			startPlayingAudio(7);
		}else if(v==eight){
			addToInput("8");
			startPlayingAudio(8);
		}else if(v==nine){
			addToInput("9");
			startPlayingAudio(9);
		}else if(v==btnClear){
			
			txtInputShow.setText("");
		}else if(v==btnAnswer){
			
			String answer=txtInputShow.getText().toString();
			if(answer.equals(currentQuestion.getAnswer().trim()))
					{
						
						txtInputShow.setText("");
						currentQuestion=AppProperties.getNextQuestion();
						if(currentQuestion != null)
							{
							showAnim("good");
							txtQuestion.setText(currentQuestion.getQuestion().trim());
							}
						else{
							showAnim("level");
//							Utils.openErrorDialog(HomeActivity.this, "Level Completed");
						}
					}else{
						showAnim("wrong");
					}
		} 
	}
	   private void startPlayingAudio(int option)
	   {
	       try {
	    	   
	    	   Uri path1=null;
	    	   switch (option) {
				case 0:
					path1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.num0);
					break;
				case 1:
					path1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.num1);
					break;
				case 2:
					path1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.num2);
					break;
				case 3:
					path1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.num3);
					break;
				case 4:
					path1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.num4);
					break;
				case 5:
					path1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.num5);
					break;
				case 6:
					path1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.num6);
					break;
				case 7:
					path1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.num7);
					break;
				case 8:
					path1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.num8);
					break;
				case 9:
					path1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.num9);
					break;

			default:
				break;
			}
	            
	           
	           
	           
	           numberPlayer.reset();  // reset to idle state
	           numberPlayer.setDataSource(this, path1); // from idle to initialised state

	           numberPlayer.prepare();

	           numberPlayer.start();         
	       } catch (Exception ioe) {
	           Log.e(LOG_TAG, "Error playing the beep sound");
	       }
	   }
	void addToInput(String val){
		
		String curent=txtInputShow.getText().toString();
		curent=curent+val;
		
		txtInputShow.setText(curent);
	}
	AnimationDrawable bg_frame;
	Dialog dialog;
	String animType="";
	public void showAnim(String type){
		animType=type;
		dialog= new Dialog(HomeActivity.this,R.style.Themedialog);
//		 dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
         dialog.setContentView(R.layout.dg_screen);	            
         
         dialog.setCancelable(true);
         
         dialog.show();
			LinearLayout bg_Layout = (LinearLayout)dialog.findViewById(R.id.gifView);
			
			if("level".equals(type))
				bg_Layout.setBackgroundResource(R.drawable.level_animation);
			else if("good".equals(type))
				bg_Layout.setBackgroundResource(R.drawable.good_animation);
			else
				bg_Layout.setBackgroundResource(R.drawable.wrong_animation);
			
	        
	         bg_frame = (AnimationDrawable) bg_Layout.getBackground();
	         ibHandler.postDelayed(splashHandler, 3000);
         
	}
	@Override   
	public void onWindowFocusChanged(boolean hasFocus){
		if(null != bg_frame)
		 bg_frame.start();
	    }
	
	
	final Handler ibHandler = new Handler();
	final Runnable splashHandler = new Runnable() {
		public void run() {
			bg_frame.stop();
			dialog.dismiss();
			if("level".equals(animType)){
				Intent intent = new Intent(HomeActivity.this,MenuActivity.class);
				startActivity(intent);
				finish();
			}
		}
	};
}