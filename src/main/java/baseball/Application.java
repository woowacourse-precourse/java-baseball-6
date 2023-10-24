package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    private static class Array {
        static char[] inputToArray(UserInput input) {
            String userinput = input.input;
            int length = userinput.length();
            char[] array = new char[length];
            for (int i = 0; i < length; i++) {
                array[i] = userinput.charAt(i);
            }
            return array;
        }

        static int[] inputToArray(String str) {
            int[] array = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                array[i] = (str.charAt(i) - '0');
            }
            return array;
        }

        static boolean isArrayContains(char[] array, char e) {
            for (char c : array) {
                if (c == e) {
                    return true;
                }
            }
            return false;
        }

        static boolean isNumContains(Number answer, int e) {
            for (int j : answer.num) {
                if (j == e) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class Checker {
        static boolean checkLength(UserInput userChallenge) {
            String input = userChallenge.input;
            return input.length() == 3;
        }

        static boolean checkDuplicate(UserInput userChallenge) {
            char[] input = Array.inputToArray(userChallenge);
            char[] toCheck = new char[3];
            for (int i = 0; i < 3; i++) {
                if (Array.isArrayContains(toCheck, input[i])) {
                    return false;
                }
                toCheck[i] = input[i];
            }
            return true;
        }

        static boolean checkIsNumber(UserInput userChallenge) {
            String input = userChallenge.input;
            try {
                int number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                return false;
            }
            char[] array = Array.inputToArray(userChallenge);
            if (Array.isArrayContains(array, '0')) {
                return false;
            }
            return true;
        }

        static boolean isBallOrStrike(Game game, int number) {
            Number answer = game.answer;
            for (int e : answer.num) {
                if (number == e) {
                    return true;
                }
            }
            return false;
        }

        static boolean isStrike(Game game, int index) {
            Number answer = game.answer;
            Number userAnswer = game.userAnswer;
            return answer.num[index] == userAnswer.num[index];
        }

        static void isValidContinue(String num) {
            if (num.length() != 1) {
                throw new IllegalArgumentException();
            }
            if (!(num.charAt(0) >= '1' && num.charAt(0) <= '2')) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static class Number {
        int[] num = new int[3];

        public Number() {
        }

        public Number(String input) {
            this.num = Array.inputToArray(input);
        }
    }

    static class UserInput {
        String input;

        public UserInput() {
        }
    }

    static class Game {
        Number answer = new Number();
        Number userAnswer = new Number();
        UserInput userChallenge = new UserInput();

        Game() {
        }

        int answerAt(int index) {
            return userAnswer.num[index];
        }

        private void startGame() {
            Calculator cal = new Calculator();
            newAnswer();
            while (cal.strike != 3) {
                readAnswer();
                checkBaseballNum();
                userAnswer = new Number(userChallenge.input);
                cal.compare(this);
                cal.result();
                if (cal.strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                cal.clear();
            }
            if (isContinue()) {
                startGame();
            }
        }

        private void newAnswer() {
            userAnswer.num = new int[3];
            answer.num = new int[3];
            int i = 0;
            while (i < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!Array.isNumContains(answer, randomNumber)) {
                    answer.num[i++] = randomNumber;
                }
            }
        }

        private void readAnswer() {
            System.out.print("숫자를 입력해주세요 : ");
            userChallenge.input = Console.readLine();
        }

        private void checkBaseballNum() {
            if (!Checker.checkLength(userChallenge)) {
                throw new IllegalArgumentException();
            }
            if (!Checker.checkDuplicate(userChallenge)) {
                throw new IllegalArgumentException();
            }
            if (!Checker.checkIsNumber(userChallenge)) {
                throw new IllegalArgumentException();
            }
        }

        private boolean isContinue() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String num = Console.readLine();
            Checker.isValidContinue(num);
            System.out.println(num.charAt(0));
            return num.charAt(0) == '1';
        }
    }

    static class Calculator {
        int ball = 0;
        int strike = 0;


        public void clear() {
            ball = 0;
            strike = 0;
        }

        public void increaseBall() {
            this.ball++;
        }

        public void increaseStrike() {
            this.strike++;
        }

        public void compare(Game baseball) {
            int number;
            for (int i = 0; i < 3; i++) {
                number = baseball.answerAt(i);
                if (!Checker.isBallOrStrike(baseball, number)) {
                    continue;
                }
                if (Checker.isStrike(baseball, i)) {
                    increaseStrike();
                    continue;
                }
                increaseBall();
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
        Game baseball = new Game();
        baseball.startGame();
    }
}
