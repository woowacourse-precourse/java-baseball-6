> # 게임 진행
>1. 게임 시작 메시지 출력
>2. 컴퓨터가 서로 다른 3자리의 숫자를 생성
>3. 플레이어는 서로 다른 3자리의 숫자를 입력
>4. 입력한 숫자 비교 후, 결과 생성 및 반환
>5. 결과 출력
>6. 모두 맞힐 때까지 `4번, 5번` 과정을 반복
>7. 모두 다 맞히면, 게임 종료 메시지 출력
>8. 게임 재시작/종료 여부에 대해 입력
>

# [ domain ]

## 1. Player

### data

- 서로 다른 3자리의 숫자 리스트

## 2. Computer

### data

- 리스트(컴퓨터의 서로 다른 세 자리 숫자)

### method

- 컴퓨터의 서로 다른 3자리 숫자와 비교 후, 게임 결과를 생성 및 반환
    - Compter와 Player의 세 자리 숫자의 위치와 값이 모두 같다면, strike 1 증가
    - Computer와 Player의 세 자리 숫자의 값은 같고 위치만 다르면, ball 1 증가
    - GameResult에는 `볼 개수, 스트라이크 개수`가 포함되어야 한다

## 3. ComputerNumberGenerator

### method

- 중복되지 않는 숫자로 구성된 Computer 객체를 생성

## 4. GameResult(DTO, record)

### data

- 볼 개수
- 스트라이크 개수

### method

- 출력할 문자열 포맷팅
- 스트라이크 개수가 3이면, true를 반환 (게임 종료할 때 사용)

## 5. GameStatus (enum)

- RESTART("1")
- EXIT("2")

### method

- 주어진 문자열에 대한 GameStatus를 확인하고 반환한다.

# [ Util ]

## 5. Sentence (enum)

- 게임 시작 메시지
- 숫자 입력 메시지
- 게임 종료 메시지
- 게임 재시작/종료 여부 메시지

## 6. Err (enum)

- Error 메시지
    - "[ERROR] 서로 다른 숫자를 입력해주세요."
    - "[ERROR] 3자리의 숫자를 입력해주세요."
    - "[ERROR] 게임 재실행 또는 종료에 대한 입력 값은 1 또는 2만 가능합니다."

## 7. InputValidator

### method

- 입력값이 숫자 문자열인지 검증한다

## 8. BallNumbersValidator

### method

- 세 자리 숫자인지 검증
- 1 ~ 9 사이의 숫자인지 검증
- 서로 다른 숫자인지 검증

## 9. NumberGenerator(interface)

숫자 생성 기능을 정의

## 10. RandomNumberGenerator

NumberGenerator의 구현체

### method

- 지정된 범위 내에서 랜덤 숫자를 생성

# [ View ]

## 11. OutputView

### method

- 결과 출력
- 게임 시작 메시지 출력
- 숫자 입력 메시지 출력
- 게임 성공 메시지 출력
- 게임 재시작/종료에 대한 메시지 출력

## 12. InputView

### method

- 세 자리 숫자 입력
- 게임 재시작/종료에 대한 입력

# [ Controller ]

## 13. GameController

- 게임 로직 실행
