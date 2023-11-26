package baseball.domain;

import java.util.*;
import java.util.stream.Collectors;

public class MenuResult {
    private final List<String> categories = new ArrayList<>();
    private final Map<String, List<String>> menus = new LinkedHashMap<>();

    public MenuResult(Coachs coachs, List<FoodCategory> foodCategories) {
        initiateCategories(foodCategories);
        for (Coach coach : coachs.getCoachs()) {
            menus.put(coach.getName(), coach.getRecommendedFoods());
        }
    }

    private void initiateCategories(List<FoodCategory> foodCategories) {
        categories.add("카테고리");
        categories.addAll(convertTo(foodCategories));
    }

    private static List<String> convertTo(List<FoodCategory> foodCategories) {
        return foodCategories.stream().map(FoodCategory::getName).toList();
    }

    public List<String> getCategories() {
        return categories;
    }

    public Map<String, List<String>> getMenus() {
        return menus;
    }
}
