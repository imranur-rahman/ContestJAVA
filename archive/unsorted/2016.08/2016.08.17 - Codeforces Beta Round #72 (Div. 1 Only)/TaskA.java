package Nope;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
                int n = in.nextInt();
                int ar[] = new int[n + 1];
                for(int i = 0; i < n; ++i)
                        ar[i] = in.nextInt();
                ar[n] = 1000000009;
                long last = ar[0], cnt = 1;
                long ans = 0;
                for(int i = 1; i <= n; ++i)
                {
                        if(ar[i] == last)
                        {
                                cnt++;
                        }
                        else
                        {
                                ans += cnt * (cnt + 1) / 2;
                                cnt = 1;
                                last = ar[i];
                        }
                }
                out.print(ans);
        }
}
