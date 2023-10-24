/**
 * 제목: 숫자 야구 게임
 */
package baseball;

import camp.nextstep.edu.missionutils.Console;

/**
 * Game클래스 객체 생성, 게임 종료 후 재시작 or 종료 유무 확인
 */
public class Application {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        userInterface.startMessage();
        while (true) {
            Game game = new Game();
            game.game();

            String retryCheckNumber = Console.readLine();
            /* 재시작: 1, 종료: 2 */
            if (retryCheckNumber.equals("2")) {
                break;
            }
        }
    }
}
