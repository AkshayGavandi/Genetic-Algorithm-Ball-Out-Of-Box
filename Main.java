
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay Gavandi
 */
public class Main {
    public static final int MIN=0;
    public static final int MAX=1000;
    
    public int xmin = MIN;
    public int xmax = MAX;
    public int ymin = MIN;
    public int ymax = MAX;
    
    public static void main(String[] args){
        int unfitcount = 0;
        System.out.println("Enter the initial population : ");
        Scanner sc = new Scanner(System.in);
        int pop = sc.nextInt();
        //System.out.println("Enter the evolution levels after which unfit population is to be terminated : ");
        //int unfitcountlimit = sc.nextInt();
        int unfitcountlimit = 75;
        //System.out.println("Enter in percentage (0-100) the amount of population to be retained : ");
        //int percentTermination = sc.nextInt();
        int percentTermination = 70;
        Population population = new Population(pop);
        Evolution evolution = new Evolution();
        Fitness fit = new Fitness();
        Ball b = new Ball();
        try{
            while(!(boolean)(population.getOutOfTheBox().get("outOfTheBox"))){
                unfitcount++;
                population = fit.setFitness(population);
                b = fit.getFittest(population);
                System.out.println("Fittest ball now is "+ b.getX()+" "+b.getY()+" "+b.getR()+" "+b.getFitness());
                population = evolution.evolve(population);
                if(unfitcount == unfitcountlimit){
                    population = fit.getTopKFittest(population, percentTermination);
                    unfitcount = 0;
                }
                System.out.println("--------------------------------"+population.size());
            }
            System.out.println("I am out of the box!");
            b = (Ball)population.getOutOfTheBox().get("fittest");
            System.out.println(b.getX()+" "+b.getY()+" "+b.getR());
        }
        catch(NullPointerException n){
            System.out.println("\nPopulation Extinct!");
        }
    }
}
