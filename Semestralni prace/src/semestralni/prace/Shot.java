/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author user
 */
public class Shot {

    private double speed; //rychlost
    private double angle; // uhel
    private Helicopter playerAt;
    private Helicopter playerDef;

    public Shot(double speed, double angle) { //konstrukter
        this.speed = speed;//rychlost
        this.angle = angle * Math.PI / 180; //prevod uhlu na radiany
    }

    public Shot() {
    }

    public int bod(int x) { //vrati y-ovou souradnici pro dane x
        double p1 = -9.8 / (2 * Math.pow(speed * Math.cos(angle), 2)); //pomocne konstanty
        double p2 = (speed * Math.sin(angle)) / (speed * Math.cos(angle));
        double p3 = (playerAt.getPosition()).getY();
        return (int) (p1 * Math.pow((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX(), 2) + p2 * ((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX()) + p3);
    }

    public boolean hit() {

        double p1 = -9.8 / (2 * Math.pow(speed * Math.cos(angle), 2)); //pomocne konstanty
        double p2 = (speed * Math.sin(angle)) / (speed * Math.cos(angle));
        double p3 = (playerAt.getPosition()).getY();
        boolean hit;

        if (Math.abs((p1 * Math.pow((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX(), 2) + p2 * ((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX()) + p3) - (playerDef.getPosition()).getY()) <= playerDef.getSize()) {
            return hit = true;
        } else if (((p1 * Math.pow((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX(), 2) + p2 * ((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX()) + p3) - (playerDef.getPosition()).getY()) >= playerDef.getSize()) {
            System.out.println("Moc vysoko, zkus to znovu.");

            return hit = false;
        } else {
            System.out.println("Moc nizko, zkus to znovu.");

            return hit = false;
        }
    }

    public void damage() {

        double p1 = -9.8 / (2 * Math.pow(speed * Math.cos(angle), 2)); //pomocne konstanty
        double p2 = (speed * Math.sin(angle)) / (speed * Math.cos(angle));
        double p3 = (playerAt.getPosition()).getY();

        double health1 = (Math.abs((p1 * Math.pow((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX(), 2) + p2 * ((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX()) + p3) - (playerDef.getPosition()).getY()) / playerDef.getSize());
        double health2 = (int) (Math.log(1 / health1) * 100);
        double health3 = health2 / 10;
        System.out.println("Zasah ubral " + health3 + " zivotu.");
        playerAt.setHealth(playerAt.getHealth() + health3);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed > playerAt.getMaxShotSpeed() || speed < 0) { // rychlost je omezena podle parametru helikoptery
            System.out.println("Zadana hodnota mimo povoleny interval, zadej znovu.");
            System.out.println("");
        } else {
            this.speed = speed;
        }
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        if (Math.abs(angle) > 90) { // uhel je omezen na -90-90
            System.out.println("Zadana hodnota mimo povoleny interval, zadej znovu.");
            System.out.println("");
        } else {
            this.angle = Math.PI * angle / 180;
        }
    }

    

    public Helicopter getPlayerAt() {
        return playerAt;
    }

    public void setPlayerAt(Helicopter player) {
        if (player != null) {
            this.playerAt = player;
        }
    }

    public Helicopter getPlayerDef() {
        return playerDef;
    }

    public void setPlayerDef(Helicopter player) {
        if (player != null) {
            this.playerDef = player;
        }
    }

    @Override
    public String toString() {
        return "Hod{" + "v=" + speed + ", a=" + angle + '}';
    }
}