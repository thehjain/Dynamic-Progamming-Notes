//Here we have given array of coins with different values
//and one sum.

//And we have to find the number of ways to make the sum
//using these value coins considering we have infinite
//number of coins.

//Brute Force solution is to use recursion and check
//every possible solution considering and not considering
//every coin

//Using memoization to recursion approach we can optimize
//the solution

public long count(int S[], int m, int n) {
	//code here.
	long[][] dp = new long[m + 1][n + 1];
	for (long[] row : dp)
		Arrays.fill(row, -1);

	return ways(S, m, n, dp);
}

static long ways(int[] arr, int m, int n, long[][] dp) {
	if (n == 0)
		return 1;
	if (n < 0)
		return 0;
	if (m <= 0 && n >= 1)
		return 0;
	if (dp[m][n] != -1)
		return dp[m][n];
	return dp[m][n] = ways(arr, m - 1, n, dp) + ways(arr, m, n - arr[m - 1], dp);
}

//Another approach can be using tabulation
//Both approaches are available on geeksforgeeks

//Problem is available on geeksforgeeks