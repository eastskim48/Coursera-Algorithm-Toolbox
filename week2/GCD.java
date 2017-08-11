import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    int Large;
    int small;
    int temp;
    if(a>=b){
    	Large = a;
    	small = b;
    }
    else{
    	Large = b;
    	small = a;
    }
    
    while(Large%small!=0){
    	temp = small;
    	small = Large%small;
    	Large = temp;
    }

    return small;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
