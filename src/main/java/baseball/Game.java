package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    public static void runGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer.createRandomNumber();
        Player.input();
    }
}
