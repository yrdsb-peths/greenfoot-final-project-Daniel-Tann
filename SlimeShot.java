import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlimeShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlimeShot extends Actor
{
    GreenfootImage slime = new GreenfootImage("images/flyingresidue.png");
    int shoot = 1;
    /**
     * Act - do whatever the SlimeShot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SlimeShot()
    {
        setImage(slime);
        slime.scale(50,50);
    }
    public void act()
    {
        if(shoot == 1)
        {
            coords();
            shoot--;
        }
        move(1);
        if(getY() < 40)
        {
            turn(Greenfoot.getRandomNumber(340));
        }
        if(isTouching(Shield.class))
        {
           turn(70);
        }
        if(isAtEdge())
        {
            getWorld().removeObject(this);
            shoot++;
        }
    }
    public void coords()
    {
        turnTowards(Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
    }
    
}
