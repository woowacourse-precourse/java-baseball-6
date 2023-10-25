package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Host {

    private final Counterpart counterpart;

    Host(Counterpart counterpart) {
        this.counterpart = counterpart;
    }

    /**
     * 야구 게임을 시작한다.<br><br>
     *
     * <h3>※ 야구 게임 규칙</h3>
     * <ul>기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.</ul>
     * <ul>같은 수가 같은 자리에 있는 경우를 "스트라이크", 다른 자리에 있는 경우를 "볼" 이라고 한다.</ul>
     * <ul>사용자가 정답을 입력할 때 마다 볼과 스트라이크의 개수를 출력한다.
     *     사용자는 이 힌트를 통해서 정답을 유추할 수 있다.</ul>
     */
    public void play() {
        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {

            //하나의 게임 세트
            Answer answer;
            do {
                // 사용자에게 답안 입력 요구
                System.out.print("숫자를 입력해주세요 : ");
                try{
                    String usersAnswerInput = Console.readLine();
                    answer = new Answer(Integer.parseInt(usersAnswerInput));
                } catch (Exception e) {
                    // 잘못된 입력으로 인한 예외가 IllegalArgumentException이 아닌 경우에도 IllegalArgumentException으로 바꾸어
                    // 던지도록 처리한다. 요구사항에 따르면 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시켜야
                    // 하기 떄문이다.

                    // NoSuchElementException <- Console.readLine()
                    // NumberFormatException <- parseInt

                    throw new IllegalArgumentException();
                }
            } while (!counterpart.isCorrect(answer));

            // 반복 여부 입력 받기
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int playAgain;
            try {
                String usersChoiceInput = Console.readLine();
                playAgain = Integer.parseInt(usersChoiceInput);
            } catch (Exception e) {
                // 잘못된 입력으로 인한 예외가 IllegalArgumentException이 아닌 경우에도 IllegalArgumentException으로 바꾸어
                // 던지도록 처리한다. 요구사항에 따르면 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시켜야
                // 하기 떄문이다.

                // NoSuchElementException <- Console.readLine()
                // NumberFormatException <- parseInt

                throw new IllegalArgumentException();
            }
    
            // 반복 여부 판별
            switch (playAgain) {
                case 1:
                    counterpart.generateCorrectAnswer();
                    continue;
                case 2:
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}
