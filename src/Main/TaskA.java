package Main;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
                int n = in.nextInt();
                int[] cows = new int[n + 1];
                int[] pre = new int[n + 1];
                for(int i = 1; i <= n; ++i)
                        cows[i] = in.nextInt();
                for(int i = 1; i <= n; ++i)
                        pre[i] = pre[i - 1] + cows[i];//kotogula RIGHT hoye ache
                int cnt = 0;
                for(int i = n; i >= 1; --i)
                        if(cows[i] == 1)
                                cnt += pre[i] - 1;
                out.print(cnt);
        }
}
