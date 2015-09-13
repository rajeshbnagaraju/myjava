package org.hdp.wrdcount.custompartitioner;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.IntWritable;

public class WordCountPartitioner extends Partitioner<Text, IntWritable>{

	@Override
	public int getPartition(Text key, IntWritable value, int numOfReducers) {
		// TODO Auto-generated method stub
		String strKey = key.toString();
		if(strKey.toLowerCase().matches("^[n-z].*")){
			return 1 % numOfReducers;
		} 
		return 0;
	}

}
