package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseBallService {
  private final static String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다";
  private final BaseBallPlay baseBallPlay;
  public BaseBallService(){
    System.out.println(START_GAME_MESSAGE);
    this.baseBallPlay = new BaseBallPlay();
  }
  public void exec() {
    GameResult gameResult;
    baseBallPlay.createComNums();
    do{
      gameResult = new GameResult(baseBallPlay.play());
    }while( gameResult.get() != 3);
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }
}
