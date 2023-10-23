package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    private int strike = 0;
    private int ball = 0;
    public List<Integer> selectRandomNumber(List<Integer> computerNumber){
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNumber.contains(randomNumber)){
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public int getStrike(){
        return strike;
    }

    public int getBall(){
        return ball;
    }

    public void countStrikeAndBall(String myNumber, List<Integer> computerNumber) {
        for (int i =0; i<myNumber.length(); i++){
            int number = Character.getNumericValue(myNumber.charAt(i));
            if (number == computerNumber.get(i)){
                strike++;
            } else if (computerNumber.contains(number) && computerNumber.indexOf(number) != i) {
                ball++;
            }
        }
    }


    public boolean isVictory(int strike){
        if (strike == 3){
            return true;
        } else if (strike != 3) {
            return false;
        }
        return false;
    }

    public boolean determineFinishOrAgainGame(int startNumOrEndNum){
        if (startNumOrEndNum == 1){
            return false;
        } else if (startNumOrEndNum == 2){
            return true;
        }
        // 예외 처리 해야되는 부분
        throw new IllegalArgumentException("startNumOrEndNum 값은 1 또는 2여야 합니다.");
    }

    public void displayBaseballGameResult(int strike, int ball){
        if (strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println(String.format("%d스트라이크",strike));
            System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료",strike));
        } else if (strike != 0 && ball != 0){
            System.out.println(String.format("%d볼 %d스트라이크",ball,strike));
        } else if (ball == 0){
            System.out.println(String.format("%d스트라이크",strike));
        } else if (strike == 0){
            System.out.println(String.format("%d볼",ball));
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

    public void checkOnlyInterger(String myNumber){
        for(int i =0; i < myNumber.length(); i++){
            if(!Character.isDigit(myNumber.charAt(i))){
                throw new IllegalArgumentException("myNumber의 값은 숫자로 이루어져야 합니다.");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        // TODO: 프로그램 구현
        Application baseballGame = new Application();



        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> computerNumber = new ArrayList<>();
        boolean isExit = false;
        computerNumber = baseballGame.selectRandomNumber(computerNumber);

        while (!isExit){
            baseballGame.strike = 0;
            baseballGame.ball = 0;
            String myNumber = Console.readLine();
            baseballGame.checkOnlyInterger(myNumber);
            baseballGame.checkDuplicateNumber(myNumber);
            baseballGame.checkLengthNumber(myNumber);
            // 볼의 유형만 세주기
            baseballGame.countStrikeAndBall(myNumber,computerNumber);
            // 볼의 유형 세주는 메서드와 정답을 출력해주는 메서드 분리하기
            baseballGame.displayBaseballGameResult(baseballGame.strike, baseballGame.ball);
            if (baseballGame.isVictory(baseballGame.strike)) {
                // strike가 3이였을 때 실행되는 부분
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int startNumOrEndNum = Integer.parseInt(Console.readLine());
                if (startNumOrEndNum == 1){
                    computerNumber.clear();
                    computerNumber = baseballGame.selectRandomNumber(computerNumber);

                }
                isExit = baseballGame.determineFinishOrAgainGame(startNumOrEndNum);
            }
        }
    }
}
