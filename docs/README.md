# 기능 목록

이 문서는 java-baseball 개발하기 전에 설계를 위해 쓰는 문서이다.
세세한 사항은 구현에서 정하고 여기는 특정 기능 나열과 각각의 기능의 위치를 정한다.

### view

* OutputView : 게임의 출력 담당.
* InputView : 게임의 인풋 담당

### domain

* Game : 숫자 야구를 진행하는 도메인.
    * 생성자에 특정 타겟 생성
    * 메서드로 특정 입력을 받으면 스코어를 출력하는 로직 작성
    * 메서드 입력 시 예외 처리 담당

### controller

* GameController : game 도메인과 score dto를 이용해서 게임 흐름을 관장
    * game 결과를 처리하는 로직 작성
    * 게임 재시작 로직 작성

### dto

* ScoreDto : 게임 결과를 전달하는 DTO

### constant

* ~~Message : 인풋 아웃풋 메세지 문자열 모음~~ => 필요한 곳(OutputView)에서 직접 문자열 씀.
* Validation : 유효성 검사 관련 상수 모음
