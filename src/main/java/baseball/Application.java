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

        // Todo: input 유효성 검사

        for (int i = 0; i < 3; i++) {
            playerNumbers.add(input.charAt(i)- '0');
        }
    }
}
