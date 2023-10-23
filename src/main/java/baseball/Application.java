package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    class Array {
        static char[] StringToArray(String str) {
            char[] array = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                array[i] = str.charAt(i);
            }
            return array;
        }

        static int[] InputToArray(String str) {
            int[] array = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                array[i] = (str.charAt(i) - '0');
            }
            return array;
        }

        static boolean IsArrayContains(char[] array, char e) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == e) {
                    return true;
                }
            }
            return false;
        }

        static boolean IsArrayContains(int[] array, int e) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == e) {
                    return true;
                }
            }
            return false;
        }
    }

    static class game {
        int[] answer = new int[3];
        int[] userAnswer = new int[3];
        String userInput;

        game() {
            int i = 0;
            while (i < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!Array.IsArrayContains(answer, randomNumber)) {
                    answer[i++] = randomNumber;
                }
            }
        }

        private void newAnswer() {
            answer = new int[3];
            int i = 0;
            while (i < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!Array.IsArrayContains(answer, randomNumber)) {
                    answer[i++] = randomNumber;
                }
            }
        }

        private void startGame() {
            calculator cal = new calculator();
            while (cal.strike != 3) {
                readAnswer();
                checkBaseballNum();
                userAnswer = Array.InputToArray(userInput);
                cal.Compare(this);
                cal.result();
                if (cal.strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                cal.Clear();
            }
            if (isContinue()) {
                newAnswer();
                startGame();
            }
        }

        private void checkGameNum(String num) {
            if (num.length() != 1) {
                throw new IllegalArgumentException();
            }
            if (!(num.charAt(0) >= '1' && num.charAt(0) <= '2')) {
                throw new IllegalArgumentException();
            }
        }

        private boolean isContinue() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String num = Console.readLine();
            checkGameNum(num);
            if (num.charAt(0) == '1') {
                return true;
            }
            return false;
        }

        private void readAnswer() {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = Console.readLine();
        }

        private void checkBaseballNum() {
            if (!checkLength()) {
                throw new IllegalArgumentException();
            }
            if (!checkDuplicate()) {
                throw new IllegalArgumentException();
            }
            if (!checkIsNumber()) {
                throw new IllegalArgumentException();
            }
        }


        private boolean checkIsNumber() {
            try {
                int number = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                return false;
            }
            char[] array = Array.StringToArray(userInput);
            if (Array.IsArrayContains(array, '0')) {
                return false;
            }
            return true;
        }

        private boolean checkLength() {
            return userInput.length() == 3;
        }

        private boolean checkDuplicate() {
            char[] input = Array.StringToArray(userInput);
            char[] toCheck = new char[3];
            for (int i = 0; i < userInput.length(); i++) {
                if (Array.IsArrayContains(toCheck, input[i])) {
                    return false;
                }
                toCheck[i] = input[i];
            }
            return true;
        }

    }

    static class calculator {
        int ball = 0;
        int strike = 0;


        public void Clear() {
            ball = 0;
            strike = 0;
        }

        public void IncreaseBall() {
            this.ball++;
        }

        public void IncreaseStrike() {
            this.strike++;
        }

        public void Compare(game baseball) {
            int number;

            for (int i = 0; i < 3; i++) {
                number = baseball.userAnswer[i];
                if (!Array.IsArrayContains(baseball.answer, number)) {
                    continue;
                }
                if (baseball.answer[i] == baseball.userAnswer[i]) {
                    IncreaseStrike();
                    continue;
                }
                IncreaseBall();
            }
        }

        public void result() {
            String result = "";

            if (this.ball != 0) {
                result += this.ball + "볼";
            }
            if (this.strike != 0) {
                if (this.ball != 0) {
                    result += " ";
                }
                result += this.strike + "스트라이크";
            }
            if (result.equals("")) {
                result += "낫싱";
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        game baseball = new game();
        baseball.startGame();
    }
}
