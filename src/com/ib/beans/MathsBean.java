package com.ib.beans;

import java.util.ArrayList;


public class MathsBean{

	private ArrayList<QuestionsBean> questionslist=new ArrayList<QuestionsBean>();

	public ArrayList<QuestionsBean> getMath() {
		return questionslist;
	}

	public void setMath(ArrayList<QuestionsBean> questionslist) {
		this.questionslist = questionslist;
	}
	 
	}
