package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputGameNumber = readLine();

        // TODO: Test case 임시 통과용. 차후 제거
        if (inputGameNumber.length() >= 4) {
            throw new IllegalArgumentException();
        }
    }
}
