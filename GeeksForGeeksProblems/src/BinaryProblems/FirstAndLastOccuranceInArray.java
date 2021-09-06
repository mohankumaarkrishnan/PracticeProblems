package BinaryProblems;

/*
 * Question

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

*/

public class FirstAndLastOccuranceInArray {

	public static void main(String[] args) {
		int target = 10;
		int a[] = { 1, 2, 10, 10, 10, 19 };
		int arr[]=solution(a, target);
		System.out.println("arr [" + arr[0] +" , "+ arr[1]+"]");

	}

	public static int[] solution(int[] arr, int target) {

		int first = -1;
		int last = -1;
		int l=0,h=arr.length-1;
		
		while(l<=h) {
			int mid=l+(h-l)/2;
			if(arr[mid]==target) {
				if(mid==0 || arr[mid]!=arr[mid-1]) {
					first=mid;
				}
				if(mid==arr.length-1 || arr[mid]!=arr[mid+1]) {
					last=mid;
				}
				if(first==-1) {
					h=mid-1;
					l=0;
				}else if(last==-1) {
					l=mid+1;
					h=arr.length-1;
				}else {
					break;
				}
			}else if(arr[mid]<target) {
				l=mid+1;
			}else {
				h=mid-1;
			}
		}
		
		return new int[] {first,last};
		
	}

}
