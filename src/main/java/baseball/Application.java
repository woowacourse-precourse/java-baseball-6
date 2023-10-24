package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String restartFlag;
        do{
            run();
            restartFlag = askPlayerChoice();
        }while(restartFlag.equals("1"));
    }

    private static void run(){
        GameResult gameResult;
        List<String> computerNumber = createComputerNumber();
        do{
            List<String> playerNum = playerInputNumber();
            validatePlayerNumber(playerNum);
            gameResult = compareNumList(playerNum, computerNumber);
            printBallAndStrike(gameResult.getBall(), gameResult.getStrike());
//            String result = printBallAndStrike2(gameResult.getBall(), gameResult.getStrike());
//            System.out.println(result);
        }while(gameResult.getStrike() != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static GameResult compareNumList(List<String> playerNum, List<String> computerNumber) {
        int ball = 0;
        int strike = 0;

        System.out.println(computerNumber);
        for (int i = 0; i < computerNumber.size(); i++) {
            String tempComNum = computerNumber.get(i);
            String tempUserNum = playerNum.get(i);
            if (tempComNum.equals(tempUserNum)) {
                strike++;
            }
            if (!tempComNum.equals(tempUserNum) && computerNumber.contains(tempUserNum)) {
                ball++;
            }
        }
        return new GameResult(ball, strike);
    }

    public static void printBallAndStrike(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }
    }

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int BASEBALL_SIZE = 3;

    //랜덤 숫자 생성 함수
    private static List<String> createComputerNumber(){
        List<String> numbers = new ArrayList<>();
        while(numbers.size() < BASEBALL_SIZE){
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER));
            if(!numbers.contains(randomNumber))
                numbers.add(randomNumber);
        }
        return numbers;
    }

    //사용자 입력을 받는 함수
    private static List<String> playerInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        return Arrays.asList(
                Console.readLine()
                        .split("")
        );
    }

    //사용자 입력 숫자 검증 함수
    private static void validatePlayerNumber(List<String> playerNum){
        isDigitNumbers(playerNum);
        isThreeNumbers(playerNum);
        isRepeatedNumbers(playerNum);
        checkZero(playerNum);
    }

    //세 자리 숫자임을 검증 함수
    private static void isThreeNumbers(List<String> playerNum){
        if(playerNum.size() != BASEBALL_SIZE){
            throw new IllegalArgumentException("입력된 숫자가 3자리가 아닙니다. 게임을 종료합니다");
        }
    }

    //중복된 값이 있는지 검증 함수
    private static void isRepeatedNumbers(List<String> playerNum){
        Set<String> numset = new HashSet<>();
        for(String num : playerNum){
            numset.add(num);
        }
        if(numset.size() != BASEBALL_SIZE){
            throw new IllegalArgumentException("중복된 값이 존재합니다. 게임을 종료합니다.");
        }
    }

    //입력 값이 숫자인지 검증 함수
    private static void isDigitNumbers(List<String> playerNum){
        try{
            for(String number : playerNum){
                Integer.parseInt(number);
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 게임을 종료합니다.");
        }
    }

    //입력 값에 0이 있는지 검증 함수
    private static void checkZero(List<String> playerNum){
        for(String number : playerNum){
            int num = Integer.parseInt(number);
            if(num == 0){
                throw new IllegalArgumentException("입력된 값에 0이 포함되어 있습니다. 게임을 종료합니다.");
            }
        }
    }

    //게임 재시작 여부 선택 함수
    private static String askPlayerChoice(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        isValidChoice(choice);
        return choice;
    }

    //사용자 선택 검증 함수
    private static void isValidChoice(String choice){
        if(choice != "1" || choice != "2"){
            throw new IllegalArgumentException("사용자의 입력이 1또는 2가 아닙니다. 게임을 종료합니다.");
        }
    }
}
