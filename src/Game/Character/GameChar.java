package Game.Character;

import Game.Location.Weapon.Tools.Inventory;

public abstract class  GameChar {
    private int damage;
    private int health;
    private int money;
    private int id;
    private String nameChar;
    private Inventory inventory;


    public GameChar(int id, String nameChar, int damage, int health, int money) {
        this.id = id;
        this.nameChar = nameChar;
        this.damage = damage;
        this.health = health;
        this.money = money;


    }

    public String getNameChar() {
        return nameChar;
    }

    public void setNameChar(String nameChar) {
        this.nameChar = nameChar;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }



}
