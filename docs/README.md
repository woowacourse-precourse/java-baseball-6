# 숫자 야구 게임 구현 기능 목록


-----


>### 랜덤 숫자 생성
>
>---
>-[x] 첫 번째, 두 번째, 세 번째 자리수 구분
>
>##### 조건
>-[x] 세 숫자가 중복되지 않는다.
>-[x] 숫자는 1부터 9까지
>-[x] camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()사용
>
>### 사용자 숫자 입력
>
>
>---
>-[x] 첫 번째, 두 번째, 세 번째 자리수 구분
>##### 조건
>-[x] camp.nextstep.edu.missionutils.Console의 readline() 사용
>### 사용자 숫자 판단
>
>
>---
>-[x] 정답 여부 체크
>-[x] 볼 개수 체크
>-[x] 스트라이크 개수 체크
>-[x] 없을 경우 낫싱
>### 결과 출력
>
>
>---
>-[x] 정답인 경우(strike 3개) 게임 클리어
>
>### 재시작 혹은 종료
>
>
>---
>-[x] 1입력은 재시작, 2 입력은 게임 종료       
>
>  
> 
> ### 테스트 통과 필요
>
>
>---
>- [x] ApplicationTest
>- [x] NumberTest


># MVC 형태 설계
>
>
>-----
>
>## model
>
>----
>### Score
>-[x] baseball게임의 ball, strike로 이루어진 점수 데이터가 저장된다.
>
>## View
>
>---
>### BaseBallGame
>-[x] 게임 run
>-[x] user의 숫자 입력 받아오기
>-[x] 정답을 맞출 때까지 게임 반복하기
>-[x] 정답을 맞추면 게임을 종료하고, 다시 시작할지, 프로그램을 종료할지 묻기
>##### 조건
>- [x] 1입력 시 게임 재시작
>- [x] 2입력 시 게임 종료
>
> 
> 
> 
>## Controller
>
>---
>### NumberController
>-[x] 숫자 관련 연산.
>-[x] 받아온 user의 숫자 변환하여 저장하기.
>-[x] computer의 랜덤 숫자 생성하기.
>### CheckNumberController
>-[xs] user의 숫자와 computer의 숫자를 비교하고 score를 매겨 저장