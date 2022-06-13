import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    int x = 0;
    int personX = 0;
    int personY = 0;
    int lvl = 0;
    int dHp = 10;
    int wizardHp = 4;
    int slimeHp = 5;
    Label dHpScore;
    Label dHpText;
    Label wizardHpScore;
    Label wizardHpText;
    Label slimeHpScore;
    Label slimeHpText;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
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
            removeObject(dHpText);
            removeObject(dHpScore);
        }
    
    }
    public void wizardHpDecrease()
    {
        wizardHp--;
        wizardHpScore.setValue(wizardHp);
        if(wizardHp <= 0 )
        {
            removeObject(wizardHpText);
            removeObject(wizardHpScore);
        }
    }
    public void slimeHpDecrease()
    {
        slimeHp--;
        slimeHpScore.setValue(slimeHp);
        if(slimeHp == 0)
        {
            removeObject(slimeHpText);
            removeObject(slimeHpScore);
        }
    }
    public void slimeHpIncrease()
    {
        slimeHp+= 5;
        slimeHpScore.setValue(slimeHp);
    }
    public void summonJuice(int x, int y)
    {
        slimeJuice sludge = new slimeJuice();
        addObject(sludge,x,y);
    }
    public void shootJuice(int x, int y)
    {
        SlimeShot shootJuice = new SlimeShot();
        addObject(shootJuice,x,y);
    }
    
    public void attackOne(int x, int y)
    {
        BossAttack2 at = new BossAttack2();
        addObject(at,x,y);
    }
    public void attackTwo()
    {
        BossAttack1 a = new BossAttack1();
        addObject(a,Greenfoot.getRandomNumber(600),0);
    }
    public void nextWorld()
    {
        if(lvl == 0)
        {   
            dHpText = new Label("Dragon HP:",30);
            dHpScore = new Label("10", 30);
            addObject(dHpText,70,20);
            addObject(dHpScore,160, 20);
            Dragon d = new Dragon();
            addObject(d, 300,100);
            
        }
        if(lvl == 1)
        {
            enemy e = new enemy();
            addObject(e,Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
            wizardHpText = new Label("Wizard HP:", 30);
            wizardHpScore = new Label("4",30);
            addObject(wizardHpText,70,20);
            addObject(wizardHpScore, 160,20);
        }
        if(lvl == 2)
        {
            slimeHpText = new Label("Slime Hp:" , 30);
            slimeHpScore = new Label("5", 30);
            addObject(slimeHpText,70,20);
            addObject(slimeHpScore,160, 20);
            SlimeMonster sm = new SlimeMonster();
            addObject(sm, 380,380);
        }
        if(lvl == 3)
        {
            FinalBoss boss = new FinalBoss();
            addObject(boss,100,100);
        }
        
        
        lvl++;
    }
   
    
    
    
}
