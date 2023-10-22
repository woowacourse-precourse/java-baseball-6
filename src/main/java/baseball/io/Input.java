package baseball.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static final String RESUME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final String NUMBER_MESSAGE = "숫자를 입력해주세요 : ";


    public static ContinueOption resumeInput() {
        String userInput = readLineWithPrompt(RESUME_MESSAGE);
        if (userInput.equals("1")) {
            return ContinueOption.CONTINUE;
        }
        if (userInput.equals("2")) {
            return ContinueOption.QUIT;
        }

        throw new IllegalArgumentException();
    }

    public static String numberInput() {
        return readLineWithPrompt(NUMBER_MESSAGE);
    }

    public enum ContinueOption {
        CONTINUE,
        QUIT
    }

    private static String readLineWithPrompt(String prompt) {
        System.out.print(prompt);
        return readLine();
    }
}
