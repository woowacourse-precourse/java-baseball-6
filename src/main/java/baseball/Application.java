package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        int gameStartFlag = 1;

        while(gameStartFlag == 1) {

            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> answer = setAnswer();

            boolean isProcessingGame = true;

            while(isProcessingGame) {

                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                if(!inputValidation(input))
                    throw new IllegalArgumentException();

                int[] inputResultArray = checkAnswer(answer, conversionNumStringToList(input));

                String inputResultString = "";

                if(inputResultArray[1] > 0)
                    inputResultString += String.format("%d볼 ", inputResultArray[1]);
                if(inputResultArray[0] > 0)
                    inputResultString += String.format("%d스트라이크", inputResultArray[0]);

                if(inputResultString.isBlank())
                    inputResultString = "낫싱";

                System.out.println(inputResultString);

                if(inputResultArray[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    isProcessingGame = false;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String finishInput = Console.readLine();

            if(!finishInputValidation(finishInput))
                throw new IllegalArgumentException();

            gameStartFlag = Integer.parseInt(finishInput);
        }
    }

    public static List<Integer> setAnswer() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }

    public static int[] checkAnswer(List<Integer> answer, List<Integer> input) {
        int strike = 0, ball = 0;

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                if(Objects.equals(answer.get(i), input.get(j))) {
                    if(i == j) strike++;
                    else ball++;
                }
            }
        }

        return new int[]{strike, ball};
    }

    public static boolean inputValidation(String input) {
        Pattern pattern = Pattern.compile("^(?!\\d*(\\d)\\d*\\1\\d*\\1)\\d{3}");
        return pattern.matcher(input).matches();
    }

    public static boolean finishInputValidation(String input) {
        return Objects.equals(input, "1") || Objects.equals(input, "2");
    }

    public static List<Integer> conversionNumStringToList(String input) {
        List<Integer> result = new ArrayList<>();
        for(char c : input.toCharArray()) {
            result.add(Character.getNumericValue(c));
        }
        return result;
    }
}
