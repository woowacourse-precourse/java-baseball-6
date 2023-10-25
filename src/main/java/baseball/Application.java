package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private final BaseballService baseballService;
    public static String computer = "";

    public Application() {
        baseballService = new BaseballService();
    }

    public static void main(String[] args) throws IllegalArgumentException {
        Application app = new Application();
        String user = "";
        int repeat = 1;

        try {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> randomArr = app.baseballService.init();

            while (repeat == 1) {
                int strike = 0;
                int ball = 0;
                int nothing = 1;

                System.out.print("숫자를 입력해주세요 : ");

                user = app.baseballService.getStringInput();

                for (int i = 0; i < 3; i++) {
                    if (Character.getNumericValue(user.charAt(i)) == randomArr.get(i)) {
                        strike++;
                        nothing = 0;
                    } else {
                        for (int j = 0; j < 3; j++) {
                            if (i == j) {
                                continue;
                            }
                            if (Character.getNumericValue(user.charAt(i)) == randomArr.get(j)) {
                                ball++;
                                nothing = 0;
                            }
                        }
                    }
                }

                if (nothing == 1) {
                    System.out.println("낫싱");
                } else {
                    if (strike >= 3) {
                        System.out.println("3스트라이크");
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                        try {
                            repeat = app.baseballService.getIntInput();
                        } catch (IllegalArgumentException e) {
                            throw e;
                        }

                        if (repeat == 1) {
                            randomArr = app.baseballService.init();
                            continue;
                        } else {
                            break;
                        }
                    }
                    if (ball > 0) {
                        System.out.print(ball + "볼 ");
                    }
                    if (strike > 0 && strike < 3) {
                        System.out.print(strike + "스트라이크");
                    }
                    System.out.println("");
                }
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}