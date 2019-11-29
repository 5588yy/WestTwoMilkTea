import java.util.Calendar;

abstract class Ingredient {
    protected String name;
    protected Calendar manufacturedate;
    protected int date;
    public Ingredient(){}
    public Ingredient(String name,Calendar manufacture,int date)
    {
        this.name=name;
        this.manufacturedate=manufacture;
        this.date=date;
    }

    public String toString()
    {
        return "name="+name+" manufacture="+manufacturedate.getTime()+" qualitydate="+date+'\n';
    }
}
