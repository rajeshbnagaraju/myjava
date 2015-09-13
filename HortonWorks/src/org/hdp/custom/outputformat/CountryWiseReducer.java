package org.hdp.custom.outputformat;

import java.io.IOException;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.log4j.Logger;

public class CountryWiseReducer extends
		Reducer<Text, Text, Text, Iterable<Text>> {
	final static Logger logger = Logger.getLogger(CountryWiseMapper.class);

	@Override
	public void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		logger.info("**********Reducer*****************");
		context.write(key, values);
	}
}
