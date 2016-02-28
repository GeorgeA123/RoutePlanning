package aw.GUI;

import aw.file.Job;

public class Information {
	
	private Job job;
	
	public Information(){
		job = new Job("10001,ce,2,bi,6,aj,2,bc,3,ab,1,af,4,ai,1");
	}
	
	
	public Job getJob() {
		return job;
	}
	
	public void setJob(Job job){
		this.job = job;
	}
	
	public int getJobID(){
		return job.getID();
	}
	
	public String getJobItem(int index) {
		return job.getItem(index);
	}
	
	public double getUtility() {
		return job.getUtility();
	}
	
	public int numberItems() {
		return job.numberItems();
	}

}