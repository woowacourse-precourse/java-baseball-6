package baseball;

import java.util.List;

public class Display {
  private static final String OUTPUT_COMPLETE_SCORE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
  private static final String OUTPUT_NEXT_GAME_SETUP = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
  public void completeScore() { //3스트라이크 완성
    System.out.println("3 스트라이크");
    System.out.println(OUTPUT_COMPLETE_SCORE);
    System.out.println(OUTPUT_NEXT_GAME_SETUP);
  }
}
