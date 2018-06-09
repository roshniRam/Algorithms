import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.util.Arrays;
import java.util.ArrayList;

public class DivideAndConquer{
	public static void main(String[] args) {
		int n;
		Scanner inp = new Scanner(System.in);
		Random rand = new Random();
		n = inp.nextInt();
		Coord[] points = new Coord[n];
		for (int i = 0;i < n ; i++) {
			points[i] = new Coord(rand.nextDouble() * 20,rand.nextDouble() * 20);
		}
		Arrays.sort(points);
		double d = getMinDist(points, n, 0, n - 1);
		System.out.println("The closest distance between two points is" + d);
	}
	
	public static double getDist(Coord p1, Coord p2){
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	}

	public static double getMinDist(Coord []points, int n, int i, int j){
		if(n <= 3){
			return useBrute(points, i, j, n);
		}
		double d1 = getMinDist(points, n / 2, i, i + n / 2 - 1);
		double d2 = getMinDist(points, n - (n / 2), i + n / 2, j);
		double d = Math.min(d1, d2);
		d = getInterectionDist(points, i, j, d);
		return d;
	}

	public static double useBrute(Coord[] points, int i, int j, int n){
		double d = -1;
		for(int k1 = i;k1 <= j; k1++){
			for(int k2 = k1 + 1; k2 <= j ; k2++){
				double dist = getDist(points[k1], points[k2]);
				if(d == -1 || d > dist){
					d = dist;
				}
			}
		}
		return d;
	}

	public static double getInterectionDist(Coord[] points, int i, int j,double d ){
		double midx = (points[i].getX() + points[j].getX()) / 2;
		double rangex_low = midx - d;g
		double rangex_high = midx + d;
		ArrayList<Coord> al = new ArrayList<Coord>();
		for(int k1 = i; k1 <= j;k1++){
			if(points[k1].getX() >= rangex_low || points[k1].getX() <= rangex_high){
				al.add(points[k1]);
			}
		}
		Coord[] al_array = al.toArray(new Coord[0]);
		d = useBrute(al_array, 0,al_array.length - 1, al_array.length);
		return d;	
	}
}

class Coord implements Comparable<Coord>{
	private double x;
	private double y;
	public Coord(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double getY(){
		return this.y;
	}

	public double getX(){
		return this.x;
	}

	@Override
	public int compareTo(Coord p){
		return new Double(this.getX()).compareTo(new Double(p.getX()));
	}
}