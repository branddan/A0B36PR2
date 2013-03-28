/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author user
 */
public class Helicopter {

    private Position position;
    private String playerName;
    private String type; //Apache nebo Black Hawk
    private double health; //pocet zivotu, kdyz pod nulou, konec hry
    private double firepower; //ovlivni damage
    private double maxShotSpeed; //ovlivni strmost drahy strely
    private double size; //velikost helikoptery
    private int moves; //ovlivni pohybovych tahu
    private int skore2; //mazat

//    public Helicopter(String jmeno) {
//        this.playerName = jmeno;
//        this.position = new Position();
//    }
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

    public void setHealth(double skore) {
        if (skore >= 0) {
            this.health = skore;
        }
    }

    public int getSkore2() {
        return skore2;
    }

    public void setSkore2(int skore2) {
        if (skore2 >= 0) {
            this.skore2 = skore2;
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

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public void move(int direction) {
        switch (direction) {
            case 1:
                this.position.setY(this.getPosition().getY() + 5);
                break;
            case 2:
                this.position.setX(this.getPosition().getX() + 5);
                break;
            case 3:
                this.position.setY(this.getPosition().getY() - 5);
                break;
            case 4:
                this.position.setX(this.getPosition().getX() - 5);
                break;
            default:
                break;
        }
        this.setMoves(moves - 1);
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
