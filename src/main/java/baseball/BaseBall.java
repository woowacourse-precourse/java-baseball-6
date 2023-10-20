package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseBall {
    private final int LENGTH;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<Integer> computer;
    private Map<String, Integer> map;

    public BaseBall(int length) {
        this.LENGTH = length;
    }

    public BaseBall() {
        this.LENGTH = 3;
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        createComputerNumber();

        while (true) {
            int strike = 0;
            int ball = 0;
            map = new HashMap<>();

            try {
                String inputNumber = br.readLine();

                if (inputNumber == null) {
                    throw new IllegalArgumentException();
                }

                if (inputNumber.length() != LENGTH) {
                    throw new IllegalArgumentException();
                }

                for (int i = 0; i < LENGTH; i++) {
                    char cur = inputNumber.charAt(i);
                    if (cur < '1' || cur > '9') {
                        throw new IllegalArgumentException();
                    } else {
                        if (map.containsKey(String.valueOf(cur))) {
                            throw new IllegalArgumentException();
                        } else {
                            map.put(String.valueOf(cur), 1);
                        }
                    }
                }

                for (int i = 0; i < LENGTH; i++) {
                    int cur = inputNumber.charAt(i) - '0';
                    if (computer.get(i) == cur) {
                        strike++;
                    } else if (computer.contains(cur)) {
                        ball++;
                    }
                }

                if (strike == LENGTH) {
                    System.out.println(strike + "스트라이크");
                    System.out.println(LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    break;
                }

                if (strike == 0) {
                    if (ball == 0) {
                        System.out.println("낫싱");
                    } else {
                        System.out.println(ball + "볼");
                    }
                } else {
                    if (ball == 0) {
                        System.out.println(strike + "스트라이크");
                    } else {
                        System.out.println(ball + "볼 " + strike + "스트라이크");
                    }
                }
            } catch (IOException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    public boolean isTerminate() {
        try {
            String inputNumber = br.readLine();

            if (inputNumber == null) {
                throw new IllegalArgumentException();
            }

            if (inputNumber.length() != 1) {
                throw new IllegalArgumentException();
            }

            if (inputNumber.charAt(0)  == '1' || inputNumber.charAt(0) == '2') {
                if (inputNumber.charAt(0) - '0' == 2) {
                    return true;
                } else {
                    return false;
                }
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    private void createComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
