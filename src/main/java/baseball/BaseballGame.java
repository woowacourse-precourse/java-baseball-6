package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class BaseballGame {
    List<Integer> computer = new ArrayList<>();
    public BaseballGame(){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public static void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGame game;
        do{
            game = new BaseballGame();
            game.play();
        }while(game.reStart());
    }
    private void play(){
        String answer;
        do {
            System.out.print("숫자를 입력해 주세요 : ");
            answer = Console.readLine();
            checkIsValidAnswer(answer);
        }while(isEnd(answer));
    }

    private boolean isEnd(String answer){
        int[] answers = changeStringToIntList(answer);
        int ball = countBall(answers);
        int strike = countStrike(answers);
        ball -= strike;
        gameMessage(ball,strike);
        return !(strike == answer.length());
    }

    private void gameMessage(int ball, int strike){
        noneBallAndStrikeMessage(ball, strike);
        ballMessage(ball);
        strikeMessage(strike);
        System.out.println();
    }
    private void gameReStartMessage(){
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        System.out.println("게임 종료");
        System.out.println("게임을 새로 시작하러면 1, 종료하려면 2를 입력하세요.");
    }
    private void noneBallAndStrikeMessage(int ball, int strike){
        if(ball == 0 && strike ==0){
            System.out.println("낫싱");
        }
    }

    private void ballMessage(int ball){
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
    }
    private void strikeMessage(int strike){
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
    }

    private int countBall(int[] answers){
        int ball = 0;
        for(int answer : answers){
            if(computer.contains(answer)){
                ball++;
            }
        }
        return ball;
    }
    private int countStrike(int[] answers){
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if(answers[i] == computer.get(i)){
                strike++;
            }
        }
        return strike;
    }
    private int[] changeStringToIntList(String answers){
        int[] intList = new int[answers.length()];
        for(int i = 0; i < answers.length(); i++){
            intList[i] = answers.charAt(i) - '0';
        }
        return intList;
    }

    private void checkIsValidAnswer(String answers) {
        checkStringlength(answers);
        checkIsZeroToNine(answers);
    }
    private void checkIsZeroToNine(String answers){
        for (int i = 0; i < answers.length(); i++) {
            if (answers.charAt(i) < '0' || answers.charAt(i) > '9') {
                throw new IllegalArgumentException(answers);
            }
        }
    }
    private void checkStringlength(String answers){
        if(answers.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
    private boolean reStartRequset(String a){
        if(Objects.equals(a, "1")){
            return true;
        }else if(Objects.equals(a, "2")){
            return false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }


    private boolean reStart(){
        gameReStartMessage();
        String reQuest = Console.readLine();
        return reStartRequset(reQuest);
    }
}
