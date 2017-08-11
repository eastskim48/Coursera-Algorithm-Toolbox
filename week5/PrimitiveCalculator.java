import java.util.*;

public class PrimitiveCalculator {
	 
	
//    private static List<Integer> optimal_sequence(int n) {
//        List<Integer> sequence = new ArrayList<Integer>();
//        while (n >= 1) {
//            sequence.add(n);
//            if (n % 3 == 0) {
//                n /= 3;
//            } else if (n % 2 == 0) {
//                n /= 2;
//            } else {
//                n -= 1;
//            }
//        }
//        Collections.reverse(sequence);
//        return sequence;
//    }

    public static List<Integer> Calculator(int n){
    	int[] cal = new int[n+1];
    	List<Integer> num = new ArrayList<Integer>();
    	int min;
    	int mid;
    	int contain;
    	
    	cal[1] = 1;
    	
    	for(int a=2; a<=n; a++){
    		min=cal[a-1];
    		if(a%6==0){
    			if(cal[a/3]>cal[a/2])
    				mid = a/2;
    			else
    				mid = a/3;
    			if(cal[mid]<min)
    				min = cal[mid];
    		} //6의 배수 -> 세 수 모두 비교
    		else if(a%3==0&&a%2!=0){
    			if(cal[a/3]<min)
    				min = cal[a/3];
    		}
    		else if(a%2==0&&a%3!=0){
    			if(cal[a/2]<min){
    				min = cal[a/2];
    			}
    		}
    		cal[a]=min+1;
    	} //n-1까지 구하는 과정 
    	
    	while(n>=1){
    		num.add(n);
    		min=cal[n-1];
    		contain = n;
    		if(n%6==0){
    			if(cal[n/3]>cal[n/2])
    				mid = n/2;
    			else
    				mid = n/3;
    			if(cal[mid]<min){
    				n=mid;
    				min = cal[mid];
    			}
    		} //6의 배수 -> 세 수 모두 비교
    		else if(n%3==0&&n%2!=0){
    			if(cal[n/3]<min){
    				n=n/3;
    				min = cal[n/3];
    			}
    		}
    		else if(n%2==0&&n%3!=0){
    			if(cal[n/2]<min){
    				n=n/2;
    				min = cal[n/2];
    			}
    		}
    		if(contain==n){
    			n-=1;
    		}
    	} //n-1까지 구하는 과정 
    	Collections.reverse(num);
    	return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = Calculator(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
        
    }
}

