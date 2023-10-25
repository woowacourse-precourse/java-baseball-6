package baseball;

public class InputOutput {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static String inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
    public static void printResult(int strike, int ball) {
        String resultMessage = "";
        if (ball > 0) {
            resultMessage += ball + "볼 ";
        }
        if (strike > 0) {
            resultMessage += strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            resultMessage += "낫싱";
        }
        System.out.println(resultMessage);
    }
    public static String inputRestartNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}
