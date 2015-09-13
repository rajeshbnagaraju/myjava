package org.hdp.custom.outputformat;

import java.io.IOException;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.log4j.Logger;


public class CountryWiseMapper extends Mapper<LongWritable, Text, Text, Text> {
	final static Logger logger = Logger.getLogger(CountryWiseMapper.class);
	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		logger.info("******************MAPPER*******************");
		String strLine = value.toString();
		String strWords[] = strLine.split(" ");
		logger.info("******************"+strWords[0]+":"+strWords[1]+"*******************");
		context.write(new Text(strWords[0]), new Text(strWords[1]));
	}
}
