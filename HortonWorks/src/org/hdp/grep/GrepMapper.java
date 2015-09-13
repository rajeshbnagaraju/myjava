package org.hdp.grep;
import java.io.IOException;


import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
public class GrepMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	
	@Override
	public void map(LongWritable key,Text value,Context context)
	       throws IOException, InterruptedException
	{
		String strLine = value.toString();
		String strWords[] = strLine.split(" ");
		IntWritable oneWritable = new IntWritable(1);
		String searchString = context.getConfiguration().get("searchString");
		for (String strWord:strWords) {
			if(strWord.equalsIgnoreCase(searchString)) {
				context.write(new Text(strWord), oneWritable);
			}
		}
		
	}

}
