package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTING = "낫싱";

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            playGame(computerPickNumber());

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputRestart = Console.readLine();

            validateInputRestart(inputRestart);

            if (inputRestart.equals("2")) {
                break;
            }
        }
    }

    private static List<Integer> computerPickNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }


    private static void playGame(List<Integer> computer) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = Console.readLine();

            validateInputNumber(inputString);

            List<Integer> input = new ArrayList<>();
            for (int i = 0; i < inputString.length(); i++) {
                int number = (int) inputString.charAt(i) - '0';
                input.add(number);
            }

            String hint = "";
            int ballCnt = 0;
            int strikeCnt = 0;
            int nothingCnt = 0;

            for (int i = 0; i < 3; i++) {
                if (computer.get(i).equals(input.get(i))) {
                    strikeCnt++;
                } else if (computer.contains(input.get(i))) {
                    ballCnt++;
                } else {
                    nothingCnt++;
                }
            }

            if (nothingCnt == 3) {
                hint = NOTING;
                System.out.println(hint);
                continue;
            }

            if (ballCnt > 0) {
                hint = ballCnt + BALL;
            }

            if (strikeCnt > 0) {
                if (ballCnt > 0) {
                    hint += " ";
                }
                hint += strikeCnt + STRIKE;
            }
            System.out.println(hint);

            if (hint.equals("3" + STRIKE)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static void validateInputNumber(String number) {
        if (!number.matches("^[1-9]+$")) {
            throw new IllegalArgumentException("숫자로 입력되어야 합니다.");
        }
        if (number.length() != 3) {
            throw new IllegalArgumentException("3자리로 입력되어야 합니다.");
        }

        for (int index1 = 0; index1 < 3; index1++) {
            for (int index2 = 0; index2 < 3; index2++) {
                if (index1 != index2) {
                    if (number.charAt(index1) == number.charAt(index2)) {
                        throw new IllegalArgumentException("서로 다른 숫자가 와야 합니다.");
                    }
                }
            }
        }
    }

    private static void validateInputRestart(String number) {
        if (!number.matches("^[1-2]+$")) {
            throw new IllegalArgumentException("1 또는 2의 숫자로 입력되어야 합니다.");
        }
        if (number.length() != 1) {
            throw new IllegalArgumentException("1자리로 입력되어야 합니다.");
        }
    }
}
