package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public void playGame(Computer computer) {
        boolean inGame = true;

        System.out.println(Message.START_GAME);
        while(inGame) {
            playTurn(computer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            GameOption option = readOption();

            if(option == GameOption.RESTART) {
                computer.updateAnswer();
                continue;
            }
            if(option == GameOption.END) {
                return;
            }
        }
    }

    public void playTurn(Computer computer) {
        boolean onTurn = true;
        while(onTurn) {
            System.out.print(Message.ENTER_NUMBER);
            Answer inputAnswer = readAnswer();
            Result result = computer.checkAnswer(inputAnswer);
            result.print();

            if(result.isCorrect(inputAnswer.getLength())) {
                onTurn = false;
            }
        }
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        System.out.println("게임 종료");
    }

    private Answer readAnswer() {
        String input =  Console.readLine();
        return new Answer(input);
    }

    private GameOption readOption() {
        String input =  Console.readLine();
        return GameOption.of(input);
    }
}