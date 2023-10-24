package baseball.service;

import baseball.model.Game;
import baseball.model.User;
import baseball.utils.Parser;
import baseball.utils.RandomUtils;
import baseball.view.GameInputView;
import baseball.view.GameOutputView;

public class GameService {
    Game game;
    User user = new User();
    Parser parser = new Parser();
    RandomUtils randomUtils = new RandomUtils();
    GameInputView gameInputView = new GameInputView();
    GameOutputView gameOutputView = new GameOutputView();
    boolean[] isStrike;

    // 게임 준비: 컴퓨터 임의의 세 자리 숫자 생성
    public void setGame() {
        gameOutputView.printStartGame();
        game = new Game(randomUtils.getGameNumber());
    }

    // 게임 시작: 스트라이크 3개 뜰 때 까지 진행
    public void playGame() {
        int strike = 0;

        while(strike != 3){
            play();
            gameOutputView.printResult(game.getStrike(), game.getBall());
            strike = game.getStrike();
        }
    }

    // 게임 진행: 사용자로부터 입력값 받은 후 검증, 점수 계산
    public void play() {
        game.initGame();
        gameOutputView.printInputNumber();
        user.setUserNumber(parser.parseUserInput(gameInputView.getUserInput(),3));
        computeScore(game.getGameNumber(), user.getUserNumber());
    }

    // 게임 종료: 게임 종료 문구 출력
    public void endGame() {
        gameOutputView.printGameOver();
    }

    // 게임 재시작: 입력값을 받아 게임 재시작 또는 종료하기
    public int retryGame() throws IllegalArgumentException{
        gameOutputView.printRetryGame();
        int number = parser.parseUserInput(gameInputView.getUserInput(),1)[0];
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    // 각각의 숫자값마다 비교
    public void computeScore(int[] gameNumber, int[] userNumber) {
        isStrike = new boolean[3];
        for(int i=0; i<gameNumber.length; i++) {
            compareNumber(gameNumber,userNumber,i);
        }
    }

    // 숫자값 비교 후 스트라이크, 볼 결정
    public void compareNumber(int[] gameNumber, int[] userNumber, int index) {
        for(int i=0; i<gameNumber.length; i++) {
            if(userNumber[index] == gameNumber[i] && index == i) {
                game.increaseStrike();
                isStrike[index] = true;
                break;
            }
            if(userNumber[index] == gameNumber[i] && index != i && !isStrike[i]) {
                game.increaseBall();
                break;
            }
        }
    }
}