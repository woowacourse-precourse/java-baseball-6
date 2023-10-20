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

public class Application {
    static final int DIGIT = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        playGame(DIGIT);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        if (Console.readLine().equals("1")) {
            playGame(DIGIT);
        } else if (Console.readLine().equals("2")) {
            System.out.println("게임 종료\n");
        }
    }

    public static void playGame(int digit) {
        List<Integer> pickedList = selectDigitNumbers(digit);

        String userInput = tryAnswer();
        while (!checkAnswer(userInput, pickedList)) {
            userInput = tryAnswer();
        }
    }

    public static List<Integer> selectDigitNumbers(int digit) {
        List<Integer> pickedList = new ArrayList<>();
        while (pickedList.size() < digit) {
            int pickedRandomNum = Randoms.pickNumberInRange(1, 9);
            if (pickedList.contains(pickedRandomNum)) {
                continue;
            }
            pickedList.add(pickedRandomNum);
        }
        return pickedList;
    }

    public static String tryAnswer() {
        System.out.println("세개의 숫자를 입력해주세요. : ");
        String userInput = Console.readLine();
        try {
            validateInput(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }

    public static void validateInput(String userInput) throws Exception {
        // 3자리 수가 아니거나, 숫자가 아니거나, 동일한 수가 있으면 에러
        boolean isDuplicate = Arrays.stream(userInput.split("")).distinct().count() != userInput.split("").length;
        boolean hasZero = userInput.contains("0");
        if (userInput.length() != 3 || isDuplicate || hasZero) {
            throw new Exception();
        }
    }

    public static boolean checkAnswer(String candidate, List<Integer> pickedList) {
        Map<String, Integer> resultMap = countNumbers(candidate, pickedList);
        printAnswer(resultMap);
        return resultMap.containsKey("strike") && resultMap.get("strike") == 3;
    }

    public static Map<String, Integer> countNumbers(String candidate, List<Integer> pickedList) {
        Map<String, Integer> resultMap = new HashMap<>();
        List<Integer> list = Arrays.stream(candidate.split("")).map(Integer::parseInt).toList();
        long sameNumbersCount = list.stream().filter(l -> pickedList.stream()
                .anyMatch(Predicate.isEqual(l))).count();
        long strike = IntStream.range(0, DIGIT)
                .filter(i -> pickedList.get(i).equals(list.get(i)))
                .count();
        resultMap.put("ball", (int) (sameNumbersCount - strike));
        resultMap.put("strike", (int) strike);
        return resultMap;

    }


    public static void printAnswer(Map<String, Integer> map) {
        if (map.get("strike") == 0 && map.get("ball") == 0) {
            System.out.println("낫싱");
            return;
        }
        String strike = map.get("strike") + "스트라이크";
        String ball = map.get("ball") + "볼";

        System.out.println(ball + " " + strike);
    }
}
