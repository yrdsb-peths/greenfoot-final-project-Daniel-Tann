import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person extends Actor
{

    SimpleTimer time = new SimpleTimer();
    SimpleTimer jump = new SimpleTimer();
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Person()
    {
        time.mark();
        jump.mark();
    }

    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(time.millisElapsed() > 1000 && Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("shift"))
        {
            setLocation(getX()+80,getY());
            time.mark();
        }
        if(time.millisElapsed() > 1000 && Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("shift"))
        {
            setLocation(getX()-80, getY());
            time.mark();
        }
        //Moving Normally
        if(Greenfoot.isKeyDown("a"))
        {
            move(-1);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            move(1);
        }
        if(jump.millisElapsed() > 3000 && Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(),getY()-380);
            jump.mark();
        }
        if(getY() < 380)
        {
            setLocation(getX(), getY()+1);
        }
        if(mouse != null)
        {            
            if(mouse.getButton() == 1)
            {
                MyWorld world = (MyWorld) getWorld();
                world.spawnLaser(getX(), getY());
            }
        }
        if(getNeighbours(600, true, snake.class).size() < 1 && getNeighbours(600, true, Dragon.class).size() < 1)
        {
            if(isTouching(Portal.class))
            {
                setLocation(50, 380);
                MyWorld world = (MyWorld) getWorld();
                world.nextWorld();
                
            }
           
        }
        
            
    }
   
}
