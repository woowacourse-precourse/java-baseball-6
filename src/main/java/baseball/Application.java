package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computerNumbers = new ArrayList<>();
    static List<Integer> playerNumbers = new ArrayList<>();
    static boolean isThreeStrike;

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
            playerNumbers.add(input.charAt(i) - '0');
        }
    }

    public void isValidCheck(String input) {
        if (isNull(input) || input.isEmpty() || !isLengthThree(input) || !hasUniqueElementsOnly(input)) {
            throw new IllegalArgumentException("Invalid input: Input must be numbers between 1 and 9 only.");
        }

        for (int i = 0; i < 3; i++) {
            if (!isNumberInRange(input.charAt(i) - '0', 1, 9)) {
               throw new IllegalArgumentException("Invalid input: Input must be numbers between 1 and 9 only.");
            }
        }
    }

    public boolean isNull(String string) {
        return string == null;
    }

    public boolean isLengthThree(String string) {
        return string.length() == 3;
    }

    public boolean hasUniqueElementsOnly(String string) {
        char target1 = string.charAt(0);
        char target2 = string.charAt(1);
        char target3 = string.charAt(2);

        if (target1 != target2 && target1 != target3 && target2 != target3) {
            return true;
        }
         return false;
    }

    public boolean isNumberInRange(int number, int start, int end) {
        return number >= start && number <= end;
    }
}
