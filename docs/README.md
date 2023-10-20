# 기능목록

## BaseballGame

야구게임을 진행시키는 객체이다.

## BaseballNumber

야구번호를 가진 객체이다.

## Continue

 게임진행 커맨드를 가진 객체이다.
 
## BaseballCreateService

 NumberGenerator을 통해 BaseballNumber를 생성하는 서비스객체이다.
 
## BaseballCheckAnswerService
 
 숫자가 볼인지, 스트라이크인지 확인하는 객체이다.

## BaseballGameFlowService

 게임 클리어와 컨디뉴를 확인하는 객체이다.
 
## NumberGenerator

 1~9까지의 무작위의 수를 생성하는 객체이다
 
## ErrorMessage

 에러메세지들을 가진 객체이다.
 
## ProgressMessage

 게임진행 메세지들을 가진 객체이다.
 

## Validator

 전체적인 예외처리를 하는 객체이다
 
 - 3자리수가 아닌경우 예외처리한다.
 - 숫자가 중복된 경우 예외처리한다.
 - 값이 커맨드(1, 2)가 아니면 예외처리한다.
 - 값이 숫자가 아닌 문자가 오면 예외처리한다.

## InputView

 사용자의 입력을 받는 객체이다

## OutputView

 출력을 담당하는 객체이다.