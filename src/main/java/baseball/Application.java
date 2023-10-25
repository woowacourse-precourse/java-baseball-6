package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int NUMBER_COUNT = 3;
    public static int strike, ball;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        numberBaseballGameStart();
    }

    /**
     * 숫자 야구 게임을 시작한다.
     */
    public static void numberBaseballGameStart() {
        initData();

        try {
            //컴퓨터가 생성한 수를 List배열에 저장
            List<Integer> computerNumbers = inputComputerNumbers();

            //computerNumbers에 대한 유효성 검증
            validNumbers(computerNumbers);
            //생성된 computerNumbers와 사용자가 입력한 수를 가지고 비교하여 결과값 출력
            countStrike(computerNumbers);

            System.out.println(NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            //게임 종료 시 재시작 or 종료
            ReStart();
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("게임이 종료되었습니다");
        }
    }

    /**
     * 사용자가 입력한 3개의 숫자를 입력 받고, 유효성 검사 후 컴퓨터가 생성한 3개의 숫자와 비교한다.
     *
     * @param computerNumbers 컴퓨터가 생성한 3개의 숫자
     */
    public static void countStrike(List<Integer> computerNumbers) {
        while(strike!=NUMBER_COUNT) {

            //사용자로부터 입력받은 값을 List배열에 저장
            List<Integer> playerNumbers = inputPlayerNumbers();
            //playerNumbers에 대한 유효성 검증
            validNumbers(playerNumbers);
            //computerNumbers와 playerNumbers를 비교하여 strike와 ball값 증가
            compareNumbers(computerNumbers, playerNumbers);

        }
    }

    /**
     * 게임 종료 후 사용자가 입력하는 값에 대한 유효성 검사와 게임 재시작 또는 게임을 종료한다.
     */
    public static void ReStart() {
        System.out.println("게임을 새로 시작려면 1, 종료하려면 2를 입력하세요.");

        //사용자로부터 게임을 재시작할건지 종료할건지 값 입력받기
        String reStartNumber = Console.readLine();
        //reStartNumber에 대한 유효성 검증
        validInputNumber(reStartNumber);

        //사용자가 1을 입력했다면
        if (reStartNumber.equals("1")) {
            //게임 재시작
            numberBaseballGameStart();
            return;
        }
        //사용자가 2를 입력했다면 게임 종료
        System.out.println("게임이 종료되었습니다.");
    }

    /**
     * 컴퓨터가 랜덤한 숫자를 생성하고 List에 저장한다.
     *
     * @return 컴퓨터가 생성한 수를 저장한 List를 리턴한다.
     */
    public static List<Integer> inputComputerNumbers() {

        List<Integer> computer = new ArrayList<>();

        while(computer.size()<NUMBER_COUNT) {
            //1~9사이의 랜덤한 수 생성
            int randomNumber = Randoms.pickNumberInRange(1, 9);
                //computer 배열에 생성한 randomNumber가 없다면
                if(!computer.contains(randomNumber)) {
                    //computer 배열에 추가
                    computer.add(randomNumber);
                }

        }
        return computer;
    }

    /**
     * 사용자에게서 숫자를 입력받고 List배열에 저장한다.
     *
     * @return 사용자가 입력한 숫자를 저장한 List배열을 리턴한다.
     */
    public static List<Integer> inputPlayerNumbers() {
        List<Integer> playerNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        //사용자가 서로 다른 수 3개를 입력
        String player = Console.readLine().replaceAll(" ", "");

        //playerNumbers 배열에 저장
        for(int i=0; i<player.length(); i++) {
            playerNumbers.add(player.charAt(i) - '0');
        }

        return playerNumbers;
    }

    /**
     * 컴퓨터와 사용자가 입력한 3개의 숫자가 담긴 두 List를 비교하여 스트라이크와 볼의 개수를 증가시킨 후 결과값을 출력한다.
     *
     * @param computerNumbers 컴퓨터가 생성한 서로 다른 3개의 숫자
     * @param playerNumbers 사용자가 입력한 서로 다른 3개의 숫자
     */
    public static void compareNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        initData();

        for(int i=0; i<NUMBER_COUNT; i++) {
            //컴퓨터와 사용자의 수와 위치가 같다면 strike 증가
            if (playerNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
                continue;
            }
            //컴퓨터와 사용자의 수가 같고 위치가 다르다면 ball 증가
            if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
        System.out.println(printResult());
    }

    /**
     * 스트라이크와 볼의 개수를 출력한다.
     *
     * @return 스트라이크와 볼의 개수를 포함한 결과값을 리턴한다.
     */
    public static String printResult() {
        if(ball == 0 && strike == 0) {
            return "낫싱";
        }
        if(ball == 0) {
            return strike + "스트라이크";
        }
        if(strike==0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    /**
     * 스트라이크와 볼의 개수를 초기화한다.
     */
    public static void initData() {
        strike = 0;
        ball = 0;
    }

    /**
     * 잘못된 값을 입력했는지 검증하고, 예외를 발생시킨다.
     *
     * @param numbers 컴퓨터가 생성한 수 또는 사용자가 입력한 수
     */
    public static void validNumbers(List<Integer> numbers) {
        //아무것도 입력하지 않았을 경우
        if(numbers == null) {
            throw new IllegalArgumentException();
        }
        //생성한 수 또는 입력받은 수의 개수가 3개가 아닌 경우
        if(numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
        //중복되는 값이 있는 경우
        if(checkDuplicateNumber(numbers, 0, 0)) {
            throw new IllegalArgumentException();
        }
        //1~9외에 다른 숫자가 사용된 경우
        if(checkOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 게임 종료 시점에 사용자가 입력한 값을 검증하고 예외를 발생시킨다.
     *
     * @param InputNumber 사용자로부터 입력받은 수
     */
    public static void validInputNumber(String InputNumber) {

        //게임 종료 시점에 사용자가 1 또는 2외에 다른 숫자를 입력했을 경우
        if(!InputNumber.equals("1") && !InputNumber.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 중복되는 수가 있는지 검증한다.
     *
     * @param numbers 컴퓨터가 생성한 수 또는 사용자가 입력한 수
     * @param numbersIdx 중복되는 수가 있는지 기준이 되는 인덱스
     * @param checkNumberIdx numbersIdx가 바뀔 때마다 배열의 크기만큼 순환할 인덱스
     * @return 중복되는 수가 있다면 true 없다면 false를 리턴한다.
     */
    public static boolean checkDuplicateNumber(
            List<Integer> numbers,
            int numbersIdx,
            int checkNumberIdx
    ) {
        //numbersIdx가 numbers의 길이가 되면 반복문 종료
        while(numbersIdx != numbers.size()) {
            int searchNumber = numbers.get(numbersIdx);
            int checkNumber = numbers.get(checkNumberIdx);

            //자기 자신과 같은 인덱스일 경우 numbersIdx 증가
            if(numbersIdx == checkNumberIdx) {
                numbersIdx++;
                continue;
            }
            //checkNumberIdx가 numbers의 길이만큼 순환했을 경우
            if(checkNumberIdx == numbers.size()-1) {
                checkNumberIdx = 0;
                numbersIdx++;
            }
            //중복된 수가 있는 경우
            if(searchNumber == checkNumber) {
                return true;
            }
            checkNumberIdx++;
        }
        return false;
    }

    /**
     * 입력받은 수 중에서 1~9를 벗어나는 수가 있는지 확인한다.
     *
     * @param numbers 컴퓨터가 생성한 수 또는 사용자가 입력한 수
     * @return 1~9를 벗어나는 수가 있으면 true 없으면 false를 리턴한다.
     */
    public static boolean checkOutOfRangeNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number.equals(0)) {
                return true;
            }
        }
        return false;
    }
}
