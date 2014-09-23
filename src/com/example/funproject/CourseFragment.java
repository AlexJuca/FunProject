package com.example.funproject;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class CourseFragment extends ListFragment {

	protected String[] mData = {"Python Programming", "Javascript Basics", "Cuda Programming", "Hacking Android"};
	protected SwipeRefreshLayout mRefreshLayout;
	protected TextView mHi;
	protected LinearLayout mProfile;
	protected ImageView mProfileImage;
	
	public View rootView;
	
	private static final String ARG_SECTION_NUMBER = "section_number";

	public static CourseFragment newInstance(int sectionNumber) {
		CourseFragment fragment = new CourseFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public CourseFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		mHi = (TextView)rootView.findViewById(R.id.hi);
		mRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.refreshLayout);
		mRefreshLayout.setColorScheme(R.color.styleColor1, R.color.styleColor2, R.color.courseWrapperBackground, R.color.styleColor4);
		mRefreshLayout.setOnRefreshListener(mOnRefreshListner);
		mProfile = (LinearLayout)rootView.findViewById(R.id.profile);
		mProfile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				mProfile.setBackgroundResource(R.color.styleColor2);
				intentAnimation();
				
			}
		});
		
		return rootView;
	}
	
	@Override
	public void onResume() {
		
		super.onResume();
		CourseAdapter adapter = new CourseAdapter(getActivity(), mData);
		
		
		if (getListView().getAdapter() == null) {
			CourseAdapter messageAdapter = new CourseAdapter(
					getActivity(), mData);
			setListAdapter(adapter);
		} else {
			// Refresh list
			((CourseAdapter) getListView().getAdapter())
					.refill(mData);
		}

		
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		switch (position) {
		case 0:
			YoYo.with(Techniques.RubberBand)
		    .duration(700)
		    .playOn(v);
			
			YoYo.with(Techniques.FadeInLeft)
		    .duration(700)
		    .playOn(mHi);
			
			mHi.setText("Its so simple to use this animation. YoYo.with(Techniques.RubberBand).duration(700) .playOn(v);");
			break;
		case 1:
			YoYo.with(Techniques.DropOut)
		    .duration(700)
		    .playOn(v);
			mHi.setText("It took me about two hours in total to create this app. Practice makes perfect!");
			
			YoYo.with(Techniques.FadeInRight)
		    .duration(700)
		    .playOn(mHi);
			break;
		case 2:
			YoYo.with(Techniques.Swing)
		    .duration(700)
		   .playOn(v);
			mHi.setText("Mobile Development is a great market");
			
			YoYo.with(Techniques.FadeInDown)
		    .duration(700)
		    .playOn(mHi);
			break;
		case 3:
			YoYo.with(Techniques.FlipInX)
		    .duration(700)
		    .playOn(v);
			
			YoYo.with(Techniques.FadeInUp)
		    .duration(700)
		    .playOn(mHi);
			
			mHi.setText("I am a multi skilled Software Developer. I love all platforms! I can't wait to program Quantum Computers.");
			
		default:
			break;
		}
		
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(getArguments().getInt(
				ARG_SECTION_NUMBER));
	}
	
	protected OnRefreshListener mOnRefreshListner = new OnRefreshListener() {
			
			@Override
			public void onRefresh() {
				Toast.makeText(getActivity(), "No new courses!", Toast.LENGTH_SHORT).show();
//				mRefreshLayout.setRefreshing(false);
			}
		};
		
		
		protected void intentAnimation(){
			/*
			 *  This is the code responsible for starting the about activity with that nice little animation from the left.
			 *  Check out the xml code I defined in the res/anim/ folder. Thats where you should define the in and out transitions
			 */
			Intent about = new Intent(getActivity(), AboutAlex.class);
			startActivity(about);
			getActivity().overridePendingTransition(R.anim.push_left_in,R.anim.push_up);
		}
		
	
}