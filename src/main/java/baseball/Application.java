package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

//컴퓨터 랜덤값 생성
class Balls{
    static final int NUMBER_COUNT = 3;
    int number[] = new int[NUMBER_COUNT];
    public void Game(){
        int randomNum;
        int randomNumCount = 0;
        //서로 다른 랜덤값 생성
        while(randomNumCount < 3){
            randomNum = pickNumberInRange(1, 9);
            if(this.compareNumberList(randomNum, number)){
                number[randomNumCount++] = randomNum;
            };
        }
    }
    private boolean compareNumberList(int number, int[] numberArray){
        for(int value: numberArray){
            if(value == number)
                return false;
        }
        return true;
    }
}

class Game{
    final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final String REGAME_MESSAGE =  "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final int NEW_GAME = 1;
    final int QUIT_GAME = 2;
    int[] userNumber = new int[3];
    public void start(Balls computer){
        int reGameAnswer = Game.reGame();
        Hint hint = new Hint();
        Game game = new Game();
        hint.compareAnswer(computer, game);
        hint.Result();

        if(hint.strike != 3){
            Game.start(computer);
            return;
        }
        int newGameAnswer = Game.reGame();
        if (newGameAnswer == 1) {
            computer = new Balls();
            Game.start(computer);
        }

    }
    private void getAnswer(){
        System.out.println(INPUT_MESSAGE);
        String userNumber = readLine();
        Game.checkAnswer(userNumber);
    }
    private void checkAnswer(String string){
        char[] RandomChar = new char[string.length()];
        for(int i = 0; i < string.length(); i++) {
            RandomChar[i] = string.charAt(i);
        }
        if(!Game.checkLength(string)){
            throw new IllegalArgumentException();
        }
        if(!Game.checkNumber(string)){
            throw new IllegalArgumentException();
        }
        if(!Game.checkRange(RandomChar)){
            throw new IllegalArgumentException();
        }
        if(!Game.checkduplicate(RandomChar)){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < RandomChar.length; i++){
            this.userNumber[i] = RandomChar[i] - '0';
        }
    }

    private boolean checkLength(String string){
        if(string.length() == 3){
            return true;
        }
        return false;
    }
    private boolean checkNumber(String string){
        try{
            int numberValue = Integer.parseInt(string);
        }
        catch(NumberFormatException e){
            return false;
        }
        finally{
            return true;
        }
    }
    private boolean checkRange(char[] number){
        char notNumber = '0';
        for(int i = 0; i < String.length(); i++){
            if(number[i] == notNumber){
                return false;
            }
        }
        return true;
    }
    private boolean checkduplicate(char[] number){
        char[] checkDuplicate = new char[number.length];
        for(int i = 0; i < number.length; i++){
            for(char value : checkDuplicate){
                if(number[i] == value)
                    return false;
            }
            checkDuplicate[i] = number[i];
        }
        return true;
    }
    private int reGame(){
        System.out.println(SUCCESS_MESSAGE);
        System.out.println(REGAME_MESSAGE);

        String newGameAnswer = readLine();

        int reGameCheck = Integer.parseInt(newGameAnswer);
        return reGameCheck;

    }
}


class Hint{
    int ball = 0;
    int strike = 0;

    private final String BALL_WORD = "볼";
    private final String STRIKE_WORD = "스트라이크";
    private final String NOT_MATCH_WORD = "낫싱";

    public void compareAnswer(Balls computer, Game user){
        int nowNumber;
        for(int i = 0; i < 3; i++){
            nowNumber = user.userNumber[i];
            for(int value : computer.number){
                if(value != nowNumber){
                    continue;
                }
                if(i == strikecheck(nowNumber, computer.number)){
                    strike++;
                    continue;
                }
                ball++;
            }
        }
    }

    public int strikecheck(int answer, int[] array){
        for(int i = 0; i < array.length; i++){
            if(array[i] == answer){
                return i;
            }
        }
        return -1;
    }
    void Result(){
        String result = "";
        if (this.ball != 0) {
            result += this.ball + BALL_WORD;
        }

        if (this.strike != 0) {
            if (this.ball != 0) {
                result += " ";
            }
            result += this.strike + STRIKE_WORD;
        }

        if (result.equals("")) {
            result = NOT_MATCH_WORD;
        }
        System.out.println(result);
    }
}

public class Application {
    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static void main(String[] args){
        System.out.println(START_MESSAGE);
        Balls computer = new Balls();
        Game game = new Game();
        game.start(computer);
    }
}

