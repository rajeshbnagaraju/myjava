package org.hdp.average;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.log4j.Logger;

public class AverageJob extends Configured implements Tool {
	final static Logger logger = Logger.getLogger(AverageJob.class);

	public void writeInputFile(FileSystem fs,Path in) {
		int min = 1;
		int max = 1000;
	    Random rand = new Random();	   
	    PrintWriter writer = null;
	    String ipSrc = "testInputUpload.txt";
	    Path ipPath = new Path(ipSrc);
	    try {
			 writer = new PrintWriter(ipSrc, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    for(int i=0;i<1000;i++) {
	    	int randomNum = rand.nextInt((max - min) + 1) + min;
	    	writer.println(randomNum+"");
	    }
	    writer.close();
	    logger.info("**************Created local file:"+ipPath.toUri()+"::now writing to "+in.toUri());
	    try {
			fs.copyFromLocalFile(ipPath, in);
			logger.info("**************HDFS file"+fs.exists(in));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job job = Job.getInstance(getConf(), "Average Job");
		Path in = new Path(args[0]);
		Path ip = new Path(args[1]);
		Path out = new Path(args[2]);
		FileSystem fs = FileSystem.get(getConf());
		writeInputFile(fs,in);
		// does not the HDFS setting that is set for the eclipse env
		Path pathOut = new Path("/test/average/op");
		if(fs.exists(pathOut)) {
			fs.delete(out,true);
		}
		
		FileInputFormat.setInputPaths(job, ip);
		FileOutputFormat.setOutputPath(job, out);
		job.setMapperClass(AverageMapper.class);
		job.setReducerClass(AverageReducer.class);
		job.setNumReduceTasks(1);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(IntWritable.class);
		
		return job.waitForCompletion(true) ? 0 : 1;
	}

	public static void main(String args[]) {
		try {
			int result = ToolRunner.run(new Configuration(),
					new AverageJob(), args);
			System.exit(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
