package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static int ball = 0;
    static int strike = 0;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }
    static void playGame() {
        // 초기화
        ball = 0;
        strike = 0;
        // 랜덤 숫자 생성
        int[] answer = new int[3];
        int answerIndex = 0;
        while (answerIndex < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!isContained(answer, randomNumber)) { // 중복인지 체크
                answer[answerIndex++] = randomNumber;
            }
        }
        // 사용자 입력
        while (strike != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            checkInputNumber(userInput);
            // check Answer - 결과 출력
            checkAnswer(userInput, answer);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        int gameStatus = keepOrStopGame();
        if (gameStatus == 1) {
            playGame();
        }
    }

    static int keepOrStopGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userChoiceStr = Console.readLine();
        int userChoice = Integer.parseInt(userChoiceStr);
        if (userChoice != 1 && userChoice != 2)
            throw new IllegalArgumentException();
        return userChoice;
    }

    static boolean isContained(int[] answer, int randomNumber) {
        for (int i : answer) {
            if (i == randomNumber)
                return true;
        }
        return false;
    }

    static boolean isContained(String str) {
        boolean[] board = new boolean[10];
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (board[c-'0']) {
                return true;
            }
            board[c-'0'] = true;
        }
        return false;
    }

    static void checkInputNumber(String str) {
        if (str.length() != 3){
            throw new IllegalArgumentException();
        }
        if (isContained(str)){ // 중복 체크
            throw new IllegalArgumentException();
        }
        //char[] arr = new char[str.length()]; // 생각해보니 0으로 시작하는 숫자는 어카지..

    }
    static void checkAnswer(String input, int[] answer) {
        ball = 0;
        strike = 0;
        int[] inputArray = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            inputArray[i] = input.charAt(i)-'0';
        }

        int value;
        for (int i = 0; i < answer.length; i++) {
            value = answer[i];
            for (int j = 0; j < inputArray.length; j++) {
                if (value == inputArray[j]){
                    if (i == j)
                        strike++;
                    else
                        ball++;
                }
            }
        }
        // 출력
        String ballComment="";
        String strikeComment="";
        if (ball > 0)
            ballComment = ball + "볼 ";
        if (strike > 0)
            strikeComment = strike + "스트라이크 ";

        if (ball == 0 && strike == 0)
            System.out.println("낫싱");
        else
            System.out.println(ballComment + strikeComment);

    }
}
