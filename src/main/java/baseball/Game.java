package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import baseball.RandomNumberGenerator;

class Game {
    final int DIGIT = 3;
    final int RESTART = 1;
    final int EXIT_GAME = 2;

    final String STARTING_SENTENCE = "숫자 야구 게임을 시작합니다.";
    final String INPUT_NUM_SENTENCE = "숫자를 입력해주세요 : ";
    final String CORRECT_ANSWER_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final String RESTART_QUESTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    int strike = 0;
    int ball = 0;
    int system_state = 0; // 0 : init, 1 : restart, 2 : exit

    public Game() {
    }

    public void PlayGame() {
        System.out.println(STARTING_SENTENCE);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        while(system_state != 2) {
            strike = 0;
            ball = 0;

            List<Integer> answerNum = randomNumberGenerator.setRandomNum();
            //System.out.println(answerNum);

            while (strike != 3) {
                strike = 0;
                ball = 0;

                List<Integer> userNum = UserInput();
                DetermineResult(answerNum, userNum);
                PrintResult();
            }

            System.out.println(RESTART_QUESTION);
            system_state = Integer.parseInt(Console.readLine());
        }
    }

    public List<Integer> UserInput() {
        System.out.print(INPUT_NUM_SENTENCE);
        List<Integer> userNum = new ArrayList<>();
        String input = Console.readLine();

        char[] inputArr = input.toCharArray();
        char temp;
        int inputInt = 0;

        // 3자리가 아닌 경우 예외 처리
        if(inputArr.length != 3) {
            throw new IllegalArgumentException();
        }

        // 1~9의 수로 이루어지지 않은 경우와 중복된 경우 예외 처리
        for(int i = 0; i < DIGIT; i++) {
            temp = inputArr[i];
            inputInt = (int)temp;

            if((inputInt < 49) || (inputInt > 57)) {
                throw new IllegalArgumentException();
            }

            for(int j = i + 1; j < DIGIT; j++) {
                if(temp == inputArr[j]) {
                    throw new IllegalArgumentException();
                }
            }
        }

        for(int i = 0; i < DIGIT; i++) {
            userNum.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }

        return userNum;
    }

    public void DetermineResult(List<Integer> answer, List<Integer> user) {
        for(int i = 0; i < DIGIT; i++) {
            for(int j = 0; j < DIGIT; j++) {
                if(answer.get(i) == user.get(j)) {
                    if(i == j) {
                        strike++;
                    }
                    else {
                        ball++;
                    }
                }
            }
        }
    }

    public void PrintResult() {
        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        else {
            if(ball != 0) {
                System.out.print(ball + "볼 ");
            }
            if(strike != 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println();

            if(strike == 3) {
                System.out.println(CORRECT_ANSWER_SENTENCE);
            }
        }
    }
}