package baseball;

public class NumberGame {
    private int restart;

    public NumberGame() {
        System.out.println("숫자 야구를 시작합니다.");
        GamePlay();
    }

    public void GamePlay(){
        GameNumber number = new GameNumber();

        String computerNumber = number.getComputerNumber();
        String userNumber = number.getUserNumber();

        System.out.println(computerNumber);
        System.out.println(userNumber);

        GameScore score = new GameScore();
        score.updateScore(computerNumber, userNumber);
        ShowScore(score);
        while (score.getStrike() != 3) {
            number.inputUserNumber();
            userNumber = number.getUserNumber();
            score.updateScore(computerNumber, userNumber);
            ShowScore(score);
        }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }
    public void ShowScore(GameScore score) {

        if(score.getBall() == 0)
            System.out.printf("%d스트라이크 \n", score.getStrike());
        else if (score.getStrike() == 0)
            System.out.printf("%d볼 \n", score.getBall());
        else {
            System.out.printf("%d볼 %d스트라이크 \n", score.getBall(), score.getStrike());
        }
    }
}
