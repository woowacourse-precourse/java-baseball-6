package baseball;

import java.util.ArrayList;
import java.util.List;

public class Play {

    public void game(String input) {

        List<Integer> computer = new Computer().anotherNumber();
        String result;
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> player = change(input);

            result = compare(player, computer);
            if (result.equals("3스트라이크")) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            System.out.println(result);

        }
    }

    //String형으로 들어온 input값 List<Integer>로 형변환
    public List<Integer> change(String input) {

        List<Integer> inputNumber = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            int number = Integer.parseInt(String.valueOf(input.charAt(i)));
            inputNumber.add(number);
        }
        return inputNumber;
    }


    // input으로 들어오는 값 전체 에러 확인
    public void inputCheck(String input) {
        List<Character> inputNumber = new ArrayList<>();
        for (int i = 0; i < inputNumber.size(); i++) {
            char wordNumber = input.charAt(i);
            if (!inputNumber.contains(wordNumber)) {
                inputNumber.add(wordNumber);
            }
        }
        try {
            if (input.length() != 3 || !numberCheck(input)) {
                throw new IllegalArgumentException();
            } else if (inputNumber.size() != input.length()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private boolean numberCheck(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= '1' && input.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    // 새로운 게임 시작하느냐 결정, 중간 1, 2이외 다른값 예외처리


    // 컴퓨터(상대방) 나의 숫자(input) 비교
    public String compare(List<Integer> player, List<Integer> answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < player.size(); i++) {
            int now = player.get(i);
            if (answer.get(i) == now) {
                strike++;
            } else if (answer.contains(now)) {
                ball++;
            }
        }
        if (strike == 0 && ball == 0) {
            return ("낫싱");
        } else if (strike == 0) {
            return (ball + "볼");
        } else if (ball == 0) {
            return (strike + "스트라이크");
        } else {
            return (ball + "볼 " + strike + "스트라이크");
        }
    }
}
