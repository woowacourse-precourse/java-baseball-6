package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        try {
            playBaseballGame();
        } catch (IllegalArgumentException e) {
        }
    }

    public static void playBaseballGame() {
        boolean isOver = false;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!isOver) {
            List<Character> answer = answer();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String str = Console.readLine();
                List<Character> userGuess = guess(str);

                int[] result = count(userGuess, answer);
                String output = output(result);
                System.out.println(output);

                if (result[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String playAgainInput = Console.readLine();

            if (playAgainInput.equals("2")) {
                isOver = true;
            } else if (playAgainInput.equals("1")) {
                isOver = false;
            } else {
                throw new IllegalArgumentException("1이나 2의 숫자를 입력하시오.");
            }
        }
    }

    public static List<Character> answer(){
        List<Character> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(Character.forDigit(randomNumber,10))) {
                computer.add(Character.forDigit(randomNumber,10));
            }
        }
        return computer;
    }

    public static List<Character> guess(String str) {
        List<Character> user = new ArrayList<>();


        //길이 3확인
        if (str.length() != 3) {
            throw new IllegalArgumentException("3자리를 입력하시오");
        }
        //전부 숫자인지 확인
        for (int i = 0; i < 3; i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("숫자만 입력하시오");
            }
        }
        //중복있는지 확인
        if (str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(0) == str.charAt(2)) {

            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다");
        }
        //1~9숫자인지 확인
        for (int i = 0; i < 3; i++) {
            char ch = str.charAt(i);
            if (ch == '0') {
                throw new IllegalArgumentException("1~9숫자를 입력하시오.");
            }
        }

        for (int i = 0; i < 3; i++) {
            user.add(str.toCharArray()[i]);
        }

        return user;
    }

    public static int[] count(List<Character> user, List<Character> computer) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            if (user.get(i).equals(computer.get(i))) {
                result[1]++;
            } else {
                if (computer.contains(user.get(i))) {
                    result[0]++;
                }
            }
        }
        return result;
    }

    public static String output(int[] result) {
        String answer;
        if (result[0] == 0 && result[1] == 0) {
            answer = "낫싱";
        } else if (result[0] == 0) {
            answer = result[1]+"스트라이크";
        } else if (result[1] == 0) {
            answer = result[0] + "볼";
        } else {
            answer = result[0] + "볼 " + result[1] + "스트라이크";
        }
        return answer;
    }
}