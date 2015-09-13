package org.hdp.wrdcount.custompartitioner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
public class WordCountCustomPartitionerJob extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job job = Job.getInstance(getConf(), "Word Count Job");
		Path in = new Path(args[0]);
		Path out = new Path(args[1]);
		FileSystem fs = FileSystem.get(getConf());
		// does not the HDFS setting that is set for the eclipse env
		Path pathOut = new Path("/test/wordcount/custompartitioner/op");
		if(fs.exists(pathOut)) {
			fs.delete(out,true);
		}
		FileInputFormat.setInputPaths(job, in);
		FileOutputFormat.setOutputPath(job, out);
		job.setMapperClass(WordCountCustomPartitionerMapper.class);
		job.setReducerClass(WordCountCustomPartitionerReducer.class);
		job.setPartitionerClass(WordCountPartitioner.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		job.setNumReduceTasks(3);
		return job.waitForCompletion(true) ? 0 : 1;
	}

	public static void main(String args[]) {
		// args[0]="/test/wordcount/ip/LICENSE.txt";
		// args[1]="/test/wordcount/op";
		try {
			int result = ToolRunner.run(new Configuration(),
					new WordCountCustomPartitionerJob(), args);
			System.exit(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
