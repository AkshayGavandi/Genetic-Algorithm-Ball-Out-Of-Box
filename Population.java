
import java.lang.reflect.Array;
import java.util.ArrayList;
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
public class Population {
    ArrayList<Ball> balls;
    
    public Population(int populationSize){
        balls = new ArrayList<>();
        
        for(int i=0;i<populationSize;i++){
            addBall(250,250,50,Main.MAX);
        }
    }
    
    public int size(){
        return balls.size();
    }
    
    public Ball getBall(int index){
        return balls.get(index);
    }
    
    public HashMap<String, Object> getOutOfTheBox(){
        Ball out = new Ball(250,250,50,Main.MAX);
        boolean outOfTheBox = false;
        HashMap<String, Object> map = new HashMap<>();
        for(Ball b : balls){
            if(b.getX()<0-b.getR() || b.getX()>500+b.getR() || b.getY()<0-b.getR() || b.getY()>500+b.getR()){
                out = b;
                outOfTheBox = true;
            }
            map.put("fittest", out);
            map.put("outOfTheBox", outOfTheBox);
        }
        return map;
    }
    
    public void addBall(int x, int y, int r, int f){
        Ball b = new Ball(x,y,r,f);
        balls.add(b);
        //return b;
    }
    
    public void removeBall(Ball b){
        balls.remove(b);
    }
}
