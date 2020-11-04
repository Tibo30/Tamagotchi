package TamagotchiV2;

import javax.swing.JOptionPane;

/**
 * 
 * @author Tjlvt We create here the class Cat extends from Tamagotchi
 */
public class Cat extends Tamagotchi {
	/**
	 * This is the constructor of the Cat class
	 * 
	 * @param name
	 */
	public Cat(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.type = "Chat";
		this.health = 10;
		this.healthMax = 10;
		this.lifeExpectancy = 8;
		this.awake = 10;
		this.awakeMax = 10;
		this.hungry = 8;
		this.hungryMax = 8;
		this.height = 10;
	}

	/**
	 * This method is used to ask the color of the tamagotchi the player wants
	 */
	public void color() {

		String[] catColor = { "Noire", "Blanche", "Rousse", "Grise" };
		color = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la couleur de sa fourrure puis cliquez sur Ok", "COULEUR DU CHAT",
				JOptionPane.QUESTION_MESSAGE, null, catColor, catColor[0]);
	}

	/**
	 * This method is used to ask the otherColor (whiskers) of the tamagotchi the
	 * player wants
	 */
	public void otherColor() {
		String[] catOtherColor = { "Noires", "Blanches", "Rousses", "Grises" };
		otherColor = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la couleur de ses moustaches puis cliquez sur Ok", "COULEUR DES MOUSTACHES",
				JOptionPane.QUESTION_MESSAGE, null, catOtherColor, catOtherColor[0]);
	}

	/**
	 * This method is used to do the action "dye the otherColor of the tamagotchi"
	 */
	public void dyeOtherColor() {

		String[] catDyeOtherColor = { "Noires", "Blanches", "Rousses", "Grises" };
		String newOtherColor = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la nouvelle couleur de ses moustaches puis cliquez sur Ok", "TEINDRE LES MOUSTACHES",
				JOptionPane.QUESTION_MESSAGE, null, catDyeOtherColor, catDyeOtherColor[0]);

		if (newOtherColor.equals(catDyeOtherColor[2])) { // If the user choose the color Roux
			JOptionPane.showMessageDialog(null,
					"Les moustaches de " + name + " ne peuvent pas être teintes en rousse !!", "TEINDRE LES MOUSTACHES",
					JOptionPane.PLAIN_MESSAGE, null);
		} else {
			if (newOtherColor.equals(this.otherColor)) { // If the user choose the same
															// color
				JOptionPane.showMessageDialog(null,
						"Les moustaches de " + name + " sont déjà de couleur " + this.otherColor,
						"TEINDRE LES MOUSTACHES", JOptionPane.PLAIN_MESSAGE, null);
			} else { // If the color is different
				this.otherColor = newOtherColor;
				JOptionPane.showMessageDialog(null,
						"Les moustaches de " + name + " sont maintenant de couleur " + newOtherColor,
						"TEINDRE LES MOUSTACHES", JOptionPane.PLAIN_MESSAGE, null);
				setAwake(this.awake - 1);
				setNeedToilettes(this.needToilettes + 1);
			}
		}
	}

	/**
	 * This method is used to do the action "Eat"
	 */
	public void eat() {
		if (this.hungry < (this.hungryMax - 1)) { // if the value "hungry" is low enough

			String[] catFood = { "Souris", "Croquettes", "Patée" };
			String food = (String) JOptionPane.showInputDialog(null,
					"Veuillez choisir le menu d'aujourd'hui puis cliquez sur Ok", "REPAS", JOptionPane.QUESTION_MESSAGE,
					null, catFood, catFood[0]);
			JOptionPane.showMessageDialog(null, "Miam " + this.name + " a bien mangé !", "REPAS",
					JOptionPane.PLAIN_MESSAGE, null);
			setAwake(this.awake - 1); // we set new values of the variables according to the action
			setNeedToilettes(this.needToilettes + 2);
			setDirtLevel(this.dirtLevel + 1);
			setHungry(hungryMax);
			setHealth(this.health + 1);
		} else {
			JOptionPane.showMessageDialog(null, this.name + " n'a pas faim !", "REPAS", JOptionPane.PLAIN_MESSAGE,
					null);
		}
	}

}
