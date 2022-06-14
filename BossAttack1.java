import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossAttack1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossAttack1 extends Actor
{
    GreenfootImage attack = new GreenfootImage("images/bossBeam.png");
    /**
     * Act - do whatever the BossAttack1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
