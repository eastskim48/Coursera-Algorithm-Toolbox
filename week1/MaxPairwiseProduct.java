import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long temp=0;
        long input=0;
        long result=0;
        int n = sc.nextInt();
        long first = sc.nextLong();
        long second = sc.nextLong();
        
        if(second>first){
            temp = first;
            first = second;
            second = temp;
        }
        
        
        
        if(n>2){
            for(int a=2; a<n; a++){
                input = sc.nextLong();
                if(input>first){
                    second = first;
                    first = input;
                }
                else if(input<=first && input>=second)
                    second = input;
            }
        }
        result = first * second;
        System.out.println(result);
    }
/*
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextLong() {
            return Integer.parseLong(next());
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }

    }

*/
}
