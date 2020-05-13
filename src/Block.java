public class Block {
    private int row;
    private int column;

    public Block(int row,int column) {
        this.row=row;
        this.column=column;
    }
    public Boolean goRight(int[][] maze) {
        if(maze[2*row][2*column+1]==0) {
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean goLeft(int[][] maze) {
        if(maze[2*row][2*column-1]==0) {
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean goUp(int[][] maze) {
        if(maze[2*row-1][2*column]==0) {
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean goDown(int[][] maze) {
        if(maze[2*row+1][2*column]==0) {
            return true;
        }
        else {
            return false;
        }
    }
}
