package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import javax.sound.midi.Soundbank;

public class BaseballGame {
    private final List<Integer> computer = new ArrayList<Integer>();

    public void run() {
        while (computer.size()<3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.print("Computer: ");
        computer.forEach(System.out::print);
        System.out.println();

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean haveToStop = false;
        while (!haveToStop) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            List<Integer> user = Arrays.stream(userInput.split(""))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();

            int strike = 0;
            int ball = 0;

            for (int i = 0; i < 3; i++) {
                if (computer.get(i) == user.get(i)) {
                    strike++;
                }
            }

            for (int i = 0; i < 3; i++) {
                int compareNumber = computer.get(i);
                if (user.contains(compareNumber)) {
                    if (i != user.indexOf(compareNumber)) {
                        ball++;
                    }
                }
            }

            System.out.println(ball + " 볼 " + strike + " 스트라이크");


            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String a = Console.readLine();
                if (Objects.equals(a, "2")) {
                    haveToStop = true;
                }
            }
        }
    }
}
