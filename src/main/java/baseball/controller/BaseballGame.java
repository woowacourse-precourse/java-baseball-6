package baseball.controller;

import baseball.constant.StringError;
import baseball.domain.AnswerChecker;
import baseball.domain.Computer;
import baseball.domain.Message;
import baseball.domain.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    private BaseballGame() {
    }

    /*
     * 게임을 동작시키는 기능
     * */
    public static void run() {
        System.out.println(Message.init());
        List<Integer> c = Computer.newNumber();
        System.out.println(c);
        start(c);
    }

    /*
     * 게임을 동작하는 기능
     * */
    private static void start(List<Integer> computer) {
        String result = "";

        while (!result.equals("3스트라이크")) {

            System.out.print(Message.pending());
            String input = Console.readLine();

            if (Validator.isNull(input)) {
                exit(StringError.notInputError);

            } else if (!Validator.stringLengthCheck(input)) {
                exit(StringError.wrongLengthInputError);

            } else if (!Validator.isNumber(input)) {
                exit(StringError.wrongInputError);
                
            } else if (Validator.isDuplicate(input)) {
                exit(StringError.duplicatedInputError);
            }

            // 입력받은 StringNum을 List<Integer>로 바꾸어 정답체크 결과출력
            List<Integer> userInput = stringToIntegerList(input);
            result = AnswerChecker.result(computer, userInput);

            System.out.println(result);
        }
        // 정답을 맞춘 후 게임을 지속할 지 여부 묻기
        System.out.println(Message.correct());
        continueGame();
    }

    /*
     * 비정상적인 입력으로 인해 예외를 발생시켜 종료시키는 기능
     * */
    public static void exit(String message) {
        System.out.println(message);
        Console.close();
        throw new IllegalArgumentException(message);
    }

    /*
     * 게임 지속여부를 체크하여 처리하는 기능
     * */
    private static void continueGame() {

        System.out.println(Message.continueOrNot());
        String input = Console.readLine();

        if (!Validator.reStartChecker(input)) {
            exit(StringError.wrongInputError);
        }
        if (input.equals("1")) {
            List<Integer> computer = Computer.newNumber();
            System.out.println(computer);
            start(computer);

        } else if (input.equals("2")) {
            Console.close();
            System.out.println(Message.expire());
        }
    }

    /*
     * String을 Integer List로 변환하는 기능
     * */
    private static List<Integer> stringToIntegerList(String strNum) {
        return Arrays.stream(strNum.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
