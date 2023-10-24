package baseball;

import baseball.entity.BaseBallGame;

public class Application {

    public static void main(String[] args) {
        // 게임 시작
        BaseBallGame game = new BaseBallGame();
        game.startGame();
        // 컴퓨터 view. 진행상황 표시와 사용자 입력 처리를 받음
        // 게임. 현재 게임 진행 상태 관리(게임 재시작 or 종료)
        // 내부 로직.(사용자 입력과 정답 비교)
        // 정답.(정답 관리)
    }
}
