import java.util.Scanner;

public class Constant {
   //用数组保存牌的点数
   public static  final String[] DOTS = {"2,","3","4","5","6","7","8","9","10","J", "Q","K","A"};

   //保存固定的几个花色
   public static final PokerType[] TYPES = {PokerType.SPADES,PokerType.HEARTS,PokerType.CLUBS,PokerType.DIAMONDS};

   //提供玩家默认姓名
   public static final String[] DEFAULT_NAMES = {"merry","jack","刘德华"};

   //设置默认金币
   public static final int MONEY = 1000;

   //每局消耗的金币数
   public static final int BASE = 10;
}
