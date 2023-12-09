package Game.Location;

import Game.Location.BattleLoc.NormalLoc;
import Game.Player;
import Game.Location.Weapon.Tools.Armor;
import Game.Location.Weapon.Tools.Weapon;

import java.util.Scanner;

public class ToolStore extends NormalLoc {
    public static Scanner scanner = new Scanner(System.in);

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz. Ne yapmak istersiniz?");
        System.out.println("1- Silahlar\n2- Zırhlar\n3- Çıkış yap");
        int selectCase = scanner.nextInt();
        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Geçersiz bir değer girdiniz. Lütfen tekrar deneyiniz.");
            selectCase = scanner.nextInt();

        }
        switch (selectCase) {
            case 1:
                printWeaponMenu();
                buyWeapon();
                break;
            case 2:
                printArmorMenu();
                buyArmor();
                break;
            case 3:
                System.out.println("Güle güle!");
                break;

        }

        return true;
    }

    public void printWeaponMenu() {
        System.out.println("Silahlar Menüsü");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println("ID: " + weapon.getId() +
                    " \t Silah: " + weapon.getName() +
                    " \t Hasar: " + weapon.getDamage() +
                    " \t Fiyat: " + weapon.getPrice());
        }
    }

    public void buyWeapon() {
        System.out.println("Lütfen satın almak istediğiniz silahı seçiniz.");
        int selectWeapon = scanner.nextInt();
        while (selectWeapon < 1 || selectWeapon > Weapon.weapons().length) {
            System.out.println("Geçersiz bir değer girdiniz. Lütfen tekrar deneyiniz.");
            selectWeapon = scanner.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeapon);
        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yetersiz Bakiye");
            } else {
                System.out.println(selectedWeapon.getName() + "  Silahını satın aldınız");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println(" Yeni Bakiye == " + this.getPlayer().getMoney());
                System.out.println("Önceki Silahınız == " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Yeni silahınız == " + this.getPlayer().getInventory().getWeapon().getName());
                System.out.println("Hasar" + this.getPlayer().getDamage());

            }
        }
    }

    public void printArmorMenu() {
        System.out.println("Zırhlar Menüsü");
        for (Armor armor : Armor.armors()) {
            System.out.println("ID: " + armor.getId() +
                    " \t Bloklama: " + armor.getBlock() +
                    " \t Fiyat: " + armor.getPrice());
        }
    }

    public void buyArmor() {
        System.out.println("Lütfen satın almak istediğiniz Armoru seçiniz seçiniz.");
        int selectArmor = scanner.nextInt();
        while (selectArmor < 1 || selectArmor > Armor.armors().length) {
            System.out.println("Hatalı Seçim Yaptınız Başka Seçim Giriniz");
            selectArmor = scanner.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObjById(selectArmor);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yetersiz Bakiye");
            }
            else{
                int balance= this.getPlayer().getMoney()- selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println(" Yeni Bakiye == " + this.getPlayer().getMoney());
                System.out.println("Önceki Zırhınız == " + this.getPlayer().getInventory().getArmor().getName());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Yeni Zırhınız == " + this.getPlayer().getInventory().getArmor().getName());
                System.out.println("Hasar" + this.getPlayer().getDamage());

            }
        }
    }
}
