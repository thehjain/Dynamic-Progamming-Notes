//Here we have given two string and we have to convert the
//first string to second one by performing following three
//operations.

// Insert a character
// Delete a character
// Replace a character

//We have to find the minimum number of operations for it.


//Brute force solution is to check every possible solution
//by considering every operation at every step using recursion
//it will time complexity of O(3^N).

//Efficient approach is using memoization and we can bring the time
//complexity to O(MN) by storing the results in dp array.


public int minDistance(String word1, String word2) {

	int n = word1.length();
	int m = word2.length();
	char[] a = word1.toCharArray();
	char[] b = word2.toCharArray();

	int[][] dp = new int[n + 1][m + 1];

	for (int[] row : dp)
		Arrays.fill(row, -1);

	return edit(a, b, n, m, dp);
}
static int edit(char[] a, char[] b, int n, int m, int[][] dp) {
	if (n == 0) return m;
	if (m == 0) return n;
	if (dp[n][m] != -1)
		return dp[n][m];
	if (a[n - 1] == b[m - 1]) {
		dp[n][m] = edit(a, b, n - 1, m - 1, dp);
		return dp[n][m];
	} else {
		dp[n][m] = 1 + min(edit(a, b, n - 1, m, dp), edit(a, b, n, m - 1, dp), edit(a, b, n - 1, m - 1, dp));
		return dp[n][m];
	}
}
static int min(int a, int b, int c) {
	if (a <= b && a <= c) return a;
	if (b <= a && b <= c) return b;
	return c;
}


//Problem is available both on geeksforgeeks and leetcode
