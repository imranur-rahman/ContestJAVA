package Nope;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskD {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
                String s1, s2;
                s1 = in.nextLine();
                s2 = in.nextLine();
                int n = s1.length();
                int m = s2.length();
                long ans = 0;

                for(int i = 0; i < Math.min(n, m); ++i)
                {
                        if(n % (i + 1) != 0  ||  m % (i + 1) != 0 )
                                continue;
                        boolean isOK = true;
                        for(int j = 0; j <= i; ++j)
                                if(s1.charAt(j) != s2.charAt(j))
                                        isOK = false;
                        for(int j = i + 1; j < n; ++j)
                                if(s1.charAt(j) != s1.charAt(j - i - 1))
                                        isOK = false;
                        for(int j = i + 1; j < m; ++j)
                                if(s2.charAt(j) != s2.charAt(j - i - 1))
                                        isOK = false;
                        if(isOK == true)
                                ans++;
                }

                out.println(ans);
        }
}
