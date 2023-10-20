package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void selectThreeNumber(List<Integer> selectNumber){
        while (selectNumber.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!selectNumber.contains(randomNumber)) {
                selectNumber.add(randomNumber);
            }
        }
    }
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        String inputNumber;
        Integer[] intArr = new Integer[3];
        int strikeCount = 0;
        int ballCount = 0;

        //1. 선택
        List<Integer> selectNumber = new ArrayList<>();
        Application.selectThreeNumber(selectNumber);

        System.out.println("selectNumber = " + selectNumber);
        //2. 출력문 구성
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            ballCount = 0;
            strikeCount = 0;

            System.out.print("숫자를 입력해주세요 : ");
            //3. 사용자 입력값 받기
            String[] strArr;
            try {
                inputNumber = Console.readLine();

                //입력값의 크기가 3개가 아닐 때 => 예외 발생
                if (inputNumber.length() != 3) {
                    throw new IllegalArgumentException("3개의 숫자만 입력하세요.");
                }

                //숫자배열 만들기
                strArr = inputNumber.split("");
                for (int i = 0; i < 3; i++) {

                    //0입력시 => 예외 발생
                    if (Integer.parseInt(strArr[i]) == 0) {
                        throw new IllegalArgumentException("1~9 사이의 숫자를 입력하세요.");
                    }
                    intArr[i] = Integer.parseInt(strArr[i]);
                    //같은 숫자를 입력했을 때 => 예외발생
                    for (int j = i + 1; j < 3; j++)
                        if (intArr[i] == Integer.parseInt(strArr[j])) {
                            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
                        }

                }

            } catch (NumberFormatException ex) {
                //문자가 포함될 때 => 예외 발생
                throw new IllegalArgumentException("숫자만 입력하세요.");
            }

//            for (int i : intArr) {
//                System.out.println("i = " + i);
//            }
            //4. 규칙에 따라 출력
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (selectNumber.get(i) == intArr[j] && i == j) {
                        strikeCount++;
                    } else if (selectNumber.get(i) == intArr[j]) {
                        ballCount++;
                    }
                }
            }
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
            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                inputNumber = Console.readLine();
                try {
                    if (Integer.parseInt(inputNumber) != 1 && Integer.parseInt(inputNumber) != 2) {
                        throw new IllegalArgumentException("1과 2중에 입력하세요.");
                    }
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("숫자만 입력하세요.");
                }

                if (Integer.parseInt(inputNumber) == 1) {
                    selectNumber.clear();
                    Application.selectThreeNumber(selectNumber);
                    System.out.println("selectNumber = " + selectNumber);
                } else {
                    break;
                }
            }

        }
    }


}

