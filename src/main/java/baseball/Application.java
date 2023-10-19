package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {

    private static final Pattern inputValidator = Pattern.compile("^([1-9]{3})$");

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while(true) {
            NumberBaseball game = new NumberBaseball();
            System.out.println("숫자 야구 게임을 시작합니다.");

            while(true) {
                System.out.print("숫자를 입력해 주세요 : ");
                String inputString = Console.readLine();

                int[] userNumber = parseInput(inputString);

                GuessResult guessResult = game.countResult(userNumber);

                System.out.println(getResultMsg(guessResult));

                if(guessResult.strikes() == 3) {
                    System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
        }
    }

    public static String getResultMsg(GuessResult result) {
        if(result.balls() == 0 && result.strikes() == 0) {
            return "낫싱";
        }

        String resultMsg = "";
        if(result.balls() > 0) {
            resultMsg += (result.strikes() + "스트라이크");
        }
        if(result.balls() > 0 && result.strikes() > 0) {
            resultMsg += " ";
        }
        if(result.strikes() > 0) {
            resultMsg += (result.strikes() + "스트라이크");
        }

        return resultMsg;
    }

    public static int[] parseInput(String inputString) throws IllegalArgumentException {
        if(!inputValidator.matcher(inputString).matches()) {
            throw new IllegalArgumentException();
        }

        int[] userNumber = (int[])Arrays.stream(inputString.split("")).mapToInt(
                element -> Integer.parseInt(element)
        ).toArray();

        if(doContainDupNumber(userNumber)) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

    public static boolean doContainDupNumber(int[] input) {
        boolean[] numberFlag = new boolean[10];
        for(int i = 0; i < 3; i++) {
            if(numberFlag[input[i]]) {
                return true;
            }
            numberFlag[input[i]] = true;
        }
        return false;
    }
}
