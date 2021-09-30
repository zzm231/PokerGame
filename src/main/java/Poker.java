import java.security.Policy;
import java.util.ArrayList;
import java.util.Arrays;

public class Poker {
    private String dot;
    private PokerType type;

    public Poker(){}

    public Poker(String dot,PokerType type){
        this.dot = dot;
        this.type = type;
    }

    public boolean bigerThan(Poker poker){
        int mIndex = Arrays.binarySearch(Constant.DOTS,this.dot);
        int oIndex = Arrays.binarySearch(Constant.DOTS,poker.dot);

        if (mIndex != oIndex){
            //点数不同 直接比较
            return mIndex > oIndex;
        }else {
            //点数相同 比较花色
            return this.type.getId() > poker.type.getId();
        }
    }

    //提供setter/getter方法
    public void setDot(String dot){
        this.dot = dot;
    }

    public String getDot(){
        return dot;
    }

    public PokerType getType() {
        return type;
    }

    public void setType(PokerType type) {
        this.type = type;
    }
}
