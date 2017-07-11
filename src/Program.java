import game.GameWindow;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {

        double width = 5;
        int center = (int)(width / 2);

        int x = 5;
        double y = x;

        System.out.println(center);

        GameWindow gameWindow = new GameWindow();
        gameWindow.loop();


    }
}
