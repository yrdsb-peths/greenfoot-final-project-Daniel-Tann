import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlimeMonster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlimeMonster extends Actor
{
    GreenfootImage slimeRight = new GreenfootImage("images/slime.png");
    GreenfootImage slimeLeft = new GreenfootImage("images/slime.png");
    String facing = "left";
    int slimeHp = 5;
    int size = 100;
    SimpleTimer damageCoolDown = new SimpleTimer();
    SimpleTimer sludgeCoolDown = new SimpleTimer();
    SimpleTimer shootCoolDown = new SimpleTimer();
    /**
     * Act - do whatever the SlimeMonster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SlimeMonster()
    {
        slimeRight.mirrorHorizontally();
        setImage(slimeLeft);
        slimeLeft.scale(size,size);
        slimeRight.scale(size,size);
        damageCoolDown.mark();
        sludgeCoolDown.mark();
        shootCoolDown.mark();
    }
    public void act()
    {
        if(isTouching(Person.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.loseScreen();
            removeTouching(Person.class);
        }
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
            setImage(slimeRight);
            facing = "right";
        }
        if(getX() == 599)
        {
            setImage(slimeLeft);
            facing = "left";
        }
        if(isTouching(Shield.class))
        {
            setLocation(getX(), 20);
        }
        if(getY() < 380)
        {
            setLocation(getX(), getY()+1);
        }
        if(isTouching(banana.class) && damageCoolDown.millisElapsed() > 100)
        {
            removeTouching(banana.class);
            slimeHp--;
            size-= 19;
            slimeLeft.scale(size,size);
            slimeRight.scale(size,size);
            MyWorld world = (MyWorld) getWorld();
            world.slimeHpDecrease();
            if(slimeHp == 0)
            {
                world.removeObject(this);
            }
            damageCoolDown.mark();
        }
      
        if(damageCoolDown.millisElapsed() > 10000)
        {
            slimeHp += 5;
            size+=100;
            slimeLeft.scale(size,size);
            slimeRight.scale(size,size);
            MyWorld world = (MyWorld) getWorld();
            world.slimeHpIncrease();
            damageCoolDown.mark();
        }
        if(sludgeCoolDown.millisElapsed() > 3000)
        {
            MyWorld world = (MyWorld) getWorld();    
            world.summonJuice(getX(), getY());
            sludgeCoolDown.mark();
        }
        if(shootCoolDown.millisElapsed() > 5000)
        {
            MyWorld world = (MyWorld) getWorld();   
            for(int i = 0; i < 10; i++)
            {
                world.shootJuice(getX(), getY());
            }
            shootCoolDown.mark();
        }
    }
}
