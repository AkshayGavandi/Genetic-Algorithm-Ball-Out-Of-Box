
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
            addBall(Main.MAX/2,Main.MAX/2,50,Main.MAX);
        }
    }
    
    public int size(){
        return balls.size();
    }
    
    public Ball getBall(int index){
        return balls.get(index);
    }
    
    public HashMap<String, Object> getOutOfTheBox(){
        Ball out = new Ball(Main.MAX/2,Main.MAX/2,50,Main.MAX);
        boolean outOfTheBox = false;
        HashMap<String, Object> map = new HashMap<>();
        for(Ball b : balls){
            if(b.getX()<Main.MIN-b.getR() || b.getX()>Main.MAX+b.getR() || b.getY()<Main.MIN-b.getR() || b.getY()>Main.MAX+b.getR()){
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
