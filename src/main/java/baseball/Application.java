package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final boolean DEFAULT_STATE = false;
    private static final String GAMESTART_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_DESCRIPTION_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAMECLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String TRYAGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public static void main(String[] args) {
        // 게임 재시작, 종료 여부를 제어할 변수
        boolean isRestart;
        System.out.println(GAMESTART_MESSAGE);

        do {
            // TODO: 랜덤 세 자리 수 생성
            // computer: 랜덤으로 생성한 세 자리 수를 저장할 list
            // 인덱스 0: 백의 자리, 인덱스 1: 십의 자리, 인덱스 2: 일의 자리
            List<Integer> computer = makeComputerNumber();

            // TODO: 숫자 야구 게임 진행

            // 정답 여부를 체크하는 변수
            boolean isGameClear = DEFAULT_STATE;

            while (!isGameClear) {
                System.out.print(INPUT_DESCRIPTION_MESSAGE);

                /*
                # 사용자 입력 예외처리

                - 1) 숫자입니까?
                    yes : inputNumber에 문자열을 정수형으로 변환
                - 2) 3자리입니까?
                    yes : player 배열에 자릿수 분해
                - 3) 서로 다른 숫자로 이루어졌습니까?
                    yes : 야구 게임 처리를 시작합니다!
                => 하나라도 NO 라면 IllegalArgumentException 예외를 발생!
                */

                // 플레이어가 입력한 문자열
                String inputString = readLine();

                // TODO: 사용자의 세 자리 수 입력 예외 처리
                if (!isNumberInteger(inputString)) {
                    throw new IllegalArgumentException();
                } else if (!isThreeDigitNumber(inputString)) {
                    throw new IllegalArgumentException();
                } else if (!isDifferentDigits(inputString)) {
                    throw new IllegalArgumentException();
                }

                // 입력 받은 세 자리 수를 자릿수 별로 분리
                int[] player = separateDigits(Integer.parseInt(inputString));

                int strikeCount = 0;
                int ballCount = 0;

                // 스트라이크, 볼의 개수 계산
                for (int i = 0; i < player.length; i++) {
                    if (computer.get(i) == player[i]) {
                        strikeCount++;
                    } else if (computer.contains(player[i])) {
                        ballCount++;
                    }
                }

                // 스트라이크, 볼의 개수에 따른 결과 출력
                System.out.println(makeResultMessage(ballCount, strikeCount));

                // 만약 strikeCount == 3 이면, 모두 정답이므로 정답 처리
                if (isAnswerCollect(strikeCount)) {
                    isGameClear = true;
                    System.out.println(GAMECLEAR_MESSAGE);
                }
            }

            // 게임 종료 후, 재시작 여부 확인 메시지 출력
            System.out.println(TRYAGAIN_MESSAGE);
            String choice = readLine();

            // TODO: 사용자의 재시작, 종료 선택 입력 예외 처리
            if (!isNumberInteger(choice)) {
                throw new IllegalArgumentException();
            } else if (!isOneOrTwo(Integer.parseInt(choice))) {
                throw new IllegalArgumentException();
            }

            isRestart = wantTryAgain(Integer.parseInt(choice));

        } while (isRestart);

    }


    // 입력 받은 값이 정수형인지 판별하는 메서드
    public static boolean isNumberInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    // 입력 받은 값이 세 자리 수인지 판별하는 메서드
    public static boolean isThreeDigitNumber(String input) {
        int number = Integer.parseInt(input);
        return (number / 100) >= 1 && (number / 1000) == 0;
    }

    // 입력 받은 값이 서로 다른 수로 구성되었는지 판별하는 메서드
    public static boolean isDifferentDigits(String input) {
        return input.charAt(0) != input.charAt(1)
                && input.charAt(1) != input.charAt(2)
                && input.charAt(0) != input.charAt(2);
    }

    // 입력 받은 값이 1 또는 2인지 판별하는 메서드
    public static boolean isOneOrTwo(int number) {
        return number == 1 || number == 2;

        /*
        if (number == 1 || number == 2) {
            return true;
        }
        return false;
        */
    }

    // 컴퓨터에게 정답 세 자리 수를 부여하는 메서드
    public static ArrayList<Integer> makeComputerNumber() {
        // computer : 랜덤으로 생성한 세 자리 수를 저장할 list
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    // 세 자리 수를 각 자릿수대로 나눠주는 메서드
    public static int[] separateDigits(int inputNumber) {
        int[] numbers = new int[3];
        numbers[0] = inputNumber / 100;
        numbers[1] = (inputNumber - (inputNumber / 100) * 100) / 10;
        numbers[2] = inputNumber % 10;

        return numbers;
    }

    // 스트라이크, 볼의 개수에 따른 결과를 전달하는 메서드
    public static String makeResultMessage(int ballCount, int strikeCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        } else if (ballCount > 0 && strikeCount > 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        } else if (strikeCount > 0) {
            return strikeCount + "스트라이크";
        } else {
            return ballCount + "볼";
        }
    }

    // 정답을 맞췄는지 판별하는 메서드
    public static boolean isAnswerCollect(int strikeCount) {
        return strikeCount == 3;

        /*
        if (strikeCount == 3) {
            return true;
        }
        return false;
         */
    }

    // 사용자가 입력한 수에 따라 재시작할지 종료할지 판별하는 메서드
    public static boolean wantTryAgain(int choice) {
        // 재시작
        return choice == 1;

        /*
        *   if (choice == 1) {
                // 재시작
                return true;
            }
            // 게임 종료
            return false;
        *
        * */
    }
}
