import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 管理牌的相关操作
 * 生成一副牌 洗牌 发牌 牌的比较
 */
public class PokerManager {
    //保存一副牌
    ArrayList<Poker> pokers = new ArrayList<>();

    //定义一个方法生成一副牌
    public void deal(){
        //遍历牌的点数
        for (int i = 0; i < Constant.DOTS.length; i++){
            //获取对应点数
            String dot = Constant.DOTS[i];

            //生成4种花色
            for (int j = 0; j < Constant.TYPES.length; j++){
                //创建一张牌
                Poker poker = new Poker(dot, Constant.TYPES[j]);
                //田间到数组中
                pokers.add(poker);
            }
        }
        //洗牌
        Collections.shuffle(pokers);
    }

    //显示一副牌
    public void show(){
        for (Poker poker:pokers){
            System.out.print(poker.getDot()+poker.getType().getPic()+" ");
        }
        System.out.println();
    }
}
