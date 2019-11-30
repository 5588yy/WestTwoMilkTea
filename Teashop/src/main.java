import java.awt.desktop.ScreenSleepEvent;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class main {
    public static void Purchase(Teashop westtwo) throws ParseException {
        //输入配料名称以及生产日期
        String name;
        Scanner sc=new Scanner(System.in);
        System.out.println("输入配料名称 Coconut or Bubble");
        name=sc.next();
        System.out.println("请输入生产日期：格式为：2020-02-02");
        String strin = sc.next();
        String str=strin;//键盘输入日期格式的字符串
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null ;//= format.parse(str);//将字符串转化为指定的日期格式
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        Calendar cal= new GregorianCalendar();
        cal.setTime(date);
        //测试输入
        //System.out.println(name);
        //System.out.println(cal.getTime());
        //输入进货数量
        System.out.println("请输入进货数量：");
        int num;
        num=sc.nextInt();
        for(int i=1;i<=num;i++)
        {
            if(name.equals("Bubble")) {
                westtwo.Purchase(new Bubble(cal));
            }
            else {
                westtwo.Purchase(new Coconut(cal));
            }
        }
    }
    public static void Shop(Teashop westtwo)
    {
        String milkteaname;
        String ingredientname;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入奶茶名称和配料名称");
        milkteaname=sc.next();
        ingredientname=sc.next();
        westtwo.Sale(milkteaname,ingredientname);
    }
    public static void Information(Teashop westtwo)
    {
        System.out.println("请输入想要获取奶茶店的什么信息：");
        System.out.println("想获取奶茶店店名请输入“name”：");
        System.out.println("想获取奶茶店所有配料的信息请输入“Ingredient”：");
        System.out.println("想获取奶茶店所有Bubble配料的信息请输入“Bubble”：");
        System.out.println("想获取奶茶店所有Coconut配料的信息请输入“Coconut”:");
        System.out.println("想获取奶茶店的信息请输入“All”：");
        String op;
        Scanner sc=new Scanner(System.in);
        op=sc.next();
        if(op.equals("name"))
        {
            westtwo.get_name();
        }
        if(op.equals("Ingredient"))
        {
            westtwo.get_Ingredient();
        }
        if(op.equals("Bubble"))
        {
            westtwo.get_Bubble();
        }
        if(op.equals("Coconut"))
        {
            westtwo.get_Coconut();
        }
        if(op.equals("All"))
        {
            System.out.println("??????");
            westtwo.get();
        }
    }
    public static int judge()
    {
        Scanner sc= new Scanner(System.in);
        String ju;
        System.out.println("是否继续进行当前操作？继续进行请输入“yes”，结束当前操作请输入“no");
        ju=sc.next();
        if(ju.equals("yes")) return 1;
        else return 0;
    }
    public static void main(String[] args) throws ParseException {
        Teashop WestTwo = new Teashop();
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎光临西二奶茶店！");
        System.out.println("Can I help you?");
        String op;
        while (true) {
            //System.out.println("请输入操作，进货（Purchase）、买奶茶（Shop）、获取奶茶店信息（Information）");
            System.out.println("如果您想为西二奶茶店进货请输入“Purchase”");
            System.out.println("如果您想在西二奶茶店购买奶茶请输入“Shop”");
            System.out.println("如果您想获取西二奶茶店的信息请输入“Information”");
            System.out.println("如果您想离开，请输入“Bye”");
            op = sc.next();
            int judge=1;
            if(op.equals("Bye"))
            {
                System.out.println("谢谢您的光临，祝您一路顺风！");
                break;
            }
            //进货
            if (op.equals("Purchase")) {
                while(judge==1)
                {
                    Purchase(WestTwo);
                    judge=judge();
                }
            }
            //销售
            if (op.equals("Shop")) {
                while(judge==1)
                {
                    Shop(WestTwo);
                    judge=judge();
                }
            }
            //获取奶茶店信息
            if(op.equals("Information"))
            {
                while(judge==1)
                {
                    Information(WestTwo);
                    judge=judge();
                }
            }
        }
    }
}
