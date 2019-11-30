import java.util.Calendar;
import java.util.zip.CheckedOutputStream;

public class Coconut extends Ingredient implements Comparable<Coconut> {
    public Coconut() {}
    public Coconut(Calendar manufacture)
    {
        super("Coconut", manufacture, 5);
    }
    public Calendar get_manufacture()
    {
        return manufacturedate;
    }
    public String toString()
    {
        return "name="+name+" manufacture="+manufacturedate.getTime()+" qualitydate="+date+'\n';
    }
    @Override
    public int compareTo(Coconut coconut) {
        return this.manufacturedate.compareTo(coconut.manufacturedate);
    }
}
