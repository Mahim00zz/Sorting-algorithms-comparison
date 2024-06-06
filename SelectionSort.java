public class SelectionSort {

    public void sort(Integer[] arrayToSort) {
        int numbersSize = arrayToSort.length;

        for (int i = 0; i < numbersSize - 1; ++i) {
            int indexSmallest = i;

            for (int j = i + 1; j < numbersSize; ++j) {
                if (arrayToSort[j] < arrayToSort[indexSmallest]) {
                    indexSmallest = j;
                }
            }

            
            int temp = arrayToSort[i];
            arrayToSort[i] = arrayToSort[indexSmallest];
            arrayToSort[indexSmallest] = temp;
        }
    }
}