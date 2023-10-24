package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public void showStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public List<Integer> readNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String read = Console.readLine();
        validateIsNumeric(read);
        return toIntegerList(read);
    }

    public boolean askRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String read = Console.readLine();
        validateRestartCommand(read);
        return read.equals("1");
    }

    private void validateRestartCommand(String command) {
        if (command.equals("1") || command.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("1또는 2만 입력해야 합니다");
    }

    private List<Integer> toIntegerList(String str) {
        List<Integer> list = new ArrayList<>();
        for (char c: str.toCharArray()) {
            list.add(Character.getNumericValue(c));
        }
        return list;
    }

    private void validateIsNumeric(String read) {
        for (char c: read.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }
    }
}
