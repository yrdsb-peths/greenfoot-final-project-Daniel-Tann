import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The actor class which allows the player to go through portals.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class Portal extends Actor
{
    GreenfootImage teleport = new GreenfootImage("images/Portal.png");
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Portal()
    {
        setImage(teleport);
        teleport.scale(100,100);
    }
    public void act()
    {
       if(getNeighbours(600, true, snake.class).size() < 1 && getNeighbours(600, true, Dragon.class).size() < 1 && getNeighbours(600, true, enemy.class).size() < 1 && getNeighbours(600, true, SlimeMonster.class).size() < 1)
       {
           if(isTouching(Person.class))
           {
               MyWorld world = (MyWorld) getWorld();
                world.removeObject(this);
           }
       }
       if(getNeighbours(600, true, FinalBoss.class).size() >= 1)
       {
            MyWorld world = (MyWorld) getWorld();
           world.removeObject(this);
       }
    }
}
