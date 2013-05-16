/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.Color;

/**
 *
 * @author user
 */
public class Helicopter {

    private Game game;
    private Position position;
    private String playerName;
    private String type; //Apache nebo Black Hawk
    private double health; //pocet zivotu, kdyz pod nulou, konec hry
    private double firepower; //ovlivni damage
    private double maxShotSpeed; //ovlivni strmost drahy strely
    private double size; //velikost helikoptery
    private int speed; //ovlivni pocet pohybovych tahu
    private boolean attack; //jestli je na tahu

    public Helicopter(String jmeno) {
        this.playerName = jmeno;
        this.position = new Position();
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if (position != null) {
            this.position = position;
        }
    }

    public void setRandomPosition() {
        position.createRandom(1, 30, 1, 10);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String jmeno) {
        if (jmeno != null) {
            this.playerName = jmeno;
        }
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        if (health <= 0) {
            this.health = 0;
            game.getGameW().getInstructions().setForeground(Color.red);
        }else{
            this.health = health;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFirepower() {
        return firepower;
    }

    public void setFirepower(double firePower) {
        this.firepower = firePower;
    }

    public double getMaxShotSpeed() {
        return maxShotSpeed;
    }

    public void setMaxShotSpeed(double maxShotSpeed) {
        this.maxShotSpeed = maxShotSpeed;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int moves) {
        this.speed = moves;
    }

    public boolean isAttack() {
        return attack;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }
    
    

    public void move(String direction) {
        switch (direction) {
            case "up":
                this.position.setY(this.getPosition().getY() - 30);
                break;
            case "right":
                this.position.setX(this.getPosition().getX() + 30);
                break;
            case "down":
                this.position.setY(this.getPosition().getY() + 30);
                break;
            case "left":
                this.position.setX(this.getPosition().getX() - 30);
                break;
            default:
                break;
        }
        this.game.getGameW().move();
    }

    @Override
    public String toString() {
        return "Player " + playerName + position.toString();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
}
