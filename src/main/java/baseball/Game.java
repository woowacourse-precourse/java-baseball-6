package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game{

        private final Input input = new Input();
        private final InputValidator inputValidator = new InputValidator();
        private final Output output = new Output();


        public void playGame() {
                boolean isStartState = true;
                String serverNumber = "";

                while (true)
                {
                        if (isStartState) {
                                serverNumber = generateNumber();
                                output.printStartMessage();
                                isStartState = false;
                        }

                        output.printInputMessage();
                        String userInput = input.readInput();

                        if (inputValidator.isValidInput(userInput)) {
                                if (checkNumberMatches(serverNumber, userInput))
                                {
                                        output.printGameEndMessage();
                                        output.printGameRestartMessage();
                                        int choice = input.readUserChoice(); // choice 이상하게 입력한 경우도 생각
                                        isStartState = choice == 1;
                                        if (!isStartState) break;
                                }
                        } else {
                                generateException();
                        }

                }
        }

        private String generateNumber() {
                StringBuilder sb = new StringBuilder("000");

                for (int index = 0; index < 3;) {
                        int randomPickNumber = Randoms.pickNumberInRange(1, 9);
                        if (sb.charAt(0) == randomPickNumber-'1' || sb.charAt(1) == randomPickNumber-'1') {
                                continue;
                        }
                        sb.replace(index, index, String.valueOf(randomPickNumber));
                        index++;
                }

                return sb.toString();
        }

        private boolean checkNumberMatches(String serverNumber, String clientNumber) {
                int strike = 0;
                int ball = 0;
                int nothing = 0;

                boolean[] checkNumArr = new boolean[9];

                for (int i = 0; i < 3; i++) {
                        char serverChar = serverNumber.charAt(i);
                        char clientChar = clientNumber.charAt(i);
                        checkNumArr[serverChar-'1'] = true;

                        if (serverChar == clientChar) {
                                strike++;
                                continue;
                        }

                        if (checkNumArr[clientChar-'1']) {
                                ball++;
                        }
                }

                if (strike == 0 && ball == 0) nothing = 1;

                output.printResult(ball, strike, nothing);

                return strike == 3;
        }

        private void generateException() {
                throw new IllegalArgumentException();
        }
}
