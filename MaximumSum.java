//Here we have given an array and we have to
//find maximum sum increasing subsequence

//Basically it is the extension of problem longest increasing
//subsequence and solution is also similar.

public int maxSumIS(int arr[], int n) {
	//code here.
	int[] dp = new int[n];
	for (int i = 0; i < n; i++) {
		dp[i] = arr[i];
		for (int j = 0; j < i; j++) {
			if (arr[j] < arr[i])
				dp[i] = Math.max(dp[i], dp[j] + arr[i]);
		}
	}
	int res = 0;
	for (int ele : dp)
		res = Math.max(ele, res);

	return res;

}


//Problem is available on geeksforgeeks