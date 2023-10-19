package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    static final String BALL_MESSAGE = "볼";
    static final String STRIKE_MESSAGE = "스트라이크";
    static final String NOTHING_MESSAGE = "낫싱";
    static final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String GET_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printStart();

    }
    public static void printStart() {
        System.out.println(START_MESSAGE);
    }
    public static List<Integer> getComputerNumbersList() {
        List<Integer> computerNumbersList = new ArrayList<>();
        while (computerNumbersList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbersList.contains(randomNumber)) {
                computerNumbersList.add(randomNumber);
            }
        }
        return computerNumbersList;
    }

}
