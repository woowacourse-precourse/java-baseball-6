package baseball;

/*
    게임과 관련된 문구를 출력해주는 클래스
 */
public class GamePrinter {

    private static GamePrinter gamePrinter;

    private GamePrinter() {
    }

    public static GamePrinter getGamePrinter() {
        if (gamePrinter == null)
            gamePrinter = new GamePrinter();
        return gamePrinter;
    }

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printEnterNumber() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public void printEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printResult(int[] gameResult) {
        String resultToText = changeResultToText(gameResult);
        System.out.println(resultToText);
    }

    private String changeResultToText(int[] result) {
        StringBuffer buffer = new StringBuffer();
        if (result[0] == 0 && result[1] == 0) {
            buffer.append("낫싱");
        } else {
            if (result[0] != 0) {
                buffer.append(result[0] + "볼");
            }

            if (result[1] != 0) {
                if (!buffer.isEmpty()) {
                    buffer.append(" ");
                }
                buffer.append(result[1] + "스트라이크");
            }
        }
        return buffer.toString();
    }
}
