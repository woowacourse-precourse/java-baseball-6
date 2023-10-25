package baseball;

import java.util.HashMap;

public class FeedbackAssistant {
    public static void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void printEndMessage(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static void printString(String string){
        System.out.println(string);
    }

    private void printNothing(){
        System.out.println("낫싱");
    }

    private void printBall(int ballCount){
        System.out.printf("%d볼", ballCount);
    }
    private void printWhiteSpace(){
        System.out.print(" ");
    }

    private void printStrike(int strikeCount) {
        System.out.printf("%d스트라이크", strikeCount);
    }

    private void printHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0)
            this.printNothing();
        if (ballCount != 0)
            this.printBall(ballCount);
        if (strikeCount != 0)
        {
            this.printWhiteSpace();
            this.printStrike(strikeCount);
        }
        System.out.print("\n");
    }

    public void giveHintToUser(String userInput, String answer) {
        int strikeCount = 0;
        int ballCount = 0;
        HashMap<Character, Integer> answerMap = new HashMap<>();

        for (int i = 0; i < 3; ++i) {
            answerMap.put(answer.charAt(i), i);
            if (userInput.charAt(i) == answer.charAt(i))
                ++strikeCount;
        }
        for (int i = 0; i < 3; ++i) {
            Character current = userInput.charAt(i);
            if (answerMap.containsKey(current) && answerMap.get(current) != i)
                ++ballCount;
        }
        this.printHint(strikeCount, ballCount);
    }

}