package baseball;

import java.util.HashSet;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static int ballCount(int[] inputIntegerArray, int[] answerIntegerArray) {
        int sum = 0;

        HashSet<Integer> ballHashSet = new HashSet<>(3);


        for (int i = 0; i < answerIntegerArray.length; i++) {
            if (inputIntegerArray[i] == answerIntegerArray[i]) {
                continue;
            }
            else {
                for (int j = 0; j < answerIntegerArray.length; j++) {
                    if ((inputIntegerArray[i] == answerIntegerArray[j]) && (i != j)) {
                        ballHashSet.add(inputIntegerArray[i]);
                        continue;
                    }
                }
            }
        }

        sum = ballHashSet.size();

        return sum;
    }

    public static int strikeCount(int[] inputIntegerArray,int[] answerIntegerArray) {
        int sum = 0;

        for (int i = 0; i < answerIntegerArray.length; i++) {
            if (inputIntegerArray[i] == answerIntegerArray[i]) {
                sum += 1;
            }
        }

        return sum;
    }

    public static int[] inputParsingToIntArray(String input) {
        int[] intArray = new int[input.length()];

        for(int i = 0; i < input.length(); i++){
            intArray[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        return intArray;
    }

    public static boolean inputValidator(String input) {
        boolean result = true;
        int[] intArray = new int[3];
        HashSet<Integer> intArrayHashSet = new HashSet<>(3);

        if (input.length() != 3) {
            result = false;
        }

        try {
            intArray = inputParsingToIntArray(input);
        }
        catch (NumberFormatException event) {
            result = false;
        }

        for (int i = 0; i < intArray.length; i++) {
            intArrayHashSet.add(intArray[i]);
        }

        if (intArrayHashSet.size() != 3) {
            result = false;
        }

        return result;
    }

    public static int[] answerInitializerOld() {
        // 해당 방법으로 진행시 Test에 필요한 난수를 배열에 넣지 못하므로 사용하지 않는다.
        ArrayList<Integer> answerArrayList = new ArrayList<>(9);
        int[] answer = new int[3];

        for (int i = 1; i <= 9; i++) {
            answerArrayList.add(i);
        }

        for (int i = 0; i < answer.length; i++) {
            int tempIndex = Randoms.pickNumberInRange(0,answerArrayList.size()-1);
            int tempValue = answerArrayList.get(tempIndex);

            answer[i] = tempValue;
            answerArrayList.remove(tempIndex);
        }

        return answer;
    }

    public static int[] answerInitializer() {
        ArrayList<Integer> answerArrayList = new ArrayList<>();
        int[] answer = new int[3];

        while (answerArrayList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerArrayList.contains(randomNumber)) {
                answerArrayList.add(randomNumber);
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerArrayList.get(i);
        }

        return answer;
    }

    public static int[] compareLogic(int[] inputIntegerArray,int[] answerIntegerArray) {
        int[] result = new int[3];

        result[0] = ballCount(inputIntegerArray, answerIntegerArray);
        result[1] = strikeCount(inputIntegerArray, answerIntegerArray);
        result[2] = (result[1] == 3) ? 1 : 0;

        return result;
    }

    public static String inputLogic() {
        String input = Console.readLine();

        return input;
    }

    public static void messagePrintingLogic(int[] resultArray) {
        if (resultArray[2] == 0) {
            if ((resultArray[0] == 0) && (resultArray[1] == 0)) {
                System.out.println("낫싱");
            }
            else if ((resultArray[0] > 0) && (resultArray[1] == 0)) {
                System.out.printf("%d볼\n", resultArray[0]);
            }
            else if ((resultArray[0] == 0) && (resultArray[1] > 0)) {
                System.out.printf("%d스트라이크\n", resultArray[1]);
            }
            else if ((resultArray[0] > 0) && (resultArray[1] > 0)) {
                System.out.printf("%d볼 %d스트라이크\n", resultArray[0], resultArray[1]);
            }
        }
        else {
            System.out.printf("%d스트라이크\n", resultArray[1]);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static void restartLogic(int[] resultArray, int[] answerArray) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String tempInput = inputLogic();

        if (tempInput.equals("1")) {
            int[] tempAnswerArray = answerInitializer();

            for (int i = 0; i < answerArray.length; i++) {
                answerArray[i] = tempAnswerArray[i];
            }

            resultArray[2] = 0;
        }
        else {
            if (tempInput.equals("2")) {

            }
            else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int[] answer = answerInitializer();
        int[] result = new int[3];

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (result[2] != 1) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = inputLogic();

            if (!inputValidator(input)) {
                throw new IllegalArgumentException();
            }

            int[] inputArray = inputParsingToIntArray(input);

            result = compareLogic(inputArray,answer);

            messagePrintingLogic(result);

            if (result[2] == 1) {
                restartLogic(result, answer);
            }
        }
    }
}
