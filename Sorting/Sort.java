import java.util.*;
class Sort{
   public static void main(String args[]){
	Scanner num= new Scanner(System.in);
	System.out.println("Enter the array length");
	int n=num.nextInt();
	int arr[]=new int[n];
	Random r = new Random();
	for(int i=0;i<arr.length;i++){
	   arr[i]=r.nextInt(100);	
	}

	int arr2[]=new int[n];
	for(int i=0;i<arr.length;i++){
	   arr2[i]=arr[1];	
	}
	Sort s = new Sort();
	long start = System.nanoTime();
	s.insertionSort(arr);
	long end = System.nanoTime();
	long diff = end-start;
	System.out.println("INsertion sort: "+diff);

	long start1 = System.nanoTime();
	s.qsort(arr2,0,n-1);
	long end1 = System.nanoTime();
	long diff1 = end1-start1;
	System.out.println("Quick Sort: "+diff1);
}

 void insertionSort(int[] arr){
	for(int i=0;i<arr.length;i++){
           for(int j=0;j<i;j++){
		if(arr[i]<arr[j]){
		   int temp=arr[i];
		   arr[i]=arr[j];
		   arr[j]=temp;		
		}
 	   }
        }
}

  int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
    void qsort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
 
            qsort(arr, low, pi-1);
            qsort(arr, pi+1, high);
        }
    }
}
