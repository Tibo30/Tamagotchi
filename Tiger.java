package TamagotchiV2;

import javax.swing.JOptionPane;

/**
 * 
 * @author Tjlvt We create here the class Tiger extends from Tamagotchi
 */
public class Tiger extends Tamagotchi {
	/**
	 * This is the constructor of the Tiger class
	 * 
	 * @param name
	 */
	public Tiger(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.type = "Tigre";
		this.health = 20;
		this.healthMax = 20;
		this.lifeExpectancy = 10;
		this.awake = 20;
		this.awakeMax = 20;
		this.hungry = 7;
		this.hungryMax = 7;
		this.height = 25;
	}

	/**
	 * This method is used to ask the color of the tamagotchi the player wants
	 */
	public void color() {

		String[] tigerColor = { "Blanche rayée noire", "Dorée", "Rousse rayée noire" };
		color = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la couleur de sa fourrure puis cliquez sur Ok", "COULEUR DU TIGRE",
				JOptionPane.QUESTION_MESSAGE, null, tigerColor, tigerColor[0]);
	}

	/**
	 * This method is used to ask the otherColor (tail) of the tamagotchi the player
	 * wants
	 */
	public void otherColor() {

		String[] tigerOtherColor = { "Noire", "Blanche", "Rousse", "Grise" };
		otherColor = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la couleur de sa queue puis cliquez sur Ok", "COULEUR DE LA QUEUE",
				JOptionPane.QUESTION_MESSAGE, null, tigerOtherColor, tigerOtherColor[0]);
	}

	/**
	 * This method is used to do the action "dye the otherColor of the tamagotchi"
	 */
	public void dyeOtherColor() {

		String[] tigerDyeOtherColor = { "Noires", "Blanches", "Rousses", "Grises" };
		String newOtherColor = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la nouvelle couleur de sa queue puis cliquez sur Ok", "TEINDRE LA QUEUE",
				JOptionPane.QUESTION_MESSAGE, null, tigerDyeOtherColor, tigerDyeOtherColor[0]);

		if (newOtherColor.equals(tigerDyeOtherColor[2])) { // If the user choose the color Roux
			JOptionPane.showMessageDialog(null, "La queue de " + name + " ne peut pas être teinte en rousse !!",
					"TEINDRE LA QUEUE", JOptionPane.PLAIN_MESSAGE, null);
		} else {
			if (newOtherColor.equals(this.otherColor)) { // If the user choose the same color
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

			String[] tigerFood = { "Sanglier", "Cerf", "Chien", "Humain" };
			String food = (String) JOptionPane.showInputDialog(null,
					"Veuillez choisir le menu d'aujourd'hui puis cliquez sur Ok", "REPAS", JOptionPane.QUESTION_MESSAGE,
					null, tigerFood, tigerFood[0]);
			JOptionPane.showMessageDialog(null, "Miam " + this.name + " a bien mangé !", "REPAS",
					JOptionPane.PLAIN_MESSAGE, null);
			setAwake(this.awake - 1); // we set new values of the variables according to the action
			setNeedToilettes(this.needToilettes + 2);
			setDirtLevel(this.dirtLevel + 1);
			setHungry(hungryMax);
			setHealth(this.health + 1);
		} else {
			JOptionPane.showMessageDialog(null, this.name + " n'a pas faim !", "TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE,
					null);
		}
	}
}
