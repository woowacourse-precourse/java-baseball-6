    package baseball;

    import static camp.nextstep.edu.missionutils.Console.readLine;

    public class Game {
        int inputClose(){
            int closeOpt;
            closeOpt = Integer.parseInt(readLine());
            Validator.closeValidator.validateValue(closeOpt);

            return closeOpt;
        }

        boolean isContinue() {
            return inputClose() == 1;
        }

        void playGame() {
            System.out.println("숫자 야구 게임을 시작합니다.");
            do {
                Round round = new Round();
                round.playRound();
            } while (isContinue());
        }
    }