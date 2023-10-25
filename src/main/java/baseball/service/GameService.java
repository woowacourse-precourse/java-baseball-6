package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.Validator;
import baseball.utils.RandomUtils;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class GameService {

    int size;

    Game game;
    User user = new User();

    Validator validator = new Validator();

    SystemMessage systemMessage = new SystemMessage();

    public void playGame() {
        int strike = 0;
        while (strike != 3) {
            game.initBaseBall();
            user.setUserNumbers(/**입력값**/);
            computeScore();/** 게임 숫자와 사용자 숫자간 비교 **/
            strike = game.getStrikeCount(); /**스트라이크 숫자 확인 **/
        }
    }

    public void setGame(int size, int start, int end) {
        this.size = size;
        game = new Game(RandomUtils.getRandomNumbers(size, start, end));
    }

    private void computeScore() {
        compareNumber(game.getGameNumbers(), user.getUserNumbers());
    }

    private void compareNumber(int[] gameNumber, int[] userNumber) {

        for (int i = 0; i < gameNumber.length; i++){
            Integer[] gameArray = Arrays.stream(gameNumber).boxed().toArray(Integer[]::new);
            List<Integer> gameNumberList = Arrays.asList(gameArray);
            if (gameNumberList.get(i) == userNumber[i]){
                game.incStrikeCount();
                continue;
            }
            if (gameNumberList.contains(userNumber[i])){
                game.incBallCount();
            }
        }
    }



}
