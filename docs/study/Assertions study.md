# Assertions study

## 해당 클래스의 목적
> junit의 Assertions를 우테코의 mission에 맞게 기능을 추가하여, 더 편하게 테스트 할 수 있게 하기 위함으로 보인다.

----------
## method 분석
### assertSimpleTest
```java
public static void assertSimpleTest(final Executable executable) {
        assertTimeoutPreemptively(SIMPLE_TEST_TIMEOUT, executable);
}
```
- `assertTimeoutPreemptively`에서 timeout 추가된 버전.  
다른 함수들과 달리 random num을 지정해주지 않는다.  

<br>

### assertRandomNumberInListTest
```java
 public static void assertRandomNumberInListTest(
        final Executable executable,
        final Integer value,
        final Integer... values
    ) {
        assertRandomTest(
            () -> Randoms.pickNumberInList(anyList()),
            executable,
            value,
            values
        );
    }
```
- `assertRandomTest` + `Randoms.pickNumberInList`
- `anyList()` : `assertRandomTest`에서 `when`으로 원하는 메소드 가져오는 용이기 때문에, argumentMatch 용으로 사용함.

<br>

### assertRandomNumberInRangeTest
```java
    public static void assertRandomNumberInRangeTest(
        final Executable executable,
        final Integer value,
        final Integer... values
    ) {
        assertRandomTest(
            () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
            executable,
            value,
            values
        );
    }
```
- `assertRandomTest` + `Randoms.pickNumberInRange`

<br>

### assertRandomUniqueNumbersInRangeTest
```java
    public static void assertRandomUniqueNumbersInRangeTest(
        final Executable executable,
        final List<Integer> value,
        final List<Integer>... values
    ) {
        assertRandomTest(
            () -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()),
            executable,
            value,
            values
        );
    }
```
- `assertRandomTest` + `Randoms.pickUniqueNumbersInRange`

<br>

### assertShuffleTest
```java
    public static <T> void assertShuffleTest(
        final Executable executable,
        final List<T> value,
        final List<T>... values
    ) {
        assertRandomTest(
            () -> Randoms.shuffle(anyList()),
            executable,
            value,
            values
        );
    }
```
- `assertRandomTest` + `Randoms.shuffle`

<br>

### assertRandomTest
```java
    private static <T> void assertRandomTest(
        final Verification verification,
        final Executable executable,
        final T value,
        final T... values
    ) {
        assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());
                executable.execute();
            }
        });
    }
```
- 위의 다른 메소드들의 기본이 되는 메소드
- try-with-resources 구조 : AutoCloseable 인터페이스를 구현하는 자원에 대해, 자원을 자동 반납해줌.
그래서 반납 누락 없이 코드 쓸 수 있다.
- `mockStatic(Random.class)` : Random class 객체를 임시로 만들어줌. Random class의 메소드들이 static이라 MockedStatic class로 만든 것 같다.
- `mock.when(verification).thenReturn()` : `verification`에 원하는 random method 넣으면, `when`으로 체크하고 가져와서 thenReturn 실행.
