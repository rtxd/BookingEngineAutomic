public class Tour {
    private String id;
    private String name;
    private float price;

    public Tour(String id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId()
    {
        return id;
    }

    public float getPrice()
    {
        return price;
    }

    public String getName()
    {
        return name;
    }

    public float setPrice()
    {
        return price;
    }

    @Override
    public String toString(){
        return "id: " + id + " name: " + name + " price: $" + price;
    }
}
