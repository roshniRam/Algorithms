import java.util.*;
class QSort{
  public static void main(String args[]){
	Scanner num= new Scanner(System.in);
	int arr[]=new int[5];
	System.out.println("Enter the array elements");
	for(int i=0;i<arr.length;i++){
	   arr[i]=num.nextInt();	
	}
	QSort q=new QSort();
	q.sort(arr,0,arr.length-1);
	for(int i=0;i<arr.length;i++){
	   System.out.println(arr[i]);	
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
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
 
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}
