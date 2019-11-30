import java.util.Calendar;

public class Bubble extends Ingredient implements Comparable<Bubble>{
    public Bubble(){}
    public  Bubble(Calendar manufacture)
    {
        super("Bubble", manufacture, 7);
    }
    public String toString()
    {
        return "name="+name+" manufacture="+manufacturedate.getTime()+" qualityfate="+date+'\n';
    }
    public Calendar get_manufacture()
    {
        return manufacturedate;
    }
    @Override
    public int compareTo(Bubble bubble) {
        return this.manufacturedate.compareTo(bubble.manufacturedate);
    }
}
