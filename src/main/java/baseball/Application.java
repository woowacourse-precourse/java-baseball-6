package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computerNumbers = new ArrayList<>();
    static List<Integer> playerNumbers = new ArrayList<>();
    static boolean isThreeStrike = false;

    public static void main(String[] args) {
        boolean isFinishGame = false;
        Application application = new Application();

        application.printGameStartText();

        while(!isFinishGame) {
            application.setComputerNumber();
            while(!isThreeStrike) {
                application.inputPlayerNumber();
            }
        }
    }

    public void printGameStartText() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void setComputerNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public void inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        isValidCheck(input);

        for (int i = 0; i < 3; i++) {
            playerNumbers.add(input.charAt(i)- '0');
        }
    }

    public void isValidCheck(String input) {
        if (isNull(input) || input.isEmpty() || !isLengthThree(input)
            // Todo: 입력값에 숫자외에 다른 문자가 들어가 있는지 검사한다.
            // Todo: 각 숫자(n)가 `1 <= n <= 9`의 범위에 속하는 정수인지 검사한다.
            // Todo: 각 숫자가 서로 다른 수인지 검사한다.
        ) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isNull(String string) {
        return string == null;
    }

    public boolean isLengthThree(String string) {
        return string.length() == 3;
    }
}
