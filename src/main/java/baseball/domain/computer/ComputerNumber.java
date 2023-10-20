package baseball.domain.computer;

// 일급 컬렉션
// 접근 최소화
public class ComputerNumber {
    private final NumberList numberList;

    public ComputerNumber() {
        this.numberList = new NumberList();
    }

    public boolean containsNumber(final int number) {
        return numberList.contains(number);
    }

    public int getNumberAt(final int index) {
        return numberList.get(index);
    }

    public int size() {
        return numberList.size();
    }
}
