package org.hdp.custom.sorting;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class RatingsGroupComparator extends WritableComparator {
	
	protected RatingsGroupComparator() {
		super(RatingsKey.class,true);
	}
    
	@SuppressWarnings("rawtypes") 
	@Override
	public int compare(WritableComparable one, WritableComparable other) {
		RatingsKey oneKey = (RatingsKey) one;
		RatingsKey otherKey = (RatingsKey) other;
		if(oneKey.getUserId()==otherKey.getUserId()) {
			return 0;
		}
		return oneKey.getUserId()>otherKey.getUserId()?1:-1;
	}
}
