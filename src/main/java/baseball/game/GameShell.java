package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class GameShell {
    private UniqueNumberString goalNumberString;
    private RuleSet ruleSet = RuleSet.BASIC;

    public void startGame() {
        introduce();
        while (true) {
            runRoundOnce();
            boolean wantToExit = askExit();
            if (wantToExit) {
                break;
            }
        }
        exitGame();
    }

    private void introduce() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void runRoundOnce() {
        setRandomGoalNumber();
        while (true) {
            MatchResult result = tryMatch();
            System.out.println(result);
            if (result.getStrike() == ruleSet.getNumLen()) {
                System.out.println(ruleSet.getNumLen() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private MatchResult tryMatch() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        UniqueNumberString inputNumberString = UniqueNumberString.create(input, ruleSet);
        return UniqueNumberString.match(goalNumberString, inputNumberString);
    }

    private boolean askExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return false;
        }
        if (input.equals("2")) {
            return true;
        }
        throw new IllegalArgumentException("1 혹은 2 중에서 입력해야 합니다.");
    }

    private void exitGame() {
        Console.close();
    }

    private void setRandomGoalNumber() {
        this.goalNumberString = UniqueNumberString.createRandom(ruleSet);
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }
}
