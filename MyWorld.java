import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    boolean test = true;
    int x = 0;
    int personX = 0;
    int personY = 0;
    
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
        //addObject(d, 300,100);
        Portal door = new Portal();
        addObject(door,550,350);
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
    public void spawnFire(int x, int y)
    {
        dragon_fire spawnFire = new dragon_fire();
        addObject(spawnFire,x,y);
    }
    public void createPortal()
    {
        Portal door = new Portal();
        addObject(door,550,350);
    }
    public void nextWorld()
    {
        secondLevel second = new secondLevel();
        Greenfoot.setWorld(second); 
    }
   
    
    
    
}
