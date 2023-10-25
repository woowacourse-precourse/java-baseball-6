> # 게임 진행
> 1. 게임 시작 메시지 출력
>2. 컴퓨터가 서로 다른 3자리의 숫자를 생성
>3. 플레이어는 서로 다른 3자리의 숫자를 입력
>4. 입력한 숫자 비교 후, 결과 생성 및 반환
>5. 결과 출력
>6. 모두 맞힐 때까지 `4번, 5번` 과정을 반복
>7. 모두 다 맞히면, 게임 종료 메시지 출력
>8. 게임 재시작/종료 여부에 대해 입력<br>
    > 재시작하면 `2번`부터 다시 반복<br>
    > 종료하면 게임은 끝난다

# [ domain/game ]

## 1. GameNumber (record)

### data

- 한 자리의 숫자
- MIN_GAME_NUMBER: `1`
- MAX_GAME_NUMBER: `9`

### method

- 숫자가 1에서 9사이의 범위에 있는지 검증

## 2. GameNumbers

GameNumber 객체 리스트를 지닌 클래스

### data

- GAME_NUMBERS_COUNT: `3`
- 세 자리 숫자: `List<GameNumber>`

### method

- 주어진 숫자 리스트의 유효성을 검사
    - 주어진 숫자 리스트의 크기가 GAME_NUMBERS_COUNT와 일치하는지 확인
    - 숫자 리스트에 중복된 값이 없는지 확인
- 숫자 리스트를 GameNumber 객체의 리스트로 변환
- 지정된 인덱스에 있는 GameNumber 객체를 반환

## 3. Player

`GameNumbers` 클래스를 상속

### method

- 주어진 숫자 리스트로 Player 객체를 생성하여 반환

## 4. Computer

`GameNumbers` 클래스를 상속

### method

- 주어진 숫자 리스트로 Computer 객체를 생성하여 반환
- 컴퓨터와 플레이어의 세 자리 숫자를 비교하고, 게임 결과를 반환
    - 볼의 개수를 계산
    - 스트라이크의 개수를 계산
    - 컴퓨터의 한 자리 숫자와 주어진 플레이어의 한 자리 숫자와 같은 위치, 같은 값인지 확인
    - 컴퓨터의 세 자리 숫자가 주어진 플레이어의 한 자리 숫자를 포함하고 있는지 확인

## 5. ComputerNumberGenerator

게임에서 사용할 Computer의 숫자를 생성하는 클래스

### data

- 숫자를 생성하는 데 사용되는 NumberGenerator 객체

### method

- 무작위로 생성된 유효한 게임 숫자로 구성된 Computer 객체를 생성하여 반환

## 6. GameStatus (enum)

게임을 재시작할지 종료할지 여부를 나타낸다

- `RESTART("1")`
- `EXIT("2")`

### method

- 주어진 입력 문자열에 대해 GameStatus enum constant를 반환

# [ domain/dto ]

## 7. GameResult (record)

### data

- 볼 개수
- 스트라이크 개수

### method

- 스트라이크 개수가 3개인지 확인

# [ Util ]

## 8. Sentence (enum)

게임에서 사용되는 다양한 문장

### data

- `GAME_START`: ("숫자 야구 게임을 시작합니다.")
- `INPUT_NUMBER`: ("숫자를 입력해주세요 : ")
- `GAME_SUCCESS`: ("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
- `GAME_RESTART_OR_EXIT`: ("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

### method

- enum constant에 대한 메시지를 반환

## 9. Err (enum)

게임에서 발생할 수 있는 오류 및 예외 상황에 대한 메시지를 나타낸다

### data

- `DUPLICATE_NUMBERS`: ("서로 다른 숫자만 있어야 합니다.")
- `INVALID_NUMBERS_SIZE`: ("세 자리의 숫자가 있어야 합니다.")
- `INVALID_GAME_STATUS`: ("게임 재실행 또는 종료하려면, 1 또는 2만 입력해야 합니다.")
- `INVALID_NUMERIC_INPUT`: ("숫자 문자만 입력할 수 있습니다.")
- `OUT_OF_RANGE_NUMBERS`: ("1부터 9까지의 범위에 있는 숫자만 가능합니다.")

### method

- 오류 메시지를 `[ERROR]` 접두사와 함께 반환

## 10. Result (enum)

### data

- BALL
- STRIKE
- NOTHING

## 11. InputValidator

입력 데이터를 유효성 검사하는 데 사용되는 클래스

### method

- 주어진 입력 문자열이 숫자로 변환 가능한지 확인하고,</br>
  변환 불가능한 경우 오류 메시지와 함께 예외를 발생시킨다

## 12. NumberGenerator(interface)

숫자 생성 기능을 정의

## 13. RandomNumberGenerator

NumberGenerator의 구현체

### method

- 지정된 범위 내에서 랜덤 숫자를 생성

# [ View ]

## 14. OutputView

게임 메시지 및 결과 출력을 담당하는 클래스

### method

- 결과 출력
- 게임 시작 메시지 출력
- 숫자 입력 메시지 출력
- 게임 성공 메시지 출력
- 게임 재시작/종료에 대한 메시지 출력

## 15. InputView

사용자 입력 처리를 담당하는 클래스

### method

- 사용자로부터 3개의 숫자 입력을 받는다
- 사용자로부터 게임 재시작/종료에 대한 입력을 받는다
- 콘솔에서 문자열을 읽어와 반환한다

# [ Convertor ]

## 16. InputConvertor

사용자 입력 처리 및 변환을 담당하는 클래스

- 사용자로부터 3개의 숫자 입력을 받아 Player 객체로 변환
- 사용자로부터 게임 상태 입력을 받아 GameStatus로 변환

# [ Controller ]

## 17. GameController

게임의 전체적인 흐름을 제어하는 클래스

- 게임 시작, 게임이 성공할 때까지 반복<br>
  성공 시, 재시작 여부를 판단하여 게임을 반복한다
- 랜덤 컴퓨터 숫자를 생성하고 게임 시작 메시지 출력
- 게임을 진행하고 게임 결과 출력, 3스트라이크가 나올 때까지 게임을 반복