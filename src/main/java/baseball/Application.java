package baseball;

import baseball.domain.MyNumber;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.run();
    }
}

class Computer{

    private List<Integer> answerNumberList;
    public Computer(List<Integer> answerNumber) {
        this.answerNumberList = answerNumber;
    }

    public List<Integer> getAnswerNumberList() {
        return answerNumberList;
    }
}
class BaseBallGame{

    public void run(){

        boolean playButton = true;
        while(playButton) {
            printStartMessage();
            playGame();
            printEndMessage();
            playButton = inputRestartOrEndButton();
        }
    }

    public boolean inputRestartOrEndButton() {
        String playButton = Console.readLine();
        validatePlayButton(playButton);
        return Integer.valueOf(playButton) == 1;
    }

    public void validatePlayButton(String playButton) {
        if(isNotIntegerType(playButton)){
            throw new IllegalArgumentException("정수 타입이 아닙니다");
        }
        if(isNotCorrectButton(playButton)){
            throw new IllegalArgumentException("버튼 입력은 1 또는 2만 가능합니다");
        }
    }

    public boolean isNotCorrectButton(String playButton) {
        return !(playButton.equals("1") || playButton.equals("2"));
    }

    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void playGame() {
        MyNumber myNumber = new MyNumber();
        Computer computer = new Computer(createRandomNumber());

        System.out.println(computer.getAnswerNumberList());
        while(myNumber.getStrike() != 3){
            myNumber.resultInit();
            printInputNumberMessage();
            inputNumber(myNumber);
            getResult(myNumber,computer);
        }
    }

    public void getResult(MyNumber myNumber, Computer computer) {
        getStrikeAndBallCount(myNumber,computer);
        printResult(myNumber);
    }

    public void printResult(MyNumber myNumber) {
        int ball = myNumber.getBall();
        int strike = myNumber.getStrike();

        if(ball != 0 && strike != 0){
            System.out.println(ball + "볼 " + strike +"스트라이크");
        }
        if(ball != 0 && strike == 0){
            System.out.println(ball + "볼");
        }
        if(ball == 0 && strike != 0){
            System.out.println(strike + "스트라이크");
        }
        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
        }
    }

    public void getStrikeAndBallCount(MyNumber myNumber, Computer computer) {
        List<Integer> myNumberList = myNumber.getMyNumberList();
        List<Integer> answerNumberList = computer.getAnswerNumberList();

        for(int numberIndex = 0 ; numberIndex < myNumberList.size() ; numberIndex++){
            int number = myNumberList.get(numberIndex);
            if(number == answerNumberList.get(numberIndex)){
                myNumber.strikeCount();
            }
            if(number != answerNumberList.get(numberIndex)
                    && answerNumberList.contains(number)){
                myNumber.ballCount();
            }
        }
    }

    public void inputNumber(MyNumber myNumber) {
        String inputNumber = Console.readLine();
        validateInputNumber(inputNumber);
        List<Integer> myNumberList = splitStringToDigits(inputNumber);
        myNumber.setMyNumberList(myNumberList);
    }

    public void validateInputNumber(String inputNumber) {
        if(isNotIntegerType(inputNumber)){
            throw new IllegalArgumentException("정수 타입이 아닙니다");
        }
        if(isNotCorrectRange(inputNumber)){
            throw new IllegalArgumentException("길이가 일치하지 않습니다");
        }
        if(isDuplicateNumber(inputNumber)){
            throw new IllegalArgumentException("중복된 숫자가 있습니다");
        }
    }

    public boolean isDuplicateNumber(String inputNumber) {
        List<Integer> numberList = splitStringToDigits(inputNumber);

        HashSet<Integer> numberSet = new HashSet<>(numberList);
        return numberSet.size() != inputNumber.length();
    }

    public List<Integer> splitStringToDigits(String inputNumber){
        return Arrays.stream(inputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean isNotCorrectRange(String inputNumber) {
        return inputNumber.length() != 3;
    }

    public boolean isNotIntegerType(String inputNumber) {
        String integerCode = "^[-+]?\\d+$";
        Pattern pattern = Pattern.compile(integerCode);
        Matcher matcher = pattern.matcher(inputNumber);

        return !matcher.matches();
    }

    public void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> createRandomNumber(){
        List<Integer> randomNumberList = new ArrayList<>();
        while(randomNumberList.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!randomNumberList.contains(randomNumber)){
                randomNumberList.add(randomNumber);
            }
        }

        return randomNumberList;
    }
}
