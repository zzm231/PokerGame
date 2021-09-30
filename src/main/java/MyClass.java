public class MyClass {
    public static void main(String[] args) {
        Utils.showText(true,true,new String[]{"欢迎使用扑克游戏"});

        //生成一副牌
        PokerManager.manager.deal();
        //显示一副牌
        PokerManager.manager.show();

        //提示输入玩家人数
        Utils.showText(false,false,new String[]{"请输入玩家人数"});
        int count = Utils.getInput();

        //初始化玩家
        PlayerManager.manager.initPlayer(count);
        //显示玩家信息
        //PlayerManager.manager.show();

        GameCenter center = new GameCenter();
        center.start();
    }
}
