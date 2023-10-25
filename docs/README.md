# 기능 구현 목록

## 게임 진행 관점의 절차적 구현

1. 게임 시작 문구 출력
2. 랜덤한 세자리수 생성
3. Player의 숫자 입력
4. 게임 규칙에 따른 결과 반환
5. Player가 정답을 맞힐 때까지 3과 4의 과정을 반복, 맞혔으면 6으로 이동
6. 게임 종료 문구 출력 후, 재시작과 종료 선택 문구 출력
7. 재시작 선택할 경우 2로 이동, 종료 선택할 경우 게임을 완전히 종

## 구현을 위해 필요한 기능

- ### Controller
    - GameController
        - 게임 시작 및 종료 관리
- ### Model
    - Referee
        - 정답을 갖고 있고, 채점을 할 수 있음
    - Answer
        - 새로운 정답을 생성할 수 있음
- ### DTO
    - PlayerDto
        - Player의 입력값 전달
    - ResultDto
        - 게임 결괏값을 전달
- ### View
    - PlayerView
        - Player 입장의 뷰
    - RefereeView
        - Referee 입장의 뷰
    - GameView
        - 게임 시작과 종료를 관리하는 뷰
- ### Util
    - StringToIntegerListParser
        - String 입력값을 Integer 리스트로 변환
- ### Validator
    - InputValidator
      - Player의 입력값의 유효성을 판별
- ### Constant
    - GameConstant
        - 게임 관련 상수 모음
    - GameMessage
        - 게임 진행 메시지 모음
    - ExceptionMessage
        - 예외 발생 메시지 모음