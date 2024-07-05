import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Loc{
    int r;
    int c;
    int z;

    public Loc(int r, int c, int z) {
        this.r = r;
        this.c = c;
        this.z = z;
    }
}

public class Main {
    static int[] dr = {0,0,0,0,-1,1};
    static int[] dc = {0,0,-1,1,0,0};
    static int[] dz = {1, -1,0,0,0,0};
    static StringBuilder sb = new StringBuilder();
    static int L, R, C;
    static char[][][] map;
    static int[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L == 0 && R == 0 && C == 0){
                System.out.println(sb.toString()); // sb vs sb.toString()
                return;
            }
            // 초기화
            int sr=0, sc=0, sz=0;
            map = new char[L][R][C];
            visit = new int[L][R][C];

            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String str = br.readLine();
                    for(int k=0; k<C; k++){
                        map[i][j][k]=str.charAt(k);
                        if(map[i][j][k]=='S'){
                            sr=j; sc=k; sz=i;
                            map[i][j][k]='.';
                        }
                    }
                }
                br.readLine(); // 여백
            }
            bfs(sr, sc, sz);
        }
    }

    static void bfs(int sr, int sc, int sz){
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(sr, sc, sz));
        visit[sz][sr][sc] = 1;

        while(!q.isEmpty()){
            Loc loc = q.poll();

            for(int d=0; d<6; d++){
                int nr = loc.r + dr[d];
                int nc = loc.c + dc[d];
                int nz = loc.z + dz[d];

                if(nz<0 || nz>=L || nc<0 || nc>=C || nr<0 || nr>=R || visit[nz][nr][nc]!=0){continue;}
                if(map[nz][nr][nc]=='E'){ //도착하면
                    sb.append("Escaped in " + visit[loc.z][loc.r][loc.c] + " minute(s).\n");
                    return;
                }
                if(map[nz][nr][nc]=='.' ){
                    visit[nz][nr][nc] = visit[loc.z][loc.r][loc.c] +1;
                    q.offer(new Loc(nr, nc, nz));
                }
            }
        }
        sb.append("Trapped!\n");
    }
}