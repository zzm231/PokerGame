import java.util.ArrayList;

public class PlayerManager {
    //记录当前下注的玩家编号
    public int currentPlayerIndex = 0;

    //保存所有玩家
    public ArrayList<Player> players = new ArrayList<>();

    public static final PlayerManager manager = new PlayerManager();

    private PlayerManager(){};

    //初始化玩家
    public void initPlayer(int count){
        for (int i = 0; i < count; i++){
            //创建玩家
            String name = Constant.DEFAULT_NAMES[i];
            Player player = new Player(name,i+1,Constant.MONEY);

            //保存玩家
            players.add(player);
        }
    }

    //输出玩家信息
    public void show(){
        for (Player player:players){
            System.out.println(player);
        }
    }

    public int betAll(int count){
        for (Player player:players){
            int result = player.bet(count);
            if (result == -1){
                return -1;
            }
        }
        //返回总共下注金额
        return count * players.size();
    }

    /**
     * 获取当前下注的玩家
     * @return 玩家对象
     */
    public Player currentPlayer(){
        //获取当前玩家
        return players.get(currentPlayerIndex);
    }

    /**
     * 当前剩余玩家
     * @return
     */
    public int leftPlayerCount(){
        int total = 0;
        for (int i = 0; i < players.size(); i++){
            Player player = players.get(i);
            //没弃牌并且有钱
            if (player.hasDisCard == false && player.money > 0){
                total++;
            }
        }
        return total;
    }

    /**
     * 查找下一个下注的人
     */
    public void changeNext(){
        int i = currentPlayerIndex;
        if (i == players.size()-1){
            i = 0;
        }else {
            i++;
        }
        //查找下一个可以参与的玩家
        for (;i < players.size(); i++){
            Player player = players.get(i);
            if (player.hasDisCard == false && player.money > 0){
                currentPlayerIndex = i;
                return;
            }
        }
    }

    /**
     * 奖励赢家
     */
    public void awardWinner(int total){
        Player winner;
        int available = leftPlayerCount();
        if (available == 1){
            //只有一个玩家 这就是玩家
            changeNext();
            winner = currentPlayer();
        }else {
            //需要比较两个玩家的牌
            Player w1 = null;
            Player w2 = null;
            for (int i = 0; i < players.size(); i++){
                Player player = players.get(i);
                if (player.hasDisCard == false){
                    if (w1 == null){
                        w1 = player;
                    }else {
                        w2 = player;
                    }
                }
            }

            boolean result = w1.poker.bigerThan(w2.poker);
            if (result){
                winner = w1;
            }else {
                winner = w2;
            }
        }
        System.out.println(winner.id+"号玩家赢得"+total+"金币");

        winner.add(total);
    }
}
