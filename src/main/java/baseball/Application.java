package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void validateInput(List<Integer> user){
        if (user.size() != 3 || user.stream().distinct().count() != 3 || user.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean getResult(List<Integer> computer, List<Integer> user){
        int strike = 0;
        int ball = 0;

        // compare number
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(user.get(i))) ball++;
            if (Objects.equals(computer.get(i), user.get(i))) {
                strike++;
                ball--;
            }
        }

        // print response
        if (strike==0 && ball ==0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        // if user's input is correct answer
        if (strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }

    // start game
    public static int playBaseBall(int playAgain) {
        List<Integer> user;
        List<Integer> computer = new ArrayList<>();

        // get computer's number
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // game playing until input answer
        do {
            System.out.print("숫자를 입력해주세요 : ");
            // get user's number
            user = Arrays.stream(Console.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .boxed().toList();

            // validate user's number
            validateInput(user);
        } while (getResult(computer, user));

        // restart or finish game
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine().trim());
    }

    public static void main(String[] args) {
        int playAgain = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (playAgain==1) {
            playAgain = playBaseBall(playAgain);
        }
    }
}