package controller;

import controller.validate.ContinueValidate;
import controller.validate.NumberValidate;
import model.domain.Discriminator;
import model.service.DiscriminatorService;
import model.service.MessageService;
import util.RandomUtil;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BaseBallController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    NumberValidate numberValidate = new NumberValidate();
    ContinueValidate continueValidate = new ContinueValidate();
    DiscriminatorService discriminatorService = new DiscriminatorService();
    MessageService messageService = new MessageService();
    private static String playerThreeNumber = "";
    private static int ball = 0;
    private static int strike = 0;
    private static int playerChoose = 0;

    public void gameStart() {

        // 게임 시작 메세지 생성
        outputView.gameStartMessage();
        gameRun();
    }

    public void gameRun() {
        //게임 재시작시 초기화
        init();
        List<Integer> computerThreeNumber = RandomUtil.randomThreeNumber();
        Discriminator discriminator;
        //플레이어가 3 스트라이크 될 때까지 반복
        while (strike != 3) {
            //플레이어가 선택한 세가지 번호가 올바른지 형식으로 들어왔는지 검증
            checkInputNumber();
            //플레이어와 컴퓨터 번호 판별기에 대입
            discriminator = new Discriminator(computerThreeNumber, playerThreeNumber);
            //플레이어가 선택한 세가지 번호와 컴퓨터의 번호 비교 결과 반환
            discriminatorOperate(discriminator.getComputer(),discriminator.getPlayer());
            //판별 결과 메세지 생성
            discriminatedMessagePrint();
        }
        outputView.gameFinishMessage();
        outputView.tobeContinueMessage();
        continueOrFinish();
    }
    private void init(){
        ball = 0;
        strike = 0;
        playerChoose = 0;
    }
    //플레이어가 선택한 세가지 번호가 올바른지 형식으로 들어왔는지 검증
    private void checkInputNumber(){
        while (true) {
            try {
                outputView.inputNumberPleaseMessage();
                String beforeValidateNumber = inputView.pickThreeNumber();
                numberValidate.NumberValidateMachine(beforeValidateNumber);
                playerThreeNumber = beforeValidateNumber;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //플레이어와 컴퓨터 번호 판별기에 대입
    private void discriminatorOperate(List<Integer> computer, String player){
        List<Integer> ballAndStrikeNum = discriminatorService.discriminatorResult(player, computer);
        ball = ballAndStrikeNum.get(0);
        strike = ballAndStrikeNum.get(1);
    }
    //플레이어가 선택한 세가지 번호와 컴퓨터의 번호 비교 결과 반환
    private void discriminatedMessagePrint(){
        String resultMessage = messageService.resultMessage(ball, strike);
        outputView.gameResultMessage(resultMessage);
    }
    //판별 결과 메세지 생성
    private void continueOrFinish(){
        while (true) {
            try {
                playerChoose = inputView.tobeContinueNumber();
                continueValidate.ContinueValidateMachine(playerChoose);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        if (playerChoose == 1) {
            // 게임 재시작
            gameRun();
        }
    }
}
