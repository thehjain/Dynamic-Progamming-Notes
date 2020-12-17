//Here we have given an array and we have to check
//if array can be divided into two subsets that
//sum of both subsets is same.


//Brute force solution is to do recursion and check
//every subset and we can optimize it by doing
//memoization.


//Brute Force approach
static bool isSubsetSum(int[] set, int n, int sum) {
	if (sum == 0)
		return true;
	if (n == 0)
		return false;
	if (set[n - 1] > sum)
		return isSubsetSum(set, n - 1, sum);
	return isSubsetSum(set, n - 1, sum)
	       || isSubsetSum(set, n - 1, sum - set[n - 1]);
}

//Recursion solution with memoization

static int equalPartition(int N, int arr[]) {
	// code here
	int sum = 0;
	for (int ele : arr)
		sum += ele;
	if (sum % 2 != 0)
		return 0;
	sum /= 2;
	int[][] dp = new int[N + 1][sum + 1];
	for (int[] row : dp)
		Arrays.fill(row, -1);
	return (check(arr, N, sum, dp) == true) ? 1 : 0;
}

static boolean check(int[] arr, int n, int sum, int[][] dp) {

	if (sum == 0)
		return true;
	if (n == 0)
		return false;
	if (sum < 0)
		return false;
	if (dp[n][sum] != -1) {
		if (dp[n][sum] == 0) return false;
		return true;
	}
	if (arr[n - 1] > sum)
		if (check(arr, n - 1, sum, dp)) {
			dp[n][sum] = 1;
			return true;
		} else {
			dp[n][sum] = 0;
			return false;
		}
	else {
		if (check(arr, n - 1, sum, dp) || check(arr, n - 1, sum - arr[n - 1], dp)) {
			dp[n][sum] = 1;
			return true;
		} else {
			dp[n][sum] = 0;
			return false;
		}
	}
}



//Problem is available on geeksforgeeks
