package baseball;

import java.util.Arrays;
import java.util.Objects;

public enum Menu {
    START("1"),
    TERMINATE("2");

    private final String menuCode;

    Menu(String menuCode) {
        this.menuCode = menuCode;
    }

    public static Menu findMenu(String menuInput) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.isMatching(menuInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 메뉴 번호입니다."));
    }

    private boolean isMatching(String menuInput) {
        return Objects.equals(menuCode, menuInput);
    }
}
