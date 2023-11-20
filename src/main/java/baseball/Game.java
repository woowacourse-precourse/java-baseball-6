package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    private int strikeValue = 0;
    private int ballValue = 0;
    private boolean isExit = false;

    User user = new User();
    Computer computer = new Computer();


    public int getStrike(){
        return strikeValue;
    }

    public int getBall(){
        return ballValue;
    }

    public void setUser(User user) {
        user.setMyNumber();
    }

    public void setComputer(Computer computer) {
        List<Integer> computerNumber = selectRandomNumber();
        computer.setComputerNumber(computerNumber);
    }

    public void gameStartPreparation() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        setComputer(computer);
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void gameStart() {
        gameStartPreparation();
        while(!isExit){
            resetStrikeAndBall();
            setUser(user);
            checkMyNumberAllException(user.getMyNumber());
            countStrikeAndBall(user.getMyNumber(),computer.getComputerNumber());
            displayBaseballGameResult(strikeValue,ballValue);
            reStartGame();
        }

    }

    public void resetStrikeAndBall(){
        strikeValue = 0;
        ballValue = 0;
    }

    public void reStartGame(){
        if (isVictory(strikeValue)) {
            // strike가 3이였을 때 실행되는 부분
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int startNumOrEndNum = Integer.parseInt(Console.readLine());
            if (startNumOrEndNum == 1){
                setComputer(computer);
            } else if (startNumOrEndNum == 2) {
                System.out.println("게임 종료");
            }
            isExit = determineFinishOrAgainGame(startNumOrEndNum);
        }
    }

    public List<Integer> selectRandomNumber(){
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNumber.contains(randomNumber)){
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public void countStrikeAndBall(String myNumber, List<Integer> computerNumber) {
        for (int i =0; i<myNumber.length(); i++){
            int numberValue = Character.getNumericValue(myNumber.charAt(i));
            if (numberValue == computerNumber.get(i)){
                strikeValue++;
            } else if (computerNumber.contains(numberValue) && computerNumber.indexOf(numberValue) != i) {
                ballValue++;
            }
        }
    }

    public boolean isVictory(int strikeValue){
        if (strikeValue == 3){
            return true;
        } else if (strikeValue != 3) {
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

    public void displayBaseballGameResult(int strikeValue, int ballValue){
        if (strikeValue == 0 && ballValue == 0){
            System.out.println("낫싱");
        } else if (strikeValue == 3) {
            System.out.println(String.format("%d스트라이크",strikeValue));
            System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료",strikeValue));
        } else if (strikeValue != 0 && ballValue != 0){
            System.out.println(String.format("%d볼 %d스트라이크",ballValue,strikeValue));
        } else if (ballValue == 0){
            System.out.println(String.format("%d스트라이크",strikeValue));
        } else if (strikeValue == 0){
            System.out.println(String.format("%d볼",ballValue));
        }
    }

    public void checkDuplicateNumber(String myNumber){
        HashMap<String,Integer> countNumber = new HashMap<>();
        for(int i = 0; i < myNumber.length(); i++){
            String numberValue = Character.toString(myNumber.charAt(i));
            if (!countNumber.containsKey(numberValue)){
                countNumber.put(numberValue,1);
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

    public void checkMyNumberAllException(String myNumber){
        checkDuplicateNumber(myNumber);
        checkLengthNumber(myNumber);
        checkOnlyInterger(myNumber);
    }

}
