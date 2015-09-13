package org.hdp.average;
import java.io.IOException;


import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
public class AverageMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	
	@Override
	public void map(LongWritable key,Text value,Context context)
	       throws IOException, InterruptedException
	{
		//String strLine = value.toString();
		//String strWords[] = strLine.split(" ");
		final IntWritable oneWritable = new IntWritable(1);
		context.write(value, oneWritable);
		
	}

}
