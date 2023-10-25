package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean replay = true;
        while(replay) {
            replay = newGame();
        }
    }

    private static boolean newGame() {
        List<Integer> numberComputer = randomNumberComputer();

        while(true) {
            List<Integer> numberUser = inputNumberUser();
            System.out.println(numberComputer);
            System.out.println(numberUser);
            if(numberResult(numberComputer,numberUser)) {
                return endGameInput();
            }
        }
    }

    private static boolean endGameInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        Pattern pattern = Pattern.compile("[1-2]");
        Matcher matcher = pattern.matcher(userInput);

        if(!matcher.matches()) {
            throw new IllegalArgumentException("[1-2] 사이의 한자리 값이 아닙니다.");
        } else if(userInput.equals("1")) {
            return true;
        } else {
            return false;
        }
    }
    private static List randomNumberComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List inputNumberUser() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        Pattern pattern = Pattern.compile("[1-9][1-9][1-9]");
        Matcher matcher = pattern.matcher(userInput);

        if(!matcher.matches() || userInput.isEmpty()) {
            throw new IllegalArgumentException("각 자리가 [1-9]인 세자리 숫자가 아닙니다.");
        }

        List<Integer> user  = new ArrayList<>();
        for(int i = 0; i < userInput.length(); i++) {
            if(!user.contains((int)userInput.charAt(i) - 48)) {
                user.add((int) userInput.charAt(i) - 48);
            } else {
                throw new IllegalArgumentException("각 자리 중 서로 같은 수가 있습니다.");
            }
        }
        return user;
    }

    private static boolean numberResult(List<Integer> numberComputer, List<Integer> numberUser) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < numberComputer.size(); i++) {
            if(numberComputer.get(i) == numberUser.get(i)) {
                strike++;
            } else if(numberComputer.contains(numberUser.get(i))) {
                ball++;
            }
        }

        if(strike == 3) {
            System.out.println(strike+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else if(ball > 0 && strike > 0) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike+"스트라이크");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball+"볼");
        } else {
            System.out.println("낫싱");
        }

        return false;
    }

}