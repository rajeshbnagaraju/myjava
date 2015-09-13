package org.hdp.wrdcount.totalorderpartitioner;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.lib.InputSampler;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.partition.TotalOrderPartitioner;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.log4j.Logger;
public class WordCountTotalOrderPartitionerJob extends Configured implements Tool {
    
	final static Logger logger = Logger.getLogger(WordCountTotalOrderPartitionerJob.class);
	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("************run method--->");
		Configuration conf = getConf();
		conf.set("mapred.child.java.opts", "-Xmx1024m");
		Job job = Job.getInstance(conf, "Word Count Job");	
		Path in = new Path(args[0]);
		Path out = new Path(args[1]);
		
		
		FileInputFormat.setInputPaths(job, in);
		FileOutputFormat.setOutputPath(job, out);
		job.setMapperClass(WordCountTotalOrderPartitionerMapper.class);
		job.setReducerClass(WordCountTotalOrderPartitionerReducer.class);
		job.setPartitionerClass(TotalOrderPartitioner.class);
		job.setNumReduceTasks(5);
		String partitionFile = TotalOrderPartitioner.getPartitionFile(getConf());
		TotalOrderPartitioner.setPartitionFile(job.getConfiguration(),
                new Path(partitionFile));
		InputSampler.Sampler<LongWritable, Text> sampler = 
				new InputSampler.RandomSampler<LongWritable, Text>(0.1,200,3);
		InputSampler.writePartitionFile(job, sampler);		
		URI partitionUri = new URI(partitionFile);
		logger.info("************adding cache file--->partitionUri:"+partitionUri);
		job.addCacheFile(partitionUri);		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		logger.info("************starting job--->");
		return job.waitForCompletion(true) ? 0 : 1;
	}

	public static void main(String args[]) {
		try {
			int result = ToolRunner.run(new Configuration(),
					new WordCountTotalOrderPartitionerJob(), args);
			System.exit(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}