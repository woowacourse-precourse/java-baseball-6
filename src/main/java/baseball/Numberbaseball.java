package baseball;

public class Numberbaseball {
    public Numberbaseball() {
        System.out.println("숫자 야구를 시작합니다.");
        GamePlay();
    }
    public void GamePlay(){
        GameNumber number = new GameNumber();

        String computerNumber = number.getComputerNumber();
        String userNumber = number.getUserNumber();

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
        RestartGame(number.inputRestart());
    }
    public void ShowScore(GameScore score) {
        if(score.getStrike() == 0 && score.getBall() == 0)
            System.out.println("낫싱");
        else if (score.getStrike() == 0)
            System.out.printf("%d볼 \n", score.getBall());
        else if (score.getBall() == 0)
            System.out.printf("%d스트라이크 \n", score.getStrike());
        else
            System.out.printf("%d볼 %d스트라이크 \n", score.getBall(), score.getStrike());
    }
    public void RestartGame(String userInput) {
        if(userInput.equals("1"))
            GamePlay();
        else if(userInput.equals("2"))
            System.out.println("게임 종료");
    }
}
