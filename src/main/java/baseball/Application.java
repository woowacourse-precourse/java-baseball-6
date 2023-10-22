package baseball;



import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {


    public boolean compareMyInputNumberAndComputerNumber(String myNumber, List<Integer> computerNumber) {
        int strike = 0;
        int ball = 0;

        for (int i =0; i<myNumber.length(); i++){
            int number = Character.getNumericValue(myNumber.charAt(i));
            if (number == computerNumber.get(i)){
                strike++;
            } else if (computerNumber.contains(number) && computerNumber.indexOf(number) != i) {
                ball++;
            }
        }
        checkAnswerStrikeAndBall(strike,ball);
        
        if (strike == 3){
            return true;
        } else {
            return false;
        }
    }

    public boolean determineFinishOrAgainGame(int startNumOrEndNum){
        if (startNumOrEndNum == 1){
            return false;
        }
        else if (startNumOrEndNum == 2){
            return true;
        }
        // 예외 처리 해야되는 부분
        throw new IllegalArgumentException("startNumOrEndNum 값은 1 또는 2여야 합니다.");
    }

    public void checkAnswerStrikeAndBall(int strike, int ball){
        if (strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println(String.format("%d스트라이크",strike));
            System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료",strike));
        } else if (strike != 0 && ball != 0){
            String result = String.format("%d볼 %d스트라이크",ball,strike);
            System.out.println(result);
        } else if (ball == 0){
            String result = String.format("%d스트라이크",strike);
            System.out.println(result);
        } else if (strike == 0){
            String result = String.format("$d볼",ball);
            System.out.println(result);
        }
    }


    public void checkDuplicateNumber(String myNumber){
        HashMap<String,Integer> countNumber = new HashMap<>();
        for(int i = 0; i < myNumber.length(); i++){
            String number = Character.toString(myNumber.charAt(i));
            if (!countNumber.containsKey(number)){
                countNumber.put(number,1);
            } else {
                throw new IllegalArgumentException("myNumber의 값은 서로 다른 숫자로 이루어져야 합니다");
            }
        }
    }

    public void checkLengthNumber(String myNumber){
        if (myNumber.length() != 3){
            throw new IllegalArgumentException("myNumber의 길이는 3이어야 합니다");
        }
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        // TODO: 프로그램 구현
        Application baseballGame = new Application();

        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> computerNumber = new ArrayList<>();
        boolean isExit = false;

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNumber.contains(randomNumber)){
                computerNumber.add(randomNumber);
            }
        }

        while (!isExit){
            String myNumber = Console.readLine();
            baseballGame.checkDuplicateNumber(myNumber);
            baseballGame.checkLengthNumber(myNumber);
            boolean victory = baseballGame.compareMyInputNumberAndComputerNumber(myNumber,computerNumber);
            if (victory) {
                // strike가 3이였을 때 실행되는 부분
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int startNumOrEndNum = Integer.parseInt(Console.readLine());
                isExit = baseballGame.determineFinishOrAgainGame(startNumOrEndNum);
            }
        }
    }
}
