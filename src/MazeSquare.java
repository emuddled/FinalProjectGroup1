
/**
 * Created by Evan on 4/19/2017.
 */
public class MazeSquare {

    private int coX;
    private int coY;
    private boolean solid;
    private boolean hidden;



    public MazeSquare(int x, int y){
        coX = x;
        coY = y;
        solid = true;
        hidden = true;


    }

    public int getCoX() {
        return coX;
    }

    public void setCoX(int coX) {
        this.coX = coX;
    }

    public int getCoY() {
        return coY;
    }

    public void setCoY(int coY) {
        this.coY = coY;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
