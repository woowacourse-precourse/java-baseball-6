package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        getRandomsNumber(computer);
        System.out.println(computer);
    }

    private static void getRandomsNumber(List<Integer> computer) {
        while (computer.size() < Constant.NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(Constant.START_NUM, Constant.END_NUM);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    static class Constant {
        public static final int START_NUM = 1;
        public static final int END_NUM = 9;
        public static final int GAME_RESTART = 1;
        public static final int GAME_END = 2;
        public static final int NUMBER_COUNT = 3;
        public static final String BALL = "볼";
        public static final String STRIKE = "스트라이크";
        public static final String NOTHING = "낫싱";
        public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
        public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
        public static final String SUCCESS_MESSAGE = Constant.NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        public static final String END_MESSAGE = "게임을 새로 시작하려면 " + Constant.GAME_RESTART + ", 종료하려면 " + Constant.GAME_END + "를 입력하세요.";
    }
}
