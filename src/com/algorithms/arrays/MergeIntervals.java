package com.algorithms.arrays;

import java.util.ArrayList;

/*
 * 

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.

 */

/*
 * Definition for an interval.*/
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return start + " " + end;
	}
}

public class MergeIntervals {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		// incase if start > end
		if (newInterval.start > newInterval.end) {
			int temp = newInterval.start;
			newInterval.start = newInterval.end;
			newInterval.end = temp;
		}

		ArrayList<Interval> newIntervalList = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if ((newInterval.start > interval.end && newInterval.end > interval.end)) {
				// non overlapping intervals when newInterval is > than existing
				// interval
				newIntervalList.add(interval);
			} else if (newInterval.start < interval.start && newInterval.end < interval.start) {
				// non overlapping intervals when newInterval is < than existing
				// interval
				newIntervalList.add(newInterval);
				// setting existing interval as new interval to check for
				// mergers with next intervals
				newInterval = interval;
			} else {

				// Control will come here when interval and newInterval Overlap!

				// take smaller of the start
				int smallerStart = (interval.start < newInterval.start) ? interval.start : newInterval.start;
				// take bigger of end
				int biggerEnd = (interval.end > newInterval.end) ? interval.end : newInterval.end;

				newInterval = new Interval(smallerStart, biggerEnd);
				// not adding because this newInterval might overlap with the
				// next interval
				// in the list
			}
		}
		// add the last marked newInterval which was left unadded
		newIntervalList.add(newInterval);

		return newIntervalList;
	}

	public static void main(String[] args) {
		MergeIntervals i = new MergeIntervals();
		ArrayList<Interval> intervals = new ArrayList<Interval>();

		intervals.add(new Interval(0, 0));
		intervals.add(new Interval(0, 0));
		intervals.add(new Interval(0, 0));
		intervals.add(new Interval(0, 0));
		intervals.add(new Interval(12, 16));

		// o/p [0,9][12,16]
		System.out.println(i.insert(intervals, new Interval(0, 9)));

	}

}
