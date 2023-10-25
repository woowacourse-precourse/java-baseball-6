package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        RandomNumber rn = new RandomNumber();
        Scanner sc = new Scanner(System.in);
        String inputNum = "";
        int ball = 0;
        int strike = 0;
        String randomNum ="";

        try {
            while (true) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                randomNum = String.valueOf(rn.makeRandomNum());

                while (true) {
                    //System.out.println(randomNum);
                    inputNum = sc.next();
                    sc.nextLine();
                    if (!inputNum.matches("^[1-9]*$")) {
                        throw new IllegalArgumentException("입력한 숫자는 1-9 사이의 숫자로 이루어져야 합니다.");
                    }

                    if (inputNum.length() != 3) {
                        throw new IllegalArgumentException("입력한 숫자의 길이는 3이어야 합니다.");
                    }

                    //inputNum 중복 숫자 check
//                    for(int k=0; k<inputNum.length(); k++){
//
//                    }

                    strike=0;
                    ball=0;

                    for (int j = 0; j < inputNum.length(); j++) {
                        char rnNum = randomNum.charAt(j);
                        char ipNum = inputNum.charAt(j);
                        if (rnNum == ipNum) {
                            strike++;
                        } else if (randomNum.contains(String.valueOf(ipNum))) {
                            ball++;
                        }
                    }


                    if (strike > 0 && ball > 0) {
                        System.out.println(strike + "스트라이크 " + ball + "볼");
                    }  else if (ball>0) {
                        System.out.println(ball +"볼");
                    } else if (strike == 3) {
                        System.out.println("3스트라이크");
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    } else if (strike>0) {
                        System.out.println(strike + "스트라이크");
                    } else {
                        System.out.println("낫싱");
                    }

                }
                // 사용자에게 게임을 종료할지 한 판 더 할지 물어봅니다.
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {

                } else if (choice == 2) {
                    return; // 게임을 종료합니다.
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
            System.out.println("게임을 종료합니다.");
        } finally {
            sc.close();
        }
    }
}