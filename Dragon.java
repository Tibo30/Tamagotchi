package TamagotchiV2;

import javax.swing.JOptionPane;

/**
 * 
 * @author Tjlvt We create here the class Dragon, extends from Tamagotchi
 */
public class Dragon extends Tamagotchi {
	/**
	 * This is the constructor of the Dragon class
	 * 
	 * @param name
	 */
	public Dragon(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.type = "Dragon";
		this.health = 20;
		this.healthMax = 20;
		this.lifeExpectancy = 10;
		this.awake = 20;
		this.awakeMax = 20;
		this.hungry = 7;
		this.hungryMax = 7;
		this.height = 50;
	}

	/**
	 * This method is used to ask the color of the tamagotchi the player wants
	 */
	public void color() {
		String[] dragColor = { "Noire", "Blanche", "Bleue", "Rouge", "Verte" };
		color = (String) JOptionPane.showInputDialog(null, "Veuillez choisir la couleur de sa robe puis cliquez sur Ok",
				"COULEUR DU DRAGON", JOptionPane.QUESTION_MESSAGE, null, dragColor, dragColor[0]);
	}

	/**
	 * This method is used to ask the otherColor (scale) of the tamagotchi the
	 * player wants
	 */
	public void otherColor() {
		String[] dragOtherColor = { "Noires", "Blanches", "Rousses", "Bleues", "Vertes", "Rouges", "Jaunes" };
		otherColor = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la couleur de ses écailles puis cliquez sur Ok", "COULEUR DES ECAILLES",
				JOptionPane.QUESTION_MESSAGE, null, dragOtherColor, dragOtherColor[0]);
	}

	/**
	 * This method is used to do the action "dye the otherColor of the tamagotchi"
	 */
	public void dyeOtherColor() {
		String[] dragDyeOtherColor = { "Noires", "Blanches", "Rousses", "Bleues", "Vertes", "Rouges", "Jaunes" };
		String newOtherColor = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la nouvelle couleur de ses écailles puis cliquez sur Ok", "TEINDRE LES ECAILLES",
				JOptionPane.QUESTION_MESSAGE, null, dragDyeOtherColor, dragDyeOtherColor[0]);

		if (newOtherColor.equals(dragDyeOtherColor[2])) { // If the user choose the color Roux
			JOptionPane.showMessageDialog(null, "Les écailles de " + name + " ne peuvent pas être teintes en rousse !!",
					"TEINDRE LES ECAILLES", JOptionPane.PLAIN_MESSAGE, null);
		} else {
			if (newOtherColor.equals(this.otherColor)) { // If the user choose the same
															// color
				JOptionPane.showMessageDialog(null,
						"Les écailles de " + name + " sont déjà de couleur " + this.otherColor, "TEINDRE LES ECAILLES",
						JOptionPane.PLAIN_MESSAGE, null);
			} else { // If the color is different
				this.otherColor = newOtherColor;
				JOptionPane.showMessageDialog(null,
						"Les écailles de " + name + " sont maintenant de couleur " + newOtherColor,
						"TEINDRE LES ECAILLES", JOptionPane.PLAIN_MESSAGE, null);
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
			String[] dragFood = { "Mouton", "Vache", "Cochon", "Humain" };
			String food = (String) JOptionPane.showInputDialog(null,
					"Veuillez choisir le menu d'aujourd'hui puis cliquez sur Ok", "REPAS", JOptionPane.QUESTION_MESSAGE,
					null, dragFood, dragFood[0]);
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
