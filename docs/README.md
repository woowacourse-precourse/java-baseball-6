# 첫 주차 미션 - 숫자 야구

## 프로그램 흐름

### Player : 유저 , 컴퓨터

1. 게임 시작
    - 컴퓨터 랜덤 숫자 3개 저장.

2. 게임 진행
    - 반복 (유저가 숫자 3개 맞추면 종료)
        - 유저 : 숫자 3개 입력
        - 컴퓨터 : 
          - 자릿 수와 숫자가 맞으면 **스트라이크**
          - 숫자는 존재하지만 자리가 틀리면 **볼**
          - 두 경우 모두 존재하지 않으면 **낫싱**

3. 게임 종료
    - 재시작 1, 종료 2 (유저 입력)
    - 재시작 시 2번부터 다시 반복

## 구현 사항 정리

### Error
- [x] InputErrorException (유효하지 않을 시 IllegalArgumentException)
    - [x] GameInputErrorException
        - [x] 숫자가 3자리인지 검사 기능
        - [x] 중복된 숫자가 있는지 검사 기능
        - [x] 숫자 외에 입력값이 들어온지 검사 기능
        - [x] 각 자리 숫자가 1~9의 값인지 확인
    - [x] RetryInputErrorException
        - [x] 1,2 외의 값이 들어오는지 검사 기능
        - [x] 입력 값 숫자인지 확인

### Util
- [x] Random한 3자릿 수 생성해주는 Util 구현
    - [x] 중복 숫자 검사 기능
- [x] MesseageUtil
    - [x] Enum으로 출력할 메시지 나열
    - [x] 출력할 메시지 출력

### Model
- [x] Comuputer
    - [x] 랜덤 숫자 3개 저장할 List
    - [x] 유저 숫자와 비교해 ball Strike 체크
        - [x] strike인지 체크하는 함수 (자리와 숫자가 똑같은지 체크, strike면 Continue로 볼체크 x)
        - [x] ball인지 체크하는 함수 (strike가 아닌 숫자가 ComputerNumber의 존재하는지)

### View
- [x] InputView (InputValidateController에서 유효성 검사)
    - [x] 사용자에게 숫자 3개 입력 받는 기능
      - [x] 유효한 값 인지 ErrorException을 통해 확인 , 유효하지 않으면 종료
    - [x] 사용자에게 재시작 , 종료 여부 입력 받는 기능
      - [x] 유효한 값 인지 ErrorException을 통해 확인 , 유효하지 않으면 종료

- [ ] OutputView
    - [x] 게임 시작 메시지
    - [ ] 입력 받는 숫자의 힌트 제공
    - [ ] 모두 맞출 시 게임 종료
    - [x] 숫자 입력 메시지
    - [x] 게임 재시도 여부 메시지
    - [x] 게임 성공 메세지 (종료 메시지)

### Controller
- [ ] GameController
    - [x] Comuputer Model 생성
        - [x] RandomUtil로 생성한 숫자 저장
    - [ ] 게임 시작
        - [x] 게임 시작 메시지 출력 (OutputView 사용)
        - [ ] 사용자에게 숫자 입력 받기 (InputView 사용)
    - [ ] 유저의 입력 String -> List<Integer> 로 변환 기능
    - [ ] 입력 값과 Comuputer에 저장된 숫자 값 비교후 힌트 제공 (OutputView 사용)
        - [ ] 입력 값을 Computer Model에서 비교 후 Strike 수 , Ball 수 List 배열 받기
        - [x] 비교 결과 받은 ball,strike List를 출력 메시지로 전환 기능
        - [ ] 3스트라이크면 게임 종료
    - [x] 게임 종료
        - [x] 종료 메시지 출력
        - [x] 재시작 , 종료 여부 입력 받기 (InputView 사용)