package Nope;

import net.egork.io.IOUtils;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
                int n = in.nextInt();
                int k = in.nextInt();
                int x = in.nextInt();

                int[] ar = new int[n + 1];
                for(int i = 1; i <= n; ++i)
                        ar[i] = in.nextInt();

                int[] pre = new int[n + 2];
                int[] suf = new int[n + 2];

                for(int i = 1; i <= n; ++i)
                        pre[i] = pre[i - 1] | ar[i];
                for(int i = n; i >= 1; --i)
                        suf[i] = suf[i + 1] | ar[i];

                long ret = 1;
                while(k-- > 0)
                        ret = ret * x;//x^k

                long ans = 0;
                for(int i = 1; i <= n; ++i)
                        ans = Math.max(ans, pre[i - 1] | (ar[i] * ret) | suf[i + 1]);
                out.println(ans);
        }
}
