import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class which allows the player to shoot a laser.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class banana extends Actor
{
    GreenfootImage beam = new GreenfootImage("images/LASER.png");
    int x = 0;
    int y = 0;
    int shoot = 1;
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
    {   
        
        if(shoot == 1)
        {
            mouseCoords();
            shoot--;
        }
        move(-5);
        removeTouching(snake.class);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
            shoot++;
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