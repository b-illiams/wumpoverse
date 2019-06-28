package items;

public class Item {
    private String name;
    private String description;
    private int id;
    private int price;

    public Item(){
        this.name = "";
        this.description = "";
        this.id = -1;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Item(String name, String description, int id, int price){
        this.name = name;
        this.description = description;
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        try {
            name += "";
            return name;
        } catch (NullPointerException e) {
            return "NONE:";
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
