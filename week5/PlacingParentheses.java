import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
    	int n = exp.length()/2;
    	long[] num = new long[n+1];
    	char[] op = new char[n];
    	int index = 0;
    	long guide;
    	long buide;
    	long[][] min = new long[n+1][n+1];
    	long[][] max = new long[n+1][n+1];
    	char[] input = exp.toCharArray();
    	long a;
    	long b;
    	long c;
    	long d;
    	
    	for(int j=0; j<2*n+1; j+=2){ 
    		max[index][index] = (long)input[j]-48;
    		min[index][index] = max[index][index];
//    		System.out.println(num[index]);
    		index++;
    	} //숫자 추출
    	
    	index = 0;
    	
    	for(int j=1; j<2*n+1; j+=2){
    		op[index] = exp.charAt(j);
//    		System.out.println(op[index]);
    		index++;
    	} //연산기호 추출  
    	
//    	for(int j=0; j<n; j++){
//    		max[j][j+1]=eval(max[j][j],max[j+1][j+1],op[j]);
//    		min[j][j+1]=eval(min[j][j],min[j+1][j+1],op[j]);
//    	} //인접한 수들 끼리의 연산  
    	

    	//숫자의 개수 : n+1
    	for(int s=1; s<=n; s++){ //s는 차이  
    		for(int i=0; i<=n-s; i++){   //i는 가로좌표  
    			max[i][s+i] = -1000000000;
    			min[i][s+i] = 1000000000;
    			for(int k=i; k<s+i; k++){
    					a = eval(max[i][k],max[k+1][s+i],op[k]);
    					b = eval(max[i][k],min[k+1][s+i],op[k]);
    					c = eval(min[i][k],max[k+1][s+i],op[k]);
    					d = eval(min[i][k],min[k+1][s+i],op[k]);
    					guide = findMax(a,b,c,d);
    					if(guide>max[i][s+i])
    						max[i][s+i] = guide;
//    					System.out.println(guide);
    					guide = findMin(a,b,c,d);
    					if(guide<min[i][s+i])
    						min[i][s+i] = guide;
//    					System.out.println("max["+i+"]["+(s+i)+"]"+max[i][s+i]);
    					
    				}
//    			System.out.println(i);
    			}
//    		System.out.println(s);
    	}
    	
      //write your code here
      
      return max[0][n];
    }
    
    private static long findMax(long a, long b, long c, long d){
    	long max=a;
    	if(b>max)
    		max=b;
    	if(c>max)
    		max=c;
    	if(d>max)
    		max=d;
    	return max;
    }
    
    private static long findMin(long a, long b, long c, long d){
    	long min=a;
    	if(b<min)
    		min=b;
    	if(c<min)
    		min=c;
    	if(d<min)
    		min=d;
    	return min;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}


//if(op[k]=='+'){
//	if(max[i][k]+max[k+1][s]>max[i][s])
//		max[i][s] = max[i][k]+max[k+1][s];
//	if(min[i][k]+min[k+1][s]<min[i][s])
//		min[i][s] = min[i][k]+min[k+1][s];
//	}
//else if(op[k]=='-'){
//	if(max[i][k]-min[k+1][s]>max[i][s])
//		max[i][s] = max[i][k]-min[k+1][s];
//	if(min[i][k]-max[k+1][s]<min[i][s])
//		min[i][s] = min[i][k]-max[k+1][s];
//	}
//else if(op[k]=='*'){
//	if(max[i][k]*max[k+1][s]>max[i][s])
//		max[i][s] = max[i][k]*max[k+1][s];
//	if(min[i][k]*min[k+1][s]>max[i][s])
//		max[i][s] = min[i][k]*min[k+1][s]; //곱의 max  
//	if(max[i][k]*min[k+1][s]<min[i][s])
//		min[i][s] = max[i][k]*min[k+1][s];
//	if(min[i][k]*max[k+1][s]<min[i][s])
//		min[i][s] = min[i][k]*max[k+1][s]; //곱의 min  
//	}


