package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean reStart = true;

        while(reStart) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();

            //컴퓨터 랜덤 숫자 3개 받게 하는법
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            //사용자가 입력한 숫자를 저장할 배열
            List<Integer> user;

            int count = 1;
            while (count == 1) {
                user = new ArrayList<>();
                int ball = 0;
                int strike = 0;
                System.out.println("\n" + "숫자를 입력해주세요 : ");

                String input = Console.readLine();
                validateInput(input);

                for (char c : input.toCharArray()) {
                    user.add(Character.getNumericValue(c));
                }

                for (int i = 0; i < 3; i++) {
                    if (user.get(i).equals(computer.get(i))) {
                        strike++;
                    } else if (computer.contains(user.get(i))) {
                        ball++;
                    }
                }

                System.out.println(getResultMessage(ball, strike));

                if (strike == 3) {
                    count = 0;
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    reStart = reStartGame(); //게임 재시작 메소드 호출
                }
            }
        }
    }

    //결과 출력
    private static String getResultMessage(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else {
            return ball + "볼 " + strike +"스트라이크";
        }
    }

    //잘못된 숫자 검증 메소드
    private static void validateInput(String input) {
        if (input.length() > 3) {
            throw new IllegalArgumentException("입력값은 3자리를 넘을 수 없습니다.");
        }
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        if (hasDuplicatedDigits(input)) {
            throw new IllegalArgumentException("입력값에 숫자 3개가 중복되었습니다.");
        }
    }

    //입력한 각 자리 숫자가 중복되었을 경우 메소드
    private static boolean hasDuplicatedDigits(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }



    //게임 재시작 메소드
    private static boolean reStartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int flag = Integer.parseInt(Console.readLine());

        if(flag == 1) {
            return true;
        } else if(flag == 2)
            return false;
        else
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 1과 2만 입력 해주세요.");
    }
}
