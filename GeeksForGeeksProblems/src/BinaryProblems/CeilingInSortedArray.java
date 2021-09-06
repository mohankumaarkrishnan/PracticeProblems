package BinaryProblems;

/*
 * Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and  floor  
 * * is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient 
 * * functions to find floor and ceiling of x. 
 * 
 * For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
 * For x = 0:    floor doesn't exist in array,  ceil  = 1
 * For x = 1:    floor  = 1,  ceil  = 1
 * For x = 5:    floor  = 2,  ceil  = 8
 * For x = 20:   floor  = 19,  ceil doesn't exist in array
 * 
*/
public class CeilingInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int target = 9;
		int arr[] = { 1, 2, 8,  10, 12, 19 };
		int ceil = findCeil(arr, target, 0, arr.length-1);
		if (ceil != -1) {
			System.out.println("Ceil = " + ceil);
		} else {
			System.out.println("Ceil doesnt exist in array");
		}

	}

	public static int findCeil(int arr[], int target, int l, int h) {
		if (arr[l] >= target) {
			return arr[l];
		}
		if (arr[h] < target) {
			return -1;
		}
		int pos=-1;
		
		while(l<=h) {
			
			int mid = (l + h) / 2;
			
			if (arr[mid] == target) {
				return target;
			} else if (arr[mid] < target) {
				l=mid+1;
			} else {
				h=mid-1;
				pos=arr[mid];
			}
		}
		return pos;

//		if (arr[mid] == target) {
//			return target;
//		} else if (arr[mid] < target) {
//			return findCeil(arr, target, mid+1, h);
//		} else {
//			return findCeil(arr, target, l, mid);
//		}

	}

}
