//Here we have given some eggs and one building with
//some floors and we have to find minimum number of
//attempts to find the floor where egg is going to
//break for the first time.


//This is variation of MCM (Matrix Chain Mulitplication)
//We are going to measure the number of attempts considering
//every floor where egg is going to break for the first time.

//Brute force solution is to use recursion and we can optimize
//this solution using memoization

static int findAttempts(int N, int K, int[][] dp) {
	if (K == 0 || K == 1)
		return K;
	if (N == 1)
		return K;
	if (dp[N][K] != -1)
		return dp[N][K];
	int res = Integer.MAX_VALUE;
	for (int i = 1; i <= K; i++) {
		int temp = Math.max(findAttempts(N - 1, i - 1, dp),
		                    findAttempts(N, K - i, dp));
		res = Math.min(res, temp);
	}
	return dp[N][K] = res + 1;
}



//Bottom Up DP approach

static int findAttemptsBU(int N, int K) {

	int[][] dp = new int[N + 1][K + 1];
	for (int i = 0; i <= K; i++)
		dp[1][i] = i;
	for (int i = 0; i <= N; i++) {
		dp[i][0] = 0;
		dp[i][1] = 1;
	}
	for (int i = 2; i <= N; i++) {
		for (int j = 2; j <= K; j++) {
			dp[i][j] = Integer.MAX_VALUE;
			for (int k = 1; k <= j; k++) {
				int temp = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
				dp[i][j] = Math.min(dp[i][j], temp);
			}
		}
	}
	return dp[N][K];
}



//Problem is available on geeksforgeeks