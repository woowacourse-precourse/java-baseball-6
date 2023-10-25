package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public void input(Game game) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != 3) throw new IllegalArgumentException("[입력 오류]세자리 수를 입력해야 합니다.");

        for (int i=0; i<3; i++) {
            char c = input.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("[입력 오류]1~9 사이의 수를 입력해야 합니다.");
            }

            String sub = input.substring(0,i) + input.substring(i+1);
            if (sub.contains(String.valueOf(c))) {
                throw new IllegalArgumentException("[입력 오류]중복되지 않는 세자리 수를 입력해야 합니다.");
            }
        }
        game.setGameInput(input);
    }

    public String inputRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1") || input.equals("2")) {
            return input;
        }
        throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
    }
}
