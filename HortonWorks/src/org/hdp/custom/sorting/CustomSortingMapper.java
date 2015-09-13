package org.hdp.custom.sorting;
import java.io.IOException;


import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.IntWritable;
public class CustomSortingMapper extends Mapper<LongWritable,Text,RatingsKey,Text>{
	
	@Override
	public void map(LongWritable key,Text value,Context context)
	       throws IOException, InterruptedException
	{
		String strLine = value.toString();
		String strWords[] = strLine.split("::");
		int userId = Integer.parseInt(strWords[0]);
		// to limit the output we will just print userIds less than 5.
		if(userId<5) {
			int movieId = Integer.parseInt(strWords[1]);
			RatingsKey ratingsKey = new RatingsKey();
			ratingsKey.setUserId(userId);
			ratingsKey.setMovieId(movieId);
			context.write(ratingsKey, value);
		}
	}
}
