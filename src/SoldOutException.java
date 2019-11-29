import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class SoldOutException extends BaseException {
    public SoldOutException(){}
    public void overdate(Teashop teashop)
    {
        Calendar nowtimeB=Calendar.getInstance();
        nowtimeB.add(Calendar.DATE,-7);
        Calendar nowtimeC=Calendar.getInstance();
        nowtimeC.add(Calendar.DATE,-5);
        while(teashop.get_Bubblenum()!=0)
        {
            if (nowtimeB.after(teashop.Bubblecheck()))
            {
                teashop.deletefirstbubble();
            }
            else
            {
                break;
            }
        }
        while(teashop.get_Coconutnum()!=0)
        {
            if (nowtimeC.after(teashop.Coconutcheck()))
            {
                teashop.deletefirstcoconut();
            }
            else
            {
                break;
            }
        }
    }

    public void check(Teashop teashop,String ingredientname) throws BaseException
    {
        if(ingredientname.equals("Bubble"))
        {
            if(teashop.get_Bubblenum()==0)
            {
                throw new BaseException("配料Bubble已售完");
            }
        }
        if(ingredientname.equals("Coconut"))
        {
            if(teashop.get_Coconutnum()==0)
            {
                throw new BaseException("配料Coconut已售完");
            }
        }
    }
}
