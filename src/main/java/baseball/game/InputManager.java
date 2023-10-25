package baseball.game;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {

    public List<Integer> getBallNumber() {
        String num = Console.readLine();


        return validate(num);

    }

    private List<Integer> validate(String num) {
        Integer number=null;
        try {
            number = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 수를 입력했습니다.");
        }



        if (number < 111 || number > 999) {
            throw new IllegalArgumentException("잘못된 수를 입력했습니다.");

        }

        List<Integer> inputBall = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (inputBall.contains(number % 10)) {
                throw new IllegalArgumentException("잘못된 수를 입력했습니다.");
            } else {
                inputBall.add(number % 10);
            }
            number /= 10;
        }

        if (inputBall.contains(0)) {
            throw new IllegalArgumentException("잘못된 수를 입력했습니다.");
        }


        return inputBall;

    }

    public boolean checkNext() {
        String next = Console.readLine();

        return validateNext(next);


    }

    private boolean validateNext(String next) {
        Integer nextNum = Integer.parseInt(next);
        if (nextNum == 1) {
            return true;
        } else if (nextNum == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 수를 입력했습니다.");
        }


    }


}
