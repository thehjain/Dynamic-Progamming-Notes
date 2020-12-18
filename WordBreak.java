//Here we have given one string one dictionary containing
//some words and we have to check if it possible to break
//a string in such a way that all parts are present in
//dictionary


//This is also variation of MCM and here we are going to
//break the string at every point and check recursively
//it is possible or not.


//To make the approach efficient we can memoization to the
//recursive approach.


static boolean findMCM(ArrayList<String> arr, String s) {
	int n = s.length();
	if (n == 0)
		return true;
	for (int i = 1; i <= n; i++)
		if (arr.contains(s.substring(0, i)) && findMCM(arr, s.substring(i, n)))
			return true;
	return false;
}


//Problem is available on geeksforgeeks