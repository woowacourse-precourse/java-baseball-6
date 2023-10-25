package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

class Array {
    static boolean checkArrayContains(final int[] array, final int number){
        for(int value : array){
            if(value == number){
                return true;
            }
        }
        return false;
    }

    static boolean checkArrayContains(final char[] array, final char number){
        for(int value : array){
            if(value == number){
                return true;
            }
        }
        return false;
    }

    static char[] getArrayFromStr(String str){
        char[] charArray = new char[str.length()];
        for(int i = 0; i < str.length(); i++){
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }

    static int getIndexFromValue(final int[] arr, final int value){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}

class Game {
    static final int NUM_SIZE = 3;
    private static final int NUM_START = 1;
    private static final int NUM_END = 9;
    private static final int GAME_RESTART = 1;
    private static final int GAME_OVER = 2;
    private static final String GET_NUM_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CORRECT_MESSAGE = Game.NUM_SIZE
            + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 "
            + Game.GAME_RESTART + ", 종료하려면 "
            + Game.GAME_OVER + "를 입력하세요.";
    int[] num = new int[NUM_SIZE];

    Game() {
        int randNum;
        int numIdx = 0;

        while(numIdx < NUM_SIZE){
            randNum = this.getRandomNum();
            if(!Array.checkArrayContains(num, randNum)){
                num[numIdx++] = randNum;
            }
        }
    }

    Game(String str){
        for(int i = 0; i < NUM_SIZE;  i++){
            num[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    private int getRandomNum() {
        return pickNumberInRange(Game.NUM_START, Game.NUM_END);
    }

    public static void init(Game correctAnswer){
        Game answer = Game.getAnswer();
        Hint hint = new Hint();
        hint.compareAns(answer, correctAnswer);
        hint.printResult();

        if(hint.strike != Game.NUM_SIZE){
            Game.init(correctAnswer);
            return;
        }

        int newGameAnswer = Game.checkNewGameStart();
        if(newGameAnswer == Game.GAME_RESTART) {
            correctAnswer = new Game();
            Game.init(correctAnswer);
        }
    }

    private static Game getAnswer() {
        System.out.print(GET_NUM_MESSAGE);
        String input = readLine();
        checkException(input);

        return new Game(input);
    }

    private static int checkNewGameStart() {
        System.out.println(CORRECT_MESSAGE);
        System.out.println(RETRY_MESSAGE);

        String newGameAnswer = readLine();
        return Game.getNewGameAnswer(newGameAnswer);
    }

    private static int getNewGameAnswer(String str){
        int intVal;
        try {
            intVal = Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return intVal;
    }

    static void checkException(final String str){
        if(str.length() != NUM_SIZE){
            throw new IllegalArgumentException();
        }
        if(!Game.checkInput(str)){
            throw new IllegalArgumentException();
        }
        if(!Game.equalInput(str)){
            throw new IllegalArgumentException();
        }
    }

    static boolean checkInput(String str){
        try {
            int inputValue = Integer.parseInt(str);
        } catch (NumberFormatException e){
            return false;
        }

        char[] charArray = Array.getArrayFromStr(str);
        return !Array.checkArrayContains(charArray, '0');
    }

    static boolean equalInput(String str){
        char[] checkEqual = new char[str.length()];
        char[] word = Array.getArrayFromStr(str);

        for(int i = 0; i < str.length(); i++) {
            if (Array.checkArrayContains(checkEqual, word[i])) {
                return false;
            }
            checkEqual[i] = word[i];
        }
        return true;
    }
}

class Hint {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    int ball, strike;

    public String toString(){
        return "ball: " + this.ball + ", strike: " + this.strike;
    }

    private void ballCount() {
        this.ball++;
    }

    private void strikeCount() {
        this.strike++;
    }

    void compareAns(Game answer, Game correctAnswer){
        int nowNumber;

        for(int i = 0; i < Game.NUM_SIZE; i++){
            nowNumber = answer.num[i];

            if(!Array.checkArrayContains(correctAnswer.num, nowNumber)){
                continue;
            }
            if(i == Array.getIndexFromValue(correctAnswer.num, nowNumber)){
                strikeCount();
                continue;
            }
            ballCount();
        }
    }
    void printResult(){
        String result = "";
        if(this.ball != 0){
            result += this.ball + BALL;
        }
        if(this.strike != 0){
            if(this.ball != 0){
                result += " ";
            }
            result += this.strike + STRIKE;
        }
        if(result.isEmpty()){
            result = NOTHING;
        }
        System.out.println(result);
    }
}