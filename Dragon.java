import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The main actor class for the dragon enemy.
 * 
 * @author (Daniel Tan) 
 * @version (June 2022)
 */
public class Dragon extends Actor
{
    SimpleTimer dragonBreath = new SimpleTimer();
    GreenfootImage rightBoss = new GreenfootImage("images/PngItem_377031.png");
    GreenfootImage leftBoss = new GreenfootImage("images/PngItem_377031.png");
    String facing = "left";
    int dragonHp = 10;
    SimpleTimer damageCoolDown = new SimpleTimer();
    public Dragon()
    {
        rightBoss.mirrorHorizontally();
        setImage(leftBoss);
        leftBoss.scale(100,100);
        rightBoss.scale(100,100);
        dragonBreath.mark();
        damageCoolDown.mark();
    }
    public void act()
    {
        if(facing.equals("left"))
        {
            move(-1);
        }
        if(facing.equals("right"))
        {
            move(1);
        }
        if(getX() == 0)
        {
            setImage(rightBoss);
            facing = "right";
        }
        if(getX() == 599)
        {
            setImage(leftBoss);
            facing = "left";
        }
        if(dragonBreath.millisElapsed() > 3000 && getX() > 100 && getX() < 500)
        {
            MyWorld world = (MyWorld) getWorld();
            world.spawnFire(getX(), getY());
            for(int i = 0; i < 8; i++)
            {
                world.spawnFire(getX(), getY());
            }
            dragonBreath.mark();
        }
        if(isTouching(banana.class) && damageCoolDown.millisElapsed() > 100)
        {
            removeTouching(banana.class);
            dragonHp--;
            MyWorld world = (MyWorld) getWorld();
            world.dHpDecrease();
            if(dragonHp == 0)
            {
                world.removeObject(this);
            }
            damageCoolDown.mark();
        }   
    }
}
