package org.hdp.custom.outputformat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
//import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.io.Text;
import org.apache.log4j.Logger;

public class CountryWiseJob extends Configured implements Tool {
	final static Logger logger = Logger.getLogger(CountryWiseJob.class);

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Configuration conf = getConf();
		conf.set("yarn.scheduler.maximum-allocation-mb","-Xmx2048m");
		conf.set("mapreduce.map.java.opts","-Xmx1024m");
		Job job = Job.getInstance(conf, "Custom Ouput Job");
		Path in = new Path(args[0]);
		Path out = new Path(args[1]);
		logger.info("******************Got the path*******************"+in.getName()+"::"+out.getName());
		FileInputFormat.setInputPaths(job, in);
		CountryWiseOutputFormat.setOutputPath(job, out);
		job.setMapperClass(CountryWiseMapper.class);
		job.setReducerClass(CountryWiseReducer.class);
		logger.info("**** Mapper Class and Reducer class set*****");
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		logger.info("******************Before setting the input and output format*******************");
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(CountryWiseOutputFormat.class);
		logger.info("******************Wait for completion*******************");
		return job.waitForCompletion(true) ? 0 : 1;
	}

	public static void main(String args[]) {
		// args[0]="/test/wordcount/ip/LICENSE.txt";
		// args[1]="/test/wordcount/op";
		try {
			int result = ToolRunner.run(new Configuration(),
					new CountryWiseJob(), args);
			System.exit(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
