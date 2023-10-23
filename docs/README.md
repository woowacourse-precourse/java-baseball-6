# 기능 분석

## 1. 제한 사항 분석

- 맞춰야 하는 수는 1~9 사이의 서로 다른 3자리 수이다.
- 같은 수가 같은 자리에 있으면 스트라이크다.
- 같은 수가 다른 자리에 있으면 볼이다.
- 같은 수가 없으면 낫싱이다.
- 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료된다.
- 게임의 재식작/종료 구분은 1,2의 수로 구분한다.

## 2. 기능 분석

- 게임을 시작한다.
- 서로 다른 임의의 수 3개 선택한다.
- 선택된 수를 비교한다.
- 게임 종료 여부를 확인한다.
- 게임을 재시작/종료한다.

## 3. 도메인, 역할 분석

- (게임이) 숫자야구를 시작한다. : start
- (컴퓨터가) 서로 다른 임의의 수 3개를 선택한다. : initBalls
- (사용자가) 서로 다른 3자리 수를 선택한다. : attack
- (컴퓨터가) 선택된 수를 비교한다. : defend

## 4. 객체 분석

- Game
    - start(restart)

- Player
  - initBalls

- Attacker : Player
  - attack

- Defender : Player
  - defend

### 결합 관계
- Game
  - Defender
  - Attacker

## 5. 시나리오 분석
1. 게임을 시작한다.
2. 시작 문구를 출력한다.
3. 컴퓨터가 서로 다른 임의의 수 3개를 선택한다.
4. 숫자 입력 문구를 출력한다.
5. 사용자가 서로 다른 3자리 수를 입력한다.
6. 컴퓨터가 선택된 수를 비교한다.
7. 비교 결과를 출력한다.
8. 3개의 숫자를 모두 맞히면
9. 게임 종료 문구를 출력한다.
10. 게임을 재시작/종료 여부를 확인한다.
11. 재시작을 선택하면 2번으로 돌아간다.
12. 종료를 선택하면 게임을 종료한다.

## 6. 예외 분석

- IllegalArgumentException : 잘못된 값을 입력할 경우
  - 입력된 값이 3자리가 아닐 경우 : `InputLengthException`
  - 입력된 값이 숫자가 아닐 경우 : `InputTypeException`
  - 입력된 값이 중복될 경우 : `InputDuplicateException`
  - 입력된 값이 1~9 사이의 수가 아닐 경우 : `InputRangeException`
  - 입력된 값이 1,2가 아닐 경우 : `NotSupportOptionException`

## 7. 패키지 구조

```markdown
├── domain
│ // 도메인 패키지
├── view
│ // 뷰 패키지
│── supports
│ // 지원 패키지 : 도메인과 관련된 지원성 처리를 위한 패키지 ex) Factory, Validator, ...
│── utils
│ // 유틸 패키지 : 도메인과 관련 없는 유틸리티성 처리를 위한 패키지
│── exceptions
│ // 예외 패키지 : 예외 처리를 위한 패키지
└── Application.java
```
