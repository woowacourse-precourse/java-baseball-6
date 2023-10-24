package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    // main 안에는 하나의 메소드를 호출하는 방식으로, 유지보수가 용이하고 가독성이 좋도록 하였습니다.
    public static void main(String[] args) {
        boolean isGameOver = false; //게임 종료를 판단하기 위한 변수. true: 게임 중, false:게임 종료
        boolean play = true; //두번째 while문 탈출을 위해 만들어둔 변수

        //맨 처음 환영 문구는 한번만 출력한다.
        System.out.println("숫자 야구 게임을 시작합니다.");
        //게임을 종료하지 않는 한 계속 한다.
        while (!isGameOver) {
            // 컴퓨터가 숫자 세자리를 가지고 있는 입장이므로, 게임을 시작할 때마다 그에 대한 리스트 생성
            int[] computerNumbers = generateRandomNumbers();

            while(play) {
                System.out.println("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                //사용자 입력에 대한 예외처리
                if (!isValidInput(input)) { // 하단에 구현해두었습니다.
                    throw new IllegalArgumentException("잘못된 입력");
                }

                //사용자가 제시해나갈 숫자 3자리를 숫자로 바꾸고
                int[] userNumbers = convertInputToNumbers(input);
                //결과판단. 하단에 메소드 위치
                int[] result = calculateResult(computerNumbers, userNumbers);

                //아래는 스트라이크, 볼, 낫싱에 대한 판단
                //세 수 모두 스트라이크일 때
                if (result[0] == 3) {
                    System.out.println(result[0] + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    //play = false; //while 탈출
                    break; //if 탈출
                    //하단의 1, 2 입략을 받는 부분으로 이동
                }

                //스트라이크와 볼이 섞인 경우를 특별히 다뤄주자.
                else if (result[0] > 0 && result[1] > 0) {
                    System.out.println(result[1] + "볼" + " " + result[0] + "스트라이크");
                }
                //볼밖에 없을 때
                else if (result[1] > 0 && result[0] == 0) {
                    System.out.println(result[1] + "볼");
                }
                //스트라이크밖에 없을 때
                else if (result[0] > 0 && result[1] == 0) {
                    System.out.println(result[0] + "스트라이크");
                }
                //낫싱인 경우
                else if (result[2] == 3) {
                    System.out.println("낫싱");
                }
            }

            //1 또는 2를 입력받음
            String playAgain = Console.readLine();
            if (playAgain.equals("2")) {
                isGameOver = true;
            } else if (playAgain.equals("1")) {
                isGameOver = false; //다시 첫번째 while로 돌아감
            } else {
                System.out.println("1 또는 2를 입력하세요.");
            }
        }
    }

    // 무작위로 서로 다른 3자리 숫자를 생성하는 함수
    public static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int num;
            do {
                // 문제 요구 사항
                num = Randoms.pickNumberInRange(1, 9);
            } while (contains(numbers, num)); //하단에 메소드 구현
            numbers[i] = num;
        }
        return numbers;
    }

    // 배열에 숫자가 이미 존재하는지 확인하는 유틸리티 함수
    public static boolean contains(int[] array, int num) {
        for (int value : array) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

    // 사용자 입력이 유효한지 확인하는 함수
    public static boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
        }
        return areAllDigitsDifferent(input);
    }

    // 입력된 숫자들이 서로 다른 숫자인지 확인하는 함수
    public static boolean areAllDigitsDifferent(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 사용자 입력을 숫자 배열로 변환하는 함수
    public static int[] convertInputToNumbers(String input) {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }

    // 게임 결과를 계산하는 함수 (스트라이크, 볼, 낫싱)
    public static int[] calculateResult(int[] computerNumbers, int[] userNumbers) {
        int[] result = new int[3];

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                result[0]++; // 스트라이크
            } else if (contains(computerNumbers, userNumbers[i])) {
                result[1]++; // 볼
            }
        }

        result[2] = 3 - result[0] - result[1]; // 낫싱
        return result;
    }
}
