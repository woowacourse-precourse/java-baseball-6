package baseball.game.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baseball {

    private final List<Character> baseball;

    public Baseball(List<Character> baseball) {
        this.baseball = baseball;
    }

    public char at(int position) {
        return baseball.get(position);
    }

    public int indexOf(char value) {
        return baseball.indexOf(value);
    }

    public int size() {
        return baseball.size();
    }

    public static Baseball of(char... baseballs) {
        final List<Character> characters = new ArrayList<>();
        for (char ch : baseballs) {
            characters.add(ch);
        }
        return new Baseball(characters);
    }

    public static Baseball of(String inputValue) {
        return of(inputValue.toCharArray());
    }
}
