public class InsertionSort {
	
	public void sort(Integer[] arrayToSort) {
		
		for (int i = 1; i < arrayToSort.length; ++i) {
			int j = i;
			
			while (j > 0 && arrayToSort[j] < arrayToSort[j - 1]) {
				
				int temp = arrayToSort[j];
				arrayToSort[j] = arrayToSort[j - 1];
				arrayToSort[j - 1] = temp;
				--j;
			}
		}
}

	public void addRuntime(long l) {
		// TODO Auto-generated method stub
		
	}
}