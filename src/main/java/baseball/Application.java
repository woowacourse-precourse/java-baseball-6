package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        List<Integer> answer = createAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");

        Integer strike = 0;
        while (strike < 3) {
            String userAnswer = getUserAnswer();
            Map<String, Integer> matchingCount = checkMatchingCount(answer, userAnswer);
            strike = matchingCount.get("strike");
            printResult(matchingCount);
        }

        if (askMoreGame()) {
            startGame();
        }
    }

    private static String getUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String userAnswer = Console.readLine();
        validateUserAnswer(userAnswer);
        return userAnswer;
    }

    private static void validateUserAnswer(String userAnswer) {
        // 1부터 9까지
        if (userAnswer.length() != 3) {
            throw new IllegalArgumentException("입력 값이 세 자리 수가 아닙니다.");
        }
        // 서로 다른 세 자리
        if (hasDuplication(userAnswer)) {
            throw new IllegalArgumentException("서로 다른 세 자리 수가 아닙니다.");
        }
    }

    private static Boolean hasDuplication(String str) {
        StringBuilder answer = new StringBuilder();
        char[] elements = str.toCharArray();
        for (char element : elements) {
            if (!answer.toString().contains(String.valueOf(element))) {
                answer.append(element);
            }
        }

        return !str.equals(answer.toString());
    }


    private static boolean askMoreGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int moreGame = Integer.parseInt(Console.readLine());
        return moreGame == 1;
    }

    private static void printResult(Map<String, Integer> matchingCount) {
        String ballMessage = matchingCount.get("ball") + "볼 ";
        String strikMessage = matchingCount.get("strike") + "스트라이크";

        String result = "";
        if (!ballMessage.startsWith("0")) {
            result = ballMessage;
        }
        if (!strikMessage.startsWith("0")) {
            result = result + strikMessage;
        }
        if (result.equals("")) {
            result = "낫싱";
        }
        System.out.println(result);


    }

    private static Map<String, Integer> checkMatchingCount(List<Integer> answer, String userAnswer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int target = Integer.parseInt(String.valueOf(userAnswer.charAt(i)));
            if (target == answer.get(i)) {
                strike++;
            } else if (answer.contains(target)) {
                ball++;
            }
        }
        return  Map.of("strike", strike, "ball", ball);
    }

    private static List<Integer> createAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}