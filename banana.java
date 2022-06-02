import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class banana extends Actor
{
    GreenfootImage beam = new GreenfootImage("images/LASER.png");
    int x = 0;
    int y = 0;
    /**
     * Act - do whatever the laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public banana()
    {
        setImage(beam);
        beam.scale(200,100);
    }
    public void act()
    {   mouseCoords();
        move(-5);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
        
    }
    public void mouseCoords()
    {
        MouseInfo coords = Greenfoot.getMouseInfo();
        x = coords.getX();
        y = coords.getY();
        turnTowards(x,y);
        turn(180);
    }
    
}