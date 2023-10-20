package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {

    private static int strikeCount = 0;
    private static int ballCount = 0;

    public static void selectThreeNumber(List<Integer> selectNumber) {
        while (selectNumber.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!selectNumber.contains(randomNumber)) {
                selectNumber.add(randomNumber);
            }
        }
    }

    public static void inputThreeNumber(String inputNumber, String[] strArr, Integer[] intArr) {
        try {
            inputNumber = Console.readLine();

            //입력값의 크기가 3개가 아닐 때 => 예외 발생
            if (inputNumber.length() != 3) {
                Application.throwException("3개의 숫자만 입력하세요.");
            }

            //숫자배열 만들기
            strArr = inputNumber.split("");
            for (int i = 0; i < 3; i++) {

                //0입력시 => 예외 발생
                if (Integer.parseInt(strArr[i]) == 0) {
                    Application.throwException("1~9 사이의 숫자를 입력하세요.");
                }
                intArr[i] = Integer.parseInt(strArr[i]);
                //같은 숫자를 입력했을 때 => 예외발생
                for (int j = i + 1; j < 3; j++)
                    if (intArr[i] == Integer.parseInt(strArr[j])) {
                        Application.throwException("서로 다른 숫자를 입력하세요.");
                    }

            }

        } catch (NumberFormatException ex) {
            //문자가 포함될 때 => 예외 발생
            Application.throwException("숫자만 입력하세요.");
        }
    }

    public static void throwException(String warning) {
        throw new IllegalArgumentException(warning);
    }

    public static void calculateStrikeAndBall(List<Integer> selectNumber, Integer[] intArr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (selectNumber.get(i) == intArr[j] && i == j) {
                    strikeCount++;
//                    System.out.println("strikeCount = " + strikeCount);
                } else if (selectNumber.get(i) == intArr[j]) {
                    ballCount++;
//                    System.out.println("ballCount = " + ballCount);
                }
            }
        }
    }

    public static void displayResult(int ballCount, int strikeCount) {
        if (ballCount != 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        if (ballCount + strikeCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static boolean restartOrExitGame(int strikeCount, String inputNumber, List<Integer> selectNumber) {
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            inputNumber = Console.readLine();
            try {
                if (Integer.parseInt(inputNumber) != 1 && Integer.parseInt(inputNumber) != 2) {
                    Application.throwException("1과 2중에 입력하세요.");
                }
            } catch (NumberFormatException ex) {
                Application.throwException("숫자만 입력하세요.");
            }

            if (Integer.parseInt(inputNumber) == 1) {
                selectNumber.clear();
                Application.selectThreeNumber(selectNumber);
                System.out.println("selectNumber = " + selectNumber);
            } else {
                return false;
            }

        }
        return true;
    }

    public static void initializeCounts() {
        strikeCount = 0;
        ballCount = 0;
    }

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        String inputNumber = "";
        Integer[] intArr = new Integer[3];


        boolean isGameRunning = true;

        String[] strArr = new String[3];

        //1. 선택
        List<Integer> selectNumber = new ArrayList<>();
        Application.selectThreeNumber(selectNumber);

        System.out.println("selectNumber = " + selectNumber);
        //2. 출력문 구성
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isGameRunning) {
            Application.initializeCounts();

            System.out.print("숫자를 입력해주세요 : ");
            //3. 사용자 입력값 받기
            Application.inputThreeNumber(inputNumber, strArr, intArr);

//            for (int i : intArr) {
//                System.out.println("i = " + i);
//            }
            //4. 규칙에 따라 출력

            Application.calculateStrikeAndBall(selectNumber, intArr);
//            System.out.println("strikeCount = " + strikeCount);
//            System.out.println("ballCount = " + ballCount);
            Application.displayResult(ballCount, strikeCount);

            //5. 게임 종료 후, 재시작 & 종료 선택
            isGameRunning = Application.restartOrExitGame(strikeCount, inputNumber, selectNumber);


        }
    }




}

