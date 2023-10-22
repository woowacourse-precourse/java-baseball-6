package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class BaseballGame {
    private final List<Integer> answer;
    int digit;

    public BaseballGame(int digit) {
        this.digit = digit;
        answer = selectDigitNumbers(digit);
    }

    private List<Integer> selectDigitNumbers(int digit) {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < digit) {
            int pickedRandomNum = Randoms.pickNumberInRange(1, 9);
            if (answer.contains(pickedRandomNum)) {
                continue;
            }
            answer.add(pickedRandomNum);
        }
        System.out.println(answer);
        return answer;
    }

    public Map<String, Integer> countNumbers(List<Integer> candidate, List<Integer> pickedList) {
        Map<String, Integer> resultMap = new HashMap<>();
        long sameNumbersCount = candidate.stream().filter(l -> pickedList.stream()
                .anyMatch(Predicate.isEqual(l))).count();
        long strike = IntStream.range(0, 3)
                .filter(i -> pickedList.get(i).equals(candidate.get(i)))
                .count();
        resultMap.put("ball", (int) (sameNumbersCount - strike));
        resultMap.put("strike", (int) strike);
        return resultMap;

    }

    public List<Integer> getUserInput() {
        System.out.println(digit + "개의 숫자를 입력해주세요. : ");
        String userInput = Console.readLine();
        List<Integer> userAnswer = new ArrayList<>();
        validateInput(userInput);
        for (int i = 0; i < 3; i++) {
            userAnswer.add(Character.getNumericValue(userInput.charAt(i)));
        }
        return userAnswer;
    }

    public void validateInput(String userInput) {
        // 3자리 수가 아니거나, 숫자가 아니거나, 동일한 수가 있으면 에러
        boolean isDuplicate = Arrays.stream(userInput.split("")).distinct().count() != userInput.split("").length;
        boolean hasZero = userInput.contains("0");
        if (userInput.length() != 3 || isDuplicate || hasZero) {
            throw new IllegalArgumentException();
        }
    }

    public void printAnswer(Map<String, Integer> map) {
        String strike = map.get("strike") + "스트라이크";
        String ball = map.get("ball") + "볼";
        if (map.get("strike") == 0 && map.get("ball") == 0) {
            System.out.println("낫싱");
            return;
        }
        if (map.get("strike") == digit) {
            System.out.println(strike);
            return;
        }
        if (map.get("ball") == digit) {
            System.out.println(ball);
            return;
        }

        System.out.println(ball + " " + strike);
    }


    public boolean isRight(Map<String, Integer> result) {
        return result.containsKey("strike") && result.get("strike") == 3;
    }

    public boolean retry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            System.out.println("게임 종료\n");
            return false;
        } else {
            return retry();
        }

    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        Map<String, Integer> result;
        do {
            List<Integer> userInput = getUserInput();
            result = countNumbers(userInput, answer);
            printAnswer(result);
        } while (!isRight(result));
        System.out.println(digit + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n");

    }
}
