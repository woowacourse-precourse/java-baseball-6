# 숫자 야구 게임
#### 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

> - 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
>
> 예) 
>> 상대방(컴퓨터)의 수가 425일 때<br>
>>
>> 123을 제시한 경우 : 1스트라이크<br> 
>> 456을 제시한 경우 : 1볼 1스트라이크 <br>
>> 789를 제시한 경우 : 낫싱
>
> - 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
> - 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
> - 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
> - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

# Class
**주어진 조건을 바탕으로 클래스 작성**
- Computer
- UserNumber
- Compare
- GameResult
- RestartGame
- Application

## Computer
#### 컴퓨터 숫자 Random 값 생성
> #### randomNumber()
> - 임의의 세자리 수 저장
> - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 이용
>

## UserNumber
#### 사용자에게 숫자 입력받음
> #### player()
>    - 사용자에게 숫자 세자리 입력받음
>    - camp.nextstep.edu.missionutils.Console의 readLine() 사용자 입력값
>    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 예외
>      - 사용자가 입력한 값이 세자리가 아닌 경우
>      - 사용자가 숫자 외의 값을 입력한 경우

## Compare
 ####  입력한 수와 컴퓨터의 숫자 비교
> #### countTotal()
>    - 사용자가 입력한 숫자가 컴퓨터가 랜덤으로 생성한 숫자에 포함되어 있는 경우 total 값 증가
>    - 이때 사용자가 입력한 숫자와 컴퓨터가 랜덤으로 생성된 숫자의 위치까지 똑같은 경우(strike 의 경우) 까지 total값에 추가됨 
> 
> #### countStrike()
>   - 사용자가 입력한 숫자와 컴퓨터가 랜덤으로 생성된 숫자의 숫자와 숫자의 위치가 일치하는 경우 strike 값 증가

## GameResult
#### ball과 strike 값으로 게임 결과 출력
>  #### score()
>   - compare의 countTotal과 countStrike 이용해 ball과 strike 저장
>   - total이 0인 경우 일치하는 값이 없기 때문에 낫싱 
>   - ball, strike 값 이용해 출력될 결과 reutrun

## RestartGame
#### 게임 재시작 여부 확인
> #### restart()
> - 3개의 숫자를 모두 맞힌 경우(3스트라이크) 게임 종료 여부 판단
> - 사용자가 1을 입력한 경우 게임 재시작
> - 사용자가 2를 입력한 경우 게임 종료
> - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 예외
>   - 사용자의 입력값이 1과 2가 아닌 경우 

## Application
  #### 숫자 야구 게임을 시작합니다.
> 1. 컴퓨터와 사용자의 숫자 생성
> 2. 컴퓨터와 사용자의 숫자 비교
> 3. 게임 결과가 _**3스트라이크**_ 인 경우 게임 종료 여부 판단
