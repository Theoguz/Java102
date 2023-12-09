package Game;

import Game.Character.Archer;
import Game.Character.GameChar;
import Game.Character.Knight;
import Game.Character.Samurai;
import Game.Location.Weapon.Tools.Inventory;

import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);

    private String name;
    private int health;
    private int damage;
    private int money;
    private Inventory inventory;

    private int originalHealth;

    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {

        Archer Archer = new Archer();
        Samurai Samurai = new Samurai();
        Knight Knight = new Knight();

        GameChar[] charList = {Archer, Samurai, Knight};
        for (GameChar gameChar : charList) {
            System.out.println("ID: " + gameChar.getId() +
                    " \t Karakter: " + gameChar.getNameChar() +
                    " \t\tHasar: " + gameChar.getDamage() +
                    " \t\tSağlık: " + gameChar.getHealth() +
                    " \t\tPara: " + gameChar.getMoney());
        }
        switch (scanner.nextInt()) {
            case 1:
                initPlayer(Archer);
                break;
            case 2:
                initPlayer(Samurai);
                break;
            case 3:
                initPlayer(Knight);
                break;
            default:
                System.out.println("Geçersiz bir karakter seçtiniz!");
                break;
        }
        System.out.println("Sayın " + this.getName() + " seçiminiz başarıyla gerçekleştirildi!");


    }

    public void printInfo(){
        System.out.println("Silahınız: " +this.inventory.getWeapon().getName() +
                "\t  Karakteriniz: " + this.getName() +
                " \t Hasar: " + (this.getDamage()+this.inventory.getWeapon().getDamage()) +
                " \t Sağlık: " + this.getHealth() +
                " \t Para: " + this.getMoney());
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setName(gameChar.getNameChar());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }
    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

}
