package baseball;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        play();

    }

    private static void play() {
        List<Integer> randomNumbers = getRandomNumbers();
        System.out.println(randomNumbers);

        boolean answer = false;
        while (!answer) {
            List<Integer> inputNumbers = getInputNumbers();
            System.out.println(inputNumbers);

            answer = getAnswer(randomNumbers, inputNumbers);
            int strikeCount = getStrikeCount(randomNumbers, inputNumbers);
            int ballCount = getBallCount(randomNumbers, inputNumbers);

            System.out.println(answer);
            System.out.println(strikeCount);
            System.out.println(ballCount);

            printResults(strikeCount, ballCount);
        }


        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int isContinue = Integer.parseInt(readLine());
        if(isContinue==1){
            play();
        }else if(isContinue==2){
            close();
            return;
        }
    }

    private static void printResults(int strikeCount, int ballCount) {
        StringBuilder resultBuilder = new StringBuilder();
        buildBallMessage(resultBuilder, ballCount);
        buildStrikeMessage(resultBuilder, strikeCount);
        buildNothingMessage(resultBuilder);

        System.out.println(resultBuilder);
    }

    private static void buildBallMessage(StringBuilder builder, int ballCount) {
        if (ballCount > 0) {
            builder.append(ballCount).append("볼");
        }
    }

    private static void buildStrikeMessage(StringBuilder builder, int strikeCount) {
        if (strikeCount > 0) {
            builder.append(strikeCount).append("스트라이크");
            builder.append(" ");
        }
    }

    private static void buildNothingMessage(StringBuilder builder) {
        if (builder.isEmpty()) {
            builder.append("낫싱");
        }
    }



    private static int getBallCount(List<Integer> randomNumbers, List<Integer> inputNumbers) {
        int ballCount = 0;
        for (int index=0; index<3; index++){
            boolean isSameNumber = randomNumbers.get(index).equals(inputNumbers.get(index));
            boolean hasInputNumber = randomNumbers.contains(inputNumbers.get(index));
            if (!isSameNumber && hasInputNumber) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private static int getStrikeCount(List<Integer> randomNumbers, List<Integer> inputNumbers) {
        int strikeCount = 0;
        for (int index=0; index<3; index++){
            if (randomNumbers.get(index).equals(inputNumbers.get(index))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static boolean getAnswer(List<Integer> randomNumbers, List<Integer> inputNumbers) {
        boolean isAnswer = true;
        for (int index=0; index<3; index++){
            if (!randomNumbers.get(index).equals(inputNumbers.get(index))) {
                isAnswer = false;
                break;
            }
        }
        return isAnswer;
    }

    private static List<Integer> getInputNumbers() {
        // get numbers from user input
        System.out.print("숫자를 입력해주세요 : ");

        String input = readLine();
        List<Integer> inputNumbers = new ArrayList<>();
        for (int index=0; index<3; index++){
             inputNumbers.add(Integer.parseInt(input.substring(index, index+1)));
        }
        return inputNumbers;
    }

    private static List<Integer> getRandomNumbers() {
        // get random numbers from 1 to 9
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int pickNumber = pickNumberInRange(1,9);
            if (!randomNumbers.contains(pickNumber)) {
                randomNumbers.add(pickNumber);
            }
        }
        return randomNumbers;
    }
}
