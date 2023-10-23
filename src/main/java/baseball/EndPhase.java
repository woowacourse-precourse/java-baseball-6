package baseball;

import camp.nextstep.edu.missionutils.Console;

public class EndPhase {
    public static void ending() {
        // 종료 문구 출력
        System.out.format("%d%s\n", Variables.answerLength, Text.correctGuessText);
        // 재시작/종료
        restartOrEnd();
    }

    public static void restartOrEnd() {
        // 재시작 문구 출력
        System.out.println(Text.restartText);
        // 재시작 여부 인풋
        String restartInput = Console.readLine();
        if (restartInput.equals("1")) {
            // 재시작
            return;
        } else if (restartInput.equals("2")) {
            // 종료
            Application.playGame = false;
            Console.close();
        } else {
            // 인풋 오류
            Exceptions.restartInputException();
        }
    }
}