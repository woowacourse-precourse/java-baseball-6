package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Run {
    private Run() {
    }

    private static void nullCheck(List<Integer> computerNum, List<Integer> personNum) {
        Objects.requireNonNull(computerNum);
        Objects.requireNonNull(personNum);
    }

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> createNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> userTurn() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNumsList = null;
        try {
            String consoleLine = Console.readLine();
            String[] userNums = consoleLine.split("");
            userNumsList = new ArrayList<>();
            for (int i = 0; i < userNums.length; i++) {
                userNumsList.add(Integer.parseInt(userNums[i]));
            }

            if (userNumsList.equals(0)) {
                throw new IllegalArgumentException("1 ~ 9 사이의 숫자를 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ex) 123 형식으로 입력하십시오.");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return userNumsList;
    }

    public static boolean judge(List<Integer> computerNum, List<Integer> personNum) {
        nullCheck(computerNum, personNum);
        if (personNum.size() != 3) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }

        BaseBallScore.printScore(computerNum, personNum);
        return !computerNum.equals(personNum);
    }

    public static boolean end() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String console = Console.readLine();
        if (console.equals("1")) {
            return true;
        } else {
            System.out.println("게임 종료");
        }
        return false;
    }
}
