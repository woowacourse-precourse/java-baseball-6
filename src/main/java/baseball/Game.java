package baseball;

import baseball.player.Opponent;
import baseball.player.User;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private Opponent opponent;
    private User user;
    private Score score;

    public Game(Opponent opponent, User user, Score score) {
        this.opponent = opponent;
        this.user = user;
        this.score = score;
    }

    public void newGame() throws IllegalArgumentException{
        while(true){
            // empty each lists instead of creating new object on new game
            user.emptyList();
            opponent.emptyList();
            play();

            // below process start upon user's win
            System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int endInput = Integer.parseInt(Console.readLine());

            // end loop on input number 2
            if (endInput == 2) {
                break;
            }
            // wrong input exception
            if (endInput != 1 && endInput != 2) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void play() {
        while (true) {

            user.setNumberList();
            opponent.setNumberList();
            score.setScore(user, opponent);

            int ballCounter = score.getBallCounter();
            int strikeCounter = score.getStrikeCounter();

            if (ballCounter > 0){
                System.out.print(ballCounter + "볼 ");
            }
            if (strikeCounter > 0) {
                System.out.print(strikeCounter + "스트라이크 ");
            }

            // end loop at win condition
            if (score.isOver()) {
                break;
            }
            if (ballCounter == 0 && strikeCounter == 0) {
                System.out.print("낫싱");
            }
        }
    }
}
