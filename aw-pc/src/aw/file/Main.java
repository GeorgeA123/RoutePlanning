package aw.file;

import javax.print.attribute.standard.NumberOfDocuments;

public class Main {
	public static void main(String[] args) {
//		JobList jobList = new JobList();
		// Job job = new Job(jobList.getJob(2));
		// System.out.println(job.numberItems());
		// System.out.println(jobList.getJob(2));
		// System.out.println(job.getJobReward());

		// System.out.println(job.getItem(2) + " " + job.getQuantity(2) + " " +
		// job.getUtility());
		// System.out.println(jobList);
//		for (int i = 0; i < jobList.numberJobs(); i++)
//			System.out.println(job.getUtility());

		Drop abc = new Drop();
	//	System.out.println(abc);
		for(int j = 0; j < abc.numberDrops(); j++){
			System.out.println(abc.getX(j) + " " + abc.getY(j));
		}
			
		
	}

}
