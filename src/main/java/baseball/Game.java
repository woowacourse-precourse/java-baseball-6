package baseball;

import camp.nextstep.edu.missionutils.Randoms;

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
                StringBuilder serverNumber = new StringBuilder("000");

                for (int index = 0; index < 3;) {
                        int randomPickNumber = Randoms.pickNumberInRange(1, 9); //내 추천: randomPickNumber -> randomNumber
                        if (serverNumber.charAt(0) == randomPickNumber-'1' || serverNumber.charAt(1) == randomPickNumber-'1') {
                                continue;
                        }
                        serverNumber.replace(index, index+1, String.valueOf(randomPickNumber)); //이 프로그램에서는 시간 복잡도가 상수가 나와서 상관 없지만 `replace`함수의 시간 복잡도는 O(n)이여서 안쓰는 것을 추천
                        index++;
                }

                return serverNumber.toString();
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

        private void generateException() {
                throw new IllegalArgumentException();
        }
}
