# java 17 설치 (mac os)
+ brew install --cask temurin
+ brew tap homebrew/cask-versions
+ brew install --cask temurin17
+ brew install openjdk는 16까지 이후버전은 Eclipse Temurin로 이전.

# 기능 구현 목록 
## 1. 스트라이크/볼 처리 기능 
+ BaseballService class
  + [x] countStrike : 유저와 컴퓨터의 각 자릿수의 값이 같은지 비교
  + [x] countBall : 유저와 컴퓨터의 각 자릿수의 값이 다르고 유저의 값이 컴퓨터 다른 자릿스의 존재하는지  
  + [x] countStrike : strike, ball 개수 출력

## 2. 유저 입력 처리
+ UserInputUtils class
  + [x] checkDuplication : hashset을 사용해 입력값이 3개 이하인지 확인
  + [x] checkSize : 입력값이 3인지 확인 
  + [x] checkRangeAndDigit : 입력값이 정수인지, 정수라면 범위가 맞는지 확인
    + 범위가 1 ~ 9을 사용하므로 0일 경우 따로 처리
  + [x] convertStringToInteger : 위의 조건을 모두 통과한 경우 비교를 위해 String을 Integer List로 변경
  
## 3. 게임 진행 기능 
+ BaseballGameService
  + [x] setComputerNum : 컴퓨터 랜덤 숫자 설정 
    + 요구 사항에 따라 camp.nextstep.edu.missionutils 사용
  + [x] setUserNum : 
    + + 요구 사항에 따라 camp.nextstep.edu.missionutils 사용
  + [x] run : 
    1. 컴퓨터 값 설정
    2. 유저 값 입력 및 유저 입력 처리
    3. 스트라이크/볼 카운트
    4. 스트라이크/볼 출력 
    5. 답을 맞춘 경우 재시작 질문
    6. 답을 맞추지 못한 경우 b ~ d 반복 
  + [x] playGame :
    + BaseballService를 사용해 스트라이크/볼 개수 찾음
  + [x] replay : 
    + 요구 사항에 따라 camp.nextstep.edu.missionutils 사용
    + 1일 경우 새로운 게임, 2일 경우 종료
    + 1, 2가 아닐 경우 IllegalArgumentException
