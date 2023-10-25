package baseball.io;

import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.matchers.Null;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleInput {

    private static boolean isDifferentEachIndex(String unvalid) {
        for (int i=0; i < unvalid.length() - 1; i++) {
            for (int j=i+1; j < unvalid.length(); j++) {
                if (unvalid.charAt(i) == unvalid.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String guessAnswer() {
        String answer;

        System.out.print("숫자를 입력해주세요 : ");
        answer = Console.readLine();

        String regex = "^[0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(answer);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력은 세자리 수여야 합니다.");
        }
        if (!isDifferentEachIndex(answer)) {
            throw new IllegalArgumentException("각 자리수는 서로 달라야 합니다.");
        }

        return answer;
    }

    public static boolean askTermination() {
        boolean result = false;
        String answer;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        answer = Console.readLine();

        String regex = "^[12]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(answer);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력은 1 또는 2여야 합니다.");
        }

        if (answer.equals("2")) {
            result = true;
        }
        return result;
    }

}
