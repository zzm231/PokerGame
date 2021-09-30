public class Poker {
    private String dot;
    private PokerType type;

    public Poker(){}

    public Poker(String dot,PokerType type){
        this.dot = dot;
        this.type = type;
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
