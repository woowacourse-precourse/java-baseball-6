package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

//코드에 중복이 되는 요소가 없는가?
//한 메서드에 너무 많은 기능이 들어가 있지는 않는가?
//객체 간 기능의 분리가 잘 되어있는가?
//리팩토링 조건들

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
        //사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

        //!flag = true
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag1 = false;
        while (!flag1) {

            //기능1
            List<Integer> computerRandomNums = getRandomNums();
            System.out.println(computerRandomNums);

            boolean flag2 = false;
            while (!flag2) {

                //기능 2~3
                char[] userNums = inputUserNums();

                //기능 4
                flag2 = checkStrikeBall(computerRandomNums, userNums);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            //flag1 false 다시 진행 flag2 true 진행 종료
            flag1 = gameBranch(flag1);
        }
        Console.close();
    }

    public static List<Integer> getRandomNums() {
        //기능구현 1
        List<Integer> computer = new ArrayList<>();
        //리스트에 1~9까지 넣는데 이미 포함되어있으면 작업 X 크기 3까지 작업
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static char[] inputUserNums() {
        //기능구현 2
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String strBaseballNum = Console.readLine();
            int intBaseballNum = Integer.parseInt(strBaseballNum);

            if (100 <= intBaseballNum && intBaseballNum < 1000) {

                //기능구현3
                char[] BaseballNumCharArr = strBaseballNum.toCharArray();
                if (BaseballNumCharArr[0] != BaseballNumCharArr[1] && BaseballNumCharArr[1] != BaseballNumCharArr[2]
                        && BaseballNumCharArr[0] != BaseballNumCharArr[2]) {
                    return BaseballNumCharArr;
                } else {
                    throw new IllegalArgumentException("OMG! you input over the same of two numbers. Error.");
                }
            } else {
                throw new IllegalArgumentException("OMG! should input the nums well in range. Error.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("NO. should not input out of variable. Error.");
        }
    }

    public static boolean checkStrikeBall(List<Integer> computerRandomNums,
                                          char[] userNums) {
        int strike = 0;
        int ball = 0;
        boolean flag2 = false;
        //비교하는 좋은 방법 체크
        //기능구현 4
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Character.getNumericValue(int value) 캐릭터의 int값 반환
                if (i == j) {
                    if (computerRandomNums.get(i) == Character.getNumericValue(userNums[j])) {
                        strike++;
                    }
                } else {
                    if (computerRandomNums.get(i) == Character.getNumericValue(userNums[j])) {
                        ball++;
                    }
                }
            }
        }
        if (ball != 0) {
            System.out.print(ball + "볼" + " ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크" + " ");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        if (strike == 3) {
            flag2 = true;
        }
        System.out.println();
        return flag2;
    }

    public static boolean gameBranch(boolean flag1) {
        boolean flag = false;
        while (!flag) {
            try {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String Userchoice = Console.readLine();
                if (Userchoice.length() != 1) {
                    System.out.println("should input only length 1");
                } else if (Integer.parseInt(Userchoice) == 1) {
                    System.out.println(Userchoice);
                    flag = true;
                } else if (Integer.parseInt(Userchoice) == 2) {
                    System.out.println("게임 종료");
                    flag = true;
                    flag1 = true;
                } else {
                    throw new IllegalArgumentException("Should input num 1 or 2");
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("no. should not input out of variable");
            }
        }
        return flag1;
    }
}