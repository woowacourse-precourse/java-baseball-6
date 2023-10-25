package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static List<Integer> computer = new ArrayList<>();

    public static void main(String[] args) {
        init();
        playGame();
    }

    public static void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void giveRandomNumber() {
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void reGame() {
        try {
            String userInput = Console.readLine();
            if (userInput.equals("1")) {
                playGame();
            } else if (userInput.equals("2")) {
                System.out.println("게임을 완전히 종료합니다!");
                return;
            } else {
                throw new IllegalArgumentException("입력값을 올바르게 입력해주세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("예외가 발생했습니다: " + e.getMessage());
            reGame();
        }
    }

    public static void playGame() {
        giveRandomNumber();
        while (true) {
            Integer Ball = 0;
            Integer Strike = 0;
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            List<Integer> userNumber = new ArrayList<>();
            for (char digitChar : userInput.toCharArray()) {
                userNumber.add(Character.getNumericValue(digitChar));
                if (userInput.length() != 3 || (digitChar<'0'||digitChar>'9')) {
                    throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
                }
            }


            for (int i = 0; i < 3; i++) {
                if (userNumber.contains(computer.get(i))) {
                    if (computer.get(i).equals(userNumber.get(i))) {
                        Strike++;
                    } else {
                        Ball++;
                    }
                }
            }
            if (Strike == 3) {
                System.out.println(Strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                reGame();
                break;
            } else if (Strike == 0 && Ball == 0) {
                System.out.println("낫싱");
            } else if (Strike == 0) {
                System.out.println(Ball + "볼 ");
            } else if (Ball == 0) {
                System.out.println(Strike + "스트라이크");
            } else {
                System.out.print(Ball + "볼 ");
                System.out.println(Strike + "스트라이크");
            }
        }
    }
}
