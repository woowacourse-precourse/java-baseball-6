# ⚾ 공

## 📕 Ball

- [x] 공의 값과 위치 값을 갖는 class
    - [x] 다른 공에 대해 값이 일치하는지 비교
    - [x] 다른 공에 대해 위치 값이 일치하는지 비교
    - [x] 다른 공에 대해 값과 위치 값이 일치하는지 비교 (`equals()` 오버라이딩)

### 📕 BallValue

- [x] 공의 값을 갖는 class
    - [x] 값에 대한 검증
    - [x] `equals()` 오버라이딩

### 📕 BallIndex

- [x] 공의 위치 값을 갖는 class
    - [x] 위치 값에 대한 검증
    - [x] `equals()` 오버라이딩

## 📕 Balls

- [x] `Ball`들을 갖는 class
    - [x] `List<Ball>`만을 가지는 일급 컬렉션
        - [x] `Ball`들의 개수 검증
        - [x] `Ball`들의 값 중복 검증
        - [x] `Ball`들의 위치 중복 검증
    - [x] 어떠한 `Ball`에 대해 같은 값을 가진 `Ball`을 포함하는지 확인
    - [x] 어떠한 `Ball`에 대해 같은 `Ball`을 포함하는지 확인

## 📒 BallsUtils

- [x] Balls 관련 utility class
    - [x] `List<Integer>`를 `List<Ball>`로 변환
    - [x] 무작위 `Balls`을 생성 (게임에서의 정답)
        - [x] `camp.nextstep.edu.missionutils.Randoms`library의 `pickNumberInRange()` 활용
        - [x] 중복값 제외
    - [x] `List<Integer>`를 `Balls`로 변환
    - [x] `String`를 `Balls`로 변환

---

# 🔍 판별 결과

## 📙 ResultStatus

- [ ] `Strike/Ball/Out`에 대한 enum class

## 📒 ResultDeterminerUtil

- [ ] `ResultStatus`를 판별하는 utility class
    - [ ] 하나의 `Ball`와 하나의 `Balls`에 대한 `ResultStatus`를 판별하여 반환

## 📙 Results

- [ ] 2개의 `Numbers`에 대한 `ResultStatus`들을 다루는 class
    - [ ] `Strike/Ball/Out`의 각각의 수를 저장
    - [ ] 결과를 반환 (`toString()` 오버라이딩)

## 📒 ResultStringBuilderUtil

- [ ] 결과를 `String`으로 반환
    - [ ] `Strike`, `Ball`, `Out` 값을 받아 `String`으로 반환
        - [ ] `n볼`로 가공
        - [ ] `n스트라이크`로 가공
        - [ ] 볼과 스트라이크가 없을 경우 `낫싱` 반환

---

# 💻 뷰

## 📗 ConsoleView

- [ ] View를 구현하는 class
    - [ ] `Input` 구현
        - [ ] 입력 구현 : `camp.nextstep.edu.missionutils.Console`library의 `readLine()` 활용
    - [ ] `Output` 구현
        - [ ] 게임 시작 메시지 출력 구현 : `숫자 야구 게임을 시작합니다.`
        - [ ] 숫자 입력 요구 메시지 출력 구현 : `숫자를 입력해주세요 : `
        - [ ] 정답 축하 메시지 출력 구현 : `n개의 숫자를 모두 맞히셨습니다! 게임 종료`
        - [ ] 재시작 여부 질문 메시지 출력 구현 : `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`

## 📗 View

- [ ] `Input`과 `Output`을 상속받는 interface

## 📗 Input

- [ ] 입력을 담당하는 interface
    - [ ] `String`을 입력받는 메소드

## 📗 Output

- [ ] 출력을 담당하는 interface
    - [ ] 게임 시작 메시지 출력
    - [ ] 숫자 입력 요구 메시지 출력
    - [ ] 정답 축하 메시지 출력
    - [ ] 재시작 여부 질문 메시지 출력

## 📒 StringUtils

- [x] String 관련 utility class
    - [x] `String`을 `List<Integer>`로 변환

---

# 🎮 게임

## 📘 BaseballGame

- [ ] `Game`을 구현
- [ ] 전체적인 야구 게임의 흐름을 제어
    - [ ] 1 : 게임 시작 메시지 출력
    - [ ] 2 : 정답 생성
    - [ ] 3 : 숫자 입력 요구 메시지 출력
    - [ ] 4 : 사용자의 숫자 입력
    - [ ] 5 : 정답 판별
    - [ ] 6 : 판별 결과 메시지 출력 `→ 3 or 7`
    - [ ] 7 : 정답 축하 메시지 출력
    - [ ] 8 : 재시작 여부 질문 메시지 출력
    - [ ] 9 : 재시작 여부 입력 `→ 2 or 종료`

## 📘 Game

- [ ] 게임이라는 interface
    - [ ] 게임을 실행하는 `run()` 메소드

## 📘 Application

- [ ] 게임을 실행
