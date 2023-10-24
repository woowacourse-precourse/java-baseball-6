package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
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
            System.exit(0);
        }
    }

    private static void printResults(int strikeCount, int ballCount) {
        ArrayList<String> result = new ArrayList<>();
        if(ballCount!=0){
            String ballOut = ballCount + "볼";
            result.add(ballOut);
        }
        if(strikeCount!=0){
            String strikeOut = strikeCount + "스트라이크";
            result.add(strikeOut);
        }
        System.out.println(String.join(" ",result));
    }

    private static int getBallCount(List<Integer> randomNumbers, List<Integer> inputNumbers) {
        int ballCount = 0;
        for (int randomNumberIndex=0; randomNumberIndex<3; randomNumberIndex++){
            for (int inputNumberIndex=0; inputNumberIndex<3; inputNumberIndex++){
                if ((randomNumberIndex!=inputNumberIndex) && (randomNumbers.get(randomNumberIndex).equals(inputNumbers.get(inputNumberIndex)))) {
                    ballCount++;
                }
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
