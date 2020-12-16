//KnapSack is very famous problem where we have given
//some items with weight and value and we have limited
//capacity bag so we have to chose the items to carry

//And here we have to maximum the value by choosing the items
//in most efficient way


//Brute Force solution is to check on every item considering
//it and considering it not.

//Efficient Solution is to add memoization to recursion brute
//force approach


static int knapSack(int W, int wt[], int val[], int n) {
	// your code here
	int[][] dp = new int[W + 1][n + 1];
	for (int[] row : dp)
		Arrays.fill(row, -1);
	return ks(W, wt, val, n, dp);
}
static int ks(int W, int[] wt, int[] val, int n, int[][] dp) {
	if (n == 0 || W == 0) return 0;
	if (dp[W][n] != -1)
		return dp[W][n];
	if (wt[n - 1] > W) {
		dp[W][n] = ks(W, wt, val, n - 1, dp);
		return dp[W][n];
	} else {
		dp[W][n] = Math.max(val[n - 1] + ks(W - wt[n - 1], wt, val, n - 1, dp),
		                    ks(W, wt, val, n - 1, dp));
		return dp[W][n];
	}
}


//Problem is available on geeksforgeeks