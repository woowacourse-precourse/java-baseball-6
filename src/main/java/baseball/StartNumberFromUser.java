package baseball;

import camp.nextstep.edu.missionutils.Console;

public class StartNumberFromUser {

    private final static String requestMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public int getStartNumber() throws IllegalArgumentException {
        final String inputString = getInputString();
        final int startNumber = Integer.parseInt(inputString);
        if (!validate(startNumber)) {
            throw new IllegalArgumentException();
        }

        return startNumber;
    }

    private String getInputString() {
        requestForStartNumber();
        return Console.readLine();
    }

    private void requestForStartNumber() {
        System.out.print(requestMessage);
    }

    private boolean validate(int startNumber) {
        return startNumber == 1 || startNumber == 2;
    }

}