package com.example.funproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CourseAdapter extends ArrayAdapter<String>{
	
	
	protected Context mContext;
	protected String[] mData;
	protected String[] courseLevels = {"Beginner","Intermediate","Advanced"};
	protected int[] courseImages = {R.drawable.courseimage, R.drawable.javascript, R.drawable.cuda, R.drawable.hackingdroid};
	protected int[] courseImageWrapperColors = {R.color.styleColor1, R.color.styleColor2, R.color.styleColor3, R.color.styleColor4};
	protected String[] course = {"course"};
	
	public CourseAdapter(Context context, String[] data)
	{
		super(context, R.layout.course_item, data);
		mContext = context;
		mData = data;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if (convertView == null)
		{
		
			convertView = LayoutInflater.from(mContext).inflate(R.layout.course_item, null);
			holder = new ViewHolder();
			holder.courseImageWrapper = (LinearLayout)convertView.findViewById(R.id.courseImageWrapper);
			holder.courseLabel = (TextView)convertView.findViewById(R.id.course);
			holder.courseTitle = (TextView)convertView.findViewById(R.id.courseTitle);
			holder.courseLevel = (TextView)convertView.findViewById(R.id.courseLevel);
			holder.courseImage = (ImageView)convertView.findViewById(R.id.courseimage);
			
			holder.courseImageWrapper.setBackgroundResource(courseImageWrapperColors[position]);
			holder.courseImage.setImageResource(courseImages[position]);
			holder.courseLabel.setText(course[0]);
			holder.courseTitle.setText(mData[position]);
			holder.courseLevel.setText(courseLevels[0]);
			
		}else
		{
			holder = (ViewHolder)convertView.getTag();
		}
		
		return convertView;
	}
	
	private static class ViewHolder
	{
		TextView courseLabel;
		TextView courseTitle;
		TextView courseLevel;
		ImageView courseImage;
		LinearLayout courseImageWrapper;
	}
	
		//Elegantly refill list instead of reloading the fragement everytime
		public void refill(String[] mData)
		{
			
			notifyDataSetChanged();
		}

}
