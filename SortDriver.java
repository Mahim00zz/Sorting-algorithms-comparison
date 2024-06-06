import java.util.Arrays;
import java.util.Random;

public class SortDriver implements SortDriverInterface {

   
   //Generate and return an array of Integer values all initialized to 1
   
   public Integer[] getEqualNumbers(int arraySize) {
       Integer[] arr = new Integer[arraySize];
       Arrays.fill(arr, 1);

       return arr;
   }

   
   //Generate and return an array of Integer with random values
   
   public Integer[] getRandomNumbers(int arraySize) {
       Integer[] arr = new Integer[arraySize];

       Random r = new Random();
       for (int i = 0; i < arraySize; i++) {
           arr[i] = r.nextInt();
       }

       
       
       return arr;
   }

   
   //Generate and return an array of Integer values starting at 1 and ending at arraySize
   
   
   public Integer[] getIncreasingNumbers(int arraySize) {
       Integer[] arr = new Integer[arraySize];

       for (int i = 0; i < arraySize; i++) {
           arr[i] = i + 1;
       }
       return arr;
   }

   
   // Generate and return an array of Integer values starting at arraySize and ending at 1
   
   public Integer[] getDecreasingNumbers(int arraySize) {
       Integer[] arr = new Integer[arraySize];

       for (int i = 0; i < arraySize; i++) {
           arr[i] = arraySize - i;
       }
       return arr;
   }
   
   public Integer[] getIncreasing_Random_Numbers(int arraySize) {
       Integer[] arr = new Integer[arraySize];

       Random r = new Random();
       
       for (int i = 0; i < arraySize; i++) {
           arr[i] = r.nextInt();
       }
       
       Arrays.sort(arr);
       return arr;
   }

   
  
  
   @Override
   public Integer[] createArray(ArrayType arrayType, int arraySize) {

       if (arrayType == SortDriverInterface.ArrayType.Equal) {
           return getEqualNumbers(arraySize);

       } else if (arrayType == SortDriverInterface.ArrayType.Random) {
           return getRandomNumbers(arraySize);

       } else if (arrayType == SortDriverInterface.ArrayType.Increasing) {
           return getIncreasingNumbers(arraySize);

       } else if (arrayType == SortDriverInterface.ArrayType.Decreasing){
           return getDecreasingNumbers(arraySize);
       }
       return getIncreasing_Random_Numbers(arraySize);
   }

  
   
   
   public Object[] runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes) {
	    Object[] resultArray = new Object[numberOfTimes * 2 + 1]; // Object array to store results

	    TestTimes testTimes = new TestTimes();

	    for (int i = 0; i < numberOfTimes; i++) {
	       
	        Integer[] unsortedArray = createArray(arrayType, arraySize);
	        
	        Integer[] unsortedCopy = Arrays.copyOf(unsortedArray, unsortedArray.length);
	        resultArray[i * 2] = unsortedCopy; 

	        long startTime = System.nanoTime();

	   
	        Integer[] sortedArray = performSort(sortType, Arrays.copyOf(unsortedArray, unsortedArray.length));

	        long endTime = System.nanoTime();

	       
	        long testTime = endTime - startTime;
	        testTimes.addTestTime(testTime);

	      
	        Integer[] sortedCopy = Arrays.copyOf(sortedArray, sortedArray.length);
	        resultArray[i * 2 + 1] = sortedCopy; 
	    }

	  
	    resultArray[numberOfTimes * 2] = testTimes;

	    return resultArray;
	}

	private Integer[] performSort(SortType sortType, Integer[] arrayToSort) {
	    
	    switch (sortType) {
	        case BubbleSort:
	            BubbleSort bubbleSort = new BubbleSort();
	            bubbleSort.sort(arrayToSort);
	            break;
	        case InsertionSort:
	            InsertionSort insertionSort = new InsertionSort();
	            insertionSort.sort(arrayToSort);
	            break;
	        case SelectionSort:
	            SelectionSort selectionSort = new SelectionSort();
	            selectionSort.sort(arrayToSort);
	            break;
	        
	    }
	    return arrayToSort;
	}

	public void displayRunTime(TestTimes r, SortType sortType, ArrayType arrayType, int arraySize) {
	    System.out.println("\nSortType: " + sortType + ", ArrayType: " + arrayType + ", ArraySize: " + arraySize);

	    
	    System.out.println("---------------------------------------------------------------------------------------------------------------------");

	    for (long runtime : r.getTestTimes()) {
	        System.out.printf("%-10d", runtime);
	    }

	    
	    System.out.printf("%-10s\n", r.getAverageTestTime());
	}







	public static void main(String[] args) {

	    SortDriver driver = new SortDriver();

	   
	    int[] arraySizes = {1000, 10000};
	    int testCount = 10;

	   
	    SortDriverInterface.SortType[] sortTypes = {
	            SortDriverInterface.SortType.BubbleSort,
	            SortDriverInterface.SortType.InsertionSort,
	            SortDriverInterface.SortType.SelectionSort
	    };

	   
	    SortDriverInterface.ArrayType[] arrayTypes = {
	            SortDriverInterface.ArrayType.Equal,
	            SortDriverInterface.ArrayType.Random,
	            SortDriverInterface.ArrayType.Increasing,
	            SortDriverInterface.ArrayType.Decreasing,
	            SortDriverInterface.ArrayType.IncreasingAndRandom
	    };

	    
	    for (SortDriverInterface.SortType sortType : sortTypes) {
	        for (SortDriverInterface.ArrayType arrayType : arrayTypes) {
	            for (int arraySize : arraySizes) {
	                Object[] results = driver.runSort(sortType, arrayType, arraySize, testCount);
	                TestTimes testTimes = (TestTimes) results[testCount * 2];

	                
	                driver.displayRunTime(testTimes, sortType, arrayType, arraySize);
	            }
	        }
	    }
	}

	

}


