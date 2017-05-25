package Nope;

import net.egork.collections.Pair;
import net.egork.utils.io.InputReader;
import net.egork.utils.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TaskD {
        public boolean isInGrid(int x, int y, int n){
                return x >= 0 && y >= 0 && x < n && y < n;
        }
        public void dfs(boolean[][] vis, int x, int y, int n, Pair move){
                if(isInGrid(x, y, n) == false)
                        return;
                vis[x][y] = true;
                for(int i = -1; i <= 1; ++i)
                        for(int j = -1; j <= 1; ++j)
                                if(Math.abs(i) + Math.abs(j) > 0)//all 8 direction
                                        dfs(vis, x + i * (int) move.first, y + j * (int) move.second, n, move);
        }
        public boolean isOK(ArrayList< Pair<Integer, Integer> >arrayList, char[][] ar, int n, Pair move){
                boolean[][] vis = new boolean[n][n];
                arrayList.forEach((Pair pair) -> {
                        dfs(vis, (int) pair.first, (int) pair.second, n, move);
                });
                for(int i = 0; i < n; ++i)
                        for(int j = 0; j < n; ++j){
                                if(ar[i][j] == 'x'  &&  vis[i][j] == false)
                                        return false;
                                if(ar[i][j] == '.'  &&  vis[i][j] == true)
                                        return false;
                        }
                return true;
        }
        public char[][] printSol(char[][] ar, int n, Pair move){
                char[][] sol = new char[2 * n - 1][2 * n - 1];
                Arrays.fill(sol, '.');
                sol[n][n] = 'o';
                if((int)move.first == 1  && (int)move.second == 1){
                        for(int k = 0; k < 2 * n - 1; ++k){
                                sol[k][k] = 'x';
                                sol[2 * n - 2 - k][k] = 'x';
                        }
                        sol[n][n] = 'o';
                        return sol;
                }
                if((int)move.first + (int)move.second == 1){
                        for(int k = 0; k < 2 * n - 1; ++k){
                                sol[k][n] = sol[n][k] = 'x';
                        }
                        sol[n][n] = 'o';
                        return sol;
                }
                for(int i = -1; i <= 1; ++i)
                        for(int j = -1; j <= 1; ++j)
                                if(Math.abs(i) + Math.abs(j) > 0)
                                        sol[n + i * (int) move.first][n + j * (int) move.second] = 'x';
                return sol;
        }
        public void solve(int testNumber, InputReader in, OutputWriter out) {
                int n = in.readInt();
                char[][] ar = new char[n][n];
                ArrayList< Pair<Integer, Integer> >arrayList = new ArrayList<>(n);
                for(int i = 0; i < n; ++i)
                        for(int j = 0; j < n; ++j){
                                ar[i][j] = in.readCharacter();
                                if(ar[i][j] == 'o')
                                        arrayList.add(Pair.makePair(i, j));
                        }
                for(int i = 1; i <= 50; ++i)
                        for(int j = 1; j <= 50; ++j){
                                if(isOK(arrayList, ar, n, Pair.makePair((Integer) i, (Integer) j)) == true){
                                        out.printLine("YES");
                                        char[][] sol = printSol(ar, n, Pair.makePair((Integer) i, (Integer) j));
                                        for(int k = 0; k < 2 * n - 1; ++k) {
                                                for (int l = 0; l < 2 * n - 1; ++l)
                                                        out.print(sol[k][l]);
                                                out.printLine();
                                        }
                                        return;
                                }
                        }
                out.printLine("NO");
        }
}
