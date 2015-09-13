package org.hdp.custom.sorting;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

/**
 * 
 * @author rajeshnagaraju UserID:MovieID:Rating:TimeStamp Key -- UserId and
 *         Movie Id
 */
public class RatingsKey implements WritableComparable<RatingsKey> {
	private int userId;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	private int movieId;

	@Override
	/**
	 * This is required for the sort and shuffle...or this is the SortComparator
	 */
	public int compareTo(RatingsKey key) {
		int otherUserId = key.userId;
		if (userId == otherUserId) {
			if (movieId == key.movieId) {
				return 0;
			} else {
				return movieId > key.movieId ? 1 : -1;
			}
		} else {
			return userId > otherUserId ? 1 : -1;
		}
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.userId = in.readInt();
		this.movieId = in.readInt();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(userId);
		out.writeInt(movieId);
	}
	
	public String toString() {
		return userId+"--"+movieId;
	}

}
