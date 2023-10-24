package baseball;

import java.util.List;

class BaseballGame {
    // 숫자 자릿수 초기화
    private static final int NUMBER_OF_DIGITS = 3;

    // 게임의 랜덤 숫자를 생성하기 위한 인스턴스
    private final NumberGenerator numberGenerator;

    // 게임에서의 플레이어를 나타내는 인스턴스
    private final Player player;

    // stike, ball 개수 계산을 위한 인스턴스
    private final CheckScore checkScore;

    // 게임 결과를 표시를 위한 인스턴스
    private final ShowResult showResult;

    // 게임 재시작 또는 종료를 처리하기 위한 인스턴스
    private final GameChoice gameChoice;

    // 모든 게임 컴포넌트를 초기화하는 생성자
    public BaseballGame() {
        // 정의된 숫자 자릿수로 숫자 생성기 초기화
        this.numberGenerator = new NumberGenerator(NUMBER_OF_DIGITS);

        // 정의된 숫자 자릿수로 플레이어 초기화
        this.player = new Player(NUMBER_OF_DIGITS);

        // 정의된 숫자 자릿수로 점수 검사기 초기화
        this.checkScore = new CheckScore(NUMBER_OF_DIGITS);

        // 정의된 숫자 자릿수로 결과 표시기 초기화
        this.showResult = new ShowResult(NUMBER_OF_DIGITS);

        // 정의된 숫자 자릿수로 결과 표시기 초기화
        this.gameChoice = new GameChoice();
    }

    // 야구 게임 진행
    public void play() {
        List<Integer> computerNumbers = numberGenerator.generateNumbers();

        // player가 all strike할 때까지 반복
        int strike;
        int ball;
        do {
            List<Integer> playerNumbers = player.getNumbers();
            strike = checkScore.countStrike(computerNumbers, playerNumbers);
            ball = checkScore.countBall(computerNumbers, playerNumbers);

            showResult.displayResult(strike, ball);
        } while (!isGameWon(strike));
    }
    private boolean isGameWon(int strike) {
        return strike == NUMBER_OF_DIGITS;
    }

    public boolean choiceRestart() {
        return gameChoice.choiceRestart();
    }
}
