# 미션 - 숫자 야구 게임

## ▶️ 구현할 기능 목록

### Opponent(상대방)
- ✅ initialiser 구현
  - ✅ `generateRandomNumber` 메서드가 유효한 랜덤수를 생성할 때까지 반복하여 초기화 하는 함수 생성
- ✅ generateRandomNumber 메서드 구현
  - ✅ 1부터 9까지 서로 다른 수로 이루어진 3자리의 무작위 수 생성
  - ✅ 생성된 random number와 중복인 숫자가 리스트 내 존재하는지 검사 후 추가
- ✅ validateNumbers 메서드 구현
  - ✅ 생성된 3자리의 숫자가 3자리인 지 확인 : 3자리가 아니면 false를 반환
  - ✅ 생성된 3자리의 숫자가 범위 내의 숫자인 지 확인 : 범위 내 숫자가 아니면 false를 반환
  - ✅ 생성된 3자리의 숫자에 중복 된 값이 있는 지 확인 : 중복된 값이 있으면 false를 반환
  - ✅ 상기의 3가지 validate를 모두 통과하면 true를 반환
- ✅ checkStrike 메서드 구현
  - ✅ 컴퓨터가 생성한 랜덤 수와 사용자가 입력한 수의 값과 위치가 모두 동일하면 strike의 개수를 1씩 증가(strike++)
  - ✅ 그 결과 도출된 strike의 값을 반환
- ✅ checkBall 메서드 구현
  - ✅ 컴퓨터가 생성한 랜덤 수와 사용자가 입력한 수의 값이 같지만 위치는 다른 경우 ball의 개수를 1씩 증가(ball++)
  - ✅ 그 결과 도출된 ball의 값을 반환

### Game(게임)
- ✅ initialiser 구현
  - ✅ Oppoent에서 initialise된 값들을 들고 와서(컴퓨터의 랜덤 수) 초기값을 설정
- ✅ gamePlay 매서드 구현
  - ✅ 사용자로 부터 1부터 9까지 서로 다른 수로 이루어진 3자리의 수 입력 받음
  - ✅ `validateDataType` 메서드로 타입 확인
  - ✅ `toIntegerList` 매서드로 사용자로부터 입력 받은 값으로 Integer List 생성
  - ✅ `validateCount` 메서드로 자리수 확인
  - ✅ `validateRange` 메서드로 범위 내 존재 여부 확인
  - ✅ strike 와 ball의 개수를 가지고 옴
  - ✅ 정답이 아닌 경우 : `printHint`를 사용하여 사용자에게 힌트를 제공
  - ✅ 정답인 경우 : `printWinMessage`을 사용하여 사용자에게 정답 메세지를 출력해줌
- ✅ toIntegerList 메서드 구현
  - ✅ 사용자로부터 입력 받은 String 숫자 값들을 1자리 숫자로 나눠서 List에 저장
- ✅ printHint 메서드 구현
  - ✅ 스트라이크와 볼 모두 없는 경우 : "낫싱" 출력
  - ✅ 입력한 수에 대한 결과를 스트라이크와 볼로 출력 : 볼이 있으면 [볼 개수 + "볼"] 출력 & 스트라이크가 있으면 [스트라이크 개수 + "스트라이크"] 출력
- ✅ printWinMessage 메서드 구현
  - ✅ "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 메세지 출력
- ✅ validateDataType 메서드 구현
  - ✅ 사용자로부터 입력 받은 값을 `Integer.parseInt`로 변환 하여 int 타입인 지 확인 : 예외인 경우 -> IllegalArgumentException
- ✅ validateCount 메서드 구현
  - ✅ 사용자 입력 값이 3자리 수인지 확인 : 예외인 경우 -> IllegalArgumentException
  - ✅ 사용자 입력 값에 중복된 수가 있는지 확인 : 예외인 경우 -> IllegalArgumentException
- ✅ validateRange 메서드 구현
  - ✅ 사용자가 입력한 값의 배열 안의 숫자들이 허용된 범위 안에 존재하는 지 확인 : 예외인 경우 -> IllegalArgumentException

### Controller(컨트롤러)
- ✅ gameStart 메서드 구현
  - ✅ game 초기화 하기
  - ✅ game play 하기
  - ✅ `printRequestRestartOrFinish` 메서드로 사용자의 게임 재시작 여부 물어보기
  - ✅ `validateRange`메서드로 재시작 여부 범위 확인 하기
- ✅ printRequestRestartOrFinish 메서드 구현
  - ✅ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 문구 출력
- ✅ validateRange 메서드 구현
  - ✅ 재시작 여부 입력 받을 시 1 or 2 이외의 숫자일 경우 IllegalArgumentException 예외 처리

---

## ▶️ 프로그램 플로우

### 1. 프로그램 시작
### 2. 게임 시작
### 3. 상대방의 3자리 수 생성
### 4. 상대방의 3자리 수 검증
- 검증 성공 : 통과
- 검증 실패 : (3)으로 이동
### 5. 사용자의 3자리 수 입력
### 6. 사용자의 3자리 수 검증
- 검증 성공 : 통과
- 검증 실패 : `IllegalArgumentException` 발생 및 종료
### 7. 상대방의 3자리 수와 사용자의 3자리 수를 비교
### 8. 비교 결과에 따라 힌트 출력
- 모든 자리의 수가 맞을 경우 : 힌트 출력 후 통과
- 하나라도 수가 틀린 경우 : 힌트 출력 후 (5)로 이동
### 9. 사용자의 재시작/종료 선택
- 1 입력 시 : (3)으로 이동
- 2 입력 시 : 프로그램 종료
- 그 외 입력 시 : `IllegalArgumentException` 발생 및 종료

<br>

---

## ✅ 요구사항 체크리스트

### 기능 요구사항
|✔|체크리스트|
|-|---|
|-|컴퓨터가 1부터 9까지 서로 다른 수를 정상적으로 생성하는가|
|-|사용자의 입력을 정상적으로 받아오는가|
|-|힌트가 정상적으로 출력되는가|
|-|사용자가 입력을 잘못할 경우 `IllegalArgumentException`을 발생시키는가|
|-|컴퓨터의 수와 사용자의 입력을 제대로 비교하여 볼과 스트라이크를 계산하는가|
|-|프로그래밍 실행 결과 예시와 동일한 입력과 출력이 이루어지는가|
|-|정답일 경우 정상적으로 게임이 재시작/종료되는가|

### 프로그래밍 요구사항
|-| 체크리스트                                                        |
|-|--------------------------------------------------------------|
|-| 프로그램의 시작점은 `Application`의 `main()`인가                         |
|-| JDK 17에서 정상 동작하는가                                            |
|-| 자바 코드 컨벤션을 지키는가                                              |
|-| 모든 indent depth가 2이하인가                                       |
|-| 3항 연산자를 쓰지 않는가                                               |
|-| 하나의 함수가 한 가지 일만 하도록 하였는가                                     |
|-| `camp.nextstep.edu.missionutils`의 `Random`, `Console`을 사용했는가 |
|-| `Random`의 `pickNumberInRange()`를 사용했는가                       |
|-| `Console`의 `readLine()`을 사용했는가                               |
|-| `ApplicationTest`의 모든 테스트 케이스가 성공하는가                         |

### 0점 방지
|-| 체크리스트                                   |
|-|-----------------------------------------|
|✔| 자바의 버전이 17버전인가                           |
|-| `gradlew.bat clean test`의 모든 테스트가 통과하는가 |

<br>

---