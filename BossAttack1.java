import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The actor for the first type of attack the boss uses.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class BossAttack1 extends Actor
{
    GreenfootImage attack = new GreenfootImage("images/bossBeam.png");
    public BossAttack1()
    {
        setImage(attack);
        attack.scale(200,40);
        turn(90);        
    }
    public void act()
    {
        if(isTouching(BossAttack1.class))
        {
            setLocation(Greenfoot.getRandomNumber(600), getY());
        }
        if(isTouching(Person.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.loseScreen();
            removeTouching(Person.class);
        }
        setLocation(getX(), getY()+1);
    }
}
