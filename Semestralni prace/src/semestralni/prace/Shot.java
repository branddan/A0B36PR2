/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import gui.GameWindow;

/**
 *
 * @author user
 */
public class Shot {

    private double speed; //rychlost
    private double angle; // uhel
    private Helicopter playerAt;
    private Helicopter playerDef;
    private Game game;
    private GameWindow gw;

    public Shot(double speed, double angle) { //konstrukter
        this.speed = speed;//rychlost
        this.angle = angle; //prevod uhlu na radiany
    }

    public Shot() {
    }

    public int bod(int x, Helicopter playerAt, Helicopter playerDef) { //vrati y-ovou souradnici pro dane x
        double p1 = -9.8 / (2 * Math.pow(speed * Math.cos(angle), 2)); //pomocne konstanty
        double p2 = (speed * Math.sin(angle)) / (speed * Math.cos(angle));
        double p3 = (playerAt.getPosition()).getY();
        return (int) (p1 * Math.pow((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX(), 2) + p2 * ((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX()) + p3);
    }

    public boolean hit(double x, double y) {

//        System.out.println("pomer " + (y/x));
        double y1 = playerDef.getPosition().getY() - playerAt.getPosition().getY();
        double x1 = playerDef.getPosition().getX() - playerAt.getPosition().getX();
        if (Math.abs(Math.atan(y/x)-Math.atan(y1/x1)) < playerDef.getSize()) {
//            System.out.println("zasah");
            damage(x,y);
            return true;
        }else{
//            System.out.println("nezasah");
            return false;
        }
//        if (Math.abs((playerDef.getPosition().getX()) * (y/x) + playerAt.getPosition().getY() - playerDef.getPosition().getX()) <= playerDef.getSize()) {
//            System.out.println("zasah");
//            return true;
//        }else{
//            System.out.println("nezasah");
//            return false;
//        }
//        double p1 = -9.8 / (2 * Math.pow(speed * Math.cos(angle), 2)); //pomocne konstanty
//        double p2 = Math.tan(angle); //(speed * Math.sin(angle)) / (speed * Math.cos(angle));
//        double p3 = (playerAt.getPosition()).getY();
//        boolean hit;
//
//        if (Math.abs((p1 * Math.pow((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX(), 2) + p2 * ((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX()) + p3) - (playerDef.getPosition()).getY()) <= playerDef.getSize()) {
//            damage();
//            return hit = true;
//        } else if (((p1 * Math.pow((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX(), 2) + p2 * ((playerDef.getPosition()).getX() - (playerAt.getPosition()).getX()) + p3) - (playerDef.getPosition()).getY()) >= playerDef.getSize()) {
//            System.out.println("Moc vysoko, zkus to znovu.");
//
//            return hit = false;
//        } else {
//            System.out.println("Moc nizko, zkus to znovu.");
//
//            return hit = false;
//        }
    }

    public void damage(double x, double y) {

        double y1 = playerDef.getPosition().getY() - playerAt.getPosition().getY();
        double x1 = playerDef.getPosition().getX() - playerAt.getPosition().getX();
        
        double health1 = (Math.abs(Math.atan(y/x)-Math.atan(y1/x1))/playerDef.getSize());
        double health3 = (int) (Math.sqrt(1 / health1) * 100);
        double health4 = game.getPlayerAt().getFirepower() * health3 / 10;
        
        game.getPlayerDef().setHealth(game.getPlayerDef().getHealth() - health4);
        game.getGameW().getInstructions().setText("Zasah ubral " + health4 + " zivotu. Hraci zbyva " + game.getPlayerDef().getHealth());
        if (game.getPlayerDef().getHealth() <= 0) {
            game.getGameW().getInstructions().setText(this.game.getPlayerDef().getPlayerName() + " is down. " + game.getPlayerAt().getPlayerName() + " won!");
        }
        game.getGameW().getPlayer1Info().setText("<html><h3>" + game.getPlayerAt().getPlayerName() + "</h3><br>HP: " + game.getPlayerAt().getHealth() + "<br><br><h3>" + game.getPlayerDef().getPlayerName() + "</h3><br>HP: " + game.getPlayerDef().getHealth());
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        
            this.speed = speed;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        if (Math.abs(angle) > 90) { // uhel je omezen na -90-90
//            System.out.println("Zadana hodnota mimo povoleny interval, zadej znovu.");
//            System.out.println("");
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Shot{" + "v=" + speed + ", a=" + angle + '}';
    }
}
