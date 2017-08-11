import java.util.Scanner;

public class Fibonacci {
	
	
  private static long calc_fib(int n) {
    long[] fib = new long[n+2];
    fib[0]=0;
    fib[1]=1;
    for(int a=2;a<=n;a++){
    	fib[a]=fib[a-2]+fib[a-1];
    }
    return fib[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(calc_fib(n));
  }
}
