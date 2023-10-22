package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Play {
    public Boolean play() {
        int strike = 0;
        int ball = 0;
        String userNumber = "";

        String[] comRandomNumberArr = comNumber();
        /*for (int i = 0; i < 3; i++) {
            comRandomNumberArr[i] = String.valueOf(Randoms.pickNumberInRange(1,9));
            if (i == 1) {
                while (true) {
                    if (comRandomNumberArr[0].equals(comRandomNumberArr[i])) {
                        comRandomNumberArr[i] = String.valueOf(Randoms.pickNumberInRange(1,9));
                    } else {
                        break;
                    }
                }
            } else if (i == 2) {
                while (true) {
                    if (comRandomNumberArr[0].equals(comRandomNumberArr[i]) || comRandomNumberArr[1].equals(comRandomNumberArr[i])) {
                        comRandomNumberArr[i] = String.valueOf(Randoms.pickNumberInRange(1,9));
                    } else {
                        break;
                    }
                }
            }
        }*/

        boolean gameAgain = true;
        while (gameAgain) {

            /*try {
                System.out.print("숫자를 입력해주세요 : ");
                userNumber = Console.readLine();
                if (userNumber.length() != 3) {
                    throw new IllegalArgumentException("3자리의 숫자를 입력해주세요");
                } else if ( userNumber.contains("0")) {
                    throw new IllegalArgumentException("1~9까지의 수 3자리를 입력하세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            System.out.print("숫자를 입력해주세요 : ");
            userNumber = Console.readLine();
            if (userNumber.length() != 3) {
                throw new IllegalArgumentException("3자리의 숫자를 입력해주세요");
            } else if ( userNumber.contains("0")) {
                throw new IllegalArgumentException("1~9까지의 수 3자리를 입력하세요.");
            }

            String[] userNumberArr = userNumber.split("");

            for (int i = 0; i < comRandomNumberArr.length; i++) {
                if (userNumberArr[i].equals(comRandomNumberArr[i])) strike++;
            }

            for (int i = 0; i < comRandomNumberArr.length; i++) {
                for (int j = 0; j < userNumberArr.length; j++) {
                    if (userNumberArr[i].equals(comRandomNumberArr[j])) {
                        if (i == j) continue;
                        ball++;
                    }
                }
            }


            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String playAgain = Console.readLine();
                if (playAgain.equals("1")) {
                    gameAgain = true;
                    comRandomNumberArr = comNumber();
                    //return false;
                } else if (playAgain.equals("2")) {
                    gameAgain = false;
                    //return true;
                } else {
                    throw new IllegalArgumentException();
                }
            } else if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            } else if (strike != 0 && ball != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (strike != 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println("낫싱");
            }
            strike = 0;
            ball = 0;
            //System.out.println(Arrays.toString(comRandomNumberArr));
        }
        return false;
    }

    public String[] comNumber() {
        String[] comRandomNumberArr = new String[3];
        for (int i = 0; i < 3; i++) {
            comRandomNumberArr[i] = String.valueOf(Randoms.pickNumberInRange(1,9));
            if (i == 1) {
                while (true) {
                    if (comRandomNumberArr[0].equals(comRandomNumberArr[i])) {
                        comRandomNumberArr[i] = String.valueOf(Randoms.pickNumberInRange(1,9));
                    } else {
                        break;
                    }
                }
            } else if (i == 2) {
                while (true) {
                    if (comRandomNumberArr[0].equals(comRandomNumberArr[i]) || comRandomNumberArr[1].equals(comRandomNumberArr[i])) {
                        comRandomNumberArr[i] = String.valueOf(Randoms.pickNumberInRange(1,9));
                    } else {
                        break;
                    }
                }
            }
        }
        return comRandomNumberArr;
    }
}
