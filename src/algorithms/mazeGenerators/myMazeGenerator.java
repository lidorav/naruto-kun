package algorithms.mazeGenerators;

import java.util.Arrays;

public class myMazeGenerator extends AMazeGenerator {

    public myMazeGenerator() {
    }

    public Maze generate(int height, int width)
        {
            int[][] maze = new int[height][width];
            boolean[][] visited = new boolean[height][width];
            for (boolean[] row: visited)
                Arrays.fill(row,false);

            // fill maze with walls.
            for (int i = 0; i < height; i++) {
                {
                    for (int j = 0; j < width; j++) {
                        if (i % 2 == 0 || j % 2 == 0) maze[i][j] = 1;
                    }
                }
            }

            // place exit and entrance.
            int endI = (((int) ((height - 1)*Math.random()))/2)*2 + 1;
            int startI = (((int) ((height - 1)*Math.random()))/2)*2 + 1;
            Position startPos = new Position (endI,0);
            maze[endI][0] = 0;
            Position endPos = new Position (startI,width-1);
            maze[startI][width - 1] = 0;
            // call carving function to carve maze itself.
            carve(endI, 1, maze, visited);

            return new Maze(maze,startPos,endPos);
        }

        // recursive function, uses depth first search to carve out a perfect maze.
        // (perfect = every square part of maze, one and only one path between any
        // two spaces in the maze).
        public static void carve(int currentI, int currentJ, int[][] maze,
                                 boolean[][] visited)
        {
            // mark current cell as visited.
            visited[currentI][currentJ] = true;

            // fetch a random ordering of the cardinal directions.
            int[][] directions = randomDirections();

            // call itself recursively in the four compass directions, in the order
            // determined above.
            for (int i = 0; i < 4; i++)
            {
                int newI = currentI + 2*directions[i][0];
                int newJ = currentJ + 2*directions[i][1];
                // ensure target square is in maze and unvisited.
                if (newI < 1 || newI >= maze.length - 1 || newJ < 1
                        || newJ >= maze[0].length - 1) continue;
                if (visited[newI][newJ] == true) continue;

                // remove the wall between current square and target square, and
                // then move to target square.
                maze[currentI + directions[i][0]][currentJ + directions[i][1]] = 0;
                carve(newI, newJ, maze, visited);
            }

            return;
        }
        // generates a random ordering of the cardinal directions, in array form.
        public static int[][] randomDirections()
        {
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int a[] = new int[2];
            for (int i = 0; i < 3; i++)
            {
                a = directions[i];
                int random = (int) (Math.random()*(3-i));
                int target = i + random + 1;
                directions[i] = directions[target];
                directions[target] = a;
            }
            return directions;
        }

    public static void main (String[]args){
        IMazeGenerator sMaze = new myMazeGenerator();
        Maze maze = sMaze.generate(10, 8);
        maze.print();
    }
}
