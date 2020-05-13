import javafx.scene.shape.Line;

public class Wall {
    private int[] start;
    private int[] end;
    private Line line;
    //private char type;
    public Wall(int startX, int startY, int endX, int endY) {
        start=new int[2];
        end=new int[2];
        start[0]=startX;
        start[1]=startY;
        end[0]=endX;
        end[1]=endY;
        line=new Line(startX,startY,endX,endY);
    }
    public Line getLine() {
        return line;
    }
}
