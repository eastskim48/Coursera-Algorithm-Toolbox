import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
    	int ten;
    	int five;
    	int one;
    	
    	ten = m/10;
    	m=m%10;
    	five = m/5;
    	m = m%5;
    	one=m;
        return ten+five+one;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}