# 기능 구현 목록

***

## ● Controller

+ GameController
    + 전반적인 게임 실행 흐름을 관리
    + View에서 값을 받아와서 저장
    + 유저 입력값과 컴퓨터 저장 값 비교
    + 게임이 종료되면 다시 실행할 것인지 확인

## ● Domain

+ Computer
    + 컴퓨터 값 설정 및 저장
+ User
    + 유저 값 설정 및 저장

## ● Exception

+ InputRetryNumberException
    + 게임 종료 시 유저 입력값 예외 처리
        + 1개의 값만 입력했는지 확인
        + 1이나 2만 입력했는지 확인
+ UserNumberInputException
    + 게임 시작 시 유저 입력값 예외 처리
        + 3개의 값만 입력했는지 확인
        + 1 ~ 9 사이의 값만 입력했는지 확인
        + 중복값이 없는지 확인

## ● Service

+ CalculateService
    + 유저의 입력값을 컴퓨터와 비교하는 비즈니스 로직 구현
    + 입력값으로 스트라이크와 볼 판정
+ DecideNextGameService
    + 게임 종료 시 어떻게 할 것인가 비즈니스 로직 구현
    + 입력값에 따라 boolean 값을 변경해서 다른 역할을 수행하도록 구현
        + 입력값이 1이라면 컴퓨터 숫자 재생성
        + 입력값이 2라면 boolean 값을 true로 변경

## ● Util

+ CreateRandomNumberUtil
    + 컴퓨터가 임의의 3가지 숫자를 갖도록 구현
+ StringParseRelatedUtil
    + 입력값을 Integer 형태로 바꿔서 리스트에 담도록 구현

## ● View

+ FinishView
    + 게임 종료 시 출력되는 화면
    + 다시 할 것인지 입력하도록 구현
    + 입력 값 예외처리 검사 진행
+ GameStartView
    + 게임 시작 시 출력되는 화면
    + 사용자가 생각하는 3가지의 숫자를 입력하도록 구현
    + 입력 값 예외처리 검사 진행
+ InPlayView
    + 게임 진행 중 출력되는 화면
    + 스트라이크와 볼 여부를 출력하도록 구현
    + 다시 할지 여부를 입력하라고 출력