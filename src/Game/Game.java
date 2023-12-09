package Game;

import Game.Location.*;
import Game.Location.BattleLoc.Cave;
import Game.Location.BattleLoc.Forest;
import Game.Location.BattleLoc.River;
import Game.Location.BattleLoc.SafeHouse;

import java.util.Scanner;

public class Game {
   public Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.println("Lütfen bir isim giriniz: ");
      //  String playerName = scanner.nextLine();

        Player player = new Player("Ahmet");
        System.out.println("Sayın " + player.getName() + " lütfen bir karakter seçiniz: ");
        player.selectChar();
        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("=====================================================================");
            System.out.println("\t\tLütfen gitmek istediğiniz bölgeyi seçiniz: ");
            System.out.println("1- Güvenli Ev\n2- Mağaza\n3- Orman\n4- Nehir\n5- Mağara\n6- Define\n7- Çıkış Yap");
            int selectloc = scanner.nextInt();
            switch (selectloc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location= new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Geçersiz bir bölge seçtiniz!");
                    break;
            }
            assert location != null;
            if (!location.onLocation()) {
                System.out.println("Oyunu kaybettiniz!");
                break;

            }
        }

    }
}
