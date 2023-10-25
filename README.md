## 개요
+ 우아한 테크코스 프리코스 1주차 과제 - 숫자 야구


## 게임 진행 과정
1. 컴퓨터는 서로 다른 3개의 수를 생성한다.
2. 사용자는 컴퓨터가 선택한 수를 예상하여 입력한다.
3. 사용자의 입력에 대한 결과를 출력한다.
    1. 사용자가 입력한 수가 컴퓨터가 생성한 수에 포함되어 있으며 자리가 같으면 스트라이크.
    2. 사용자가 입력한 수가 컴퓨터가 생성한 수에 포함되지 않고 위치가 다르면 볼.
    3. 사용자가 입력한 모든 수가 컴퓨터가 생성한 수에 포함되지 않으면 낫싱.
4. 사용자가 정답을 맞히게 되면 게임이 종료된다.
    1. 1을 입력하면 새로운 게임을 시작하여 1번으로 돌아간다.
    2. 2를 입ㄱ력하면 게임을 끝내고 프로그램 종료. 


##  기능 구현
- 컴퓨터가 숫자를 생성한다.<br>
- 사용자에게 입력을 받는다.<br>
- 게임 결과를 확인한다.<br>
- 재시작 여부를 묻는다.<br>

## 예외 처리
### 사용자 숫자 입력
+ 숫자가 아닌 것을 입력한 경우 `IllegalArgumentException`을 발생시킨다.
+ 숫자가 세자리가 아닌 경우 `IllegalArgumentException`을 발생시킨다.
### 재시작 여부 입력
+ 숫자가 아닌 입력에 대해 `IllegalArgumentException`을 발생시킨다.
+ "1", "2"가 아닌 입력에 대해 `IllegalArgumentException`을 발생시킨다.

## 프로젝트 구성
┣ 📂src<br>
┃ ┣ 📂main<br>
┃ ┃ ┗ 📂java<br>
┃ ┃ ┃ ┣ 📂baseball<br>
┃ ┃ ┃ ┗ 📜Application.java<br>
┃ ┃ ┃ ┣ 📂baseballgame<br>
┃ ┃ ┃ ┃ ┗ 📜Game.java<br>
┃ ┃ ┃ ┃ ┣ 📜Constant.java<br>
┃ ┃ ┃ ┃ ┗ 📜StringError.java<br>
┃ ┃ ┗ 📂test<br>
┃ ┃ ┃ ┗ 📂java<br>
┃ ┃ ┃ ┃ ┗ 📂baseball<br>
┃ ┃ ┃ ┃ ┗ 📜ApplicationTest.java<br>
┗ 📜README.md

### 사용 클래스
+ baseballgame/Game : 전체 게임을 진행하는 클래스
+ constant/Constant : Game에서 사용되는 상수를 관리하는 클래스
+ constant/StringError : Exception에 사용될 에러 메시지를 관리하는 클래스

## 진행 현황
+ 230115 - 프로젝트 시작, 구현 완료