package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private Answer input;

    public void setAnswer(final String input) {
        this.input = new Answer(input);
    }

    public void playGame(Computer computer) {
        boolean inGame = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(inGame) {
            playTurn(computer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String option = Console.readLine();
            ContinueOption.validate(option);

            if(option.equals(ContinueOption.RESTART.getValue())) {
                computer.updateAnswer();
                continue;
            }
            if(option.equals(ContinueOption.END.getValue())) {
                return;
            }
        }
    }

    public void playTurn(Computer computer) {

        boolean onTurn = true;
        while(onTurn) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputStr = Console.readLine();
            setAnswer(inputStr);
            Result result = computer.checkAnswer(input);
            result.print();

            if(result.isCorrect(input.getLength())) {
                onTurn = false;
                continue;
            }
        }
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        System.out.println("게임 종료");
    }
}