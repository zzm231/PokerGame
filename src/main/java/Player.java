/**
 * 管理玩家信息
 */
public class Player {
    public String name;
    public int id;
    public int money;
    public Poker poker;
    public boolean hasDisCard;//是否弃牌

    public Player(){};

    public Player(String name,int id,int money){
        this.name = name;
        this.id = id;
        this.money = money;
    }

    @Override
    public String toString() {
        return id+"号玩家 "+name+" 筹码"+money+" "+getPkString();
    }

    public String getPkString(){
        String pkString = "";
        if (poker != null){
            pkString =poker.getDot()+poker.getType().getPic();
        }
        return pkString;
    }

    /**
     * 打底 & 下注
     * @param count 下注金额
     * @return -1：失败 >0 成功
     */
    //下注
    public int bet(int count){
        //判断自己的金币 是否大于下注金额
        if (money >= count){
            money -= count;
            return count;
        }else {
            return -1;
        }
    }

    public void add(int count){
        money += count;
    }
}
