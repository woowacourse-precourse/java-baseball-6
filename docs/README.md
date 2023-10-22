# 1주차 미션 : 숫자 야구 기능 목록 (객체가 어떻게 동작 할지에 대해 생각)
------------
## 1. checkForDuplicateDigitsInRandomNumber
>+ camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 활용해서 랜덤으로 3자리 숫자 생성한 숫자 중 중복된 숫자가 있는지 검사하는 기능<br/>
>+ 동작과정
>   1. 3자리 숫자를 각각 체크하여 중복되지 않은 숫자를 추가 할 배열 nonDuplicateDigitsArray 생성
>   2. 각 자리의 숫자가 중복되지 않는 경우를 확인하는 변수 noDuplicateDigits 정의
>   3. 랜덤으로 0~9까지의 숫자 중 하나를 생성하고 while문을 순회하면서 nonDuplicateDigitsArray에 같은 숫자가 없으면 배열에 추가하고 noDuplicateDigits 1증가 , 있으면 다른 랜덤한 숫자 출력 반복
>   4. while noDuplicateDigits < 3 조건을 충족하면(서로 다른 숫자로 구성된 3자리 숫자) 반복문 종료 후, nonDuplicateDigitsArray 반환
------------
## 2. checkPlayerNumber 
>+ 입력받은 플레이어의 숫자를 playerGuess의 매개변수로 숫자 중 중복된 숫자가 있는지와 3자리 숫자인 검사하는 기능<br/>
>+ 동작과정
>   1. 매개변수로 입력받은 플레이어의 3자리 숫자인 playerGuess 전달
>   2. 게임을 진행하기에 적절한 숫자인지 판별하는 변수인 isPlayableNumber를 False로 정의
>   3. isPlayableNumber 중 중복된 숫자 판별을 위한 확인 변수 hasDuplicateDigits를 0으로 정의
>   4. 3자리 숫자를 각각 체크하여 중복되지 않은 숫자를 추가 할 배열 nonDuplicateDigitsArray 생성
>   5. 입력받은 playerGuess의 길이가 3이면 숫자 중복검사 실행하고 3이 아니면 "입력하신 숫자가 3자리가 아닙니다" 출력 후 프로그램 종료
>   6. 중복 검사 중 nonDuplicateDigitsArray에 중복된 숫자가 추가되게 되면, "입력하신 숫자 중 중복된 숫자가 있습니다" 출력 후 프로그램 종료
>   7. 반복문 순회 후, hasDuplicateDigits이 중복된 숫자가 없어서 3이면 isPlayableNumber를 True로 정의하고 isPlayableNumber를 반환
------------
## 3. countStrikesAndBalls 
>+ 상대방(컴퓨터)의 숫자와 플레이어의 숫자를 대조하여 같은 위치이고 같은 숫자이면 스트라이크, 다른 위치이지만 해당 숫자가 상대방의 숫자에 포함되어 있으면 볼로 설정하고, 스트라이크와 볼의 개수를 확인하는 기능<br/>
>+ 동작과정
>   1. 매개변수로 상대방의 숫자인 nonDuplicateDigitsArray와 플레이어의 숫자인 playerGuess를 매개변수로 전달
>   2. 스트라이크 개수 변수 strikeCount, 볼 개수 변수 ballCount를 0으로 선언
>   3. playerGuess를 반복문을 순회하면서 nonDuplicateDigitsArray와 대조하며 같은 위치의 같은 숫자이면 strikeCount 1 증가, 다른 위치이지만 playerGuess의 숫자가 nonDuplicateDigitsArray에 속해 있으면, ballCount 1 증가
>   4. while문 수행 후 strikeCount와 ballCount를 반환
------------
## 4. displayStrikesAndBalls
>+ 스트라이크와 볼의 개수를 개수에 따라 정해진 형식으로 출력하고 스트라이크와 볼이 없으면 낫싱을 출력하는 기<br/>
>+ 동작과정
>   1. strikeCount와 ballCount를 매개변수로 전달
>   2. strikeCount, ballCount에 대한 답변 변수 cntResult 정의
>   3. strikeCount가 0 초과이고, ballCount가 0초과이면, "{}볼 {}스트라이크" 출력
>   4. strikeCount가 0 이고, ballCount가 0초과이면, "{}볼" 출력
>   5. strikeCount가 0 초과이고, ballCount가 0이면, "{}스트라이크" 출력
>   6. strikeCount가 0 이고, ballCount가 0이면, "낫싱" 출력
>   7. cntResult 반환
------------
## 5. Application의 main()
>+ 게임 시작부터 게임 종료까지의 모든 과정을 담은 main() 파<br/>
>+ 동작과정
>   1. "숫자 야구 게임을 시작합니다." 출력
>   2. checkForDuplicateDigitsInRandomNumber에서 상대방(컴퓨터) 3자리 숫자 전달 받는다.
>   3. 게임 성공과 실패를 판단하는 변수인 gameIsWon를 True로 초기화
>   4. 플레이어의 숫자를 입력받는 userGuess 정의
>   5. 입력받은 userGuess를 checkPlayerNumber로 전달
>   6. 반환받은 isPlayableNumber가 False이면 gameIsWon를 False로 초기화하여 게임 진행에 적합하지 않은 숫자이므로 프로그램 종료 후 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출략
>   7. 반환받은 isPlayableNumber가 True이면 게임 진행
>   8. checkForDuplicateDigitsInRandomNumber의 상대방 숫자와 userGuess의 플레이어 숫자를 countStrikesAndBalls의 매개변수로 전달
>   9. 반환받은 스트라이크 개수 변수 strikeCount, 볼 개수 변수 ballCount를 displayStrikesAndBalls의 매개변수로 전달
>   10. 반환받은 cntResult 출력
>   11. 3~10번 과정을 while 반복문으로 실행하고, strikeCount가 3이면 숫자를 모두 맞췄으므로 반복 종료
>   12. gameIsWon이 True이면 "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력
>   13. 프로그램 종료 후 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력
>   14. 1이면 전체 과정을 포함한 while문 다시 실행
>   15. 2이면 프로그램 종료

  
