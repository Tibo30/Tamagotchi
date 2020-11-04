package TamagotchiV2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public abstract class Tamagotchi {
	protected String name;
	protected String type;
	protected String color;
	protected String otherColor;
	protected int health;
	protected int healthMax;
	protected double height;
	protected int lifeExpectancy;
	protected int awake;
	protected int awakeMax;
	protected boolean mask = true;
	protected int hungry;
	protected int hungryMax;
	protected int dirtLevel = 0;
	protected int dirtLevelMax = 0;
	protected int needToilettes = 0;
	protected int needToilettesMax = 0;

	/*
	 * This is the constructor of the Tamagotchi class
	 */
	public Tamagotchi(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;

	}

	/*
	 * The method color is used in Tamagotchi's child classes
	 */
	abstract public void color();

	/**
	 * The method otherColor is used in Tamagotchi's child classes
	 */
	abstract public void otherColor();

	/**
	 * The method dyeOtherColor is used in Tamagotchi's child classes
	 */
	abstract public void dyeOtherColor();

	/**
	 * The method eat is used in Tamagotchi's child classes
	 */
	abstract public void eat();

	/**
	 * This method is used to set the health variable
	 * 
	 * @param health
	 */
	public void setHealth(int health) {
		if (health < 0) {
			health = 0;
		} else if (health > this.healthMax) {
			health = this.healthMax;
		}
		this.health = health;
	}

	/**
	 * This method is used to set the height variable
	 * 
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * This method is used to set the needToilettes variable
	 * 
	 * @param needToilettes
	 */
	public void setNeedToilettes(int needToilettes) {
		if (needToilettes > 10) {
			needToilettes = 10;
		}
		this.needToilettes = needToilettes;
	}

	/**
	 * This method is used to set the hungry variable
	 * 
	 * @param hungry
	 */
	public void setHungry(int hungry) {
		if (hungry < 0) {
			hungry = 0;
		}
		this.hungry = hungry;
	}

	/**
	 * This method is used to set the dirtLevel variable
	 * 
	 * @param dirtLevel
	 */
	public void setDirtLevel(int dirtLevel) {
		if (dirtLevel > 10) {
			dirtLevel = 10;
		}
		if (dirtLevel < 0) {
			dirtLevel = 0;
		}

		this.dirtLevel = dirtLevel;
	}

	/**
	 * This method is used to set the awake variable
	 * 
	 * @param awake
	 */
	public void setAwake(int awake) {
		if (awake < 0) {
			awake = 0;
		}
		this.awake = awake;
	}

	/**
	 * This method is used to return the lifeExpectancy variable
	 * 
	 * @return
	 */
	public int getLifeExpectancy() {
		return this.lifeExpectancy;
	}

	/**
	 * This method is used to return the health variable
	 * 
	 * @return
	 */
	public int getHealth() {
		return this.health;
	}

	/**
	 * This method is used to return the height variable
	 * 
	 * @return
	 */
	public double getHeight() {
		return this.height;
	}

	/**
	 * This method is used to return the awake variable
	 * 
	 * @return
	 */
	public int getAwake() {
		return this.awake;
	}

	/**
	 * This method is used to return the awakeMax variable
	 * 
	 * @return
	 */
	public int getAwakeMax() {
		return this.awakeMax;
	}

	/**
	 * This method is used to return the hungry variable
	 * 
	 * @return
	 */
	public int getHungry() {
		return this.hungry;
	}

	/**
	 * This method is used to return the hungryMax variable
	 * 
	 * @return
	 */
	public int getHungryMax() {
		return this.hungryMax;
	}

	/**
	 * This method is used to return the needToilettes variable
	 * 
	 * @return
	 */
	public int getNeedToilettes() {
		return this.needToilettes;
	}

	/**
	 * This method is used to return the needToilettesMax variable
	 * 
	 * @return
	 */
	public int getNeedToilettesMax() {
		return this.needToilettesMax;
	}

	/**
	 * This method is used to return the cleanLevel variable
	 * 
	 * @return
	 */
	public int getDirtLevel() {
		return this.dirtLevel;
	}

	/**
	 * This method is used to return the cleanLvelMax variable
	 * 
	 * @return
	 */
	public int getDirtLevelMax() {
		return this.dirtLevelMax;
	}

	/**
	 * This method is used to return the mask variable
	 * 
	 * @return
	 */
	public boolean getMask() {
		return this.mask;
	}

	/**
	 * This method is used to display the Daily caracteristics
	 */

	public void showDailyStats() {
		JOptionPane.showMessageDialog(null,
				"\nPoints de vie : " + health + "\nEspérance de vie : " + lifeExpectancy
						+ (lifeExpectancy > 1 ? " tours" : " tour") + "\nEveil : " + awake + "\nFaim : " + hungry
						+ "\nNiveau de saleté : " + dirtLevel + "\nEnvie d'aller aux toilettes : " + needToilettes
						+ "\nMasque mis ? " + mask + "\nTaille : " + height + " cm",
				"CARACTERISTIQUES JOURNALIERES", JOptionPane.PLAIN_MESSAGE, null);
// This is going to open a new window to show the caracteristics
	}

	/*
	 * This method is used to display all the tamagotchi's caracteristics
	 * 
	 */
	public void showCaracteristics() {
		JOptionPane.showMessageDialog(null,
				"Les caractéristiques de votre tamagotchi sont les suivantes :\nNom : " + name + "\nType : " + type
						+ "\nCouleur : " + color + "\nCouleur de cheveux : " + otherColor + "\nTaille : " + height
						+ " cm" + "\nPoints de vie : " + health + "\nEspérance de vie : " + lifeExpectancy
						+ (lifeExpectancy > 1 ? " tours" : " tour") + "\nEveil : " + awake + "\nFaim : " + hungry
						+ "\nNiveau de saleté : " + dirtLevel + "\nEnvie d'aller aux toilettes : " + needToilettes
						+ "\nMasque mis ? " + mask,
				"CARACTERISTIQUES DE VOTRE TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);
	}

	/**
	 * This method is used to display the tamagotchi's vital caracteristics
	 */
	public void showLife() {
		JOptionPane.showMessageDialog(null,
				"\nVoici les caractéristiques mises à jour de votre tamagotchi : " + "\nPoints de vie : " + health
						+ "\nEspérance de vie : " + lifeExpectancy + (lifeExpectancy > 1 ? " tours" : " tour")
						+ "\nEveil : " + awake + "\nFaim : " + hungry + "\nNiveau de saleté : " + dirtLevel
						+ "\nEnvie d'aller aux toilettes : " + needToilettes,
				"CARACTERISTIQUES VITALES DE VOTRE TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);
	}

	/**
	 * This method is used to display the caracteristics of the baby when the
	 * tamagotchi reproduces himself
	 */
	public void showBaby() {
		JOptionPane.showMessageDialog(null,
				"\nVoici les caractéristiques de votre bébé tamagotchi : " + "\nNom : Bébé" + "\nType : " + type
						+ "\nCouleur : " + color + "\nCouleur de cheveux : " + otherColor,
				"BEBE TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);
	}

	/**
	 * This method is used to do the actions according to the user's choices,
	 * defined later in the code
	 * 
	 * @param i
	 */
	public void action(int i) {
		switch (i) {

		case 13:
			showLife();
			break;

		case 12:
			showMood();
			break;
		case 11:
			die();
			break;
		case 10:
			dyeOtherColor();
			break;
		case 9:
			smoke();
			break;
		case 8:
			takeShower();
			break;
		case 7:
			takeOnOffMask();
			break;
		case 6:
			doSport();
			break;
		case 5:
			seeFriends();
			break;
		case 4:
			haveSex();
			break;
		case 3:
			takeBreak();
			break;
		case 2:
			goToToilettes();
			break;
		case 1:
			eat();
			break;

		}
	}

	/**
	 * This method is used to do the action "Go to Toilettes"
	 */
	public void goToToilettes() {
		if (this.needToilettes > 2) { // if the value needToilettes is high enough
			JOptionPane.showMessageDialog(null, name + " se sent mieux", "ALLER AUX TOILETTES",
					JOptionPane.PLAIN_MESSAGE, null);
			setAwake(this.awake - 1);
			setNeedToilettes(0);
			setDirtLevel(this.dirtLevel + 1);
			setHungry(this.hungry - 1);
		} else {
			JOptionPane.showMessageDialog(null, name + " n'a pas envie d'aller aux toilettes", "ALLER AUX TOILETTES",
					JOptionPane.PLAIN_MESSAGE, null);
		}

	}

	/**
	 * This method is used to do the action "Show Tamagotchi's Mood"
	 */
	public void showMood() {
		if (this.health > 7) {
			JOptionPane.showMessageDialog(null, name + " saute de joie ! \t :D", "HUMEUR", JOptionPane.PLAIN_MESSAGE,
					null);
		} else if (this.health > 5) {
			JOptionPane.showMessageDialog(null, name + " est content ! \t :)", "HUMEUR", JOptionPane.PLAIN_MESSAGE,
					null);
		} else if (this.health < 5 && this.health > 3) {
			JOptionPane.showMessageDialog(null, name + " a besoin de se reposer ! \t zzzzzzzzz", "HUMEUR",
					JOptionPane.PLAIN_MESSAGE, null);
		} else {
			JOptionPane.showMessageDialog(null, name + " n'est pas du tout en forme ! \t x(", "HUMEUR",
					JOptionPane.PLAIN_MESSAGE, null);
		}
	}

	/**
	 * This method is used to do the action "Get a rest"
	 */
	public void takeBreak() {

		if (this.awake < this.awakeMax - 2) { // if the tamagotchi is tired enough
			String[] tamaBreak = { "Aller faire une sieste", "Aller dormir" };
			String takebreak = (String) JOptionPane.showInputDialog(null,
					"Veuillez choisir une action pour se reposer puis cliquez sur Ok " + name, "SE REPOSER",
					JOptionPane.QUESTION_MESSAGE, null, tamaBreak, tamaBreak[0]);
			// we display different messages according to the player's choice
			if (takebreak.equals(tamaBreak[0])) {
				JOptionPane.showMessageDialog(null, name + " va faire une sieste\n ZZZZZZZZZZZZZZZZZZZZZ", "SE REPOSER",
						JOptionPane.PLAIN_MESSAGE, null);
				setAwake(this.awake + 2);
				setNeedToilettes(this.needToilettes + 1);
				setHungry(this.hungry - 1);
			} else {
				JOptionPane.showMessageDialog(null, name + " va dormir \n ZZZZZZZZZZZZZZZZZZZZZ", "SE REPOSER",
						JOptionPane.PLAIN_MESSAGE, null);
				setAwake(awakeMax);
				setNeedToilettes(this.needToilettes + 2);
				setHungry(this.hungry - 2);
			}
			setHealth(this.health + 1);
		} else {
			JOptionPane.showMessageDialog(null, name + " n'est pas fatigué !", "SE REPOSER", JOptionPane.PLAIN_MESSAGE,
					null);
		}

	}

	/**
	 * This method is used to do the action "the Tamagotchi reproduces himself"
	 */
	public void haveSex() {
		JOptionPane.showMessageDialog(null, name + " est en train de se reproduire (!!-18)", "SE REPRODUIRE",
				JOptionPane.PLAIN_MESSAGE, null);
		setHealth(this.health + 1);
		setAwake(this.awake - 2);
		setHungry(this.hungry - 1);
		setDirtLevel(this.dirtLevel + 3);
		setNeedToilettes(this.needToilettes + 1);
	}

	/**
	 * This method is used to do the action "see friends"
	 */
	public void seeFriends() {
		String[] tamaFriends = { "Aller boire un coup", "Sortir en boite de nuit", "Se promener" };
		String friends = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir une action avec vos amis puis cliquez sur Ok " + name, "VOIR SES AMIS",
				JOptionPane.QUESTION_MESSAGE, null, tamaFriends, tamaFriends[0]);
		// we display different messages according to the player's choice
		if (friends.equals(tamaFriends[0])) {
			JOptionPane.showMessageDialog(null, name + " est allé boire un coup avec ses amis !", "VOIR SES AMIS",
					JOptionPane.PLAIN_MESSAGE, null);
			setNeedToilettes(this.needToilettes + 1);
		} else if (friends.equals(tamaFriends[1])) {
			JOptionPane.showMessageDialog(null, name + " est allé en boite de nuit avec ses amis !", "VOIR SES AMIS",
					JOptionPane.PLAIN_MESSAGE, null);
			setAwake(this.awake - 1);
			setNeedToilettes(this.needToilettes + 1);
		} else {
			JOptionPane.showMessageDialog(null, name + " est allé se promener avec ses amis !", "VOIR SES AMIS",
					JOptionPane.PLAIN_MESSAGE, null);
		}

		setAwake(this.awake - 1);
		setDirtLevel(this.dirtLevel + 1);
		setHungry(this.hungry - 1);
		setNeedToilettes(this.needToilettes + 1);
		setHealth(this.health + 1);
	}

	/**
	 * This method is used to do the action "do sport"
	 */
	public void doSport() {
		if (this.awake > 3) { // If the tamagotchi is enough awake
			JOptionPane.showMessageDialog(null, name + " est allé faire du sport !", "FAIRE DU SPORT",
					JOptionPane.PLAIN_MESSAGE, null);
			setHealth(this.health + 1);
			setAwake(this.awake - 1);
			setDirtLevel(this.dirtLevel + 3);
			setNeedToilettes(this.needToilettes + 1);
			setHungry(this.hungry - 1);
		} else {
			JOptionPane.showMessageDialog(null, name + " est trop fatigué pour faire du sport", "FAIRE DU SPORT",
					JOptionPane.PLAIN_MESSAGE, null);
		}

	}

	/**
	 * This method is used to kill the tamagotchi, either by the user's hands, or
	 * because of the bad caracteristics
	 */
	public void die() {

		JOptionPane.showMessageDialog(null, "\nVotre tamagochi est mort\nGAME OVER !", "GAME OVER",
				JOptionPane.PLAIN_MESSAGE, null);
		System.exit(-1); // The tamagotchi dies, the game is over
	}

	/**
	 * This method is used to do the action "take of the mask" if the tamagotchi
	 * still has his mask on
	 */
	public void takeOnOffMask() {
		if (this.mask == true) { // if the tamagotchi still has his mask on
			JOptionPane.showMessageDialog(null, name + " a enlevé son masque !", "ENLEVER SON MASQUE",
					JOptionPane.PLAIN_MESSAGE, null);
			this.mask = false;
		} else {
			JOptionPane.showMessageDialog(null, name + " a remis son masque !", "METTRE SON MASQUE",
					JOptionPane.PLAIN_MESSAGE, null);
			this.mask = true;
		}
	}

	/**
	 * This method is used to do the action "take a shower"
	 */
	public void takeShower() {
		if (this.dirtLevel < 3) { // If the value dirtLevel is not high enough

			JOptionPane.showMessageDialog(null, name + " est propre ! Il n'a pas besoin de prendre sa douche",
					"SE LAVER", JOptionPane.PLAIN_MESSAGE, null);
		} else {
			JOptionPane.showMessageDialog(null, name + " prend sa douche", "SE LAVER", JOptionPane.PLAIN_MESSAGE, null);
			setDirtLevel(0);
		}
	}

	/**
	 * This method is used to do the action "smoke a cigarette"
	 */
	public void smoke() {
		String[] tamaSmoke = { "une cigarette", "de la marijuana", "un cigare" };
		String smoke = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir ce que va fumer " + name + " puis cliquez sur Ok", "FUMER",
				JOptionPane.QUESTION_MESSAGE, null, tamaSmoke, tamaSmoke[0]);

		JOptionPane.showMessageDialog(null, name + " fume " + smoke, "FUMER", JOptionPane.PLAIN_MESSAGE, null);
		// we display different messages according to the player's choice
		if (smoke.equals(tamaSmoke[0])) {
			JOptionPane.showMessageDialog(null, "Attention ! Le tabac est mauvais pour la santé", "FUMER",
					JOptionPane.PLAIN_MESSAGE, null);
		} else if (smoke.equals(tamaSmoke[1])) {
			JOptionPane.showMessageDialog(null, "La Marijuana ça fatigue !", "FUMER", JOptionPane.PLAIN_MESSAGE, null);
			setAwake(this.awake - 1);
		} else {
			JOptionPane.showMessageDialog(null, name + " se croit à Cuba !", "FUMER", JOptionPane.PLAIN_MESSAGE, null);
		}

		setDirtLevel(this.dirtLevel + 1);
		setHungry(this.hungry - 1);
		setHealth(this.health - 3);
		setNeedToilettes(this.needToilettes + 1);
	}

	/**
	 * This method is used to display the tamagotchi according to the type
	 * 
	 * @param type
	 */
	public void showTamagotchi(String type) {

		JFrame f = new JFrame(); // Here we create the Jframe f
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // This is the screen size
		f.setBackground(Color.red);
		f.setUndecorated(true); // To remove external borders
		File file = new File(type + ".PNG"); // we create a new object file in the File Class (for
												// picture import)

		ImageIcon picture = new ImageIcon(file.getAbsolutePath()); // tamagotchi picture import

		JLabel lbl = new JLabel(picture); // put the picture into a JLabel

		f.getContentPane().add(lbl); // Put the Label into the Jframe

		f.setSize(picture.getIconWidth() + 50, picture.getIconHeight() + 50); // Get the height et width of the picture
																				// to define the jframe size

		int x = (screenSize.width - f.getSize().width / 3) / 2; // This 2 next lines are used to define the position of
																// the center of the new window
		int y = (screenSize.height / 4 - f.getSize().height) / 2;//

		f.setLocation(x, y); // We put the Jframe at the position
		f.setVisible(true); // We make the jframe visible

	}

}
