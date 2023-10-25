package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        /*
        1: 게임 시작
        2: 종료
         */
        String insertCoin = "1";

        while (insertCoin.equals("1")) {
            User player = new User();
            Computer computer = new Computer();

            startNewGame(player, computer);
            insertCoin = Console.readLine();
        }
        System.out.println("게임을 종료합니다.");
    }

    public static void startNewGame(User player, Computer comp) {
        greetings();
        comp.generateNumber();
        while (true) {
            List<Integer> inputNum = player.enterNumber();
            comp.count(inputNum);
            comp.result();

            if (comp.isCorrect()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }
        }
    }

    private static void greetings() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
