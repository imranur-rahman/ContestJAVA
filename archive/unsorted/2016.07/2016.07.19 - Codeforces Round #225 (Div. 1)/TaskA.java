package Nope;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
                int n = in.nextInt();
                int[] right = new int[n + 1];
                int[] cows = new int[n + 1];
                for(int i = 1; i <= n; ++i) {
                        cows[i] = in.nextInt();
                        right[i] = right[i - 1] + cows[i];
                }
                long cnt = 0;
                for(int i = 1; i <= n; ++i)
                        if(cows[i] == 0)
                                cnt += right[i];
                out.print(cnt);
        }
}
