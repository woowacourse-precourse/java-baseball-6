package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {

    public static boolean askReplayGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int parsedInt = ValidateUtils.parseIntWithTypeCheck(Console.readLine());

        if (parsedInt >= 3 || parsedInt < 1) {
            throw new IllegalArgumentException();
        }

        return parsedInt == 1;
    }

    public static int userInputReceive() {
        System.out.print("숫자를 입력해주세요 : ");

        return rawInputToCheckedInput(Console.readLine());
    }

    private static int rawInputToCheckedInput(String rawInput) {

        int parsedInt = ValidateUtils.parseIntWithTypeCheck(rawInput);

        if (!(parsedInt >= 100) || !(parsedInt <= 999)) {
            throw new IllegalArgumentException();
        }

        int firstPosition = (parsedInt / 100) % 100;
        int secondPosition = (parsedInt / 10) % 10;
        int thirdPosition = parsedInt % 10;

        if (firstPosition == secondPosition || firstPosition == thirdPosition || secondPosition == thirdPosition) {
            throw new IllegalArgumentException();
        }

        return parsedInt;
    }

}
