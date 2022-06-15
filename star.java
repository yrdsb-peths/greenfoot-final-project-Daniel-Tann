import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class which creates a star for the player to pick up to damage the boss.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class star extends Actor
{
    GreenfootImage star = new GreenfootImage("images/star.png");
    /**
     * Act - do whatever the star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public star()
    {
        setImage(star);
        star.scale(50,50);
    }
    public void act()
    {
        if(getY() < 380)
        {
            setLocation(getX(), getY()+1);
        }
    }
}
