package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameStart();
    }

    private static void gameStart() {
        String computer = generateRandomNumber();
    }

    private static String generateRandomNumber() {
        String computer = "";
        while (computer.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(Integer.toString(randomNumber))) computer += randomNumber;
        }
        return computer;
    }
}
