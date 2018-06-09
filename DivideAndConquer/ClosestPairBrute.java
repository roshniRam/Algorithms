import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

class ClosestPairBrute  {
	public static void main(String[] args) {
		int n;
		Scanner inp = new Scanner(System.in);
		Random rand = new Random();
		n = inp.nextInt();
		double[] x = new double[n];
		double[] y = new double[n];
		for (int i = 0;i < n ; i++) {
			x[i] = rand.nextDouble() * 20 ;
			y[i] = rand.nextDouble() * 20 ;
		}

		double min_dist = -1;
		double colx1 = 0, coly1 = 0, colx2 = 0, coly2 = 0;
		for(int i = 0; i < n ;i++){
			for(int j = i + 1; j < n; j++){
				double dist = getDist(x,y,i,j);
				if(min_dist == -1 || dist < min_dist){
					min_dist = dist;
					colx1 = x[i];
					coly1 = y[i];
					colx2 = x[j];
					coly2 = y[j];
				}
			}
		}
		System.out.println("Closest distance is " + min_dist + "Between (" + colx1 + ", " + coly1 + ") and " + "(" + colx2 + ", "+ coly2 + ")");

	}
	
	public static double getDist(double[] x, double[] y, int i, int j){
		return Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
	} 
}