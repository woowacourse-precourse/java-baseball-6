package baseball;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    public void play() {
        Balls answerBalls, playerBalls;

        // TODO : 정답 공 번호들 생성
        answerBalls = new RandomBalls();
        answerBalls.createBalls();
        System.out.println(answerBalls.getBallsList());

        // TODO : 플레이어 공 입력 받기
        playerBalls = new PlayerBalls();
        playerBalls.createBalls();
        System.out.println(playerBalls.getBallsList());



        // TODO : 비교

        // TODO : 비교 결과 출력

        // TODO : 다시 실행 or 정상 게임 종료
    }
}
