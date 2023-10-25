package baseball;

import constant.GameMessage;
import java.util.List;
import utils.InputUtil;
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

    private boolean playGame(List<Integer> targetNmbs, Hint hint) {
        // 사용자 입력
        List<Integer> playerNmbs = InputUtil.getPlayerInput();
        // 사용자 입력값 및 상대방(컴퓨터) 값의 일치 여부 확인
        boolean isCorrect = checkPlayerNmbIsCorrect(playerNmbs, targetNmbs);

        // 힌트 출력
        hint.getHint(playerNmbs, targetNmbs);

        // 일치 여부 반환
        return isCorrect;
    }

    private boolean checkPlayerNmbIsCorrect(List<Integer> playerNmbs, List<Integer> targetNmbs) {
        // list를 String으로 변환하여 두 String이 일치하는지를 통해 값 일치 여부 확인
        String playerNmb = listToStr(playerNmbs);
        String targetNmb = listToStr(targetNmbs);

        return playerNmb.equals(targetNmb);
    }

    private String listToStr(List<Integer> nmbs) {
        StringBuilder str = new StringBuilder();
        for (int idx = 0; idx < nmbs.size(); idx++) {
            str.append(nmbs.get(idx));
        }
        return str.toString();
    }
}
