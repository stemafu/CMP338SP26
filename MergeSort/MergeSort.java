
public class MergeSort <T extends Comparable <? super T>> implements SortInterface<T> {




	public static void main(String[] args) {


		Integer [] nums = {7, 6, 12, 11, 9, 2};

		MergeSort<Integer> sort = new MergeSort<Integer>();

		sort.sort(nums);

	}

	@Override
	public void sort(T[] arrayToSort) {

		Object [] temp = new Object[arrayToSort.length];



		mergeSort(arrayToSort, temp, 0, arrayToSort.length - 1);

	}


	/*
	 * The following method will recursively divide
	 * an array into halves until there is only one element 
	 * remaining.. (0)
	 */
	private void mergeSort(T [] array, Object [] tempArray, int first, int last ) {

		if(first < last) {

			int mid = (first + last ) / 2;

			/*
			 * Recursively divide the array into halves
			 * until there is only one element remaining
			 */
			mergeSort(array, tempArray, first, mid);

			mergeSort(array, tempArray,mid + 1, last);

			/* Once we have only one element remaining, the
			 * we need to merge the subarray slowly back into bigger
			 * array as we are sorting the values in the subarrays.
			 * 
			 * 
			 */

			merge(array, tempArray, first, mid, last);
		}
	}

	private void merge(T [] array, Object [] tempArray, int first, int mid, int last) {
		int leftSubarrayIndex = first;
		int lastIndexOfLeftSubArray = mid;

		int rightSubarrayIndex = mid + 1;
		int lastIndexOfRightSubArray = last;

		/*
		 * While both subarrays are not empty,
		 * copy the smaller item into the temporary array
		 * until one array is not empty.
		 */

		/* i is the next available index in the
		 * the temporary array
		 */
		int i = leftSubarrayIndex; 

		while( (leftSubarrayIndex <= lastIndexOfLeftSubArray) &&
				(rightSubarrayIndex <= lastIndexOfRightSubArray)	) {

			if(array[leftSubarrayIndex].compareTo(array[rightSubarrayIndex]) < 0) {
				tempArray[i] = array[leftSubarrayIndex];
				leftSubarrayIndex++;

			}else {
				tempArray[i] = array[rightSubarrayIndex];
				rightSubarrayIndex++;

			}
			i++;
		}


		/*
		 * What if the right sub array is empty but the left sub array is
		 * not.
		 */

		while(leftSubarrayIndex <= lastIndexOfLeftSubArray) {
			tempArray[i] = array[leftSubarrayIndex];
			leftSubarrayIndex++;
			i++;
		}
		
		
		/*
		 * What if the left sub array is empty but the right sub array is
		 * not.
		 */
		
		while(rightSubarrayIndex <= lastIndexOfRightSubArray) {
			tempArray[i] = array[rightSubarrayIndex];
			rightSubarrayIndex++;
			i++;
		}
		
		
		/* At this point all the values that have been sorted are
		 * in the temporary array. 
		 * 
		 * So, we will copy the values from the temporary array into
		 * the original array
		 * 
		 */
		
		for(int index = first; index <= last; index++) {
			
			array[index] = (T)tempArray[index];
		}
	

	}

}
