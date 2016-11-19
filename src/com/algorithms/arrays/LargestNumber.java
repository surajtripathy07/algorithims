package com.algorithms.arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 */
public class LargestNumber {

	// DO NOT MODIFY THE LIST
	public String largestNumber(final List<Integer> a) {
		Collections.sort(a, new Comparator<Integer>() {
			public int compare(Integer a1, Integer a2) {
				StringBuffer buff = new StringBuffer();
				String one = buff.append(a1).append(a2).toString();
				buff = new StringBuffer();
				String two = buff.append(a2).append(a1).toString();

				return isFirstGreater(two, one);
			}
		});

		StringBuffer result = new StringBuffer("");

		// Corner case when all values are 0
		if (a.get(0) == 0) {
			return "0";
		}

		for (Integer vlue : a) {
			result.append(vlue);
		}

		return result.toString();
	}

	private int isFirstGreater(String first, String second) {
		// return new BigInteger(first).compareTo(new BigInteger(second));

		if (first.length() > second.length()) {
			return 1;
		} else if (second.length() > first.length()) {
			return -1;
		}

		// only equal length strings will continue post this point
		int len = first.length();

		for (int i = 0; i < len; i++) {
			int one = Character.getNumericValue(first.charAt(i));
			int two = Character.getNumericValue(second.charAt(i));
			if (one > two) {
				return 1;
			} else if (one < two) {
				return -1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNumber l = new LargestNumber();
		List<Integer> newList = new ArrayList<Integer>();
		newList.add(0);
		newList.add(0);
		newList.add(0);
		newList.add(0);
		newList.add(0);

		System.out.println(l.largestNumber(newList));
	}

}
