package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model{
    private static final int NUM_SIZE = 3;
    private static final String BALL_SENTENCE = "볼 ";
    private static final String STRIKE_SENTENCE = "스트라이크 ";
    private static final String NOTING_SENTENCE = "낫싱 ";
    private static final String ERR_SENTENCE = "유효하지 않은 숫자입니다.";
    View view = new View();
    public List<Integer> initComputerNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> initPlayerNum(){
        view.inputText();
        String inputNum = Console.readLine();
        isValidUserInput(inputNum);

        return stringToArrayList(inputNum);
    }
    public void isValidUserInput(String input){
        isDuplicate(input);
        isNumber(input);
        isThreeNum(input);
        isZeroNum(input);
    }
    public void isThreeNum(String input){
        if(input.length() != NUM_SIZE){
            throw new IllegalArgumentException(ERR_SENTENCE);
        }
    }
    public void isDuplicate(String input){
        Set<Character> set = new HashSet<>();
        for(char checknum : input.toCharArray()){
            set.add(checknum);
        }
        if(set.size() != input.length()){
            throw new IllegalArgumentException(ERR_SENTENCE);
        }
    }
    public void isNumber(String input){
        for (char number : input.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException(ERR_SENTENCE);
            }
        }

    }
    public void isZeroNum(String input){
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == '0'){
                throw new IllegalArgumentException(ERR_SENTENCE);
            }
        }
    }

    public List<Integer> stringToArrayList(String input){
        List<Integer> numList = new ArrayList<>();

        for(int i = 0; i < input.length(); i++){
            char numChar = input.charAt(i);
            int number = Character.getNumericValue(numChar);
            numList.add(number);
        }
        return numList;
    }

    public int countStrike(List<Integer> computer, List<Integer> player){
        int numStrike = 0;
        for(int i=0; i < player.size(); i++){
            if(computer.get(i).equals(player.get(i))){
                numStrike++;
            }
        }
        return numStrike;
    }
    public int countBall(List<Integer> computer, List<Integer> player){
        int numBall = 0;
        for(int i=0; i < player.size(); i++){
            if(computer.contains(player.get(i)) && !computer.get(i).equals(player.get(i))){
                numBall++;
            }
        }
        return numBall;
    }
    public String initHint(int ball, int strike){
        String message = "";
        if (ball != 0){
            if (strike != 0){
                message = ball + BALL_SENTENCE + strike + STRIKE_SENTENCE;
            }
            else{
                message = ball + BALL_SENTENCE;
            }
        }
        else{
            if (strike != 0){
                message = strike + STRIKE_SENTENCE;
            }
            else{
                message = NOTING_SENTENCE;
            }
        }
        return message;
    }

    public int inputRestartOrExit(){
        String inputNum = Console.readLine();
        isValidRestartInput(inputNum);
        return Integer.parseInt(inputNum);
    }

    public void isValidRestartInput(String input){
        isNotValid(input);
    }
    public void isNotValid(String input){
        int number = Integer.parseInt(input);
        if(number != 1 && number != 2){
            throw new IllegalArgumentException(ERR_SENTENCE);
        }
    }

}