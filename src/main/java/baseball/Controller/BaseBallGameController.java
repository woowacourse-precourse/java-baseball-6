package baseball.Controller;

import baseball.Model.BaseballGameModel;
import baseball.View.BaseballGameView;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGameController {
  private BaseballGameModel model;
  private BaseballGameView view;
  
    public BaseballGameController(BaseballGameModel model, BaseballGameView view) {
      this.model = model;
      this.view = view;
  }

  public void playGame() {

  }

    private String formatResult(int[] result) {
      StringBuilder formattedResult = new StringBuilder();

      if (result[0] > 0) {
          formattedResult.append(result[0]).append("스트라이크");
      }

      if (result[0] > 0 && result[1] > 0) {
          formattedResult.append(" ");
      }

      if (result[1] > 0) {
          formattedResult.append(result[1]).append("볼");
      }

      if (formattedResult.length() == 0) {
          formattedResult.append("낫싱");
      }

      return formattedResult.toString();
  }



  private boolean isGameFinished(int[] result) {
      return result[0] == 3;
  }

  private int getRestartOrQuitOption() {
      return view.getRestartOrQuitOption();
  }
}
