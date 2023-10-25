package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameFunction {
    private static final int[] userNum = new int[3];
    private static final int[] compNum = new int[3];
    static int strike = 0;
    static int ball = 0;

    public static List<Integer> createRandomnumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static void getUserNumber(String num) {
        for(int i = 0; i < 3; i ++) {
            userNum[i] = Character.getNumericValue(num.charAt(i));
        }
    }
    public static void getComputerNumber() {
        List<Integer> computerNum = createRandomnumber();
        for(int i = 0; i < 3; i ++) {
            compNum[i] = computerNum.get(i);
        }
    }

    public static void gametry() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getComputerNumber();
        while(true) {
                strike = 0;
                ball = 0;
                System.out.print("숫자를 입력해주세요 : ");
            String num = null;
            try {
                num = br.readLine();
            } catch (IOException e) {
                throw new IllegalArgumentException("잘못된 값 입력");            }
            if (num.length() != 3) {
                    throw new IllegalArgumentException("잘못된 값 입력");
                }
                getUserNumber(num);
//                System.out.println("computer num : " + Arrays.toString(compNum));
//                System.out.println("user num : " + Arrays.toString(userNum));
                for (int i = 0; i < userNum.length; i++) {
                    for (int j = 0; j < compNum.length; j++) {
                        if (userNum[i] == compNum[j]) {
                            if (i == j) {
                                strike++;
                            } else {
                                ball++;
                            }
                        }
                    }
                }
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike == 0) {
                    System.out.println(ball + "볼");
                } else if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String quitcheck = null;
                    try {
                        quitcheck = br.readLine();
                    } catch (IOException e) {
                        throw new IllegalArgumentException("잘못된 값 입력");
                    }
                    if (quitcheck.equals("1")) {
                        getComputerNumber();
//                        continue;
                    }
                    else if (quitcheck.equals("2")) {
                        System.out.println("게임종료");
                        break;
                    }
                    else {
                        throw new IllegalArgumentException();
                    }
                    }
                }
            }
        }