package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {

            int targetValue = Randoms.pickNumberInRange(0, 999);

            //System.out.println(targetValue);

            CheckResult checkResult = new CheckResult();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                try {

                    String userGuess = Console.readLine();

                    if (Integer.parseInt(userGuess) < 0) {
                        throw new IllegalArgumentException("error");
                    }

                    if (Integer.parseInt(userGuess) > 999) {
                        throw new IllegalArgumentException("error");
                    }

                    if (checkResult.isGuessCorrect(userGuess, targetValue)) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        String userCommand = Console.readLine();
                        if (userCommand.equals("1")) {
                            break;
                        } else if (userCommand.equals("2")) {
                            return;
                        } else {
                            return;
                        }
                    }
                } catch (IllegalArgumentException e) {
                    return;
                } catch (Exception e) {
                    return;
                }
            }


        }
    }
}
