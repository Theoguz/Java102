package Game.Location.BattleLoc;

import Game.Location.Location;
import Game.Location.Obstacle.Obstacle;
import Game.Player;

import java.util.Random;

import static Game.Location.ToolStore.scanner;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    int maxObstacle;



    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, "Battle Loc");
        this.maxObstacle = maxObstacle;
        this.obstacle = obstacle;
        this.award = award;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("Şuan " + this.getName() + " bölümündesiniz!");
        System.out.println("Dikkatli ol! Burada "+ obsNumber+ " tane " +this.getObstacle().getName() + " yaşıyor!");
        System.out.print("<S>avaş veya <K>aç: ");
        String selectCase = scanner.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")){
            if (combat(obsNumber)){
                System.out.println(this.getName() + " bölümünü başarıyla tamamladınız!");
                return true;
            }
            if (this.getPlayer().getHealth() <= 0){
                System.out.println("Öldünüz!");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats();
            System.out.println("=====================================");
            System.out.println(i + ". " + this.getObstacle().getName() + " ile karşılaşıldı!");
            while (this.getObstacle().getHealth() > 0 && this.getPlayer().getHealth() > 0) {
                System.out.println("=====================================");
                System.out.println("Oyuncu Bilgileri\n" +
                        "Sağlık: " + this.getPlayer().getHealth() +
                        "\tHasar: " + this.getPlayer().getDamage() +
                        "\tPara: " + this.getPlayer().getMoney());
                System.out.println("=====================================");
                System.out.println(this.getObstacle().getName() + " Bilgileri\n" +
                        "Sağlık: " + this.getObstacle().getHealth() +
                        "\tHasar: " + this.getObstacle().getDamage() +
                        "\tÖdül: " + this.getObstacle().getAward());
                System.out.println("=====================================");
                System.out.print("<V>ur veya <K>aç: ");
                String selectCase = scanner.nextLine();
                selectCase = selectCase.toUpperCase();
                if (selectCase.equals("V")) {
                    System.out.println("Siz vurdunuz!");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println(this.getObstacle().getName() + " size vurdu!");
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - this.getObstacle().getDamage());
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (this.getPlayer().getHealth() <= 0) {
                return false;
            }
            System.out.println(this.getObstacle().getName() + " öldürüldü!");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
            System.out.println("Ödül: " + this.getObstacle().getAward() + " para kazandınız!");
            System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());
            System.out.println("=====================================");

        }
        return true;
    }

    public void afterHit(){
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Hasar: " + this.getPlayer().getDamage());
        System.out.println("=====================================");
    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Hasar: " + this.getPlayer().getDamage());
        System.out.println("Para: " + this.getPlayer().getMoney());
        System.out.println("=====================================");
    }
    public void obstacleStats(){
        System.out.println("Obstacle Değerleri");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getAward());
        System.out.println("=====================================");
    }
    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.maxObstacle) + 1;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }


}
