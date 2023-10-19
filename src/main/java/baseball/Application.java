package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame computerAnswer = new BaseBallGame();

        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseBallGame.init(computerAnswer);
    }

    class Array() {
        static char[] getStringToChar(String str) {
            char[] charArr = new char[str.length()];
            for (int i=0; i<str.length(); i++){
                charArr[i] = str.charAt(i);
            }
            return charArr;
        }
        static boolean checkContains(char[] arr, char num) {
            for (int value : arr) {
                if (value == num) return true;
            }
            return false;
        }
        static boolean checkContains(int[] arr, int num) {
            for (int value : arr) {
                if (value == num) return true;
            }
            return false;
        }
        static int getIndex(int[] arr, int value) {
            for (int i=0; i<arr.length; i++) {
                if (arr[i] == value)
                    return i;
            }
            return -1;
        }
    }


    static class BaseBallGame() {
        private static final int START_RANGE = 1;
        private static final int END_RANGE = 9;
        static final int NUMBER_IDX = 3;
        private static final int NEW_GAME = 1;
        private static final int QUIT_GAME = 2;

        int[] number = new int[NUMBER_IDX];

        BaseBallGame() {
            int nowRandomNum = 0, nowRandomNumIdx = 0;

            while (nowRandomNumIdx < NUMBER_IDX) {
                nowRandomNum = this.getNumber();
                if (!Array.checkContains(number, nowRandomNum)) {
                    number[nowRandomNumIdx++] = nowRandomNum;
                }
            }
        }
        BaseBallGame(String str) {
            for (int i=0; i<NUMBER_IDX; i++) {
                number[i] = Integer.parseInt(str.charAt(i)+"");
            }
        }

        public static void init(BaseBallGame computerAnswer) {
            BaseBallGame userAnswer = BaseBallGame.getUserAnswer();
            GameResult gameResult = new GameResult();

            gameResult.compareAnswer(userAnswer, computerAnswer);
            gameResult.printResult();

            if(gameResult.strike != BaseBallGame.NUMBER_IDX) {
                BaseBallGame.init(computerAnswer);
                return;
            }

            int newComputerAnswer = BaseBallGame.newStart();

            if (newComputerAnswer == 1) {
                computerAnswer = new BaseBallGame();
                BaseBallGame.init(computerAnswer);
            }
        }

        private static int newStart() {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String newStartAnswer = readLine();
            return BaseBallGame.getNewStartAnswer(newStartAnswer);
        }

        private static int getNewStartAnswer(String newStartAnswer) {
            int newAnswer;

            try {
                newAnswer = Integer.parseInt(newStartAnswer);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            if (newAnswer != 1 && newAnswer != 2)
                throw new IllegalArgumentException();

            return newAnswer;
        }

        private int getNumber() {
            return pickNumberInRange(START_RANGE, END_RANGE);
        }

        private static BaseBallGame getUserAnswer() {
            System.out.println("숫자를 입력해주세요 : ");
            String userInput = readLine();
            BaseBallGame.checkInput(userInput);

            return new BaseBallGame(userInput);
        }

        private static void checkInput(String str) { //IllegalException
            if (!BaseBallGame.checkLen(str))
                throw new IllegalArgumentException();
            if (!BaseBallGame.checkEqual(str))
                throw new IllegalArgumentException();
            if (!BaseBallGame.checkNum(str))
                throw new IllegalArgumentException();
        }

        static boolean checkLen(String str) {
            return str.length() == BaseBallGame.NUMBER_IDX;
        }
        static boolean checkEqual(String str) {
            char[] equalNum = new char[str.length()];
            char[] word = Array.getStringToChar(str);

            for(int i=0; i<str.length(); i++) {
                if(Array.checkContains(equalNum, word[i]))
                    return false;
                equalNum[i] = word[i];
            }
            return true;
        }
        static boolean checkNum(String str) {
            try {
                int num = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return false;
            }
            char[] numArr = Array.getStringToChar(str);
            return !Array.checkContains(numArr, '0');
        }
    }

    static class GameResult() {
        int ball = 0, strike = 0;

        private static final String BALL = "볼";
        private static final String STRIKE = "스트라이크";
        private static final String NOTHING = "낫싱";

        private void addBallCount() {
            this.ball++;
        }
        private void addStrikeCount() {
            this.strike++;
        }

        void printResult() {
            if(this.strike != 3) {
                if (this.ball > 0 && this.strike > 0)
                    System.out.println(this.ball + BALL + " " + this.strike + STRIKE);
                if (this.ball != 0)
                    System.out.println(this.ball + BALL);
                else if(this.ball == 0 && this.strike > 0)
                    System.out.println(this.strike + STRIKE);
                else if(this.ball == 0 && this.strike == 0)
                    System.out.println(NOTHING);
            }
            else {
                System.out.println(this.strike + "스트라이크"); // 3스트라이크
            }
        }

        void compareAnswer(BaseBallGame userAnswer, BaseBallGame computerAnswer) {
            int num = 0;
            for (int i=0; i<BaseBallGame.NUMBER_IDX; i++) {
                num = userAnswer.number[i];

                if (!Array.checkContains(computerAnswer.number, num))
                    continue;
                if (i == Array.getIndex(computerAnswer.number, num)) {
                    addStrikeCount();
                    continue;
                }
                addBallCount();
            }
        }
    }
}
