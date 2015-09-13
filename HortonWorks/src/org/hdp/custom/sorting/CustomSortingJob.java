package org.hdp.custom.sorting;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
//import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.IntWritable;
public class CustomSortingJob extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job job = Job.getInstance(getConf(), "Word Count Job");
		Path in = new Path(args[0]);
		Path out = new Path(args[1]);
		
		FileInputFormat.setInputPaths(job, in);
		FileOutputFormat.setOutputPath(job, out);
		job.setMapperClass(CustomSortingMapper.class);
		job.setReducerClass(CustomSortReducer.class);
		
		//job.setInputFormatClass(TextInputFormat.class);
		//job.setOutputFormatClass(TextOutputFormat.class);
		
		
		job.setMapOutputKeyClass(RatingsKey.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(RatingsKey.class);
		job.setOutputValueClass(Text.class);
		
		return job.waitForCompletion(true) ? 0 : 1;
	}

	public static void main(String args[]) {
		// args[0]="/test/wordcount/ip/LICENSE.txt";
		// args[1]="/test/wordcount/op";
		try {
			int result = ToolRunner.run(new Configuration(),
					new CustomSortingJob(), args);
			System.exit(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
