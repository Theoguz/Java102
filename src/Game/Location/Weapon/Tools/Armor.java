package Game.Location.Weapon.Tools;

public class Armor {
    private String name;
    private int id;
    private int block;
    private int price;

    public Armor(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors() {
        Armor[] armors = {new Armor(" ",1, 1, 25),
                new Armor("",2, 3, 35),
                new Armor("",3, 5, 45)
        };
        return armors;
    }

    public static Armor getArmorObjById (int id){
        for (Armor armor : armors()){
            if (armor.getId()==id){
                return armor;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
