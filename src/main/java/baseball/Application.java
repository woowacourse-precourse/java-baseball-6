package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        GameStart.start();
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String gameNum = readLine();
            if (gameNum.equals("2")) {
                break;
            } else if (gameNum.equals("1")) {
                GameStart.start();
            } else {
                throw new IllegalArgumentException("1 혹은 2만 입력하세요.");
            }
        }
    }
}
