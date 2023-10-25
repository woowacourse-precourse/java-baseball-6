package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;

public class GameService {

    Game game;
    User user = new User();

    public void playGame() {
        int strike = 0;
        while (strike != 3) {
            game.initBaseBall();
            user.setUserNumbers(/**입력값**/);
            computeScore();/** 게임 숫자와 사용자 숫자간 비교 **/
            strike = game.getStrikeCount(); /**스트라이크 숫자 확인 **/
        }
    }
    private void computeScore() {
        /**생성된 무작위 게임 번호와 사용자가 입력한 번호와의 비교**/
    }

}
