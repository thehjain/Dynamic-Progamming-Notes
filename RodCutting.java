//Here we have given rod of some length and we can divide
//or cut the pieces of rod of given lengths.

//Their is two variations of this question.
//1.We have to find maximum cuts can be made
//2.We have given value of each piece and we have to
//maximize the value.


//Solution of Variation 1
//This one is easy we just have maximum the
//number of cuts.

static int cutPipe(int length, int x, int y, int z) {
	int[] dp = new int[length + 1];
	Arrays.fill(dp, -1);
	dp[0] = 0;
	for (int i = 0; i <= length; i++) {
		if (dp[i] == -1)
			continue;
		if (i + x <= length)
			dp[i + x] = Math.max(dp[i] + 1, dp[i + x]);
		if (i + y <= length)
			dp[i + y] = Math.max(dp[i] + 1, dp[i + y]);
		if (i + z <= length)
			dp[i + z] = Math.max(dp[i] + 1, dp[i + z]);
	}
	return dp[length];
}


//Solution of Variation 2
//This is one where we gonna use memoization
//+ recursion for efficient time complexity.

//This is similar to knapsack

static int rodCut(int[] prices, int[] length, int maxLength, int n) {
	if (n == 0 || maxLength == 0)
		return 0;
	if (length[n - 1] <= maxLength)
		return Math.max(prices[n - 1] + rodCut(prices, length, maxLength - length[n - 1], n),
		                rodCut(prices, length, maxLength, n - 1));
	else
		return rodCut(prices, length, maxLength, n - 1);
}


//Problem is available on geeksforgeeks