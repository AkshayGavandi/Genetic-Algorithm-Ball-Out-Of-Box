
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay Gavandi
 */
public class Ball implements Comparable<Ball>{
    private int x;
    private int y;
    private int r;
    private int fitness;

    public Ball(){};
    
    public Ball(int x, int y, int r, int fitness) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.fitness = fitness;
    }

    public void displayBall(Ball ball){
        ball.getX();
        ball.getY();
        ball.getR();
        ball.getFitness();
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
    
    @Override
    public int compareTo(Ball o){
        int compareFitness =  ((Ball) o).getFitness();
        return this.getFitness() - compareFitness;
    }
}
