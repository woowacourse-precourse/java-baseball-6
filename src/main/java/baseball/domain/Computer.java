package baseball.domain;


import baseball.app.Baseball;
import baseball.global.enums.GuideMessage;
import java.util.List;

public class Computer {

    private RandomNumber number;

    public void init() {
        number = new RandomNumber();
        System.out.println(GuideMessage.START_MENU.message);
    }

    public void play() {
        Player player = new Player();
        Baseball baseball = new Baseball();
//        baseball.compare(number);
    }


}
