package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Player {

    public static boolean getResult(List<Integer> computer, String input, int size) {
        List<Integer> userNumberList = stringArrToIntegerList(input);

        int strikeCnt = countStrike(computer, userNumberList, size);
        int ballCnt = countBall(computer, userNumberList, size);

        printResult(strikeCnt, ballCnt);

        return strikeCnt == size;
    }

    public static List<Integer> stringArrToIntegerList(String input) {
        String[] inputStringArr = input.split("");
        List<Integer> list = new ArrayList<>();

        for (String str : inputStringArr) {
            list.add(Integer.parseInt(str));
        }

        return list;
    }

    public static void isValidInput(String input, int size) {
        if (!isNaturalNumbers(input)) {
            throw new IllegalArgumentException("자연수만 입력해야합니다.");
        } else if (!isValidSize(input, size)) {
            throw new IllegalArgumentException("세 개의 수를 입력해야합니다.");
        } else if (!isNotDuplication(input)) {
            throw new IllegalArgumentException("중복된 수를 입력했습니다.");
        }
    }

    public static boolean isValidSize(String input, int size) {
        return input.length() == size;
    }

    public static boolean isNaturalNumbers(String input) {
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') return false;
        }
        return true;
    }

    public static boolean isNotDuplication(String input) {
        List<Character> list = new ArrayList<Character>();

        for (char c : input.toCharArray()) {
            list.add(c);
        }

        Set<Character> set = new HashSet<>(list);

        return list.size() == set.size();
    }

    public static int countStrike(List<Integer> computer, List<Integer> user, int size) {
        int cnt = 0;

        for (int i=0; i<size; i++) {
            if (Objects.equals(computer.get(i), user.get(i))) cnt++;
        }

        return cnt;
    }

    public static int countBall(List<Integer> computer, List<Integer> user, int size) {
        int cnt = 0;

        for (int i=0; i<size; i++) {
            if (!Objects.equals(computer.get(i), user.get(i)) && computer.contains(user.get(i))) cnt++;
        }

        return cnt;
    }

    public static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) System.out.println("낫싱");
        else if (strike > 0 && ball == 0) System.out.println(strike + "스트라이크");
        else if (strike == 0 && ball > 0) System.out.println(ball + "볼");
        else if (strike > 0 && ball > 0) System.out.println(ball + "볼" + " " + strike + "스트라이크");
    }

    public static boolean selectRestartOrExit() {
        String input = Console.readLine();
        isOneOrTwo(input);
        return input.equals("2");
    }

    public static void isOneOrTwo(String input) {
        if (!input.equals("1") && !input.equals("2"))
            throw new IllegalArgumentException("1 또는 2만 입력해야합니다.");
    }

}
