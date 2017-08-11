import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      int m1 = l;
      int m2 = r+1;
      int cursor = m1+1;
      
      while(cursor<m2){
    	  if(a[cursor]>a[l]){
    		  m2--;
    		  int temp = a[cursor];
    		  a[cursor] = a[m2];
    		  a[m2] = temp;
    	  }
    	  else if(a[cursor]<a[l]){
    		  m1++;
    		  int temp = a[cursor];
    		  a[cursor] = a[m1];
    		  a[m1] = temp;
    	  }
//    	  System.out.println(cursor);
//    	  System.out.println(a[cursor]);
    	  if(a[cursor]==a[l]||cursor==m1)
    		  cursor++;
//    	  
//    	  System.out.println("m1:"+m1);
//          System.out.println("m2:"+m2);
      }
      
      int temp=a[l];
      a[l]=a[m1];
      a[m1]=temp;
      m1--;
      int[] m = {m1, m2};
      return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int m[] = partition3(a,l,r);
//        System.out.println("m[1]:"+m[1]+"  r:"+r);
        if(m[1]<r){
//        	System.out.println("upper실");
        	randomizedQuickSort(a, m[1],r);
        	
        }
        if(m[0]>l){
//        	System.out.println("lower실");
        	randomizedQuickSort(a, l,m[0]);
        	
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
              a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

