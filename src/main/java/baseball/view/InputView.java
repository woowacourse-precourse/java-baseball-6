package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private InputView() {
    }

    public static String readUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return readLine();
    }

    public static Integer readToReStart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(readLine());
    }
}