package TamagotchiV2;

import javax.swing.JOptionPane;

/**
 * 
 * @author Tjlvt We create here the class Dog extends from Tamagotchi
 */
public class Dog extends Tamagotchi {
	/**
	 * This is the constructor of the Dog class
	 * 
	 * @param name
	 */
	public Dog(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.type = "Chien";
		this.health = 10;
		this.healthMax = 10;
		this.lifeExpectancy = 8;
		this.awake = 10;
		this.awakeMax = 10;
		this.hungry = 8;
		this.hungryMax = 8;
		this.height = 15;
		this.secondaryColor = "Couleur de la queue : ";
	}

	/**
	 * This method is used to ask the color of the tamagotchi the player wants
	 */
	public void color() {
		// We ask the color of the tamagotchi
		String[] dogColor = { "Noire", "Blanche", "Marron", "Grise" };
		color = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la couleur de sa fourrure puis cliquez sur Ok", "COULEUR DU CHIEN",
				JOptionPane.QUESTION_MESSAGE, null, dogColor, dogColor[0]);
	}

	/**
	 * This method is used to ask the otherColor (tail) of the tamagotchi the player
	 * wants
	 */
	public void otherColor() {
		String[] dogOtherColor = { "Noire", "Blanche", "Rousse", "Grise" };
		otherColor = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la couleur de sa queue puis cliquez sur Ok", "COULEUR DE LA QUEUE",
				JOptionPane.QUESTION_MESSAGE, null, dogOtherColor, dogOtherColor[0]);
	}

	/**
	 * This method is used to do the action "dye the otherColor of the tamagotchi"
	 */
	public void dyeOtherColor() {
		String[] dogDyeOtherColor = { "Noire", "Blanche", "Rousse", "Grise" };
		String newOtherColor = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la nouvelle couleur de sa queue puis cliquez sur Ok", "TEINDRE LA QUEUE",
				JOptionPane.QUESTION_MESSAGE, null, dogDyeOtherColor, dogDyeOtherColor[0]);

		if (newOtherColor.equals(dogDyeOtherColor[2])) { // If the user choose the color Roux
			JOptionPane.showMessageDialog(null, "La queue de " + name + " ne peut pas être teinte en rousse !!",
					"TEINDRE LA QUEUE", JOptionPane.PLAIN_MESSAGE, null);
		} else {
			if (newOtherColor.equals(this.otherColor)) { // If the user choose the same
															// color
				JOptionPane.showMessageDialog(null, "La queue de " + name + " est déjà de couleur " + this.otherColor,
						"TEINDRE LA QUEUE", JOptionPane.PLAIN_MESSAGE, null);
			} else { // If the color is different
				this.otherColor = newOtherColor;
				JOptionPane.showMessageDialog(null,
						"La queue de " + name + " est maintenant de couleur " + newOtherColor, "TEINDRE LA QUEUE",
						JOptionPane.PLAIN_MESSAGE, null);
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
			String[] dogFood = { "Os", "Croquettes", "Patée", "Chat" };
			String food = (String) JOptionPane.showInputDialog(null,
					"Veuillez choisir le menu d'aujourd'hui puis cliquez sur Ok", "REPAS", JOptionPane.QUESTION_MESSAGE,
					null, dogFood, dogFood[0]);
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
