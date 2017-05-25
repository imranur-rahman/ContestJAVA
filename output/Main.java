import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.HashSet;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Nidala
 */
public class Main {
        public static void main(String[] args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                OutputWriter out = new OutputWriter(outputStream);
                TaskD solver = new TaskD();
                solver.solve(1, in, out);
                out.close();
        }

        static class TaskD {
                int k;
                int[] good = new int[26];

                public void solve(int testNumber, InputReader in, OutputWriter out) {
                        String s = in.readString();
                        String now = in.readString();
                        k = in.readInt();
                        long[] bad = new long[s.length() + 1];
                        long[] p727 = new long[s.length() + 1];
                        long[] par = new long[s.length() + 1];
                        Set<Long> set = new HashSet<Long>();
                        p727[0] = 1;
                        for (int i = 0; i < 26; ++i)
                                good[i] = now.charAt(i) - '0';
                        for (int i = 1; i <= s.length(); ++i) {
                                p727[i] = p727[i - 1] * 727;
                                par[i] = par[i - 1] * 727 + s.charAt(i - 1) - '0';
                                bad[i] = bad[i - 1] + (good[s.charAt(i - 1) - 'a'] == 0 ? 1 : 0);
                        }
                        for (int i = 0; i < s.length(); ++i) {
                                for (int j = i + 1; j <= s.length(); ++j) {//i 0-based, j 1-based
                                        if (bad[j] - bad[i] <= k) {
                                                set.add(par[j] - par[i] * p727[j - i]);
                                        }
                                }
                        }
                        out.printLine(set.size());
                }

        }

        static class InputReader {
                private InputStream stream;
                private byte[] buf = new byte[1024];
                private int curChar;
                private int numChars;
                private InputReader.SpaceCharFilter filter;

                public InputReader(InputStream stream) {
                        this.stream = stream;
                }

                public int read() {
                        if (numChars == -1) {
                                throw new InputMismatchException();
                        }
                        if (curChar >= numChars) {
                                curChar = 0;
                                try {
                                        numChars = stream.read(buf);
                                } catch (IOException e) {
                                        throw new InputMismatchException();
                                }
                                if (numChars <= 0) {
                                        return -1;
                                }
                        }
                        return buf[curChar++];
                }

                public int readInt() {
                        int c = read();
                        while (isSpaceChar(c)) {
                                c = read();
                        }
                        int sgn = 1;
                        if (c == '-') {
                                sgn = -1;
                                c = read();
                        }
                        int res = 0;
                        do {
                                if (c < '0' || c > '9') {
                                        throw new InputMismatchException();
                                }
                                res *= 10;
                                res += c - '0';
                                c = read();
                        } while (!isSpaceChar(c));
                        return res * sgn;
                }

                public String readString() {
                        int c = read();
                        while (isSpaceChar(c)) {
                                c = read();
                        }
                        StringBuilder res = new StringBuilder();
                        do {
                                if (Character.isValidCodePoint(c)) {
                                        res.appendCodePoint(c);
                                }
                                c = read();
                        } while (!isSpaceChar(c));
                        return res.toString();
                }

                public boolean isSpaceChar(int c) {
                        if (filter != null) {
                                return filter.isSpaceChar(c);
                        }
                        return isWhitespace(c);
                }

                public static boolean isWhitespace(int c) {
                        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
                }

                public interface SpaceCharFilter {
                        public boolean isSpaceChar(int ch);

                }

        }

        static class OutputWriter {
                private final PrintWriter writer;

                public OutputWriter(OutputStream outputStream) {
                        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
                }

                public OutputWriter(Writer writer) {
                        this.writer = new PrintWriter(writer);
                }

                public void close() {
                        writer.close();
                }

                public void printLine(int i) {
                        writer.println(i);
                }

        }
}

