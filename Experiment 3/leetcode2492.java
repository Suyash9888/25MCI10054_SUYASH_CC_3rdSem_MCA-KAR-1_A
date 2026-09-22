class Solution {
    public int minScore(int n, int[][] roads) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int distance = road[2];

            graph.get(u).add(new int[]{v, distance});
            graph.get(v).add(new int[]{u, distance});
        }

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int[] edge : graph.get(current)) {

                int nextCity = edge[0];
                int distance = edge[1];

                answer = Math.min(answer, distance);

                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }

        return answer;
    }
}