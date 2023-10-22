package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Baseball baseball = new Baseball();
        List<Character> characters = new ArrayList<>();
        for(char num = '1' ; num <= '9' ; num += 1)
            characters.add(Character.valueOf(num));
        baseball.setDomain(characters);
    }
}
