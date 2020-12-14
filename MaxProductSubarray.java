//Here we have given an array and we have to find
//maximum product that can be obatined using subarray
//of given array.


//Brute force approach is to check product of every
//subarray and this will give time compelexity of O(N^2).


//So we are going to use dynamic programming for this problem
//to bring the time complexity in O(N).


public int maxProduct(int[] nums) {

	//Base case where length of array is 1
	if (nums.length == 1) return nums[0];

	int count = 0;
	int pos = 0;

	//Base case where product is equal to zero or negative.
	for (int ele : nums) {
		if (ele == 0) count = 0;
		else if (ele > 0) {
			pos = 1;
			break;
		} else {
			count++;
		}
		if (count == 2) break;
	}

	if (count < 2 && pos == 0) return 0;

	int max_ending_here = 1;
	int min_ending_here = 1;
	int res = Integer.MIN_VALUE;

	for (int ele : nums) {
		if (ele == 0) {
			max_ending_here = 1;
			min_ending_here = 1;
			continue;
		}
		int temp = max_ending_here;
		max_ending_here = Math.max(Math.max(max_ending_here * ele, min_ending_here * ele), ele);
		min_ending_here = Math.min(Math.min(min_ending_here * ele, temp * ele), ele);
		if (res < max_ending_here)
			res = max_ending_here;
	}

	return res;

}


//Problem is available both leetcode and geeksforgeeks