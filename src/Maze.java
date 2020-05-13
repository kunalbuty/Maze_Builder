public class Maze {
    private int[][] maze;
    private int height;
    private int width;
    public Maze(int h,int w) {
        height=h*2+1;
        width=w*2+1;
        maze=new int[height][width];
        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                maze[i][j]=0;
            }
        }
    }
    public void wallsUp() {
        for(int i=0;i<height;i++) {
            for(int j = 0; j < width; j++) {
               if(i==0 || j==0 || i==height-1 || j==width-1) {
                   maze[i][j]=1;//set borders as 1
               }
               else {
                   if(i%2==0) {
                       maze[i][j]=1;
                   }
                   else {
                       if(j%2==0) {
                           maze[i][j]=1;
                       }
                   }
               }
            }
        }
    }

    public void wallsDown() {
        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                if(i==0 || j==0 || i==height-1 || j==width-1) {
                    maze[i][j]=1;//set borders as 1
                }
                else {
                    maze[i][j] = 0;
                }
            }
        }
    }
    
    public void printMaze() {
        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                System.out.print(maze[i][j] + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }

    public int[][] getMazeArr() {
        return maze;
    }
}
