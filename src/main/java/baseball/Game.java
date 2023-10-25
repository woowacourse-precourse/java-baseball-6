package baseball;

import java.util.List;

public class Game {

    private Initializer initializer = new Initializer();

    public void start(){

        List<Integer> comNum = initializer.setCom();
        List<Integer> userNum = initializer.setUser();
        System.out.println(comNum);
        System.out.println(userNum);
    }
}
