package org.hdp.custom.outputformat;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.Logger;

public class CountryWiseOutputFormat extends FileOutputFormat<Text, Iterable<Text>> {
	final static Logger logger = Logger.getLogger(CountryWiseOutputFormat.class);
	@Override
	public RecordWriter<Text, Iterable<Text>> getRecordWriter(TaskAttemptContext job)
			throws IOException, InterruptedException { 
		return new CountryWiseRecordWriter(job,getDefaultWorkFile(job,""));
	}

}
