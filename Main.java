package atmdatabase;

import java.util.*;
import java.io.*;
import java.lang.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int r1 = sc.nextInt();
		int r2 = sc.nextInt();
		int r = r1 + r2;
		int x = Math.abs(x1 - x2);
		int y = Math.abs(y1 - y2);
		double dist = Math.sqrt(x*x + y*y);
		double distr = (double) Math.round(dist * 100.00) / 100.00;
		if (dist == r) {
		    System.out.println("Touches");
		    System.out.println(distr);
		}
		else if (dist < r) {
		    System.out.println("Intersects");
		    System.out.println(distr);
		}
		else {
		    System.out.println("Do not Touch");
		    System.out.println(distr);
		}
	}
}

