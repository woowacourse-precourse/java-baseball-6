package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Round{
    List<Integer> computer;
    List<Integer> user;
    int strike;
    int ball;

    void makeRandNums() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    void convertToArrayList(int guess) {
        while (user.size() < 3) {
            int num = guess % 10;
            guess /= 10;
            Validator.UserGuessValidator.validateDigit(user, num);
            user.add(0, num);
        }
    }

    void inputUserGuess(){
        System.out.print("숫자를 입력해주세요 : ");
        user = new ArrayList<>();
        int guess = Integer.parseInt(readLine());
        Validator.UserGuessValidator.validateRange(guess);
        convertToArrayList(guess);
    }

    void scoreGuess() {
        strike = ball = 0;
        for (int i = 0; i < 3; ++i) {
            Integer computer_num = computer.get(i);
            if (Objects.equals(computer_num, user.get(i)))
                strike++;
            else if (user.contains(computer_num))
                ball++;
        }
    }

    void printScore() {
        if (ball > 0)
            System.out.printf("%d볼 ", ball);
        if (strike > 0)
            System.out.printf("%d스트라이크", strike);
        if (ball == 0 && strike == 0)
            System.out.print("낫싱");
        System.out.println();
        if (strike == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    void playRound() {
        makeRandNums();
        //System.out.printf("답: %d %d %d\n",computer.get(0), computer.get(1), computer.get(2));
        do {
            inputUserGuess();
            scoreGuess();
            printScore();
        } while (strike < 3);
    }
}
