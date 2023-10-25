package baseball.Interface;

import baseball.game.BaseballGame;
import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    private final BaseballGame baseballGame;

    public UserInterface(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            baseballGame.resetGame(); // 분리해서 더 명확하게 작성할 부분 발견
            startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if (input.equals("2")) {
                break;
            }
            if (!input.equals("1")) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
            }
        }
    }

    // 여기서 객체지향적으로 분리할 부분이 많이 생긴다. 나중에 코드리뷰 하면서 수정해보자
    private void startGame() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            baseballGame.saveInput(input);
            baseballGame.compareNumber();
            baseballGame.printBallHint();
            if (baseballGame.isAnswer()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

}
