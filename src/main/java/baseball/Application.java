package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isStarted = true;

        while (isStarted) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();
            makeRandomComputer(computer);

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String Numbers = Console.readLine();

                List<Integer> user = new ArrayList<>();
                userNumberList(user, Numbers);
                validUserList(user);

                HashMap<Integer, Integer> map = new HashMap();
                prepareComparison(map, user, computer);
                int ball = 0;
                int strike = 0;

                for (int m = 0; m < user.size(); m++) {
                    strike = judgeStrike(map, user, m, strike);
                    ball = judgeBall(map, user, m, ball);
                }

                if(strike==3) {
                    isStarted =restartEndGame();
                    break;
                }

                String judgeResult= makeResultBallStrike(ball, strike);
                System.out.println(judgeResult);
            }
        }
    }
    public static String makeResultBallStrike(int ball, int strike) {
        if (ball == 0 && strike == 0)
            return "낫싱";

        return ball + "볼 " + strike + "스트라이크";
    }

    public static boolean restartEndGame() {
        System.out.println("3스트라이크\n"
                + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                +"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userOpinion = Console.readLine();
        return userOpinion.equals("1");

    }
    public static int judgeBall(HashMap<Integer, Integer> map, List<Integer> user, int m, int ball) {
        if(user.get(m) != map.get(user.get(m)) && map.containsKey(user.get(m)) == true) {
            ball++;
            return ball;
        }
        
        return ball;
    }
    public static int judgeStrike(HashMap<Integer, Integer> map, List<Integer> user, int m, int strike) {
        if (user.get(m) == map.get(user.get(m)))
            strike++;

        return strike;
    }

    public static void prepareComparison(HashMap<Integer, Integer> map, List<Integer> user, List<Integer> computer) {
        for (int k = 0; k < user.size(); k++)
            map.put(computer.get(k), user.get(k));

    }
    public static void validUserList(List<Integer> user) {
        if (!(user.size() == 3))
            throw new IllegalArgumentException();

    }

    public static void userNumberList(List<Integer> user,String Numbers) {
        for (int i = 0; i < Numbers.length(); i++) {
            int userNumber = Numbers.charAt(i) - '0';
            validUser(user, userNumber);
            user.add(userNumber);
        }
    }
    public static void validUser(List<Integer> user, int userNumber) {
        validUserRange(userNumber);
        overlapUser(user, userNumber);
    }
    public static void overlapUser(List<Integer> user, int userNumber) {
        if(user.contains(userNumber))
            throw new IllegalArgumentException();

    }
    public static void validUserRange(int userNumber) {
        if (validNumberRange(userNumber))
            throw new IllegalArgumentException();

    }
    public static boolean validNumberRange(int userNumber) {
        return userNumber<1 || userNumber>9;
    }

    public static void addRandomComputer(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber))
            computer.add(randomNumber);

    }
    public static void makeRandomComputer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addRandomComputer(computer, randomNumber);
        }
    }
}