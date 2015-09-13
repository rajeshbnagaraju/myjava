package org.hdp.WordCountDataCompression;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;

public class WordCountReducerDataCompression extends
		Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int iCount = 0;
		for (IntWritable intWrit : values) {
			iCount += intWrit.get();
		}
		context.write(key, new IntWritable(iCount));
	}
}
