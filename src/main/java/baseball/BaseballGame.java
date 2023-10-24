package baseball;

import java.util.List;

class BaseballGame {
    private static final int NUMBER_OF_DIGITS = 3; // 숫자 자릿수 초기화
    private final Computer computer;
    private final Player player;
    private final CheckScore checkScore;

    public BaseballGame() {
        // 인스턴스 초기화
        this.computer = new Computer(NUMBER_OF_DIGITS);
        this.player = new Player();
        this.checkScore = new CheckScore(NUMBER_OF_DIGITS);
    }

    // 야구 게임 진행
    public void play() {
        List<Integer> computerNumbers = computer.generateNumbers();

        // player가 all strike할 때까지 반복
        while (true) {
            List<Integer> playerNumbers = player.getInput();
            int strike = checkScore.countStrike(computerNumbers, playerNumbers);
            int ball = checkScore.countBall(computerNumbers, playerNumbers);

            if (checkScore.isGameWon(strike)) {
                player.win(strike); // all strike인 경우 승리 문구 출력
                break;
            } else {
                player.showResult(strike, ball); // all strike가 아닌 경우 결과 출력
            }
        }
    }
    public boolean choiceRestart() {
        return player.choiceRestart();
    }
}
