package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.logging.Logger;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            List<Integer> computer = new ArrayList<>(); // computer 숫자 (정답)
            List<Integer> user = new ArrayList<>(); // computer 숫자 (정답)
            String userInput = "";
            int strike = 0;
            int ball = 0;
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            while (true) {

                System.out.print("숫자를 입력해주세요 : ");
                userInput = Console.readLine();
                if (userInput.length() != 3){
                    throw new IllegalArgumentException("제대로 된 값을 입력해주세요.");
                }
                try {
                    int i = Integer.parseInt(userInput);
                }catch (NumberFormatException e){
                    throw new IllegalArgumentException("숫자를 입력해주세요.");
                }
                user = Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
                if (user.size() < 3) {
                    throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
                }
                if (user.get(0).equals(user.get(1)) || user.get(1).equals(user.get(2)) || user.get(0).equals(user.get(2))) {
                    throw new IllegalArgumentException("중복된 숫자입니다.");
                }

                for (int i = 0; i < computer.size(); i++) {
                    for (int j = 0; j < user.size(); j++) {
                        if (computer.get(i).equals(user.get(j)) && i == j) {
                            strike++;
                        } else if (computer.get(i).equals(user.get(j)) && i != j) {
                            ball++;
                        }
                    }
                }

                if (ball>0 && strike > 0){
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }else if (ball>0){
                    System.out.println(ball + "볼");
                }else if (strike>0){
                    System.out.println(strike + "스트라이크");
                }else {
                    System.out.println("낫싱");
                }
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                strike = 0;
                ball = 0;
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (Console.readLine().equals("2")) {
                return;
            }
        }
    }
}
