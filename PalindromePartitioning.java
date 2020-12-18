//Here we have given a string and we have make the minimum
//number of paritions such that every parition comes out
//to be palindrome.


//this is variation of MCM (Matrix Chain Mulitplication)


//this is the recursive solution with memoization.

static int minCuts(String s, int i, int j, int[][] dp) {
	if (i >= j)
		return 0;
	if (isPalindrome(s, i, j))
		return 0;
	if (dp[i][j] != -1)
		return dp[i][j];
	int min = Integer.MAX_VALUE;
	for (int k = i; k <= j - 1; k++) {
		int left = 0, right = 0;
		if (dp[i][k] != -1)
			left = dp[i][k];
		else {
			left = minCuts(s, i, k, dp);
		}
		if (dp[k + 1][j] != -1)
			right = dp[k + 1][j];
		else
			right = minCuts(s, k + 1, j, dp);
		int temp = left + right + 1;
		if (temp < min)
			min = temp;
	}
	return dp[i][j] = min;
}

static boolean isPalindrome(String str, int i, int j) {
	for (; i < j; i++, j--)
		if (str.charAt(i) != str.charAt(j))
			return false;
	return true;
}




//Problem is available on geeksforgeeks