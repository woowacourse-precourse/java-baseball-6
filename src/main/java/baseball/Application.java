package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;



public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            int[] num = new int[10];
            Arrays.fill(num, 0);
            boolean isGameEnd = false;

            List<Integer> computer = new ArrayList<>();
            List<Integer> you = new ArrayList<>();

            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            for (int i = 0; i < computer.size(); i++){
                num[computer.get(i)]++;
            }

            while(true) {

                int ballCount = 0;
                int strikeCount = 0;
                you.clear();

                System.out.print("숫자를 입력해주세요: ");
                String yourInput = readLine();

                if (yourInput.length() != 3){
                    throw new IllegalArgumentException();
                }

                for (int i = 0; i < 3; i++) {
                    you.add((int) yourInput.charAt(i) - 48);
                }

                for (int i = 0; i < you.size(); i++) {
                    if (num[you.get(i)] == 1) {
                        ballCount++;
                    }
                }

                for (int i = 0; i < you.size(); i++) {
                    if (you.get(i) == computer.get(i)) {
                        ballCount--;
                        strikeCount++;
                    }
                }

                if (ballCount == 0 && strikeCount == 0) {
                    System.out.println("낫싱");
                } else if (strikeCount == 3) {
                    System.out.println(strikeCount + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String gameEnd = readLine();
                    if (gameEnd.charAt(0) != '1' && gameEnd.charAt(0) != '2') {
                        throw new IllegalArgumentException();
                    }
                    else if (gameEnd.charAt(0) == '1'){
                        break;
                    }
                    else {
                        isGameEnd = true;
                        break;
                    }
                }
                else if (ballCount == 0) {
                    System.out.println(strikeCount + "스트라이크");
                }
                else if (strikeCount == 0) {
                    System.out.println(ballCount + "볼");
                }
                else {
                    System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                }
            }

            if (isGameEnd){
                break;
            }

        }
    }
}
