public class MilkTea {
    private String name;
    private Ingredient ingredient;
    public MilkTea(){}
    public MilkTea(String name,Ingredient ingredient)
    {
        this.name=name;
        this.ingredient=ingredient;
    }
    public void set(String name,Ingredient ingredient)
    {
        this.name=name;
        this.ingredient=ingredient;
    }

    public String toString()
    {
        return "name="+name+" Ingredient="+ingredient;
    }
}

