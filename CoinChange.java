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

static long countWays(int S[], int m, int n) {
	//Time complexity of this function: O(mn)
	//Space Complexity of this function: O(n)

	// table[i] will be storing the number of solutions
	// for value i. We need n+1 rows as the table is
	// constructed in bottom up manner using the base
	// case (n = 0)
	long[] table = new long[n + 1];

	// Initialize all table values as 0
	Arrays.fill(table, 0);   //O(n)

	// Base case (If given value is 0)
	table[0] = 1;

	// Pick all coins one by one and update the table[]
	// values after the index greater than or equal to
	// the value of the picked coin
	for (int i = 0; i < m; i++)
		for (int j = S[i]; j <= n; j++)
			table[j] += table[j - S[i]];

	return table[n];
}

//Problem is available on geeksforgeeks