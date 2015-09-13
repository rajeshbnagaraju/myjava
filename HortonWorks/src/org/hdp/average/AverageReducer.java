package org.hdp.average;

import java.io.IOException;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.IntWritable;

public class AverageReducer extends
		Reducer<IntWritable, IntWritable, NullWritable, DoubleWritable> {

	long lSum = 0;
	long lCount = 0;
	@Override
	public void reduce(IntWritable key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		//lSum+=key.get();
		for (IntWritable intWrit : values) {
			lSum+=key.get();
			lCount+=intWrit.get();
		}
		double avg = lSum/lCount;
		context.write(null, new DoubleWritable(avg));
	}
}
