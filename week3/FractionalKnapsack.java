import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int tempValues;
        int tempWeights;
        int i=0;
        int plusWeight;
        for(int a=0; a<values.length; a++){
        	for(int v=values.length-2; v>=0;v--){
        		if((double)values[v]/(double)weights[v]<(double)values[v+1]/(double)weights[v+1]){
        			tempValues = values[v];
        			tempWeights = weights[v];
        			values[v] = values[v+1];
        			weights[v] = weights[v+1];
        			values[v+1] = tempValues;
        			weights[v+1] = tempWeights;
        		}
        			
        	}
        }

        
//        for(int a=0;a<values.length;a++){
//        	System.out.println(values[a]);
//        	System.out.println(weights[a]);
//        }
        
        while(capacity>0&&i<values.length){
        	if(weights[i]>capacity)
        		plusWeight = capacity;
        	else
        		plusWeight = weights[i];
        	capacity -=plusWeight;
        	value+=(double)plusWeight*(double)values[i]/(double)weights[i];
        	i++;
        }
        
        //write your code here

        return value;
    }

    public static void main(String args[]) {
    	
    	
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        Random random = new Random();
//        for(int a=0; a<10000; a++){
        for (int i = 0; i < n; i++) {
//        	values[i] = random.nextInt(capacity);
//            weights[i] = random.nextInt(capacity-1)+1;
          values[i] = scanner.nextInt();
           weights[i] = scanner.nextInt();
        }
        System.out.println(String.format("%.4f",getOptimalValue(capacity, values, weights)));
//    }
    }
} 
