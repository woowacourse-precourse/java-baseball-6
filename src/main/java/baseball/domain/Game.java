package baseball.domain;

import java.util.List;

public interface Game {

    // 게임이 종료될 때 까지의 실행을 담당
    void gameRun();

    // 게임 한 턴이 종료될 때 까지의 실행을 담당
    boolean gameStart(List<Integer> computerNumbers);
}
