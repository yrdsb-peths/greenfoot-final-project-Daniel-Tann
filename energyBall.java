import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class energyBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class energyBall extends Actor
{
    int fire = 1;
    /**
     * Act - do whatever the energyBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(fire == 1)
        {
            coords();
            fire--;
        }
        move(-1);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
            fire++;
        }   
    }
    public void coords()
    {
        turnTowards(Greenfoot.getRandomNumber(600),0);
    }
}
