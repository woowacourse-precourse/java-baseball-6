package baseball;

public class Printer {

    public void printResult(int strikes, int balls) {
        String result = "";

        if (strikes == 3) {
            result = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (balls > 0) {
            result = balls + "볼";
        }
        if (strikes > 0) {
            result += (result.isEmpty() ? "" : " ") + strikes + "스트라이크";
        }
        if (strikes == 0 && balls == 0) {
            result = "낫싱";
        }

        System.out.println(result);
    }

    public void printStartingMessage() {
        String message = "숫자 야구 게임을 시작합니다.";
        System.out.println(message);
    }

    public void printInputMessage() {
        String message = "숫자를 입력해주세요 : ";
        System.out.print(message);
    }

    public void printEndingMessage() {
        String message = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        System.out.println(message);
    }
}
