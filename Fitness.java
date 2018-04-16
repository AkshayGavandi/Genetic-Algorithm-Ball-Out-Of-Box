
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay Gavandi
 */
public class Fitness {
    private int xmin=0;
    private int xmax=500;
    private int ymin=0;
    private int ymax=500;
        
    public Population setFitness(Population population){
        //int[] fitness = new int[population.size()];
        //int index=0;
        for(Ball b : population.balls){
            int x1 = b.getX() - xmin;
            int y1 = b.getY() - ymin;
            int x2 = xmax - b.getX();
            int y2 = ymax - b.getY();
            
            int[] temp = {x1,y1,x2,y2};
            int min=500;
            for(int i=0; i<temp.length; i++){
                if(min>temp[i]){
                    min = temp[i]; 
                }
            }
            
            b.setFitness(min);
            //index++;
        } 
        return population;
    }
    
    public Population sortFitness(Population population){
        Collections.sort(population.balls);
        return population;
    }
    
    public Ball getFittest(Population population){
        Ball fittest = new Ball(Main.MAX,Main.MAX,50,Main.MAX);
        for(Ball b : population.balls){
            if(b.getFitness()<fittest.getFitness()){
                fittest=b;
            }
        }
        return fittest;
    }
    
    public Population getTopKFittest(Population population, int k){
        Population sortedFitness = sortFitness(population);
        Population topFitness = new Population(0);
        int x = (int) (sortedFitness.size()*k/100);
        for(int i=0;i<x;i++){
            topFitness.balls.add(sortedFitness.balls.get(i));
        }
        return topFitness;
    }
}
