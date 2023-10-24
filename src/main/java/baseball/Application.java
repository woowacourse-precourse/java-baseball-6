package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {


    public static List<Integer> randomNumberCreate() { // API를 이용한 랜덤숫자 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> InputValueToArray(int inputValue) { // 입력값을 스트링으로 변환 후 integer 리스트에 넣기
        List<Integer> inputList= new ArrayList<>();
        String tempStringConvert = String.valueOf(inputValue);
        for (char tempChar : tempStringConvert.toCharArray()) {
            inputList.add(Character.getNumericValue(tempChar));
        }
        return inputList;
    }

    public static int PlayBall(List<Integer> inputValueList, List<Integer> randomValueList) { // 숫자야구 로직
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < inputValueList.size(); i++) {
            if (inputValueList.get(i).equals(randomValueList.get(i))) { //같은 인덱스에 같은 값이 있을 경우
                strike++;
            } else if (randomValueList.contains(inputValueList.get(i))) { //위치는 다르나 같은 값이 있을 경우
                ball++;
            }
        }

        if (strike == 0 && ball == 0) { // 둘 다 없을 경우
            System.out.println("낫싱");
        } else if (strike == 0) { // 스트라이크가 없을 경우
            System.out.println(ball + "볼");
        } else if (ball == 0) { // 볼이 없을 경우
            System.out.println(strike + "스트라이크");
        } else { // 둘 다 있을경우
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return strike == 3 ? 2 : 1; //step 갱신
    }

    public static void DisPlay(int currentStep) { // 출력 부분
        switch (currentStep) {
            case 0: // 초기화면
                System.out.println("\n\n========@숫자야구입니다@========");
                System.out.println("============================");
                System.out.print("\n숫자 3자리를 이어서 작성 하시오 : ");
                break;
            case 1: // 실행 중 화면
                System.out.print("\n숫자 3자리를 이어서 작성 하시오 : ");
                break;
            case 2: // 다 맞췄을 때 화면
                System.out.print("\n숫자를 다 맞추셨습니다! 축하합니다!\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
                break;
        }
    }

    public static int ErrorCatchMaster(String inputValue) {
        if (inputValue.length() != 3 || !inputValue.matches("\\d{3}")) {
            throw new IllegalArgumentException("조건(숫자 3개 입력)에 맞는 입력 부탁 드립니다!! ");
        } else {
            return Integer.parseInt(inputValue);
        }
    }

    public static int ErrorCatchMaster_Two() { //재시작 입력값 예외처리
        int checkInput = 0;
        int inputValue;
        while (true) {
            try {
                inputValue = Integer.parseInt(Console.readLine());
                checkInput = Math.abs(inputValue);
                if (checkInput != 1 && checkInput != 2) { // 1 혹은 2 입력 했는지 확인
                    throw new IllegalArgumentException();
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) { // 오류 부분 출력
                System.out.printf("조건(1 혹은 2 입력)에 맞는 입력 부탁 드립니다!! : ");
            }
        }
        return inputValue;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int step = 0;
        int input;
        String inputForGame;
        List<Integer> createdInputNumber; // 입력값용 리스트
        List<Integer> createdRandomNumber = new ArrayList<>(); // 랜덤값용 리스트

        while(step != 2) { // step이 2일 경우 프로그램 종료
            DisPlay(step);
            createdRandomNumber = step == 0 ? randomNumberCreate() : createdRandomNumber; // step이 0일때만 랜덤값 재생성
            inputForGame = Console.readLine();
            input = ErrorCatchMaster(inputForGame);
            createdInputNumber = InputValueToArray(input); // 입력값 리스트 변환
            step = PlayBall(createdInputNumber, createdRandomNumber); // 리스트끼리의 비교
//            System.out.println("\nthis is the answer: " + createdRandomNumber); //--->테스트용
            createdInputNumber.clear(); // 비교후 계속 리스트 비우기
            if (step == 2) {
                DisPlay(step); // 화면 출력
                input = ErrorCatchMaster_Two(); // 입력값 확인
                step = input == 1 ? 0 : step; // 1 입력시 step을 0으로 입력 후 재시작, 아니면 그대로 종료
                if (step == 2) {
                    System.out.println("게임 종료");
                }
                createdRandomNumber.clear(); // 랜덤용 리스트 비우기
            }
        }
    }
}
