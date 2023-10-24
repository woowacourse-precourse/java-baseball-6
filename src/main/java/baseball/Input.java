package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

        public static int inputData() {
                return Validator.validateInputData(Console.readLine());
        }

        public static int inputNumberSuggestion() {
                System.out.print("숫자를 입력해주세요 : ");
                return Validator.validateNumberSuggestion(inputData());
        }

        public static int chooseRetryOrEnd() {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                return Validator.validateRetryOrEnd(inputData());
        }
}
