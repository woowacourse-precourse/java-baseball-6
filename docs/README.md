# 기능 목록

---

## BaseballPlayer

숫자 야구 참여자들의 인터페이스

- 사용자의 입력을 받는 `inputBaseballNumbers()`

---

## User

`BaseballPlayer` 의 구현체

- `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 이용하여 구현한 `inputBaseballNumbers()`

---

## Computer

`BaseballPlayer` 의 구현체

- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 이용하여 구현한 `inputBaseballNumbers()`

---

## BaseballNumber

숫자 야구에 필요한 Integer를 래핑한 클래스

- 한글 입력을 검증하는 `validateNumericInput(String baseballNumber)`
- 주소 값이 아닌 값 자체 비교를 위한 오버라이드 함수 `equals()`,`hashCode()`

---

## BaseballNumbers

`List<BaseballNumber>`를 래핑한 일급 컬렉션

- 리스트 크기를 반환해주는 `size()`
- 리스트에 존재하는 `BaseballNumber`를 가져오는 `get(int index)`
- `List<BaseballNumber>`에 매개변수로 받은 `BaseballNumber`를 포함하고 있는지 판별하는 `contains()`
- 자리 수 검증하는 `validateMaxLength(List<BaseballNumber> baseballNumbers)`
- 중복된 수 검증하는 `validateDuplcateNumber(List<BaseballNumber> baseballNUmbers)`
- 각 자리의 값이 같은지 판별하기 위한 오버라이드 함수 `equals()`

---

## BaseballScore

strike와 ball 계산을 위한 클래스

- `BaseballNumbers` 두 개를 받아 strike, ball을
  계산해주는`calculateStrikeAndBall(BaseballNumbers computerBaseballNumber, BaseballNumbers playerBaseballNumber)`
- strike, ball 0으로 초기화 시켜주는 함수 `clearStrikeAndBall()`
- 스트라이크 개수 반환 `getStrike()`
- 볼 개수 반환 `getBall()`

---

## Referee

- 게임 시작 함수 `playBall()`
- 게임의 흐름을 묶은 함수 `baseballFlow()` 흐름 : 입력해주세요 출력 -> 스트라이크, 볼 0으로 초기화 -> 사용자 입력 -> 스트라이크, 볼 계산 -> 힌트 출력
- 계속 진행할 것인지, 프로그램을 끝낼 것인지 물어보는 기능 `continueOrFinish()`

---

## Message

- `BaseballRules`의 함수를 이용하여 힌트를 출력하는 `printHintMessage()`
- 사용자의 입력을 받는 메세지를 출력하는 `printIntegerInputFromUserMessage()`
- 게임을 계속 진행할지, 끝낼지 물어보는 `printContinueOrFinishMessage()`
- 3스트라이크 일 때 메세지 출력하는 `printThreeStrikeMessage()`
- 게임 종료 시 메세지 출력하는 `printEndGameMessage()`
- 잘못된 입력시 출력되는 `printErrorMessage()`

---

## BaseballRules

- 스트라이크, 볼 둘다 존재 경우를 판별하는 `hasStrikeAndBall()`
- 스트라이크는 있지만, 볼은 없는 경우를 판별하는 `hasStrikeButNoBall()`
- 스트라이크가 없지만, 볼은 있는 경우를 판별하는 `hasBallButNoStrike()`
- 스트라이크, 볼 둘 다 없는 경우를 판별하는 `noStrikeAndBall()`
