package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    final static int length = 3;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computer = new ArrayList<>();

            while (computer.size() < length) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            try {
                while (true) {
                    map = new HashMap<>();
                    System.out.print("숫자를 입력해주세요 : ");

                    String inputNumber = br.readLine();

                    if (inputNumber.length() != length) {
                        throw new IllegalArgumentException();
                    }

                    for (int i = 0; i < length; i++) {
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

                    int strike = 0;
                    int ball = 0;

                    for (int i = 0; i < length; i++) {
                        int cur = inputNumber.charAt(i) - '0';

                        if (computer.get(i) == cur) {
                            strike++;
                        } else if (computer.contains(cur)) {
                            ball++;
                        }
                    }

                    if (strike == length) {
                        System.out.println("3스트라이크");
                        System.out.println(length + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
                }

                String isExit = br.readLine();
                if (isExit.length() != 1) {
                    throw new IllegalArgumentException();
                }

                if (isExit.charAt(0)  == '1' || isExit.charAt(0) == '2') {
                    if (isExit.charAt(0) - '0' == 2) {
                        break;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
    }
}
