package org.hdp.WordCountCombiner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
public class WordCountJobCombiner extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job job = Job.getInstance(getConf(), "Word Count Job");
		Path in = new Path(args[0]);
		Path out = new Path(args[1]);
		//Path outCheckPath = new Path(args[2]);
		//Path checkOutPath = new Path("")
		FileInputFormat.setInputPaths(job, in);
		FileOutputFormat.setOutputPath(job, out);
		job.setMapperClass(WordCountMapperCombiner.class);
		job.setReducerClass(WordCountReducerCombiner.class);
		job.setCombinerClass(WordCountReducerCombiner.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		
		FileSystem fs = FileSystem.get(getConf());
		if(fs.exists(out)) {
			fs.delete(out,true);
		}
		return job.waitForCompletion(true) ? 0 : 1;
	}

	public static void main(String args[]) {
		// args[0]="/test/wordcount/ip/LICENSE.txt";
		// args[1]="/test/wordcount/op";
		try {
			int result = ToolRunner.run(new Configuration(),
					new WordCountJobCombiner(), args);
			System.exit(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
