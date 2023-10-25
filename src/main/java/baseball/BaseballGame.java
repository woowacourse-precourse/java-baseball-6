package baseball;

import constant.GameMessage;
import java.util.List;
import utils.RandomUtil;

public class BaseballGame {
    public void startGame() {
        // 상대방(컴퓨터) 값 생성
        List<Integer> targetNmbs = RandomUtil.generateBaseballNumber();
        boolean isCorrect = false;
        // 사용자 입력에 맞는 스트라이크, 볼 수를 카운트하여 힌트를 보여주는 객체
        Hint hint = new Hint();

        // 게임 시작 문구 출력
        System.out.println(GameMessage.GAME_START_MESSAGE.getMessage());
        do {
            // 사용자 값 입력 문구 출력
            System.out.print(GameMessage.PLAYER_INPUT_MESSAGE.getMessage());
            // 게임 진행
            isCorrect = playGame(targetNmbs, hint);
        } while (!isCorrect);

        // 정답을 맞췄을 때 문구 출력
        System.out.println(GameMessage.CORRECT_ANSWER_MESSAGE.getMessage());
    }
}
