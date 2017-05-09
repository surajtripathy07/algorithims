class Solution{

	public boolean isPalindrome(int num){
		int rev = 0;
		int n = num;
		while(num > 0){
			int dig = num % 10;
			rev = rev * 10 + dig;
			num = num / 10;
		}
		if (rev == n){
			return true;
		} else {
			return false;
		}
	}
}
