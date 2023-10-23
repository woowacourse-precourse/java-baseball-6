# 숫자 야구 게임
***
<br>

## Computer
***
#### 컴퓨터 숫자 Random 값 생성
> #### randomNumber()
> - 임의의 세자리 수 저장
> - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 이용
>

***
## UserNumber
#### 사용자에게 숫자 입력받음
> #### player()
>    - 사용자에게 숫자 세자리 입력받음
>    - camp.nextstep.edu.missionutils.Console의 readLine() 사용자 입력값
>    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 예외
>      - 사용자가 입력한 값이 세자리가 아닌 경우
>      - 사용자가 숫자 외의 값을 입력한 경우

***
## Compare
 ####  입력한 수와 컴퓨터의 숫자 비교
> #### countTotal()
>    - 사용자가 입력한 숫자가 컴퓨터가 랜덤으로 생성한 숫자에 포함되어 있는 경우 total 값 증가
>    - 이때 사용자가 입력한 숫자와 컴퓨터가 랜덤으로 생성된 숫자의 위치까지 똑같은 경우(strike 의 경우) 까지 total값에 추가됨 
> ---
> #### countStrike()
>   - 사용자가 입력한 숫자와 컴퓨터가 랜덤으로 생성된 숫자의 숫자와 숫자의 위치가 일치하는 경우 strike 값 증가

## GameResult
#### ball과 strike 값으로 게임 결과 출력
>  #### score()
>   - compare의 countTotal과 countStrike 이용해 ball과 strike 저장
>   - total이 0인 경우 일치하는 값이 없기 때문에 낫싱 
>   - ball, strike 값 이용해 출력될 결과 reutrun
***
## RestartGame
#### 게임 재시작 여부 확인
> #### restart()
> - 3개의 숫자를 모두 맞힌 경우(3스트라이크) 게임 종료 여부 판단
> - 사용자가 1을 입력한 경우 게임 재시작
> - 사용자가 2를 입력한 경우 게임 종료
> - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 예외
>   - 사용자의 입력값이 1과 2가 아닌 경우 
***
## Application
  #### 숫자 야구 게임을 시작합니다.
> 1. 컴퓨터와 사용자의 숫자 생성
> 2. 컴퓨터와 사용자의 숫자 비교
> 3. 게임 결과가 _**3스트라이크**_ 인 경우 게임 종료 여부 판단