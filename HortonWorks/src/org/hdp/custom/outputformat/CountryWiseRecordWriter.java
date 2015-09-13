package org.hdp.custom.outputformat;

import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.log4j.Logger;

public class CountryWiseRecordWriter extends RecordWriter<Text, Iterable<Text>> {
	private DataOutputStream out;
	private TaskAttemptContext job;
	final static Logger logger = Logger
			.getLogger(CountryWiseRecordWriter.class);
	Path file;

	public CountryWiseRecordWriter(DataOutputStream fileOut) {
		// out = new PrintWriter(fileOut);
		out = fileOut;
		logger.info("****************CountryWiseRecordWriter constructor***********fileOut:"
				+ fileOut + "::path:" + fileOut.toString());
	}

	public CountryWiseRecordWriter(TaskAttemptContext job, Path file) {
		this.job = job;
		this.file = file;
		logger.info("****************CountryWiseRecordWriter constructor***********jpb:"
				+ job);
	}

	public void write(Text key, Iterable<Text> values) {
		Configuration conf = job.getConfiguration();
		try {
			FileSystem fs = file.getFileSystem(conf);
			Path writeFile = new Path(file.toString() + "/" + key.toString());
			FSDataOutputStream fileOut = fs.create(writeFile, false);
			out = fileOut;
            boolean firstLine = true;
			for (Text value : values) {
				logger.info("****************CountryWiseRecordWriter about to write***********:"
						+ key.toString() + ":" + value.toString());
				if(!firstLine) {
					out.writeBytes("\n");
				} else {
					firstLine = false;
				}
				out.writeBytes(key.toString() + ":" + value.toString());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public void close(TaskAttemptContext context) {
		
	}
}