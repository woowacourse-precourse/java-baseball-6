package baseball;

public class Number {
    int num;

    public Number(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;  // 같은 객체인 경우 true 반환
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Number otherNumber = (Number) obj;
        return this.num == otherNumber.num;
    }
}
