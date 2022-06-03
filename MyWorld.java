import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int x = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Person p = new Person();
        addObject(p, 300, 380);
        snake s = new snake();
        addObject(s,100,200);
        Dragon d = new Dragon();
        addObject(d, 300,200);
    }
    public void spawnLaser(int x,int y)
    {
        banana l = new banana();
        addObject(l,x,y);           
    }
    public void mitosis()
    {
        snake dupe = new snake();
        addObject(dupe,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
    }
    
    
    
}
