package baseball;

public enum Order {
    FIRST(1), SECOND(2), THIRD(3);

    private int order;

    Order(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
