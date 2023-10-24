package baseball.game.view.input;

import baseball.game.controller.dto.NumberListDto;
import baseball.game.view.exception.CharacterNotNumberException;
import baseball.game.view.exception.DuplicatedNumberException;
import baseball.game.view.exception.NotMenuOptionException;
import baseball.game.view.exception.NumberContainsZeroException;
import baseball.game.view.exception.SizeNotMatchException;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 유저의 입력을 받는 클래스 유저의 입력이 올바르지 않을 경우 RuntimeException 발생
 */
public class InputView {

    public NumberListDto getGuessNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String rawInput = Console.readLine();

        return convertOrThrow(rawInput);
    }

    public boolean askForGameContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String rawInput = Console.readLine();

        isMenuOption(rawInput);

        return rawInput.equals("1");
    }

    public NumberListDto convertOrThrow(String rawInput) {
        List<String> stringList = List.of(rawInput.split(""));
        List<Integer> numberList = new ArrayList<>();

        try {
            for (String s : stringList) {
                numberList.add(Integer.valueOf(s));
            }
        } catch (NumberFormatException e) {
            throw new CharacterNotNumberException();
        }

        checkNumberList(numberList);

        return new NumberListDto(numberList);
    }

    private void checkNumberList(List<Integer> numberList) {
        if (numberList.size() != 3) {
            throw new SizeNotMatchException();
        }

        if (containsZero(numberList)) {
            throw new NumberContainsZeroException();
        }

        if (isDuplicated(numberList)) {
            throw new DuplicatedNumberException();
        }
    }


    private boolean containsZero(List<Integer> numberList) {
        return numberList.contains(0);
    }

    private boolean isDuplicated(List<Integer> numberList) {
        Set<Integer> numberSet = new HashSet<>(numberList);

        return numberSet.size() != numberList.size();
    }

    public void isMenuOption(String rawInput) {
        if (!rawInput.equals("1") && !rawInput.equals("2")) {
            throw new NotMenuOptionException();
        }
    }
}
