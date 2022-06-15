import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main world of the game
 * 
 * @author (Daniel Tan)
 * @version (June 2022)
 */
public class MyWorld extends World
{
    SimpleTimer timer = new SimpleTimer();
    int time = 0;    
    int personX = 0;
    int personY = 0;
    int lvl = 0;
    int dHp = 10;
    int wizardHp = 4;
    int slimeHp = 5;
    int bossHp = 5;
    boolean attackBoss = false;
    Label timeText;
    Label timeRecord;
    Label win;
    Label lose;
    Label dHpScore;
    Label dHpText;
    Label wizardHpScore;
    Label wizardHpText;
    Label slimeHpScore;
    Label slimeHpText;
    Label bossHpScore;
    Label bossHpText;
    GreenfootImage backRoundThree = new GreenfootImage("images/Backround3.jpg");
    GreenfootImage backRoundFour = new GreenfootImage("images/Backround4.png");
    GreenfootImage backRoundFive = new GreenfootImage("images/Backround5.png");
    GreenfootImage backRoundSix = new GreenfootImage("images/Backround6.png");
    GreenfootImage backRoundSeven = new GreenfootImage("images/Backround7.png");
    GreenfootSound gameMusic = new GreenfootSound("music.mp3");
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        gameMusic.play();
        timer.mark();
        Person p = new Person();
        addObject(p, 300, 380);
        snake s = new snake();
        snake sn = new snake();
        snake sna = new snake();
        addObject(s,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(200));
        addObject(sn,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(200));
        addObject(sna,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(200));
        setBackground(backRoundThree);
        Portal door = new Portal();
        addObject(door,550,350);
    }
    /**
     * Creates a "You Win" label on screen when boss is beat.
     */
    public void winScreen()
    {
        win = new Label("You Win!" , 80);
        addObject(win, 300, 200);
        time = timer.millisElapsed()/1000;
        timeText = new Label("Time To Beat:" , 50);
        timeRecord = new Label("0", 45);
        timeRecord.setValue(time);
        addObject(timeText, 300,270);
        addObject(timeRecord, 480,270);
    }
    /**
     * Creates a "You Lose" label on the screen when player is killed.
     */
    public void loseScreen()
    {
        lose = new Label("You Lose!", 80);
        addObject(lose,300, 200);
    }
    /**
     * Creates a laser called banana at the specified x and y coordinates.
     */
    public void spawnLaser(int x,int y)
    {
        banana l = new banana();
        addObject(l,x,y);           
    }
    /**
     * Updates the values of personX and personY with the given values.
     */
    public void updateCoord(int x, int y)
    {
        personX = x;
        personY = y;
    }
    /**
     * Returns the value of personY.
     */
    public int getYCoord()
    {
        return personY;
    }
    /**
     * Returns the value of personX.
     */
    public int getXCoord()
    {
        return personX;     
    }
    /**
     * Creates a shield to protect the player at the specified x and y coordinates.
     */
    public void spawnShield(int x, int y)
    {
        Shield protect = new Shield();
        addObject(protect,x,y);
    }
    /**
     * A method which doubles the current number of snake actors in the world.
     */
    public void mitosis()
    {
        snake dupe = new snake();
        addObject(dupe,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
    }
    /**
     * Creates a fire beam at the specified x and y coordinates
     */
    public void spawnFire(int x, int y)
    {
        dragon_fire spawnFire = new dragon_fire();
        addObject(spawnFire,x,y);
    }
    /**
     * Creates a portal for the player to enter when all enemies are defeated.
     */
    public void createPortal()
    {
        Portal door = new Portal();
        addObject(door,550,350);
    }
    /**
     * Creates an energy ball at the specified x and y coordinates.
     */
    public void spawnEnergyBall(int x, int y)
    {
        energyBall ball = new energyBall();
        addObject(ball,x,y);
    }
    /**
     * Decreases the dragon's hp as well updates the health bar of the dragon actor.
     * When variable hp reaches 0, health bar is removed.
     */
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
    /**
     * Decreases the wizard's hp as well updates the health bar of the wizard actor.
     * When variable hp reaches 0, health bar is removed.
     */
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
    /**
     * Decreases the slime's hp as well updates the health bar of the slime actor.
     * When variable hp reaches 0, health bar is removed.
     */
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
    /**
     * Decreases the boss's hp as well updates the health bar of the boss actor.
     * When variable hp reaches 0, health bar is removed.
     */
    public void bossHpDecrease()
    {
        bossHp--;
        bossHpScore.setValue(bossHp);
        if(bossHp == 0)
        {
            removeObject(bossHpText);
            removeObject(bossHpScore);
        }
    }
    /**
     * Increases the slime'hp by 5 hp, as well updates the health bar of the slime actor
     */
    public void slimeHpIncrease()
    {
        slimeHp+= 5;
        slimeHpScore.setValue(slimeHp);
    }
    /**
     * Creates slime residue at the specified x and y coordinates.
     */
    public void summonJuice(int x, int y)
    {
        slimeJuice sludge = new slimeJuice();
        addObject(sludge,x,y);
    }
    /**
     * Creates slime juice at the specified x and y coordinates.
     */
    public void shootJuice(int x, int y)
    {
        SlimeShot shootJuice = new SlimeShot();
        addObject(shootJuice,x,y);
    }
    /**
     * Creates a star at a randomized x coordinate.
     */
    public void summonStar()
    {
        star w = new star();
        addObject(w,Greenfoot.getRandomNumber(600),0);
    }
    /**
     * Creates the first type of attack the boss uses at a specified x and y coordinate.
     */
    public void attackOne(int x, int y)
    {
        BossAttack2 at = new BossAttack2();
        addObject(at,x,y);
    }
    /**
     * Creates the second type of attack the boss uses.
     */
    public void attackTwo()
    {
        BossAttack1 a = new BossAttack1();
        addObject(a,Greenfoot.getRandomNumber(600),0);
    }
    /**
     * A method which allows the boss to take damage
     */
    public void hitBoss()
    {
        attackBoss = true;
    }
    /**
     * A boolean which returns if the boss can be damaged.
     */
    public boolean returnHitBoss()
    {
        return attackBoss;
    }
    /**
     * A method which allows the boss to not take damage.
     */
    public void deHitBoss()
    {
        attackBoss = false;
    }
    /**
     * A method used to go to the next level when called.
     */
    public void nextWorld()
    {
        if(lvl == 0)
        {   
            setBackground(backRoundFour);
            dHpText = new Label("Dragon HP:",30);
            dHpScore = new Label("10", 30);
            addObject(dHpText,70,20);
            addObject(dHpScore,160, 20);
            Dragon d = new Dragon();
            addObject(d, 300,100);
        }
        if(lvl == 1)
        {
            setBackground(backRoundFive);
            enemy e = new enemy();
            addObject(e,Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
            wizardHpText = new Label("Wizard HP:", 30);
            wizardHpScore = new Label("4",30);
            addObject(wizardHpText,70,20);
            addObject(wizardHpScore, 160,20);
        }
        if(lvl == 2)
        {
            setBackground(backRoundSix);
            slimeHpText = new Label("Slime Hp:" , 30);
            slimeHpScore = new Label("5", 30);
            addObject(slimeHpText,70,20);
            addObject(slimeHpScore,160, 20);
            SlimeMonster sm = new SlimeMonster();
            addObject(sm, 580,380);
        }
        if(lvl == 3)
        {
            setBackground(backRoundSeven);
            bossHpText = new Label("Boss Hp:" , 30);
            bossHpScore = new Label("5", 30);
            addObject(bossHpText,70,20);
            addObject(bossHpScore, 160, 20);
            FinalBoss boss = new FinalBoss();
            addObject(boss,100,100);
        }
        lvl++;
    }
   
    
    
    
}
