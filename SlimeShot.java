import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class which shoots slime to kill the player.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
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
        if(isTouching(Person.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.loseScreen();
            removeTouching(Person.class);
        }
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
