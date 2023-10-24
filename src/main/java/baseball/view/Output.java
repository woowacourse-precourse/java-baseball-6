package baseball.view;

import baseball.controller.BaseBallGame;
import baseball.model.Settings;
import java.util.List;
import java.util.Objects;

public class Output {

    public static void StartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void InputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void Hint(List<Integer> computer, String userInput) {
        if (Settings.strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Settings.restart = InputNumber.GetRestartInput();
            if (!Objects.equals(Settings.restart, "1") && !Objects.equals(Settings.restart, "2")) {
                throw new IllegalArgumentException();
            }
            BaseBallGame.correct = true;
        } else if (Settings.strike == 0 && Settings.ball == 0) {
            System.out.println("낫싱");
            InputMessage();
            BaseBallGame.correct = false;
        } else if (Settings.strike == 0) {
            System.out.println(Settings.ball + "볼");
            BaseBallGame.correct = false;
            InputMessage();
        } else if (Settings.ball == 0) {
            System.out.println(Settings.strike + "스트라이크");
            BaseBallGame.correct = false;
            InputMessage();
        } else if (Settings.strike != 0 && Settings.ball != 0) {
            System.out.println(Settings.ball + "볼 " + Settings.strike + "스트라이크");
            BaseBallGame.correct = false;
            InputMessage();
        }
    }
}
