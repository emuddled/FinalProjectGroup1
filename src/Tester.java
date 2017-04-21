/**
 * Created by Evan on 4/21/2017.
 */
public class Tester {
    public static void main(String[] args){
        MazeGrid test = new MazeGrid(21,21);

        test.generate(test.getStartSquare());

        test.printGrid();
    }
}
