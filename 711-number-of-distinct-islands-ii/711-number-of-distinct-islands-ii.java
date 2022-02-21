class Solution {
    
    private final int[] dir = {-1, 0, 1, 0, -1};
    private final int[][] refl = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public int numDistinctIslands2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        Set<String> set = new HashSet<>();

        List<Point> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) bfs(grid, i, j, list);
                if (list.size() > 0) {
                    set.add(norm(list));
                    list.clear();
                }
            }
        }
        return set.size();
    }
    
    private void bfs(int[][] grid, int row, int col, List<Point> list) {
        Queue<Point> queue = new ArrayDeque<>();
        Point start = new Point(row, col);
        queue.add(start);
        list.add(start);
        grid[row][col] = 2;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r = p.x + dir[i], c = p.y + dir[i+1];
                if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) continue;
                grid[r][c] = 2;
                Point next = new Point(r, c);
                list.add(next);
                queue.add(next);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
	private String norm(List<Point> list) {
        List<Point>[] comb = new List[8];
        
        for (int i = 0; i < 4; i++) {
            comb[i] = new ArrayList<Point>();
            comb[i+4] = new ArrayList<Point>();
            for (Point p : list) {
                comb[i].add(new Point(p.x * refl[i][0], p.y * refl[i][1]));
                comb[i+4].add(new Point(p.y * refl[i][1], p.x * refl[i][0]));
            }
        }
        
        for (int i = 0; i < 8; i++) {
        	Collections.sort(comb[i]);
        }
        String[] s = new String[8];
        for (int i = 0; i < 8; i++) {
           	StringBuilder sb = new StringBuilder();
            int x0 = comb[i].get(0).x, y0 = comb[i].get(0).y;
        	for (Point p : comb[i]) {
        		sb.append(p.x - x0);
                sb.append(',');
                sb.append(p.y - y0);
                sb.append('!');
        	}
        	s[i] = sb.toString();
        }
        Arrays.sort(s);
        return s[0];
    }
    
    public static class Point implements Comparable<Point> {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point p) {
            return this.x - p.x == 0 ? this.y - p.y : this.x - p.x;
        }
    }
}