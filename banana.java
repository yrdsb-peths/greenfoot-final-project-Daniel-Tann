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
    MouseInfo mouse = Greenfoot.getMouseInfo();
    /**
     * Act - do whatever the laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public banana()
    {
        setImage(beam);
    }
    public void act()
    {   
        beam.scale(200,100);
        if(mouse != null)
        {
            if(mouse.getButton() == 1)
            {
                while(!isAtEdge())
                {
                    move(-5);
                }   
                getWorld().removeObject(this);
                
            }
        }
        
    }
}