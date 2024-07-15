import java.util.*;

class Solution {
    // 최대 양의 수를 저장할 변수
    private static int maxSheepCount;
    // 그래프를 저장할 배열
    private static List<Integer>[] GRAPH;

    public int solution(int[] info, int[][] edges) {
        // 최대 양의 수 초기화
        maxSheepCount = 0;
        // 그래프 초기화
        GRAPH = new ArrayList[info.length];

        // 각 노드의 연결 리스트 초기화
        for (int i = 0; i < info.length; i++) {
            GRAPH[i] = new ArrayList<>();
        }

        // 간선 정보를 바탕으로 그래프 생성
        for (int[] edge : edges) {
            GRAPH[edge[0]].add(edge[1]);
        }

        // 시작 노드 설정
        List<Integer> path = new LinkedList<>();
        path.add(0);

        // DFS 탐색 시작
        dfs(info, path, 0, 0, 0);

        // 최대 양의 수 반환
        return maxSheepCount;
    }

    // DFS 메소드
    private void dfs(int[] info, List<Integer> path, int currentNodeIdx, int sheepCount, int wolfCount) {
        // 현재 노드가 양이면 양의 수 증가, 늑대면 늑대 수 증가
        if (info[currentNodeIdx] == 0) {
            sheepCount += 1;
        } else {
            wolfCount += 1;
        }

        // 양의 수가 늑대 수보다 작거나 같으면 더 이상 탐색하지 않음
        if (sheepCount <= wolfCount) {
            return;
        }

        // 최대 양의 수 갱신
        maxSheepCount = Math.max(maxSheepCount, sheepCount);

        // 다음 탐색할 노드 리스트를 복사
        List<Integer> copyPath = new ArrayList<>(path);

        // 현재 노드의 자식 노드를 추가
        if (!GRAPH[currentNodeIdx].isEmpty()) {
            copyPath.addAll(GRAPH[currentNodeIdx]);
        }
        // 현재 노드를 다음 탐색할 리스트에서 제거
        copyPath.remove(Integer.valueOf(currentNodeIdx));

        // 다음 탐색할 노드들에 대해 DFS 수행
        for (int nextIdx: copyPath) {
            dfs(info, copyPath, nextIdx, sheepCount, wolfCount);
        }
    }
}
