//Here we have given an array and we have to find
//the length of longest increasing subsequence.

//Brute force solution is to check every increasing
//subsequence and find the largest one.It will time
//complexity of O(2^N).

//Efficient approach is to dynamic programming and
//keep updating the dp array which will store the
//length of increasing subsequences. It will give
//time complexity of O(N^2).
public int lengthOfLIS(int[] nums) {
	int n = nums.length;
	int[] dp = new int[n];
	Arrays.fill(dp, 1);

	for (int i = 1; i < n; i++) {
		for (int j = 0; j < i; j++) {
			if (arr[j] < arr[i])
				dp[i] = Math.max(1 + dp[j], dp[i]);
		}
	}

	int res = Integer.MIN_VALUE;
	for (int ele : dp)
		res = Math.max(ele, res);

	return res;
}

//Best approach to do the problem in time complexity of
//o(NlogN) is to use binary search as keep .To understand
//the approach watch aryan mittal video of longest Increasing
//subsequence.


public int lengthOfLIS(int[] nums) {

	int n = nums.length;
	int[] dp = new int[n];
	int size = 0;
	for (int ele : nums) {
		int i = 0, j = size;
		while (i != j) {
			int m = (i + j) / 2;
			if (dp[m] < ele)
				i = m + 1;
			else
				j = m;
		}
		dp[i] = ele;
		if (i == size) ++size;
	}

	return size;
}


//Problem is available both on geeksforgeeks and leetcode