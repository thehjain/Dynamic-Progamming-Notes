//Here we have given two string and we have to find the
//longest common subsequence possible of both strings.

//Brute force solution is to check every susequence
//using recursion.

//Efficient approach is to add memoization to recursion
//solution and it will time complexity of O(MN).

public int longestCommonSubsequence(String text1, String text2) {
	int[][] dp = new int[text1.length() + 1][text2.length() + 1];
	for (int[] row : dp)
		Arrays.fill(row, -1);
	return lcs(text1, text2, text1.length(), text2.length(), dp);
}
static int lcs(String s, String r, int m, int n, int[][] dp) {
	if (m == 0 || n == 0) return 0;
	if (dp[m][n] != -1)
		return dp[m][n];
	if (s.charAt(m - 1) == r.charAt(n - 1)) {
		dp[m][n] = 1 + lcs(s, r, m - 1, n - 1, dp);
		return dp[m][n];
	} else {
		dp[m][n] = Math.max(lcs(s, r, m, n - 1, dp), lcs(s, r, m - 1, n, dp));
		return dp[m][n];
	}
}


//Another more efficient approach is to do it without recursion
//and it will be more efficient than previous solution.

public int longestCommonSubsequence(String text1, String text2) {
	char[] chars1 = text1.toCharArray();
	char[] chars2 = text2.toCharArray();
	int[][] dp = new int[chars1.length + 1][chars2.length + 1];
	for (int i = 0; i < chars1.length; i++) {
		for (int j = 0; j < chars2.length; j++)
			dp[i + 1][j + 1] = chars1[i] == chars2[j] ? dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
	}
	return dp[chars1.length][chars2.length];
}


//Problem is available on leetcode and geeksforgeeks