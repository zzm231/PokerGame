public class GameCenter {
    //记录这局的筹码
    private int totalMoney;

    //开始游戏
    public void start(){
        PlayerManager manager = PlayerManager.manager;
        //扣除底注
        manager.betAll(Constant.BASE);

        manager.show();

        //发牌
        System.out.println("开始发牌");
        PokerManager.manager.dealCards(manager.players);
        manager.show();

        int time = 0;//记录如果是两个人可以玩的次数
        boolean isFirst = true;
        int betMoney = 0;

        while (true){
            //获取当前玩家信息
            Player player = manager.currentPlayer();

            //提示选择操作
            System.out.println("请"+player.id+"号玩家 "+player.name+" 选择操作");

            Utils.showText(true,true,new String[]{"看牌","弃牌",
                    isFirst?"下注":"跟注"});
            int choice = Utils.getInput();

            boolean flag =false;

            switch (choice){
                case 1:
                    //看牌
                    System.out.println(player.getPkString());
                    flag = true;
                    break;
                case 2:
                    //弃牌
                    System.out.println(player.id+"号玩家"+player.name+"弃牌");
                    player.hasDisCard = true;
                    break;
                default:
                    //下注
                    System.out.print("请输入下注金额");
                    if (isFirst) {
                        while (true) {
                            betMoney = Utils.getInput();

                            int result = player.bet(betMoney);
                            if (result == -1) {
                                //下注不成功
                                System.out.println("余额不足");
                            } else {
                                //下注成功
                                isFirst = false;
                                totalMoney += betMoney;
                                break;
                            }
                        }
                    }else {
                        //跟注
                        int result = player.bet(betMoney);
                        if (result == -1){
                            //钱不够
                            player.hasDisCard = true;
                        }else {
                            System.out.println("下注成功");
                            totalMoney += betMoney;
                        }
                    }
                    break;
            }

            if (flag == true){
                //计算当前有多少人可以参与
                int available = manager.leftPlayerCount();
                if (available == 1){
                    manager.changeNext();
                    Player winner = manager.currentPlayer();
                    //本局结束
                    System.out.println(player.id+"号玩家获得胜利"+"获得金币"+totalMoney);
                    break;
                }
                if (available == 2){
                    time++;
                    if (time == 4){
                        //两个回合结束 结束游戏
                        break;
                    }
                }
                //切换到下一个人
                manager.changeNext();
            }
        }
        manager.awardWinner(totalMoney);
    }
}
