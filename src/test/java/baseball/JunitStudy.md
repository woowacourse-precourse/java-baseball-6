## 테스트 코드 분석공부

`@Test
void 게임종료_후_재시작() {
assertRandomNumberInRangeTest(
() -> {
run("246", "135", "1", "597", "589", "2");
assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
},
1, 3, 5, 5, 8, 9
);
}`

- run => 사용자가 입력했을 값
- assertThat(a,b) => a,b의 값 동일인지 비교
- output() => 콘솔에서 출력된 값
- contatins() => 결과값중 포함여부확인
- 1,3,5,5,8,9 => 컴퓨터가 생성한 숫자

`  @Test
void 예외_테스트() {
assertSimpleTest(() ->
assertThatThrownBy(() -> runException("1234"))
.isInstanceOf(IllegalArgumentException.class)
);
}`

- assertThatThrownBy => Exception이 발생하는지 확인
- isInstanceOf() => 인자로 들어간 class 에서 생성된 클래스 or 하위클래스인지 확인
- 제공되는 함수여서 테스트코드를 따로 공부해서 작성해야 됄것같다.

### 따라서 Given-When-Then 구조로 작성하기

준비->실행->검증 의 방식으로 작성하기!