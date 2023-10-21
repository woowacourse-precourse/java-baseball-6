package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Character> computer = new ArrayList<>();
        List<Character> user = new ArrayList<>();
        int strike = 0;
        int ball = 0;
        String result = "";
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            computer.clear();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add((char) (randomNumber + '0'));
                }
            }
            computer.forEach(character -> System.out.print(character));
            System.out.println(); // 줄바꿈 추가

            while (true) {
                strike = 0;
                ball = 0;
                user.clear();

                System.out.print("숫자를 입력해주세요 : ");
                String userInput = readLine();

                if (userInput.length() != 3) {
                    throw new IllegalArgumentException("세 개의 숫자를 입력해야 합니다.");
                }

                for (char c : userInput.toCharArray()) {
                    if (c < '0' || c > '9') {
                        throw new IllegalArgumentException("잘못된 입력값 입니다.");
                    }
                    if (user.contains(c)) {
                        throw new IllegalArgumentException("잘못된 입력값 입니다.");
                    }
                    user.add(c);
                }

                for (int i = 0; i < user.size(); i++) {
                    int index = computer.indexOf(user.get(i));
                    if (index > -1) {
                        if (index == i) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }

                if (ball > 0) {
                    result += ball + "볼 ";
                }
                if (strike > 0) {
                    result += strike + "스트라이크";
                }
                if (strike == 0 && ball == 0) {
                    result = "낫싱";
                }

                System.out.println(result);
                result = "";

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String restart = readLine();
                    if (restart.equals("1")) {
                        break;
                    } else if (restart.equals("2")) {
                        return;
                    } else {
                        throw new IllegalArgumentException("잘못된 입력값 입니다.");
                    }
                }
            }
        }
    }
}
