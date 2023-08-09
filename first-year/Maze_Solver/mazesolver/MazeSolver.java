package mazesolver;

import java.util.Stack;
import java.util.Arrays;

public class MazeSolver {
    public static final Point dir[] = {
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1),
    };

    String[] maze;
    char wall;
    Point start;
    Point end;
    boolean[][] seen;
    Stack<Point> path;

    public MazeSolver(String[] maze, char wall, int[] startCoords, int[] endCoords) {
        this.maze = maze;
        this.wall = wall;
        this.start = new Point(startCoords[0], startCoords[1]);
        this.end = new Point(endCoords[0], endCoords[1]);

        this.path = new Stack<Point>();
        this.seen = new boolean[maze.length][maze[0].length()];

        for (int i = 0; i < maze.length; ++i) {
            Arrays.fill(this.seen[i], false);
        }

        this.solveMaze(this.maze, this.wall, this.start, this.end, this.seen, this.path);
        this.displaySolvedMaze(this.maze, this.path);
    }

    private boolean solveMaze(String[] maze, char wall, Point curr, Point end, boolean[][] seen, Stack<Point> path) {
        if (curr.x < 0 || curr.x >= maze[0].length() || curr.y < 0 || curr.y >= maze.length) {
            return false;
        }

        if (maze[curr.y].charAt(curr.x) == wall) {
            return false;
        }

        if (curr.x == end.x && curr.y == end.y) {
            path.push(end);
            return true;
        }

        if (seen[curr.y][curr.x]) {
            return false;
        }

        seen[curr.y][curr.x] = true;
        path.push(curr);

        for (int i = 0; i < dir.length; ++i) {
            if (solveMaze(maze, wall, new Point(curr.x + dir[i].x, curr.y + dir[i].y), end, seen, path)) {
                return true;
            }
        }

        path.pop();
        return false;
    }

    private void displaySolvedMaze(String[] maze, Stack<Point> path) {
        String[] solvedMaze = maze.clone();

        for (Point i : path) {
            StringBuilder strb = new StringBuilder(solvedMaze[i.y]);
            strb.replace(i.x, i.x + 1, "*");
            solvedMaze[i.y] = strb.toString();
        }

        System.out.println(String.join("\n", solvedMaze));
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
