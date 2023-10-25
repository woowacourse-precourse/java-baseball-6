package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            BaseBallGameRunner.run();
            System.out.println("""
				3개의 숫자를 모두 맞히셨습니다! 게임 종료
				게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."""
            );
            final String inputValue = Console.readLine();
            if (inputValue == null) {
                throw new IllegalArgumentException();
            }
            final int result = Integer.parseInt(inputValue);
            if (result == 2) {
                break;
            }
        }
    }
}
