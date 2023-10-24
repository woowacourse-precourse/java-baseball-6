package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    // main 안에는 하나의 메소드를 호출하는 방식으로, 유지보수가 용이하고 가독성이 좋도록 하였습니다.
    // -> application test 파일 확인 결과, 적합하지 않은 방식이라 main 안에 본체 코드를 삽입함 (개인 공부용 주석 기록입니다.)

    public static void main(String[] args) {
        boolean isGameOver = false; //게임 종료를 판단하기 위한 변수. true: 게임 중, false:게임 종료
        boolean play = true;

        //맨 처음 환영 문구는 한번만 출력한다.
        System.out.println("숫자 야구 게임을 시작합니다.");
        //게임을 종료하지 않는 한 계속 한다.
        while (true) {
            // 컴퓨터가 숫자 세자리를 가지고 있다, 게임을 시작할 때마다 그에 대한 랜덤 숫자 리스트를 생성한다.
            int[] computerNumbers = generateRandomNumbers();

            while(play) {
                System.out.println("숫자를 입력해주세요 : ");
                String input = Console.readLine(); //사용자 입력을 받음

                //사용자 입력에 대한 예외처리
                if (!isValidInput(input)) { // 하단에 구현해둔, 유효한 입력인지 확인하는 메소드
                    throw new IllegalArgumentException("잘못된 입력");
                }

                //사용자가 제시해나갈 숫자 3자리를 숫자로 바꾸고
                int[] userNumbers = convertInputToNumbers(input);
                //결과판단. 하단에 스트라이크/볼/낫싱을 판단하는 메소드가 있음
                int[] result = calculateResult(computerNumbers, userNumbers);

                //아래는 스트라이크, 볼, 낫싱에 대한 판단.
                //result[0]: 스트라이크 개수, result[1]: 볼 개수, result[2]:낫싱 개수

                //세 수 모두 스트라이크일 때
                if (result[0] == 3) {
                    System.out.println(result[0] + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    break;
                    //3스트라이크 시 하단의 1, 2 입략을 받는 부분으로 이동
                }

                //스트라이크와 볼이 섞인 경우
                if (result[0] > 0 && result[1] > 0) {
                    System.out.println(result[1] + "볼" + " " + result[0] + "스트라이크");
                }
                //볼 밖에 없을 때
                else if (result[1] > 0 && result[0] == 0) {
                    System.out.println(result[1] + "볼");
                }
                //스트라이크 밖에 없을 때
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
                break; //게임 종료로 while 탈출
            } else if (!playAgain.equals("1")) {
                System.out.println("1 또는 2를 입력하세요.");
            }
        }
    }

    //아래부터는 main 안에서 사용한, 필요한 메소드들

    // 컴퓨터에게 무작위로 서로 다른 3자리 숫자를 생성해주는 함수
    public static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int num;
            do {
                num = Randoms.pickNumberInRange(1, 9);
            } while (contains(numbers, num));
            numbers[i] = num;
        }
        return numbers;
    }

    // 랜덤으로 숫자를 생성할 때 겹치는 게 있는지 확인하는 함수
    public static boolean contains(int[] array, int num) {
        for (int value : array) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

    // 길이와 숫자 분야에서 사용자 입력이 유효한지 확인하는 함수
    public static boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
        }
        return areAllDigitsDifferent(input); //하단 구현
    }

    // 시용자가 입력한 숫자들이 서로 다른 숫자인지 확인하는 함수
    public static boolean areAllDigitsDifferent(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                //팔린드롬을 확인하듯이 좌와 우에서부터 다가가며 확인
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
