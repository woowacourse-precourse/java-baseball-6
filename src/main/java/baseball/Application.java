package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    public void gameStart() {
        printGameStartMessage();
        extractRandomNumber();
    }

    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private static void extractRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
