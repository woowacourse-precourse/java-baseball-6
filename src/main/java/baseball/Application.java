package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

enum Script {
    START("숫자 야구 게임을 시작합니다\n"),
    INPUT("숫자를 입력해주세요: "),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    private final String label;

    Script(String label) {
        this.label = label;
    }

    public void print() {
        System.out.print(label);
    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
    }

    public static void startGame() {
        List<Integer> computer = generateRandomNumberList();
        List<Integer> user = generateRandomNumberList();
        String input = new String();
        Boolean result;

        Script.START.print();

        while (true) {
            Script.INPUT.print();
            user = checkValidation(Console.readLine());
            result = matchNumber(computer, user);
            if(result && Console.readLine().equals("2")) {
                break;
            }
        }
    }

    public static List<Integer> generateRandomNumberList() {
        List<Integer> numArray = new ArrayList<>();
        while (numArray.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numArray.contains(randomNumber)) {
                numArray.add(randomNumber);
            }
        }
        return numArray;
    }

    public static List<Integer> checkValidation(String input) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        List<Integer> result = new ArrayList<>();

        if (input.length() != 3) {
            throw illegalArgumentException;
        }

        for(int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (!Character.isDigit(character)) {
                throw illegalArgumentException;
            }

            if (character == '0') {
                throw illegalArgumentException;
            }

            int parsed = Integer.parseInt(String.valueOf(character));

            if (result.contains(parsed)) {
                throw illegalArgumentException;
            }

            result.add(parsed);
        }

        return result;
    }

    public static Boolean matchNumber(List<Integer> computer, List<Integer> user) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        result.put("Strike", 0);
        result.put("Ball", 0);
        result.put("Miss", 0);

        for(int i = 0; i < user.size(); i++) {
            if(computer.get(i) == user.get(i)) {
                result.put("Strike", result.get("Strike")+1);
                continue;
            }

            if(computer.contains(user.get(i))) {
                result.put("Ball", result.get("Ball")+1);
                continue;
            }

            result.put("Miss", result.get("Miss")+1);
        }

        return analyzeResult(result);
    }

    public static Boolean analyzeResult(HashMap<String, Integer> result) {
        Integer strike = result.get("Strike");
        Integer ball = result.get("Ball");
        Integer miss = result.get("Miss");

        if(strike == 3) {
            System.out.println("3스트라이크");
            Script.END.print();
            Script.RESTART.print();
            return true;
        }

        if(miss == 3) {
            System.out.println("낫싱");
            return false;
        }

        if(ball != 0 && strike != 0) {
            System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
            return false;
        }

        if(ball != 0) {
            System.out.println(String.format("%d볼", ball));
            return false;
        }

        if(strike != 0) {
            System.out.println(String.format("%d스트라이크", strike));
            return false;
        }

        return false;
    }

}