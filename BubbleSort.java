
public class BubbleSort {

public void sort(java.lang.Integer[] arrayToSort){
	
	for(int i =0; i< arrayToSort.length -1; i++) {
		for(int j = 0; j< arrayToSort.length - i -1; j++) {
			if(arrayToSort[j]>arrayToSort[j+1]) {
				int temp = arrayToSort[j];
				arrayToSort[j] = arrayToSort[j+1];
				arrayToSort [j+1] = temp;
			}
		}
	}
	
	
}

public void addTestTimes(long l) {
	// TODO Auto-generated method stub
	
}


	


}
