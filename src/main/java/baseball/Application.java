package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isGame = true;
        while (isGame) {
            Judge judge = new Judge();

            int[] userNumber;
            String gameResult;

            do {
                System.out.print("숫자를 입력해주세요 : ");

                String inputNum = Console.readLine();
                userNumber = judge.createUserNumber(inputNum);
                gameResult = judge.playGame(userNumber);
                System.out.println(gameResult);
            } while (!judge.isGameEnd(gameResult));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                    + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String isNum = Console.readLine();
            isGame = Integer.parseInt(isNum) == 1;
        }
    }
}
