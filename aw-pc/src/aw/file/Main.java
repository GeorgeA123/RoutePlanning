package aw.file;

public class Main {
	public static void main(String[] args){
	JobList jobList = new JobList();
	Job job = new Job(jobList.getJob2(2));
	System.out.println(job.numberItems());
	System.out.println(jobList.getJob2(2));
	
	
	System.out.println(job.getItem(2) + " " + job.getQuantity(2) + " " + job.getUtility());
	
	}

}
