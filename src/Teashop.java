import java.lang.reflect.Array;
import java.util.*;

public class Teashop implements shop {
    protected String name;
    protected List<Bubble> bubble=new ArrayList<>();
    protected List<Coconut> coconut=new ArrayList<>();
    public Teashop(){
        name="WestTwoMilkTea";
    }
    //getnum
    public int get_Bubblenum()
    {
        return bubble.size();
    }
    public int get_Coconutnum()
    {
        return coconut.size();
    }
    //return Calender
    public Calendar Bubblecheck()
    {
        return bubble.get(0).get_manufacture();
    }
    public  Calendar Coconutcheck()
    {
        return coconut.get(0).get_manufacture();
    }
    //delete
    public void deletefirstbubble()
    {
        if(get_Bubblenum()!=0)
        {
            bubble.remove(0);
        }
    }
    public void deletefirstcoconut()
    {
        if(get_Coconutnum()!=0)
        {
            coconut.remove(0);
        }
    }
    //重载进货
    private void add(Bubble b)
    {
        bubble.add(b);
        Collections.sort(bubble);
    }
    private void add(Coconut c)
    {
        coconut.add(c);
        Collections.sort(coconut);
    }
    //信息
    public void get_name()
    {
        System.out.println("奶茶店名：" + name);
    }
    public void get_Bubble()
    {
        SoldOutException check = new SoldOutException();
        //检查是否过期
        check.overdate(this);
        System.out.println("所有Bubble信息：");
        System.out.println("Bubble:");
        System.out.println("数量：" + this.get_Bubblenum());
        if(get_Bubblenum()!=0)
            System.out.println(bubble);
    }
    public void get_Coconut()
    {
        SoldOutException check = new SoldOutException();
        //检查是否过期
        check.overdate(this);
        System.out.println("所有Coconut信息：");
        System.out.println("Coconut:");
        System.out.println("数量：" + this.get_Coconutnum());
        if(get_Coconutnum()!=0)
            System.out.println(coconut);
    }
    public void get_Ingredient()
    {
        SoldOutException check = new SoldOutException();
        //检查是否过期
        check.overdate(this);
        System.out.println("库存情况：");
        this.get_Bubble();
        this.get_Coconut();
    }
    public void get() {

        SoldOutException check = new SoldOutException();
        //检查是否过期
        check.overdate(this);
        this.get_name();
        this.get_Ingredient();
    }
    @Override
    public void Purchase(Ingredient ingredient) {//进货
        if(ingredient instanceof Bubble)
        {
            Bubble b=(Bubble)ingredient;
            add(b);
        }
        if(ingredient instanceof Coconut)
        {
            Coconut c=(Coconut)ingredient;
            add(c);
        }
    }
    //售出奶茶
    public void sell(String milkteaname,Ingredient tmpingredient)
    {
        MilkTea milktea=new MilkTea();
        milktea.set(milkteaname,tmpingredient);
        System.out.println("您的"+milkteaname+"已做好，谢谢惠顾");
        System.out.println("已售出"+milktea);
    }
    @Override
    public void Sale(String milkteaname,String ingredientname)
    {
        SoldOutException check=new SoldOutException();
        //检查是否过期
        check.overdate(this);
        //捕捉异常并抛出
        try {
            check.check(this, ingredientname);
        }catch (SoldOutException s)
        {
            s.printStackTrace();
        } catch (BaseException e) {
            e.printStackTrace();
        }
        Ingredient tmpingredient=new Ingredient() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        //删除已售出的配料
        if(ingredientname.equals("Bubble")&&get_Bubblenum()!=0)
        {
            sell(milkteaname,bubble.get(0));
            bubble.remove(0);
        }
        if(ingredientname.equals("Coconut")&&get_Coconutnum()!=0)
        {
            sell(milkteaname,coconut.get(0));
            coconut.remove(0);
        }
    }
}
