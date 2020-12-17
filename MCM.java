//Matrix Chain Multiplication is major type of
//one of dynamic programming problems.

//Here we have given matrices and we have to multiple
//matrices in such a way that we can minimize the number
//of mulitplications.


//To understand the complete concept of MCM problem
//watch Aditya Verma's videos on MCM.

//So here we first try to make recursion approach to solve
//this problem and which will give the time complexity of
//O(2^N).

//To optimize the code we will add memoization to it and
//can bring the time complexity of O(N^2).

//Here we are going to move k from i to n-1

// Initially i=1 and j=n-1

static int matrixChain(int[] arr, int i, int j) {
	if (i == j)
		return 0;
	int min = Integer.MIN_VALUE;
	for (int k = i; k < j; k++) {
		int temp = matrixChain(arr, i, k) + matrixChain(arr, k + 1, j)
		           + arr[i - 1] * arr[k] * arr[j];
		if (temp < min)
			temp = min;
	}
	return min;
}


//This is simple recursive solution we can add memoization
//to it to optimize the code.


static int matrixChain(int[] arr, int i, int j, int[][] dp) {
	if (i == j)
		return 0;
	if (dp[i][j] != -1)
		return dp[i][j];
	dp[i][j] = Integer.MAX_VALUE;
	for (int k = i; k < j; k++) {
		dp[i][j] = Math.min(dp[i][j], matrixChain(arr, i, k) + matrixChain(arr, k + 1, j)
		                    + arr[i - 1] * arr[k] * arr[j]);
	}
	return dp[i][j];
}


//Another solution using tabulation without recursion


static int MatrixChainOrder(int p[], int n) {
	/* For simplicity of the
	program, one extra row and
	one extra column are allocated in m[][].  0th row
	and 0th column of m[][] are not used */
	int m[][] = new int[n][n];

	int i, j, k, L, q;

	/* m[i, j] = Minimum number of scalar
	multiplications needed to compute the matrix
	A[i]A[i+1]...A[j] = A[i..j] where
	dimension of A[i] is p[i-1] x p[i] */

	// cost is zero when multiplying one matrix.
	for (i = 1; i < n; i++)
		m[i][i] = 0;

	// L is chain length.
	for (L = 2; L < n; L++) {
		for (i = 1; i < n - L + 1; i++) {
			j = i + L - 1;
			if (j == n)
				continue;
			m[i][j] = Integer.MAX_VALUE;
			for (k = i; k <= j - 1; k++) {
				// q = cost/scalar multiplications
				q = m[i][k] + m[k + 1][j]
				    + p[i - 1] * p[k] * p[j];
				if (q < m[i][j])
					m[i][j] = q;
			}
		}
	}

	return m[1][n - 1];
}


//Problem is available on geeksforgeeks