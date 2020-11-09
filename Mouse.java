package TamagotchiV2;

import javax.swing.JOptionPane;

/**
 * 
 * @author Tjlvt We create here the class Mouse extends from Tamagotchi
 */
public class Mouse extends Tamagotchi {
	/**
	 * This is the constructor of the Mouse class
	 * 
	 * @param name
	 */
	public Mouse(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.type = "Souris";
		this.health = 5;
		this.healthMax = 5;
		this.lifeExpectancy = 5;
		this.awake = 10;
		this.awakeMax = 10;
		this.hungry = 6;
		this.hungryMax = 6;
		this.height = 2;
		this.secondaryColor = "Couleur des moustaches : ";
	}

	/**
	 * This method is used to ask the color of the tamagotchi the player wants
	 */
	public void color() {

		String[] mouseColor = { "Noir", "Blanc", "Roux", "Gris", "Marron" };
		color = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la couleur de son pelage puis cliquez sur Ok", "COULEUR DE LA SOURIS",
				JOptionPane.QUESTION_MESSAGE, null, mouseColor, mouseColor[0]);
	}

	/**
	 * This method is used to ask the otherColor (whiskers) of the tamagotchi the
	 * player wants
	 */
	public void otherColor() {

		String[] mouseOtherColor = { "Noires", "Blanches", "Rousses", "Grises" };
		otherColor = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la couleur de ses moustaches puis cliquez sur Ok", "COULEUR DES MOUSTACHES",
				JOptionPane.QUESTION_MESSAGE, null, mouseOtherColor, mouseOtherColor[0]);
	}

	/**
	 * This method is used to do the action "dye the otherColor of the tamagotchi"
	 */
	public void dyeOtherColor() {

		String[] mouseDyeOtherColor = { "Noires", "Blanches", "Rousses", "Grises" };
		String newOtherColor = (String) JOptionPane.showInputDialog(null,
				"Veuillez choisir la nouvelle couleur de ses moustaches puis cliquez sur Ok", "TEINDRE LES MOUSTACHES",
				JOptionPane.QUESTION_MESSAGE, null, mouseDyeOtherColor, mouseDyeOtherColor[0]);

		if (newOtherColor.equals(mouseDyeOtherColor[2])) { // If the user choose the color Roux
			JOptionPane.showMessageDialog(null,
					"Les moustaches de " + name + " ne peuvent pas être teintes en rousse !!", "TEINDRE LES MOUSTACHES",
					JOptionPane.PLAIN_MESSAGE, null);
		} else {
			if (newOtherColor.equals(this.otherColor)) { // If the user choose the same color
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

			String[] mouseFood = { "Fromage", "Graines", "Foin", "Mort au rat" };
			String food = (String) JOptionPane.showInputDialog(null,
					"Veuillez choisir le menu d'aujourd'hui puis cliquez sur Ok", "REPAS", JOptionPane.QUESTION_MESSAGE,
					null, mouseFood, mouseFood[0]);
			JOptionPane.showMessageDialog(null, "Miam " + this.name + " a bien mangé !", "REPAS",
					JOptionPane.PLAIN_MESSAGE, null);

			if (food.equals(mouseFood[3])) {
				JOptionPane.showMessageDialog(null,
						"Vous avez donné de la Mort au rat à votre tamagotchi. Il est décédé !\nGAME OVER !!", "REPAS",
						JOptionPane.PLAIN_MESSAGE, null);
				System.exit(-1);
			}
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
