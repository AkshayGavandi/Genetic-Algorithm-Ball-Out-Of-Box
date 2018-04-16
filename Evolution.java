
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay Gavandi
 */
public class Evolution {
    static int reproduce=0;
    static int death = 0;
    Random random = new Random();
    
    public Population evolve(Population newPopulation){
        Population population = newPopulation;
        for(Ball b: population.balls){
            b.setX(changeCoordinate(b.getX()));
            b.setY(changeCoordinate(b.getY()));
            b.setR(changeRadius(b.getR()));
            //System.out.print(" "+b.getX()+" "+b.getY()+" "+b.getR());
            //System.out.println("");
        }
        try{
            population = checkReproduction(population);
            newPopulation = checkDeath(population);
        }
        catch(Exception e){
                    
        }
        if(newPopulation.size()!=0){
            return newPopulation;
        }
        else {
            System.out.print("#Reproduced : " + reproduce + " #Death : " + death);
            return null;
            
        }
    }
    
    public Population checkReproduction(Population newPopulation){
        Population population = newPopulation;
        for(Ball b : population.balls){
            if(b.getR()>100){
                newPopulation.addBall(b.getX(), b.getY(), 50, b.getFitness());
                newPopulation.addBall(b.getX(), b.getY(), 50, b.getFitness());
                newPopulation.removeBall(b);
                System.out.print("Split");
                reproduce++;
            }
        }
        return newPopulation;
    }
    
    public Population checkDeath(Population newPopulation){
        Population population = newPopulation;
        for(Ball b : population.balls){
            if(b.getR()<10){
                newPopulation.removeBall(b);
                System.out.print("Dead");
                death++;
            }
        }
        return newPopulation;
    }
    
    public int changeRadius(int r){
        boolean inr = random.nextBoolean();
        if(inr){
            r+=5;
        }
        else{
            r-=5;
        }
        if(r<10){
            return 0;
        }
        return r;
    }
    
    public int changeCoordinate(int c){
        boolean inc = random.nextBoolean();
        if(inc){
            c+=5;
        }
        else{
            c-=5;
        }
        return c;
    }
}
