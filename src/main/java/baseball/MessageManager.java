package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class MessageManager extends Messages {
    private String inputResponse;
    public void showIntro() {
        System.out.print(super.getIntroMessage());
        System.out.println();
    }

    public String getUserInput() {
        System.out.print(super.getInputMessage());
        inputResponse = readLine();
        System.out.println();
        return inputResponse;
    }

    public void showAnswer(Data data, GameProcessor gameProcessor) {
        String answer;
        List<String> answerList = gameProcessor.calculateStrikeBall(data);
        System.out.println(answerList);

        if (Integer.parseInt(answerList.get(0)) > 0 && Integer.parseInt(answerList.get(1)) > 0) {
            System.out.print(answerList.get(0) + super.getSameDigitMessage() + " " + answerList.get(1) + super.getSameNumberMessage());
        }
        if (Integer.parseInt(answerList.get(0)) > 0 && Integer.parseInt(answerList.get(1)) == 0) {
            System.out.print(answerList.get(0) + super.getSameDigitMessage());
        }
        if (Integer.parseInt(answerList.get(0)) == 0 && Integer.parseInt(answerList.get(1)) > 0) {
            System.out.print(answerList.get(1) + super.getSameNumberMessage());
        }
        if (Integer.parseInt(answerList.get(0)) == 0 && Integer.parseInt(answerList.get(1)) == 0) {
            System.out.print(super.getWrongMessage());
        }
    }

//    public void showMessage(GameProcessor gameProcessor, String message) {
//        System.out.print(gameProcessor.getResult() + message);
//    }
}
