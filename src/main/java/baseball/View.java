package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {

    private View() {
    }

    public static View create() {
        return new View();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();
        System.out.println(input);
        return input;
    }

    public int result(int[] result) {
        // result[0] = strike, result[1] = ball
        String print = "";
        if (result[1] > 0) {
            print += result[1] + "볼 ";
        }
        if (result[0] > 0) {
            print += result[0] + "스트라이크";
        }
        if (print.isBlank()) {
            print = "낫싱";
        }
        System.out.println(print);
        return result[0]; // return strike
    }

    public int restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(readLine());
        System.out.println(input);
        return input;
    }
}
