package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static String computer = getRandomNumber();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static String getRandomNumber() {
        StringBuilder computer = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int randomNUmber = Randoms.pickNumberInRange(1, 9);
            computer.append(randomNUmber);
        }
        return computer.toString();
    }
}
