import java.security.Policy;

/**
 *管理牌的花色 花色比较
 */
public class PokerType {
    public static final PokerType SPADES = new PokerType("♠",4);
    public static final PokerType HEARTS = new PokerType("♥",3);
    public static final PokerType CLUBS = new PokerType("♣",2);
    public static final PokerType DIAMONDS = new PokerType("♦",1);

    private String pic;
    private int id;

    //提供一个自定义构造方法
    public PokerType(String pic,int id){
        this.pic = pic;
        this.id = id;
    }

    public String getPic() {
       return pic;
   }

    public void setPic(String pic) {
       this.pic = pic;
   }

    public int getId() {
       return id;
   }

    public void setId(int id) {
       this.id = id;
   }
}
