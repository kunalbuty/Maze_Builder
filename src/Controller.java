import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

import java.awt.*;

public class Controller extends GridPane {
    @FXML
    private Pane test;
    public void solve() {
        System.out.println("Button Clicked!!");
        Maze m=new Maze(10,10);
        m.wallsDown();
        m.printMaze();
        int[][] maze=m.getMazeArr();
        Solver.Kunal(maze,0,maze.length-1,0,maze[0].length-1);
        maze[0][1]=0;
        maze[maze.length-2][maze[0].length-1]=0;
        drawMaze(maze);
        m.printMaze();

    }

    public void drawMaze(int[][] maze) {


        //test.getChildren().removeAll();
        double width=test.getHeight();
        int lineLength=(int) (width-40)/((maze[0].length-1)/4);     //need to adjust size of maze according to width/height
        int startXVert = 20;
        int startXHor=20;
        int startYVert=20;
        int startYHor=20;
        int endXVert,endYVert,endXHor,endYHor;

        for(int i=1;i<maze.length;i=i+2) {
            for(int j=1;j<maze[0].length;j=j+2) {

                endYVert=startYVert+lineLength;
                endXVert=startXVert;


                if(maze[i][j-1]==1) {       //draw left wall
                    Line line=new Line(startXVert,startYVert,endXVert,endYVert);
                    line.setStrokeWidth(5);
                    line.setStroke(Paint.valueOf("#576490"));
                    test.getChildren().add(line);
                }
                startXVert+=lineLength;

                endXHor=startXHor+lineLength;
                endYHor=startYHor;

                if(maze[i-1][j]==1) {       //draw top wall
                    Line line=new Line(startXHor,startYHor,endXHor,endYHor);
                    line.setStrokeWidth(5);
                    line.setStroke(Paint.valueOf("#576490"));
                    test.getChildren().add(line);
                }
                startXHor+=lineLength;
            }
            startYHor+=lineLength;
            startXHor=20;

            startXVert=20;
            startYVert+=lineLength;
        }
        for(int i=1;i<maze[0].length-1;i=i+2) {            //draw right border
            if(maze[maze[0].length-1][i]==1) {
                Line line = new Line(20 + i / 2 * lineLength, 20 + maze.length / 2 * lineLength, 20 + (i / 2 + 1) * lineLength, 20 + maze.length / 2 * lineLength);
                line.setStrokeWidth(5);
                line.setStroke(Paint.valueOf("#576490"));
                test.getChildren().add(line);
            }
        }
        for(int i=0;i<maze.length-1;i++) {                 //draw bottom border
            Line line=new Line(20+maze[0].length/2*lineLength,20+i/2*lineLength,20+maze[0].length/2*lineLength,20+(i/2+1)*lineLength);
            line.setStrokeWidth(5);
            line.setStroke(Paint.valueOf("#576490"));
            test.getChildren().add(line);
        }
    }
}
