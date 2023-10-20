package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {

        Boolean restart = true;
        Boolean game = true;

        Computer computer = new Computer();

        System.out.println(Alert.GAME_START);

        while (restart) {

            ArrayList<Integer> computerNumber = computer.getRandomNumber();

            game = true;

            while (game) {
                System.out.print(Alert.INPUT_START);
                String inputNum = Console.readLine();

                onlyNumCheck(inputNum);
                lengthCheck(inputNum);

                int inputNumInt = Integer.parseInt(inputNum);

                int a = inputNumInt / 100;
                int b = inputNumInt / 10 % 10;
                int c = inputNumInt % 100 % 10;

                int strike = 0;
                int nothing = 0;

                ArrayList<Integer> userInputArray = new ArrayList<Integer>(Arrays.asList(a, b, c));

                duplicationCheck(userInputArray);

                for (int i = 0; i < 3; i++) {
                    if (!computerNumber.contains(userInputArray.get(i))) {
                        // 숫자가 존재 하지 않으면 낫씽
                        nothing += 1;
                    } else if (computerNumber.get(i) == userInputArray.get(i)) {
                        // 숫자가 존재하고 위치가 같으면 strike
                        strike += 1;
                    }
                }

                int ball = 3 - strike - nothing;

                if (nothing != 3) {
                    if (strike == 3) {
                        game = false;
                        System.out.println(strike + Alert.STRIKE);
                        System.out.println(Alert.GAME_FINISH);
                        System.out.println(Alert.RESTART);
                        String IsReGame = Console.readLine();
                        restart = (Integer.parseInt(IsReGame) == 1) ? true : false;
                    } else if (ball > 0 && strike == 0) {
                        System.out.println(ball + Alert.BALL);
                    } else if (ball == 0 && strike > 0) {
                        System.out.println(strike + Alert.STRIKE);
                    } else if (strike > 0 && ball > 0) {
                        System.out.println(ball + Alert.BALL + " " + strike + Alert.STRIKE);
                    }
                } else {
                    System.out.println(Alert.NOTHING);
                }
            }
        }
    }

    private static void onlyNumCheck(String inputNum) {
        final Pattern compile = Pattern.compile("[0-9]+");
        final Matcher matcher = compile.matcher(inputNum);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void lengthCheck(String inputNum) {
        if (inputNum.length() > 3 || inputNum.length() < 3) {
            throw new IllegalArgumentException("길이가 4글자 이상 입니다.");
        }
    }

    private static void duplicationCheck(ArrayList<Integer> userInputArray) {
        List<Integer> errorCheck = new ArrayList<Integer>();
        for (int num : userInputArray) {
            if (!errorCheck.contains(num)) {
                errorCheck.add(num);
            } else {
                throw new IllegalArgumentException("중복된 숫자 발생");
            }
        }
    }
}
