package baseballGame;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

import static constant.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Game {
    List<Integer> answer = new ArrayList<>(); // 실제 정답

    public Game() {
        for (int i = 0; i < 3; i++) {
            int randomNumber;
            do {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            } while (answer.contains(randomNumber));
            answer.add(randomNumber);
        }
    }
    public static void run(){
        Game game; // game 객체 생성
    }


}


