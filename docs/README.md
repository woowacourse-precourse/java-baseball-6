# 클래스 설계 및 초기 기능 목록

## Input

- [ ]  InputParser : 숫자를 입력받아서 Int로 파싱
- [ ]  InputHandler : 숫자의 자리수를 파악하여 비교 진행과 종료를 구분
- [ ]  InputVerifier : 입력을 BaseBallNumber 객체로 변환

## Score (사용자가 성공한 경우의 볼, 스트라이크 수를 저장)

- [ ]  사용자의 현재 점수를 저장
- [ ]  사용자가 맞춘 경우 점수 상태를 갱신
- [ ]  사용자의 현재 점수를 반환
- [ ]  게임이 끝났을 때 초기 상태로 되돌림
- [ ]  사용자의 입력값과 생성된 난수 BaseBallNumber를 비교하는 기능

## Player

- [ ]  입력값을 BaseBallNumber 객체로 파싱해서 비교 가능하게 만듬

## BaseBallNumberGenerator : 유저 맞출  타겟 번호를 생성

- [ ]  List<Integer> 형태로 자리수 별로 나누어 저장하는 구조
- [ ]  Randoms 라이브러리 메소드를 이용해 3자리 난수 생성
- [ ]  List → parse to int mapper로 최종 비교값을 int로 리턴

## GameManager : 프로그램의 전체적인 시행 흐름, 예외 처리, 종료 이벤트 등을 관리함

- 최종 application에서 실행될 대상
- 게임의 진행/종료 여부인지에 따라 케이스를 분기