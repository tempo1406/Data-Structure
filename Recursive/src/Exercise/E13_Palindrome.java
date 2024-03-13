package Exercise;

public class E13_Palindrome {

	public static boolean isPalindrome(char[] arr, int length) {
		if (length == arr.length / 2)
			return true;
		else if (arr[arr.length - length] == arr[length-1])
			return isPalindrome(arr, length - 1);
		else
			return false;
	}

	public static void main(String[] args) {
		char[] arr = { 'a', 'b', 'r', 'b', 'a' };
		System.out.println("Minimun in array is: " + isPalindrome(arr, arr.length));
	}
}
