public class MyClass {
    public static void main(String[] args) {
        Utils.showText(true,true,new String[]{"欢迎使用扑克游戏"});

        PokerManager manager = new PokerManager();
        //生成一副牌
        manager.deal();
        //显示一副牌
        manager.show();


    }
}
