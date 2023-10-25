package baseball;

import static baseball.Application.COUNT_3;

import camp.nextstep.edu.missionutils.Console;

/*
 * 클래스 이름
 * Input
 *
 * 버전 정보
 * 0.3
 *
 * 날짜
 * 2023/10/25
 *
 * 저작권 주의
 * Free Source
 */

public class Input {

    public static String inFir() {

        String input;
        input = Console.readLine();

        if (input.length() != COUNT_3) {
            throw new IllegalArgumentException("3자리 숫자만 가능합니다.");
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                throw new IllegalArgumentException("1부터 9까지만 입력해주세요.");
            }
        }

        return input;
    }

    public static String inSec() {

        String input;
        input = Console.readLine();

        if (input.length() > 1) {
            throw new IllegalArgumentException("1 혹은 2만 입력하세요.");
        }

        if (input.charAt(0) != '1' && input.charAt(0) != '2') {
            throw new IllegalArgumentException("1 혹은 2만 입력하세요.");
        }

        return input;
    }
}
