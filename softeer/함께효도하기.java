import java.io.*;
import java.util.*;

public class 함께하는효도 {

    static class Node {

        int x, y, fruit;

        Node(int x, int y, int fruit) {
            this.x = x;
            this.y = y;
            this.fruit = fruit;
        }
    }

    static int n, m, res;
    static List<Node> nodes;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        res = Integer.MIN_VALUE;
        nodes = new ArrayList<>();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            Node startNode = new Node(x - 1, y - 1, map[x - 1][y - 1]);
            nodes.add(startNode);
            map[x - 1][y - 1] = 0;
        }
        
        dfs(nodes.get(0), 1, 0, 0);

        System.out.println(res);
    }

    private static void dfs(Node curNode, int idx, int cnt, int maxFruit) {

        if (cnt == 3) {
            if (idx < m) {
                dfs(nodes.get(idx), idx + 1, 0, maxFruit + curNode.fruit);
                return;
            }

            res = Math.max(res, maxFruit + curNode.fruit);
            return;
        };

        for (int i = 0; i < 4; i++) {
            int nx = curNode.x + dx[i];
            int ny = curNode.y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

            Node nextNode = new Node(nx, ny, curNode.fruit + map[nx][ny]);
            int tmp = map[nx][ny];
            map[nx][ny] = 0;
            dfs(nextNode, idx, cnt + 1, maxFruit);
            map[nx][ny] = tmp;
        }
    }
}
