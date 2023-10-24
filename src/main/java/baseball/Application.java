package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String cond;
        do {
            cond = doBaseball();
        } while (cond.equals("1"));
    }
    public static String  doBaseball() {
        List<Integer> computerNumber = makeComputerNumber();

        while(true) {
            List<Integer> playerNumber = scanPlayerNumber();
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < playerNumber.size(); i++) {
                for (int j = 0; j < computerNumber.size(); j++) {
                    if (playerNumber.get(i).equals(computerNumber.get(j))) {
                        if (i == j) {
                            strike++;
                            continue;
                        }
                        ball++;
                    }
                }
            }
            if (strike + ball == 0) {
                System.out.println("낫싱");
            } else {
                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String cond = Console.readLine();
                    if (!cond.matches("^[1-2]*$")) {
                        throw new IllegalArgumentException();
                    }
                    return cond;
                } else if (ball > 0 && strike > 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if (ball > 0) {
                    System.out.println(ball + "볼");
                } else if (strike > 0) {
                    System.out.println(strike + "스트라이크");
                }

            }
        }
    }

    public static List<Integer> makeComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> scanPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if(!input.matches("^[1-9]*$")){
            throw new IllegalArgumentException();
        }

        List<Integer> player = Arrays.stream(input.split(""))
        .mapToInt(Integer::parseInt)
        .boxed()
        .collect(Collectors.toList());

        // 중복 숫자 존재시 OR 3자리를 다 입력하지 않았을 시
        if (player.stream().distinct().count() != 3 || player.size() != 3) {
            throw new IllegalArgumentException();
        }

        return player;
    }
}
