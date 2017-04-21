import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Evan on 4/19/2017.
 */
public class MazeGrid {

    private MazeSquare[][] theGrid;
    private MazeSquare activeSquare;
    private MazeSquare lastDeadEnd;
    private MazeSquare startSquare;
    private int height;
    private int width;
    private ArrayList<Integer> directions;

    Random rand = new Random();

    public MazeGrid(int width, int height){

        directions = new ArrayList<>();
        directions.add(0);
        directions.add(1);
        directions.add(2);
        directions.add(3);

        theGrid = new MazeSquare[width][height];

        this.width = width;
        this.height = height;

        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {

                theGrid[i][j] = new MazeSquare(i,j);
            }
        }
        int y = rand.nextInt(height);
        while (y % 2 == 0) {
            y = rand.nextInt(height);
        }

        int x = rand.nextInt(width);
        while (x % 2 == 0) {
            x = rand.nextInt(width);
        }
        startSquare = theGrid[x][y];

    }

    public MazeSquare getActiveSquare() {
        return activeSquare;
    }

    public void setActiveSquare(MazeSquare activeSquare) {
        this.activeSquare = activeSquare;
    }

    public MazeSquare getStartSquare() {
        return startSquare;
    }

    public void setStartSquare(MazeSquare startSquare) {
        this.startSquare = startSquare;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void generate(MazeSquare curSq){
        Collections.shuffle(directions);                                                //randomize direction order
        curSq.setSolid(false);                                                          //dig current square
        for (int i : directions){
            if (i == 0) {                                                               //move right
                if (curSq.getCoX() < (width - 2)) {                                     //check proximity to border
                    if (theGrid[curSq.getCoX() + 2][curSq.getCoY()].isSolid()) {        //check if position open
                        theGrid[curSq.getCoX() + 1][curSq.getCoY()].setSolid(false);    //dig path
                        generate(theGrid[curSq.getCoX() + 2][curSq.getCoY()]);          //recursive call

                    }
                }
            }
            if (i == 1) {                                                               //move down
                if (curSq.getCoY() < (height - 2)) {                                    //check proximity to border
                    if (theGrid[curSq.getCoX()][curSq.getCoY() + 2].isSolid()) {        //check if position open
                        theGrid[curSq.getCoX()][curSq.getCoY() + 1].setSolid(false);    //dig path
                        generate(theGrid[curSq.getCoX()][curSq.getCoY() + 2]);          //recursive call

                    }
                }
            }
            if (i == 2) {                                                               //move left
                if (curSq.getCoX() > 1) {                                               //check proximity to border
                    if (theGrid[curSq.getCoX() - 2][curSq.getCoY()].isSolid()) {        //check if position open
                        theGrid[curSq.getCoX() - 1][curSq.getCoY()].setSolid(false);    //dig path
                        generate(theGrid[curSq.getCoX() - 2][curSq.getCoY()]);          //recursive call

                    }
                }
            }
            if (i == 3) {                                                               //move up
                if (curSq.getCoY() > 1) {                                               //check proximity to border
                    if (theGrid[curSq.getCoX()][curSq.getCoY() - 2].isSolid()) {        //check if position open
                        theGrid[curSq.getCoX()][curSq.getCoY() - 1].setSolid(false);    //dig path
                        generate(theGrid[curSq.getCoX()][curSq.getCoY() - 2]);          //recursive call

                    }
                }
            }

        }



    }

    public void printGrid(){

        for (int i = 0; i < getHeight(); i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < getWidth(); j++) {

                if (theGrid[j][i].isSolid()){
                    sb.append("O");
                }
                else{
                    sb.append("X");
                }

            }
            System.out.println(sb);

        }


    }





}
