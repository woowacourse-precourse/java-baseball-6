package view;

import camp.nextstep.edu.missionutils.Console;
import controller.Functions;
import dto.Result;
import java.util.List;

public class Output {
    private static final Functions functions = new Functions();

    private static List<Integer> rightAnswer(List<Integer> computer) {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String cmd = Console.readLine();
        if (cmd.equals("1")) {
            computer = functions.init();
        } else if (cmd.equals("2")) {
            return null;
        }
        return computer;
    }

    private static void wrongAnswer(Result res) {
        if (res.getStrike() == 0 && res.getBall() == 0) {
            System.out.print("낫싱");
        } else if (res.getBall() > 0) {
            System.out.print(res.getBall() + "볼 ");
        }
        if (res.getStrike() > 0) {
            System.out.print(res.getStrike() + "스트라이크");
        }
        System.out.print("\n");
    }

    public void game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = functions.init();
        while (true) {
            Result res = functions.inputAndCompare(computer);
            System.out.println(computer);
            if (res.getStrike() == 3) {
                computer = rightAnswer(computer);
            } else if (res.getStrike() < 3) {
                wrongAnswer(res);
            }
            if (computer == null) {
                break;
            }
        }
    }

}
