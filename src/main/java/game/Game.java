package game;

import camp.nextstep.edu.missionutils.Console;
import validation.IntegerValidation;
import validation.StringValidation;

public class Game {

    private Game() {
    }

    private static void printUserScore(User user) {
        if (user.getBall() > 0) {
            System.out.print(user.getBall() + "볼 ");
        }
        if (user.getStrike() > 0) {
            System.out.print(user.getStrike() + "스트라이크");
        }
        if (user.getSumOfScore() == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    // 숫자를 비교하고 점수를 반영해서 리턴함
    private static User compareNumbersToComputer(User computer, User player) {
        // 숫자 비교
        for (int i = 0; i < Const.NUMBER_COUNT; i++) {
            int numberOfPlayer = player.getNumber().get(i);

            if (numberOfPlayer == computer.getNumber().get(i)) { // 같은 자리에 있으면 Strike
                player.addStrike();
            } else if (computer.getNumber().contains(numberOfPlayer)) { // 다른 자리에 있으면 Ball
                player.addBall();
            }
        }

        return player;
    }

    private static void playGame() {
        User player = new User();
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터 숫자 생성
        User computer = new User();
        computer.setRandomNumber();

        while (player.getStrike() < Const.NUMBER_COUNT) {
            System.out.print("숫자를 입력해주세요 : ");

            player.setNumber(Console.readLine());
            player.resetScore();

            player = compareNumbersToComputer(computer, player);

            printUserScore(player); // player 스코어 출력
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void start() {
        try {
            int continueValue = 1; // 게임 재시작 여부

            while (continueValue == 1) {
                playGame();
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                continueValue = StringValidation.validateInteger(Console.readLine());
                IntegerValidation.validateRange(continueValue, 1, 2);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("조건에 맞는 숫자를 입력해주세요.");
        }
    }
}
