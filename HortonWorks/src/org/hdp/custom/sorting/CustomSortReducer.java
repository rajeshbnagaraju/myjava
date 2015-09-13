package org.hdp.custom.sorting;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;


public class CustomSortReducer extends
		Reducer<RatingsKey, Text, Text, Text> {

	@Override
	public void reduce(RatingsKey key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
	
		for (Text value : values) {
			context.write(new Text(key.toString()), value);
		}
	}
}
