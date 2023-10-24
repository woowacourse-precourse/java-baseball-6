package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> randomNumberCreate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> InputValueToArray(int inputValue) {
        List<Integer> inputList= new ArrayList<>();
        String tempStringConvert = String.valueOf(inputValue);
        for (char tempChar : tempStringConvert.toCharArray()) {
            inputList.add(Character.getNumericValue(tempChar));
        }
        return inputList;
    }

    public static int PlayBall(List<Integer> inputValueList, List<Integer> randomValueList) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < inputValueList.size(); i++) {
            if (inputValueList.get(i).equals(randomValueList.get(i))) {
                strike++;
            } else if (randomValueList.contains(inputValueList.get(i))) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return 1;
        } else if (strike == 0) {
            System.out.printf("%d볼", ball);
            return 1;
        } else if (ball == 0) {
            System.out.printf("%d스트라이크", strike);
            return strike == 3 ? 2 : 1;
        } else {
            System.out.printf("%d볼 %d스트라이크" ,ball, strike);
            return 1;
        }
    }

    public static void DisPlay(int currentStep) {
        switch (currentStep) {
            case 0:
                System.out.println("\n\n========@숫자야구입니다@========");
                System.out.println("============================");
                System.out.print("\n숫자 3자리를 이어서 작성 하시오 : ");
                break;
            case 1:
                System.out.print("\n숫자 3자리를 이어서 작성 하시오 : ");
                break;
            case 2:
                System.out.print("\n숫자를 다 맞추셨습니다! 축하합니다!\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
                break;
        }
    }

    public static int ErrorCatchMaster() {
        int checkInput = 0;
        int inputValue;
        while (true) {
            try {
                inputValue = Integer.parseInt(Console.readLine());
                checkInput = Math.abs(inputValue);
                if (checkInput < 100 || checkInput > 999) {
                    throw new IllegalArgumentException();
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.printf("조건(숫자 3개 입력)에 맞는 입력 부탁 드립니다!! : ");
            }
        }
        return inputValue;
    }

    public static int ErrorCatchMaster_Two() {
        int checkInput = 0;
        int inputValue;
        while (true) {
            try {
                inputValue = Integer.parseInt(Console.readLine());
                checkInput = Math.abs(inputValue);
                if (checkInput != 1 && checkInput != 2) {
                    throw new IllegalArgumentException();
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.printf("조건(1 혹은 2 입력)에 맞는 입력 부탁 드립니다!! : ");
            }
        }
        return inputValue;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int step = 0;
        int input;
        List<Integer> createdInputNumber;
        List<Integer> createdRandomNumber = new ArrayList<>();

        while(step != 2) {
            DisPlay(step);
            createdRandomNumber = step == 0 ? randomNumberCreate() : createdRandomNumber;
            input = ErrorCatchMaster();
            createdInputNumber = InputValueToArray(input);
            step = PlayBall(createdInputNumber, createdRandomNumber);
//            System.out.println("\nthis is the answer: " + createdRandomNumber);
            createdInputNumber.clear();
            if (step == 2) {
                DisPlay(step);
                input = ErrorCatchMaster_Two();
                step = input == 1 ? 0 : step;
                createdRandomNumber.clear();
            }
        }
    }
}
