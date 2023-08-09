import mazesolver.*;

public class Test {
    public static void main(String[] args) {
        String[] maze = {
            "xxxxxxxxxxx xxx",
            "x xxxxxxxxx x x",
            "x           x x",
            "x xxxxx xxx x x",
            "x    xx xxx x x",
            "x xxxxxxxxx   x",
            "x xxxxxxxxxxxxx",
        };

        int[] start = {11, 0};
        int[] end = {1, 6};
        char wall = 'x';
        new MazeSolver(maze, wall, start, end);
    }
}
