import java.util.*;
import java.io.*;

class Loc{
    int x;
    int y;
    int cnt;
    
    public Loc(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}


class Solution {
    
    static int[][] map;
    static int[] dx = {-1, 1, 0,0};
    static int[] dy = {0,0,-1,1};
    static int minDis;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        map = new int[101][101];
        for(int[] r: rectangle){
            int x1 = 2 * r[0];
            int y1 = 2 * r[1];
            int x2 = 2 * r[2];
            int y2 = 2 * r[3];
            
            fill(x1, y1, x2, y2);
        }
        
        bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);
        return minDis; 
    }
    
    static void fill(int x1, int y1, int x2, int y2){
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(map[i][j]==2) continue; //이미 표시? pass
                // 1) 내부
                map[i][j]=2;
                // 2) 테두리
                if(i==x1 ||i== x2 || j==y1 || j==y2) map[i][j]=1;
            }
        }
    }
    
    static void bfs(int startX, int startY, int itemX, int itemY){
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(startX, startY, 0));
        
        boolean[][] visit = new boolean[101][101];
        visit[startX][startY] = true;
        
        while(!q.isEmpty()){
            Loc cur = q.poll();
            
            if(cur.x == itemX && cur.y == itemY){
                minDis = cur.cnt/2;
                break;
            }
            
            for(int d=0; d<4; d++){
                int moveX = cur.x + dx[d];
                int moveY = cur.y + dy[d];
                
                if(isPossible(moveX, moveY)){
                    if(map[moveX][moveY]==1 && !visit[moveX][moveY]){
                        visit[moveX][moveY]= true;
                        q.offer(new Loc(moveX, moveY, cur.cnt+1));
                    }
                }
            }
        }
    }
    
    static boolean isPossible(int x, int y){
        if(x<0 || y<0 || x>100 || y>100) return false;
        return true;
    }
    
}