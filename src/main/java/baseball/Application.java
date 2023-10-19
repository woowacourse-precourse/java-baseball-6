package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private final static int MIN_RANDOM_NUMBER = 1;
    private final static int MAX_RANDOM_NUMBER = 9;
    private final static int COMPUTER_NUM_SIZE = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String flag;
        do {
            startGame();
            flag = askReplayOrExit();
        }while (flag.equals("1"));  // 1을 입력하면 게임 새로 시작
    }

    private static void startGame() {
        // 숫자 야구 게임 시작

        // 사용자에게 입력 받기

        // 입력받은 숫자에 대한 결과 출력

        // 사용자가 3개의 숫자를 모두 맞힌 경우 게임 종료

    }

    private static List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COMPUTER_NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static String askReplayOrExit() {
        // 사용자에게 숫자를 입력받아 return

        // 1과 2가 아닌 다른 수를 입력할 경우 애플리케이션은 종료

        return null;
    }
}