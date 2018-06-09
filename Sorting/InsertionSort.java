import java.util.*;
class InsertionSort{
public static void main(String args[]){
	Scanner num= new Scanner(System.in);
	int arr[]=new int[5];
	System.out.println("Enter the array elements");
	for(int i=0;i<arr.length;i++){
	   arr[i]=num.nextInt();	
	}
	
	for(int i=0;i<arr.length;i++){
           for(int j=0;j<i;j++){
		if(arr[i]<arr[j]){
		   int temp=arr[i];
		   arr[i]=arr[j];
		   arr[j]=temp;		
		}
 	   }
        }

	for(int i=0;i<arr.length;i++){	
		System.out.print(arr[i]+" ");
	}
}
}
