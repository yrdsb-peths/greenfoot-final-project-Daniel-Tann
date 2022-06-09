import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    boolean test = true;
    int x = 0;
    int personX = 0;
    int personY = 0;
    int lvl = 0;
    int dHp = 10;
    Label dHpScore;
    Label hpText;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Person p = new Person();
        addObject(p, 300, 380);
        snake s = new snake();
        snake sn = new snake();
        snake sna = new snake();
        addObject(s,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        addObject(sn,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        addObject(sna,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        Portal door = new Portal();
        addObject(door,550,350);
       
    }
  
    public void spawnLaser(int x,int y)
    {
        banana l = new banana();
        addObject(l,x,y);           
    }
    public void spawnShield(int x, int y)
    {
        Shield protect = new Shield();
        addObject(protect,x,y);
    }
    public void mitosis()
    {
        snake dupe = new snake();
        addObject(dupe,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
    }
    public void spawnFire(int x, int y)
    {
        dragon_fire spawnFire = new dragon_fire();
        addObject(spawnFire,x,y);
    }
    public void createPortal()
    {
        Portal door = new Portal();
        addObject(door,550,350);
    }
    public void spawnEnergyBall(int x, int y)
    {
        energyBall ball = new energyBall();
        addObject(ball,x,y);
    }
    public void dHpDecrease()
    {
        dHp--;
        dHpScore.setValue(dHp);
        if(dHp == 0)
        {
            removeObject(hpText);
            removeObject(dHpScore);
        }
    }
    public void nextWorld()
    {
        if(lvl == 0)
        {   
            hpText = new Label("Dragon HP:",30);
            dHpScore = new Label("10", 30);
            addObject(hpText,70,20);
            addObject(dHpScore,160, 20);
            Dragon d = new Dragon();
            addObject(d, 300,100);
            
        }
        if(lvl == 1)
        {
            enemy e = new enemy();
            enemy en = new enemy();
            addObject(e,Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
            addObject(en,Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));

        }
        if(lvl == 2)
        {
            SlimeMonster sm = new SlimeMonster();
            addObject(sm, 380,380);
        }
        if(lvl == 3)
        {
            
        }
        
        
        lvl++;
    }
   
    
    
    
}
