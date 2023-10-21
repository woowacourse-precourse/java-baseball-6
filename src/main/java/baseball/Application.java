package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        String continueBaseball = "1";

        while (continueBaseball.equals("1")) {
            startBaseball();
            continueBaseball = scanner.next();
        }
    }

    public static void startBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answerNumberList = createBaseballAnswerNumberList();
        playBaseball(answerNumberList);
    }

    public static List<Integer> createBaseballAnswerNumberList() {
        List<Integer> answerNumberList = new ArrayList<>();
        while (answerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }
        return answerNumberList;
    }

    public static void playBaseball(List<Integer> answerNumberList) {
        while (true) {
            List<Integer> inputNumberList = inputBaseballNumberList();
            int[] baseballCount = checkBaseballResult(answerNumberList, inputNumberList);
            printBaseballResult(baseballCount);
            if (baseballCount[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static List<Integer> inputBaseballNumberList() {
        //TODO: 입력 라이브러리 변경
        String inputString = new Scanner(System.in).next();
        validateBaseballNumbers(inputString);
        return parseIntegerList(inputString);
    }

    public static void validateBaseballNumbers(String inputString) {
        boolean isValid = true;
        String message = "";
        if (inputString.length() != 3) {
            isValid = false;
            message = "3자리 숫자를 입력해야 합니다.";
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            char c = inputString.charAt(i);
            if (c < '1' || c > '9') {
                isValid = false;
                message = "각 자리는 1~9사이의 숫자로 입력해야 합니다.";
            }
            set.add(c);
        }

        if (set.size() != 3) {
            isValid = false;
            message = "서로 다른 숫자를 입력해야 합니다.";
        }

        if (!isValid) {
            throw new IllegalArgumentException(message);
        }
    }

    public static List<Integer> parseIntegerList(String inputString) {
        List<Integer> baseballNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            baseballNumberList.add(inputString.charAt(i) - '0');
        }

        return baseballNumberList;
    }

    public static int[] checkBaseballResult(List<Integer> answerNumberList, List<Integer> inputNumberList) {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean isCorrect = answerNumberList.get(i) == inputNumberList.get(j);
                if(isCorrect) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        return new int[]{strike, ball};
    }

    public static void printBaseballResult(int[] baseballCount) {
        if(baseballCount[0] == 0 && baseballCount[1] == 0) {
            System.out.println("낫싱");
        }
        else if(baseballCount[0] > 0 || baseballCount[1] > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            if(baseballCount[1] != 0) {
                stringBuilder.append(baseballCount[1]).append("볼 ");
            }
            if(baseballCount[0] != 0) {
                stringBuilder.append(baseballCount[0]).append("스트라이크");
            }
            System.out.println(stringBuilder.toString().trim());
        }
    }
}
