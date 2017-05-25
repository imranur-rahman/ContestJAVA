package Nope;

import net.egork.utils.io.InputReader;
import net.egork.utils.io.OutputWriter;

import java.util.Arrays;

public class TaskB {

        public void CountingSort(int col, int right[][], int n, int m)
        {
                int[] count = new int[m + 1];
                int[] output = new int[n];

                for(int i = 0; i < n; ++i)
                        count[ right[i][col] ]++;
                int j = 0;
                for(int i = 0; i <= m; ++i)
                        while(count[i] != 0)
                        {
                                count[i]--;
                                output[j++] = i;
                        }
                for(int i = 0; i < n; ++i)
                        right[i][col] = output[i];
        }
        public void solve(int testNumber, InputReader in, OutputWriter out) {
                int n = in.readInt();
                int m = in.readInt();

                String[] ar = new String[n];
                int[][] right = new int[n][m];//contains consecutive 1's starting from j-th col in i-th row

                for(int i = 0; i < n; ++i)
                        ar[i] = in.readString();

                for(int i = 0; i < n; ++i)
                {
                        right[i][m - 1] = (ar[i].charAt(m - 1) == '1' ? 1 : 0);
                        for(int j = m - 2; j >= 0; --j)
                        {
                                if(ar[i].charAt(j) == '0')
                                        right[i][j] = 0;
                                else
                                        right[i][j] = right[i][j + 1] + 1;
                        }
                }

                int ans = 0;
                int[] count = new int[m + 1];
                int[] output = new int[n];

                for(int l = 0; l < m; ++l)
                {
                        /*
                        Arrays.fill(count, 0);
                        for(int i = 0; i < n; ++i)
                                count[ right[i][l] ]++;
                        int j = 0;
                        for(int i = 0; i <= m; ++i)
                                while(count[i] != 0)
                                {
                                        count[i]--;
                                        output[j++] = i;
                                }
                        for(int i = 0; i < n; ++i)
                                right[i][l] = output[i];
                        */
                        for(int i = 0; i < n; ++i)
                                output[i] = right[i][l];
                        Arrays.sort(output);
                        for(int i = 0; i < n; ++i)
                                ans = Math.max(ans, output[i] * (n - i));
                }

                out.printLine(ans);
        }
}
