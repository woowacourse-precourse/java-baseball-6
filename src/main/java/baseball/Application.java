package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String STRING_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private static final int MIN_PICK_NUMBER = 1;
    private static final int MAX_PICK_NUMBER = 9;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printStartMessage();

        BaseBallNumberGroup computer = new BaseBallNumberGroup(getRandomNumberList());
    }

    public static void printStartMessage() {
        System.out.println(STRING_START_MESSAGE);
    }

    public static List<Integer> getRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < BaseBallNumberGroup.SIZE_RANDOM_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }
}
