package TamagotchiV2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.swing.JOptionPane;

/*
 * This is the mainScript for the game Tamagotchi
 */
public class MainScript {

	public static void main(String[] args) {

		String type;
		String name;
		Tamagotchi tamagotchi = null;
// Here we start the method. The game is played in a new window (JOptionPane)
		JOptionPane.showMessageDialog(null,
				"Bonjour ! Bienvenu dans le jeu du Tamagotchi\nNous allons créer ensemble votre nouveau Tamagotchi",
				"TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);

		String[] tamaType = { "Dragon", "Tigre", "Chien", "Chat", "Souris" };
		type = (String) JOptionPane.showInputDialog(null, "Veuillez choisir son type puis cliquez sur Ok",
				"TYPE DU TAMAGOTCHI", JOptionPane.QUESTION_MESSAGE, null, tamaType, tamaType[0]);
		// We ask in the window to the player what kind of Tamagotchi he wants

		name = JOptionPane.showInputDialog("Veuillez choisir son nom et cliquez sur Ok");
// We ask in the window, the name the player wants

		// According to the type choosen, we declare the object
		if (type == tamaType[2]) {
			tamagotchi = new Dog(name);
		} else if (type == tamaType[3]) {
			tamagotchi = new Cat(name);
		} else if (type == tamaType[0]) {
			tamagotchi = new Dragon(name);
		} else if (type == tamaType[4]) {
			tamagotchi = new Mouse(name);
		} else if (type == tamaType[1]) {
			tamagotchi = new Tiger(name);
		}

		JOptionPane.showMessageDialog(null,
				"Bravo, vous avez créé votre Tamagotchi " + name + (type.equals("souris") ? " la " : " le ") + type
						+ " !\nNous allons définir ensemble ses caractéristiques :)",
				"TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);

		tamagotchi.color(); // the player choose the tamagotchi's color
		tamagotchi.otherColor();// the player choose the tamagotchi's secondary color

		int lifeExpectancy = tamagotchi.getLifeExpectancy();
		// we get the value of the tamagotchi's life expectancy for the next "for" loop.

		tamagotchi.showCaracteristics(); // we show the tamagotchi's caracteristics

		tamagotchi.showTamagotchi(type); // we display the tamagotchi in a new window

		for (int i = 1; i <= lifeExpectancy; i++) {
			// This loop in used for the game's duration according to the tamagotchi's life
			// expectancy

			JOptionPane.showMessageDialog(null, "Une nouvelle journée commence !\nJour " + i, "TAMAGOTCHI",
					JOptionPane.PLAIN_MESSAGE, null);

			if (i == (lifeExpectancy)) {// When life expectancy is reached, the tamagotchi dies
				tamagotchi.die();
			}

			int health = tamagotchi.getHealth();
			double height = tamagotchi.getHeight();

			for (int j = 0; j < 8; j++) { // this loop is used for the player's action (8 actions per day(turn))

				if (health == 0) { // if the tamagotchi's health is equal to 0, the tamagotchi dies
					tamagotchi.die();

				} else {

					if (j == 0) {
						tamagotchi.showDailyStats(); // display daily caracteristics everyday
					}
// Here we ask what the player wants to do
					int choice;

					String[] choicePlay = { "1/ Manger", "2/ Aller au toilettes", "3/ Se reposer", "4/ Se reproduire",
							"5/ Voir des amis", "6/ Faire du sport", "7/ Enlever/Mettre son masque", "8/ Se laver",
							"9/ Fumer", "10/ Changer sa couleur secondaire", "11/ Tuer le tamagochi",
							"12/ Montrer son humeur", "13/ Montrer les statistiques vitales" };
					String choicePlayer = (String) JOptionPane.showInputDialog(null,
							"Veuillez choisir une action à effectuer puis cliquez sur Ok", "ACTION",
							JOptionPane.QUESTION_MESSAGE, null, choicePlay, choicePlay[0]);
					choice = (Arrays.asList(choicePlay).indexOf(choicePlayer) + 1);
					tamagotchi.action(choice);
					if (choice == 4) {// This loop is when the player choose to make the tamagotchi reproduces
										// himself. It defines the new baby tamagotchi
						Tamagotchi newTamagotchi = null;
						if (type == tamaType[2]) {
							newTamagotchi = new Dog("bébé");
						} else if (type == tamaType[3]) {
							newTamagotchi = new Cat("bébé");
						} else if (type == tamaType[0]) {
							newTamagotchi = new Dragon("bébé");
						} else if (type == tamaType[4]) {
							newTamagotchi = new Mouse("bébé");
						} else if (type == tamaType[1]) {
							newTamagotchi = new Tiger("bébé");
						}

						JOptionPane.showMessageDialog(null, "Félicitations ! " + name + " vient d'avoir un bébé !",
								"TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);
						newTamagotchi.showBaby();
					}

					if (choice == 13) { // showing caracteristics is not an action
						j--;
					}

// if the vital caracteristics are very bad, the tamagotchi loses two health points

					if ((tamagotchi.getNeedToilettes() >= 10) || (tamagotchi.getDirtLevel() >= 10)
							|| (tamagotchi.getHungry() <= 0) || (tamagotchi.getAwake() <= 0)) {
						tamagotchi.setHealth(health - 2);
						JOptionPane.showMessageDialog(null,
								" Les caractéristiques de votre tamagotchi sont très mauvaises, il perd 2 points de vie !",
								"TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);
						if (tamagotchi.getNeedToilettes() >= 10) {
							tamagotchi.setNeedToilettes(tamagotchi.getNeedToilettesMax());
						} else if (tamagotchi.getDirtLevel() >= 10) {
							tamagotchi.setDirtLevel(tamagotchi.getDirtLevelMax());
						} else if (tamagotchi.getHungry() == 0) {
							tamagotchi.setHungry(tamagotchi.getHungryMax());
						} else {
							tamagotchi.setAwake(tamagotchi.getAwakeMax());
						}
					}
					// the next 4 "if" are used to tell to the player when some vital caracteristics
					// are very bad and recall him to do the necessary actions .
					if (tamagotchi.getHungry() < 4) {
						JOptionPane.showMessageDialog(null, name + " a faim. Pensez à le nourrir !!", "TAMAGOTCHI",
								JOptionPane.PLAIN_MESSAGE, null);
					}
					if (tamagotchi.getNeedToilettes() > 5) {
						JOptionPane.showMessageDialog(null, name + " a très envie d'aller aux toilettes !!",
								"TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);
					}
					if (tamagotchi.getAwake() < 4) {
						JOptionPane.showMessageDialog(null, name + " est fatigué. Pensez à le faire se reposer !!",
								"TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);
					}
					if (tamagotchi.getDirtLevel() > 5) {
						JOptionPane.showMessageDialog(null,
								name + " commence à sentir mauvais. Pensez à lui faire prendre une douche !!",
								"TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);
					}

				}
			}

			// The tamagotchi grows every turn (day) (value of height with two figures after
			// the decimal point)
			BigDecimal bd = new BigDecimal(String.valueOf(height + height / 10)).setScale(2, RoundingMode.HALF_UP);
			double bd2 = bd.doubleValue();
			tamagotchi.setHeight(bd2);
			JOptionPane.showMessageDialog(null, " La journée est terminée !", "TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE,
					null);
		}
	}

}
