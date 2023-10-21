package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    int start = 1;
    List<Integer> inputNumberList = new ArrayList<>();
    String [] inputs = new String[3];

    public void play() {
        while(start != 2) {
            System.out.print("숫자를 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);

            try {
                String inputNumber = scanner.nextLine();
                inputs = inputNumber.split("");

                for(int i=0; i<3; i++) {
                    inputNumberList.add(i, Integer.parseInt(inputs[i]));
                }


            } catch (IllegalArgumentException e) {
                throw new IllegalStateException("입력값이 잘못되었습니다. 게임을 종료합니다.");
            }

        }
    }
}
