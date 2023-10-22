package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public void isLengthThree(String str) {
        if (str.length() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요.");
        }
    }

    public void isNumber(String str) {
        for (Character ch : str.toCharArray()) {
            if(!Character.isDigit(ch)) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }
    }

    public void hasSameNumber(List<Integer> list) {
        if (list.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요.");
        }
    }

    public void isFinishOrContinue(int i) {
        if (i != 1) {
            if (i != 2) {
                throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
            }
        }
    }

    public List<Integer> setRandomNumber() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
        return list;
    }

    public List<Integer> userInputToNumber(String user) {
        List<Integer> list = new ArrayList<>();
        for(Character ch : user.toCharArray())
            if (!list.contains(Character.getNumericValue(ch))) {
                list.add(Character.getNumericValue(ch));
            }
        return list;
    }

    public int[] countBallStrike(List<Integer> computer, List<Integer> userNum) {
        int[] countBS = {0, 0};
        for (int i : userNum) {
            if (computer.contains(i)) {
                if (computer.indexOf(i) != userNum.indexOf(i)) countBS[0]++;  //볼 갯수
                if (computer.indexOf(i) == userNum.indexOf(i)) countBS[1]++; //스트라이크 갯수
            }
        }
        return countBS;
    }

    public String countResult(int ball, int strike) {
        String result = "";
        if (ball > 0) {
            result += ball + "볼 ";
        }
        if (strike > 0) {
            result += strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            result += "낫싱";
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();

        System.out.println("숫자 야구 게임을 시작합니다.");

        int retryNum = 1;

        while (retryNum == 1) {
            List<Integer> computer = app.setRandomNumber();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String user = Console.readLine();
                app.isLengthThree(user);
                app.isNumber(user);

                List<Integer> userNum = app.userInputToNumber(user);
                app.hasSameNumber(userNum);

                int ball = app.countBallStrike(computer, userNum)[0];
                int strike = app.countBallStrike(computer, userNum)[1];

                System.out.println(app.countResult(ball, strike));

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String retry = Console.readLine();
                    app.isNumber(retry);

                    retryNum = Integer.parseInt(retry);
                    app.isFinishOrContinue(retryNum);

                    break;
                }
            }
         }
    }
}