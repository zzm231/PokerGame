import java.util.Scanner;

public class Utils {
    //如果不需要保存数据 没有成员变量
    //提供静态方法 访问方便
    public static void showText(boolean hasStar,boolean lineBreak,String...contents){
        //判断是否需要显示分隔线
        System.out.print(hasStar?"****************\n":"");
        //判断是输出一行还是多行
        if (contents.length == 1){
            System.out.print(contents[0]);
            //带分割线需要换行
            System.out.print(hasStar?"\n":"");
        }else {
            //输出带编号的多行数据
            for (int i = 0; i < contents.length;i++){
                System.out.println((i+1)+". "+contents[i]);
            }
        }
        System.out.print(hasStar?"****************\n":"");

        //判断是否需要换行
        System.out.print(lineBreak?"\n":"");
    }

    //接受用户输入
    public static int getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
