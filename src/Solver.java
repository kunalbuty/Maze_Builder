import java.util.Random;

public class Solver {
    public static void Kunal(int[][] maze,int minHeight,int maxHeight,int minWidth,int maxWidth) {      //assumes walls are down
        //check if max-min=1 (could be 3) and break if true
        if(maxHeight-minHeight<4 || maxWidth-minWidth<4) {
            return;     //break if corridor is of length/width 1
        }
        Random rand = new Random();

        int arrWidth=maxWidth-minWidth;
        int arrHeight=maxHeight-minHeight;
        System.out.println("minHeight=" + minHeight + ", maxHeight=" + maxHeight + ", minWidth=" + minWidth + ", MaxWidth=" + maxWidth);

        //choose horizontal or vertical
        int n = rand.nextInt(2);
        if(n==1) {      //if n==0, draw horizontal line;
            int wallLocation=minHeight+rand.nextInt((arrHeight-2)/2)*2+2;     //choose random line to build horizontal walls
            System.out.println("H wall is:" + wallLocation);

            for(int i=minWidth+1;i<maxWidth+1;i++) {
                maze[wallLocation][i]=1;
            }
            int door=minWidth+rand.nextInt((maxWidth-minWidth)/2-1)*2+1;
            maze[wallLocation][door]=0;
            if((arrHeight-2)/2>1) {
                Kunal(maze, minHeight, wallLocation, minWidth, maxWidth);
                Kunal(maze, wallLocation, maxHeight, minWidth, maxWidth);
            }
            else {
                Kunal(maze, minHeight, wallLocation, minWidth, maxWidth);
            }
        }
        else {
            int wallLocation=minWidth+rand.nextInt((arrWidth-2)/2)*2+2;     //choose random line to build horizontal walls
            System.out.println("V wall is:" + wallLocation);

            for(int i=minHeight+1;i<maxHeight+1;i++) {
                maze[i][wallLocation]=1;
            }
            int door=minHeight+rand.nextInt((maxHeight-minHeight)/2-1)*2+1;
            maze[door][wallLocation]=0;
            if((arrWidth-2)/2>1) {

                Kunal(maze, minHeight, maxHeight, minWidth, wallLocation);
                Kunal(maze, minHeight, maxHeight, wallLocation, maxWidth);
            }
            else {
                Kunal(maze, minHeight, maxHeight, minWidth, wallLocation);
            }
        }
    }
}
