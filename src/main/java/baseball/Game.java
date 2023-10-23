package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game{

        private final Input input = new Input();
        private final InputValidator inputValidator = new InputValidator();
        private final Output output = new Output();


        public void playGame() {
                boolean isStartState = true; // 게임 초기 상태를 나타내는 변수면 init이 더 좋음
                String serverNumber = "";

                while (true) // true -> 종료 조건 명시 ex) choice가 2라면 등등등..
                {
                        // Method로 빼기
                        if (isStartState) {
                                serverNumber = generateNumber();
                                output.printStartMessage();
                                isStartState = false;
                        }

                        output.printInputMessage();
                        String userInput = input.readInput();
                        System.out.println(userInput);
                        inputValidator.isValidInput(userInput);

                        if (checkNumberMatches(serverNumber, userInput)) //유저가 정답을 맞추면.
                        {
                                output.printGameEndMessage();
                                output.printGameRestartMessage();
                                // `재시작여부 설정`이라는 method정도 들어가면 어떨까?
                                String choice = input.readInput();
                                inputValidator.isValidChoice(choice);
                                isStartState = choice.equals("1");
                                if (!isStartState) break; // while 문으로 빼는게 더 좋을 듯, 이 방식이 나쁜것은 아님
                        }

                }
        }

        private String generateNumber() {

                List<Integer> computer = new ArrayList<>();
                while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                                computer.add(randomNumber);
                        }
                }

                return computer.toString().replaceAll("\\D","");
        }

        private boolean checkNumberMatches(String serverNumber, String clientNumber) {
                int strike = 0;
                int ball = 0;
                int nothing = 0;

                boolean[] checkNumArr = new boolean[9];
                checkNumArr[serverNumber.charAt(0) - '1'] = true;
                checkNumArr[serverNumber.charAt(1) - '1'] = true;
                checkNumArr[serverNumber.charAt(2) - '1'] = true;

                for (int i = 0; i < 3; i++) {
                        char serverChar = serverNumber.charAt(i);
                        char clientChar = clientNumber.charAt(i);

                        if (serverChar == clientChar) {
                                strike++;
                                continue;
                        }

                        if (checkNumArr[clientChar - '1']) {
                                ball++;
                        }
                }

                if (strike == 0 && ball == 0) nothing = 1;
                output.printResult(ball, strike, nothing);

                return strike == 3;
        }
}
