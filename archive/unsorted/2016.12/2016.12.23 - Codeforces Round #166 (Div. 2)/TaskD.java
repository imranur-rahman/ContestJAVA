package Nope;

import net.egork.utils.io.InputReader;
import net.egork.utils.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class TaskD {
        int k;
        int[] good = new int[26];
        public static final int PRIME = 727;
        public static final int MAX = 1500;
        public void solve(int testNumber, InputReader in, OutputWriter out) {
                String s = in.readString();
                String now = in.readString();
                k = in.readInt();
                long[] bad = new long[s.length() + 1];
                long[] p727 = new long[s.length() + 1];
                long[] par = new long[s.length() + 1];
                Set<Long> set = new HashSet<Long>();
                p727[0] = 1;
                for(int i = 0; i < 26; ++i)
                        good[i] = now.charAt(i) - '0';
                for(int i = 1; i <= s.length(); ++i){
                        p727[i] = p727[i - 1] * 727;
                        par[i] = par[i - 1] * 727 + s.charAt(i - 1) - '0';
                        bad[i] = bad[i - 1] + (good[s.charAt(i - 1) - 'a'] == 0 ? 1 : 0);
                }
                for(int i = 0; i < s.length(); ++i){
                        for(int j = i + 1; j <= s.length(); ++j){//i 0-based, j 1-based
                                if(bad[j] - bad[i] <= k){
                                        set.add(par[j] - par[i] * p727[j - i]);
                                }
                        }
                }
                out.printLine(set.size());
        }
}
