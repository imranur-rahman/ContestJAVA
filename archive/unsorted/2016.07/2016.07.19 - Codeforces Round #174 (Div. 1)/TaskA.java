package Nope;

import net.egork.collections.FenwickTree;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
                int n = in.nextInt();
                int[] delta = new int[n + 1];
                int[] value = new int[n + 1];
                long sum = 0;
                int size = 1;
                for(int i = 0; i < n; ++i){
                        int type = in.nextInt();
                        if(type == 1){ // increase
                                int a = in.nextInt();
                                int x = in.nextInt();
                                delta[a - 1] += x;
                                sum += a * x;
                        }
                        else if(type == 2){ // append
                                int a = in.nextInt();
                                value[size++] = a;
                                sum += a;
                        }
                        else{ // delete last element
                                sum -= value[size - 1] + delta[size - 1];
                                value[size - 1] = 0;
                                delta[size - 2] += delta[size - 1];
                                delta[size - 1] = 0;
                                size--;
                        }
                        out.println((double) sum / size);
                }
        }
}
