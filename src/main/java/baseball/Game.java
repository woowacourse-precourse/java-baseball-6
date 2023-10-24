package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Const.*;

public class Game {
    private Integer ball = 0;
    private Integer strike = 0;
    private List<Integer> computerNumberList;
    private List<Integer> userNumberList;

    public Game() {
        init();
    }
    public void init(){
        computerNumberList = new ArrayList<>();
        while(computerNumberList.size() < MAX_RANGE_NUMBER){
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if(!computerNumberList.contains(randomNumber)){
                computerNumberList.add(randomNumber);
            }
        }
    }

    public void play(){
        System.out.print("숫자를 입력해주세요. : ");
        String userNumber = Console.readLine();
        userNumberList = getUserNumberList(userNumber);
        isUserNumberListThree(userNumber);
        isUserNumberDigit(userNumber);
        isSameNumberInList();
        numberCount();
        System.out.println(printResult());
    }

    public List<Integer> getUserNumberList(String userNumber){
        String[] inputNumber = userNumber.split("");
        List<Integer> userNumbers = new ArrayList<>();
        for(int i = 0; i < userNumber.length(); i++){
            userNumbers.add(Integer.parseInt(inputNumber[i]));
        }
        return userNumbers;
    }

    public boolean isUserNumberListThree(String userNumber) throws IllegalArgumentException{
        if(userNumber.length() != MAX_RANGE_NUMBER){
            throw new IllegalArgumentException("세 자리 수를 입력하세요.");
        }
        return true;
    }

    public boolean isUserNumberDigit(String userNumber) throws IllegalArgumentException{
        for(int i = 0; i < userNumber.length(); i++){
            isStringCharDigit(userNumber, i);
        }
        return true;
    }
    public boolean isStringCharDigit(String userNumber, int index) throws IllegalArgumentException{
        if(!Character.isDigit(userNumber.charAt(index))){
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
        return true;
    }

    public boolean isSameNumberInList() throws IllegalArgumentException{
        Set<Integer> sameNumberList = new HashSet<>(userNumberList);
        if(userNumberList.size() != sameNumberList.size()){
            throw new IllegalArgumentException("중복된 숫자입니다.");
        }
        return true;
    }

    public void numberCount(){
        this.strike = 0;
        this.ball = 0;
        for(int i = 0; i< userNumberList.size(); i++){
            if(computerNumberList.indexOf(userNumberList.get(i))==i) {
                strike++;
                continue;
            }
            if(computerNumberList.contains(userNumberList.get(i)))
                ball++;
        }
    }


    public String printResult(){
        if(ball != 0 && strike != 0){
            return(ball + "볼 "+ strike+  "스트라이크");
        }
        if(strike == 0 && ball != 0){
            return(ball + "볼");
        }
        if(strike != 0 && ball == 0){
            return(strike + "스트라이크");
        }
        return ("낫싱");
    }

    public boolean askRetry(){
        if(strike != null && strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String response = Console.readLine();
            if(response.equals("1")){
                init();
                return true;
            }
            if(response.equals("2")){
                return false;
            }
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
        return true;
    }
}
