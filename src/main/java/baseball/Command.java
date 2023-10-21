package baseball;

enum Command {
    RETRY(1),
    EXIT(2)
    ;

    final int key;

    Command(int key) {
        this.key = key;
    }
}
