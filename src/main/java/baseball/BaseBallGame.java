package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseBallGame {
    private final List<Integer> computerRandomNumber;

    public BaseBallGame() {
        computerRandomNumber = RandomNumberGenerator.getUniqueRandomNumberSequence(3);
    }

    public boolean gameStart(){
        System.out.println(BaseBallGameConstant.START_MESSAGE);
        while (true){
            System.out.print(BaseBallGameConstant.INPUT_MESSAGE);
            String expectNumber = Console.readLine();
            List<Integer> expectNumberSequence = stringToListConverter(expectNumber);
            int numberOfStrike = countNumberOfStrike(expectNumberSequence);
            int numberOfBall = countNumberOfBall(expectNumberSequence, numberOfStrike);
            printDynamicOutput(numberOfBall, numberOfStrike);
            if (numberOfStrike == 3){
                System.out.println(BaseBallGameConstant.CLEAR_MESSAGE);
                System.out.println(BaseBallGameConstant.RESTART_MESSAGE);
                String restartChoice = Console.readLine();
                return getRestartCommand(restartChoice);
            }
        }
    }

    private boolean getRestartCommand(String choice){
        try{
            int convertedChoice = Integer.parseInt(choice);
            if (convertedChoice == 1){
                return true;
            }else if (convertedChoice == 2){
                return false;
            }else{
                throw new IllegalArgumentException();
            }
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    private void printDynamicOutput(final int balls,final int strikes){
        String dynamicOutput;
        if (balls > 0 && strikes > 0){
            dynamicOutput = String.format("%d볼 %d스트라이크", balls, strikes);
        }else if (balls <= 0 && strikes > 0){
            dynamicOutput = String.format("%d스트라이크", strikes);
        }else if (balls > 0 &&  strikes <= 0){
            dynamicOutput = String.format("%d볼", balls);
        }else {
            dynamicOutput = "낫싱";
        }
        System.out.println(dynamicOutput);
    }

    private int countNumberOfStrike(final List<Integer> expectNumberSequence){
        int numberOfStrikes = 0;
        for (int i =0; i < computerRandomNumber.size(); i++){
            if (expectNumberSequence.get(i).equals(computerRandomNumber.get(i))){
                numberOfStrikes++;
            }
        }
        return numberOfStrikes;
    }

    private int countNumberOfBall(final List<Integer> expectNumberSequence,final int numberOfStrikes){
        int numberOfBalls = Math.negateExact(numberOfStrikes);
        Set<Integer> set = new HashSet<>(expectNumberSequence);
        for (Integer randomNumber : computerRandomNumber) {
            if (set.contains(randomNumber)){
                numberOfBalls++;
            }
        }
        return numberOfBalls;
    }

    private List<Integer> stringToListConverter(String numberSequence){
        try{
            numberSequence = numberSequence.replaceAll(" ", "");
            validateInputNumbers(numberSequence);
            return Arrays.stream(numberSequence.split(""))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    private void validateInputNumbers(String numberSequence){
        if (numberSequence.length() != 3){
            throw new IllegalArgumentException();
        }
        List<String> nonDuplicateNumbers = Arrays.stream(numberSequence.split(""))
                .distinct().toList();
        if (nonDuplicateNumbers.size() !=3){
            throw new IllegalArgumentException();
        }
    }
}
