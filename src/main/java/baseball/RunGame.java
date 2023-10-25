package baseball;


import java.util.ArrayList;
import java.util.List;

public class RunGame {

    public void StartGame() {
        List<Integer> numbers = new ArrayList<>();


        System.out.println("숫자 야구 게임을 시작합니다.");

        IdentifyNumber identifyNumber = new IdentifyNumber();
        identifyNumber.PlayGame();

    }

}
