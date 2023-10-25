package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballDealer dealer = new BaseballDealer();
        boolean continueGame = true;
        while (continueGame) {
            dealer.runGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String runAgain = Console.readLine();
            if (runAgain.equals("2")) {
                continueGame = false;
            } else if (!runAgain.equals("1")) {
                throw new IllegalArgumentException();
            }
        }
    }
}
