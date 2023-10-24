package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 사용할 변수
        int[] user = new int[3];
        int[] com = new int[3];

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {

            for(int i = 0; i < com.length; i++){
                com[i] = Randoms.pickNumberInRange(1, 9);
                for(int j=0;j<i;j++)
                {
                    if(com[i]==com[j])
                    {
                        i--;
                        break;
                    }
                }
            }

            while (true) {
                try {
                        System.out.print("숫자를 입력해주세요 : ");
                        String num = readLine();

                        if (num.length() > 3) {
                            throw new IllegalStateException("3자리의 수를 입력하세요!!");
                        } else if (num.contains("0")) {
                            throw new IllegalStateException("0을 입력할 수 없습니다!!");
                        } else {
                            user[0] = Integer.parseInt(num.substring(0, 1));
                            user[1] = Integer.parseInt(num.substring(1, 2));
                            user[2] = Integer.parseInt(num.substring(2, 3));
                        }

                        int ball = 0;
                        int strike = 0;
                        String notCount = "낫싱";

                        for (int i = 0; i < com.length; i++) {
                            for (int j = 0; j < user.length; j++) {
                                if (user[j] == com[i]) {
                                    if (j == i) {
                                        strike++;
                                    } else {
                                        ball++;
                                    }
                                }
                            }
                        }

                        if (strike >= 1 || ball >= 1) {
                            System.out.println(ball + "볼" + " " + strike + "스트라이크");
                        } else if (strike >= 1 && ball == 0) {
                            System.out.println(strike + "스트라이크");
                        } else if (ball >= 1 && strike == 0) {
                            System.out.println(ball + "볼");
                        } else {
                            System.out.println(notCount);
                        }

                        if (strike == 3) {
                            System.out.println("3개의 스트라이크를 모두 맞히셨습니다! 게임 종료");
                            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 :");
                            String isRestartOrEnd = readLine();
                            if (isRestartOrEnd.equals("1")) {
                                com[0]=0;
                                com[1]=0;
                                com[2]=0;
                                break;
                            } else if (isRestartOrEnd.equals("2")) {
                                System.out.println("게임이 종료되었습니다");
                                break;
                            } else {
                                throw new IllegalStateException("1,2만 입력하실 수 있습니다!");
                            }
                        }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

