package game;

//Import Scanner.
import java.util.Scanner;

//Game of Conway class.
public class GameOfConway {

	// Variables.
	Scanner scan = new Scanner(System.in);
	int HEIGHT = 100;
	int WIDTH = 100;
	char world[][] = new char[100][100];
	int count;
	String name = "Player101";
	int worldRules[] = { 2, 3, 3 };

	// Main function.
	public static void main(String[] args) {

		GameOfConway GOC = new GameOfConway();
		GOC.principal();

	}

	// Principal function.
	public void principal() {

		// Menu.
		menu();

	}

	// World Inicialize function.
	private void worldInicialize() {

		// Y-AXIS.
		for (count = 0; count < HEIGHT; count++) {

			// X-AXIS.
			for (int metaCount = 0; metaCount < WIDTH; metaCount++) {

				// Set this position the value ' '.
				world[count][metaCount] = ' ';

			}

		}

	}

	// Game Function.
	private void game() {

		// Inicialize variables.
		boolean bucleJoc = true;
		String question;

		// Game.
		while (bucleJoc) {

			// Print world.
			worldPrint();

			// Generate the new world.
			worldGenerate();

			// Ask to continue the game.
			System.out.print("Vols passar a la seguent generació?{S/N}");
			question = scan.next();

			// Filter to end the game.
			if (question.equals("N") || question.equals("n")) {

				// Set bucleJoc as false.
				bucleJoc = false;

			}
		}

	}

	// WorldPrinting function.
	private void worldPrint() {

		// Print title.
		System.out.print("\nMon de " + name + "!\n");

		// Print.
		// Y-AXIS.
		for (count = 0; count < HEIGHT; count++) {

			// X-AXIS.
			for (int metaCount = 0; metaCount < WIDTH; metaCount++) {

				// Print the value at this position and [] before and after the value.
				System.out.print("[" + world[count][metaCount] + "]");

			}

			// Print a new line before the last value of the X-AXIS to Y-AXIS.
			System.out.print("\n");

		}

	}

	// Is a number function.
	private boolean isANumber(String x) {

		// Variables.
		boolean isANumber = false;

		// X is a number?
		for (int metaCount = 0; metaCount < x.length(); metaCount++) {

			// Filter the value of the position metaCount to compare with a number.
			if (x.charAt(metaCount) == '0' || x.charAt(metaCount) == '1' || x.charAt(metaCount) == '2'
					|| x.charAt(metaCount) == '3' || x.charAt(metaCount) == '4' || x.charAt(metaCount) == '5'
					|| x.charAt(metaCount) == '6' || x.charAt(metaCount) == '7' || x.charAt(metaCount) == '8'
					|| x.charAt(metaCount) == '9') {

				// Set isANumber as true.
				isANumber = true;

			} else {

				// Set isANumber as false.
				isANumber = false;

				// close the bucle if one caracter of the String is not a number.
				metaCount = x.length();

			}

		}

		// Return the value of isANumber(True or false).
		return isANumber;

	}

	// Cell position function.
	public void cellposition(String option) {

		// Inicialize number.
		boolean isANumber;
		String pH, pW;
		int H, W;
		int coloniaNumber = 5;

		// Bucle to put the cells.
		for (count = 0; count <= 5; count++) {

			// Print the world and the title.
			System.out.print("\n/*Forma Manual*/\n");
			worldPrint();

			// Manual option.
			if (option.equalsIgnoreCase("0")) {

				// Set a position for the HEIGHT.
				// Ask the value.
				System.out.print("\nPosa un valor per la altura on vols posar la cèl·lula numero[" + (count + 1)
						+ "] [0] - [" + (HEIGHT - 1) + "]:\n>> ");

				// Set the value.
				pH = scan.next();

				// Ask if pH is a number.
				isANumber = isANumber(pH);

				// The value is not number.
				if (!isANumber) {

					// Error message.
					System.out.print("\nSiusplau posa un numero correcte!\n");
					// Set count -1.
					count--;

				}

				// The value is a number.
				else {

					// Set H like the value of the String pH to integer.
					H = Integer.parseInt(pH);

					// Compare if the value H is higher than (HEIGHT - 1) or less than 0.
					if ((H > (HEIGHT - 1) || H < 0)) {

						// Error message.
						System.out.print("\nEl valor no forma part del array\n");

						// Set count -1.
						count--;

					}

					// Compare if the value H is less than (HIGHT - 1) and higher than 0.
					else {

						// Set a position for the WIDTH.
						// Ask the value.
						System.out.print("\nPosa un valor per la llargada on vols posar la cèl·lula numero["
								+ (count + 1) + "] [0] - [" + (WIDTH - 1) + "]:\n>> ");

						// Set the value.
						pW = scan.next();

						// Ask if pW is a number.
						isANumber = isANumber(pW);

						// The value is not number.
						if (!isANumber) {

							// Error message.
							System.out.print("\nSiusplau posa un numero correccte!\n");

							// Set count -1.
							count--;

						}

						// The value is number.
						else {

							// Set W like the value of the String pW to integer.
							W = Integer.parseInt(pW);

							// Compare if the value W is higher than (WIDTH - 1) or less than 0.
							if ((W > (WIDTH - 1) || W < 0)) {

								// Error message.
								System.out.print("\nEl valor no forma part del array\n");

								// Set count -1.
								count--;

							}

							// Compare if the value W is less than (WIDTH - 1) and higher than 0.
							else {

								// Look if the position asked have a alive cell.
								if (world[H][W] == '·') {

									// Error message.
									System.out.print("\nJa hi ha una cèl·lula colocada en aquesta posició!\n");

									// Set count -1.
									count--;

								}

								// Look if the position asked have a dead cell.
								else {

									// Set the position asked with a alive cell.
									world[H][W] = '·';

								}

							}

						}

					}

				}

			}

			// Automatic option.
			else {

				// Ask the colonies quantity.
				// 20 opportunities.
				for (count = 0; count < 20; count++) {

					// Ask the quantity.
					System.out.print("\nCuantes colonies vols posar? (Cada colonia consta de 5 cellules):\n>> ");

					// Set the quantity to a variable.
					String colonia = scan.next();

					// Ask if colonia is a number.
					isANumber = isANumber(colonia);

					// Filter if colonia is a number.
					if (isANumber) {

						// Message all good.
						System.out.print("\nLa cantidad de colonies s'ha assignat a [" + colonia + "]\n");

						// Set count as 998, to cancell the loop.
						count = 998;

						// Set varibale coloniaNumber like variable colonia.
						coloniaNumber = Integer.parseInt(colonia);

					}

					// Filter if colonia is not a number.
					else {

						// Error message.
						System.out.print("\nSiusplau entra un valor valid!!\n");

					}

				}

				// Filter if count have another value than 999.
				if (count != 999) {

					// Auto assigned colonies message.
					System.out.print("\nEl valor sa assignat a 5");

				}

				// Assign colonies automatically.
				// Loop to assign colonies.
				for (count = 0; count < (coloniaNumber * 5); count++) {

					// Value of H random.
					H = (int) (Math.random() * HEIGHT);

					// Value of W random.
					W = (int) (Math.random() * WIDTH);

					// Filter if the value of W is higher than WIDTH and samller than 0.
					if ((W > WIDTH || W < 0)) {

						// Set count -1.
						count--;

					}

					// Filter if the value of W is smaller than WIDTH and higher than 0.
					else {

						// Filter if the position have a live cell
						if (world[H][W] == '·') {

							// Set count -1.
							count--;

						}

						// Filter if the position have a dead cell.
						else {

							// Set the position with a alive cell.
							world[H][W] = '·';

						}

					}

				}

			}

		}

		// Print the world.
		worldPrint();

	}

	// World generate function.
	private void worldGenerate() {

		// Inicialitze variables.
		char[][] newWorld = new char[HEIGHT][WIDTH];
		int sum;

		// Generate next generation of the world.
		// Y-AXIS.
		for (count = 0; count < HEIGHT; count++) {

			// X-AXIS.
			for (int metaCount = 0; metaCount < WIDTH; metaCount++) {

				// Sum = 0;
				sum = 0;

				// Filter if the cells is alive...
				/*
				 * Rules of alive cell:
				 * 
				 * 1. If cell is near to worldRules[0] - worldRules[1] they keep alive.
				 * 
				 * 2. If cell is near to (worldRules[1] + 1) or more cells they die.
				 * 
				 * 3. If cell is near to (worldRules[0] - 1) or less cells they die.
				 * 
				 */
				if (world[count][metaCount] == '·') {

					// Look if the position is possible.
					if (HEIGHT > (count + 1)) {

						// Look for alive cells next the actual cell.
						if (world[count + 1][metaCount] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (HEIGHT > (count + 1) && WIDTH > (metaCount + 1)) {

						// Look for alive cells next the actual cell.
						if (world[count + 1][metaCount + 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (WIDTH > (metaCount + 1)) {

						// Look for alive cells next the actual cell.
						if (world[count][metaCount + 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (0 <= (count - 1) && WIDTH > (metaCount + 1)) {

						// Look for alive cells next the actual cell.
						if (world[count - 1][metaCount + 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (0 <= (count - 1)) {

						// Look for alive cells next the actual cell.
						if (world[count - 1][metaCount] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (0 <= (count - 1) && 0 <= (metaCount - 1)) {

						// Look for alive cells next the actual cell.
						if (world[count - 1][metaCount - 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (0 <= (metaCount - 1)) {

						// Look for alive cells next the actual cell.
						if (world[count][metaCount - 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (HEIGHT > (count + 1) && 0 <= (metaCount - 1)) {

						// Look for alive cells next the actual cell.
						if (world[count + 1][metaCount - 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Filter if the interval of worldRules[0] worldRules[1] to revive cells are
					// fulfilled.
					if (sum >= worldRules[0] && sum <= worldRules[1]) {

						// Set this position of the world to '·'.
						newWorld[count][metaCount] = '·';

					}

					// Filter if the interval of worldRules[0] worldRules[1] to revive cells aren't
					// fulfilled.
					else {

						// Set this position of the world to ' '.
						newWorld[count][metaCount] = ' ';

					}

				}

				// Filter if the cell is dead.
				/**
				 * 
				 * Rules of dead cell:
				 * 
				 * 1. If dead cell is near to 3 live cells then they revive.
				 * 
				 */
				else {

					// Look if the position is possible.
					if (HEIGHT > (count + 1)) {

						// Look for alive cells next the actual cell.
						if (world[count + 1][metaCount] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (HEIGHT > (count + 1) && WIDTH > (metaCount + 1)) {

						// Look for alive cells next the actual cell.
						if (world[count + 1][metaCount + 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (WIDTH > (metaCount + 1)) {

						// Look for alive cells next the actual cell.
						if (world[count][metaCount + 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (0 <= (count - 1) && WIDTH > (metaCount + 1)) {

						// Look for alive cells next the actual cell.
						if (world[count - 1][metaCount + 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (0 <= (count - 1)) {

						// Look for alive cells next the actual cell.
						if (world[count - 1][metaCount] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (0 <= (count - 1) && 0 <= (metaCount - 1)) {

						// Look for alive cells next the actual cell.
						if (world[count - 1][metaCount - 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (0 <= (metaCount - 1)) {

						// Look for alive cells next the actual cell.
						if (world[count][metaCount - 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Look if the position is possible.
					if (HEIGHT > (count + 1) && 0 <= (metaCount - 1)) {

						// Look for alive cells next the actual cell.
						if (world[count + 1][metaCount - 1] == '·') {

							// Sum 1...
							sum++;

						}
					}

					// Filter if the worldRules[2] to revive cells are fulfilled.
					if (sum == worldRules[2]) {

						// Set this position of the world to '·'.
						newWorld[count][metaCount] = '·';

					}

					// Filter if the worldRules[2] to revive cells aren't fulfilled.
					else {

						// Set this position of the world to ' '.
						newWorld[count][metaCount] = ' ';

					}
				}
			}

		}

		// Equals the world to the newWorld.
		world = newWorld;

	}

	// Menu function.
	public void menu() {

		// Variables.
		boolean menuLoop = true;
		String option;
		String x;
		boolean isANumber = false;
		String a1, a2, b;
		boolean cellsloop = true;
		boolean worldInicialize = false;
		boolean cellsInicialize = false;

		// Start Menu.
		while (menuLoop) {

			// Question, do.
			// Ask to do.
			System.out.print(
					"\nQue vols fer?\n[0] - - -> {Posar nom}\n[1] - - -> {Posar tamany al món}\n[2] - - -> {Canviar regles}\n[3] - - -> {Col·locar cèl·lules}\n[4] - - -> {Jugar}\n[5] - - > {Sortir}\n>> ");

			// Set option.
			option = scan.next();

			// Filter the result.
			switch (option) {

			// Change name.
			case "0":

				// Ask the name.
				System.out.print("\nPosa el teu nom:\n>> ");

				// Set a name value.
				name = scan.next();

				// Secret...
				// Ask if name is a number.
				isANumber = isANumber(name);

				// Filter if the name is a number.
				if (isANumber) {

					// Set the name value as "Mathlover".
					name = "MathLover";

				}

				// Filter if the name are "carles" or "cristina".
				else if (name.equals("carles") || name.equals("cristina")) {

					// Set name like "professor".
					name = "Professor";

				}

				// Break.
				break;

			// Put the world size.
			case "1":

				// Filter if the variable cellsInicialize is false.
				if (!cellsInicialize) {

					// Put the world size.
					// WIDTH.
					// 20 opportunities.
					for (count = 0; count < 20; count++) {

						// Ask for width.
						System.out.print(
								"\nQuina vols que sigui la allargada del món (Maxim 100 i minim 10)(Eix X)?\n>> ");

						// Set this value in variable x.
						x = scan.next();

						// Ask if x is a number.
						isANumber = isANumber(x);

						// Filter if x is a number.
						if (isANumber) {

							// Set the WIDTH as x.
							WIDTH = Integer.parseInt(x);

							// Filter if WIDTH is less or equal than 100 and higher or equal 0.
							if (WIDTH <= 100 && WIDTH >= 10) {

								// Message all are good.
								System.out.print("\nValor assignat, el món té [" + WIDTH + "] caselles de llargada\n");

								// Set count as 998.
								count = 998;

							}

							// Filter if WIDTH is higher or equal than 100 and less or equal 0.
							else {

								// Error message.
								System.out.print("\nSiusplau posa un valor entre 10 i 100\n");

							}

						}

						// Filter if x is not a number.
						else {

							// Error message.
							System.out.print("\nSiusplau entra un valor valid!!\n");

						}

					}

					// Filter if count is not 999.
					if (count != 999) {

						// Message.
						System.out.print("\nEl valor sa assignat a 10");

						// Set WIDTH as 10.
						WIDTH = 10;

					}

					// HEIGHT.
					// 20 opportunities.
					for (count = 0; count < 20; count++) {

						// Ask for width.
						System.out.print("\nQuina vols que sigui la altura del món (Maxim 100)(Eix Y)?\n>> ");

						// Set the x.
						x = scan.next();

						// Ask if x is a number.
						isANumber = isANumber(x);

						// filter if x is a number.
						if (isANumber) {

							// Set HEIGHT as the x value.
							HEIGHT = Integer.parseInt(x);

							// Filter if HEIGHT if less equal than 100 or higher equal like 10.
							if (HEIGHT <= 100 && HEIGHT >= 10) {

								// Good message.
								System.out.print("\nValor assignat, el món té [" + HEIGHT + "] caselles de llargada\n");

								// Set count as 998.
								count = 998;

							}

							// Filter if HEIGHT if higher equal than 100 or less equal like 10.
							else {

								// Error message.
								System.out.print("\nSiusplau posa un valor entre 10 i 100\n");

							}

						}

						// Error message.
						else {

							System.out.print("\nSiusplau entra un valor valid!!\n");

						}

					}

					// Filter if count is different than 999.
					if (count != 999) {

						// Message.
						System.out.print("\nEl valor sa assignat a 10");

						// Set HEIGHT as 10.
						HEIGHT = 10;

					}

					// Inicialize world.
					worldInicialize();

					// Print world.
					worldPrint();

					// Set worldInicialize as true.
					worldInicialize = true;

				}

				// Filter if the variable cellsInicialize is true.
				else {

					// Error message.
					System.out.print(
							"\nJa s'han col·locat les cèl·lules, després d'acabar la proxima partida podras tornar a canviar aquests valors\n");

				}

				// break.
				break;

			// Change the world rules.
			case "2":

				// Set rules
				// Ask worldRules[0]
				// 20 oportunities.
				for (count = 0; count < 20; count++) {

					// Ask for a1
					System.out.print(
							"\nLes regles són:\n[23/3] -|-|- {AA/B}\nIntrodueix les noves, primer el valor de la primera A:\n>> ");

					// Set a1 value.
					a1 = scan.next();

					// Ask if a1 is a number.
					isANumber = isANumber(a1);

					// Filter if a1 is a number.
					if (isANumber) {

						// Set worldRules[0] as a1.
						worldRules[0] = Integer.parseInt(a1);

						// Good message.
						System.out.print("\nValor assignat, [" + worldRules[0] + "A/B]\n");

						// Set count as 998.
						count = 998;

					}

					// Filter if a1 is not a number.
					else {

						// Error message.
						System.out.print("\nSiusplau entra un valor valid!!\n");

					}

				}

				// Filter if count value is 999.
				if (count != 999) {

					// Message.
					System.out.print("\nEl valor sa assignat a 2\n");

					// Set worldRules[0] as 2.
					worldRules[0] = 2;

				}

				// Ask worldRules[1].
				// 20 oportunities.
				for (count = 0; count < 20; count++) {

					// Ask for a2.
					System.out.print("\nSegon valor de la segona A:\n>> ");

					// Set a2.
					a2 = scan.next();

					// Ask if a2 is a number.
					isANumber = isANumber(a2);

					// Filter if a2 is a number.
					if (isANumber) {

						// Set worldRules[1] as a2.
						worldRules[1] = Integer.parseInt(a2);

						// Good message.
						System.out.print("\nValor assignat, [" + worldRules[0] + "" + worldRules[1] + "/B]\n>> ");

						// Set count as 998.
						count = 998;

					}

					// Filter if a2 is not a number.
					else {

						// Error message.
						System.out.print("\nSiusplau entra un valor valid!!\n");

					}

				}

				// Filter if count value is 999.
				if (count != 999) {

					// Message.
					System.out.print("\nEl valor sa assignat a 3\n");

					// Set worldRules[1] as 3.
					worldRules[1] = 3;

				}

				// Ask for b.
				// 20 opportunities.
				for (count = 0; count < 20; count++) {

					// Ask for b.
					System.out.print("\nEl valor de B:\n>> ");

					// Set b
					b = scan.next();

					// Ask if b is a number.
					isANumber = isANumber(b);

					// Filter if b is a number.
					if (isANumber) {

						// Set worldRules[2] as b.
						worldRules[2] = Integer.parseInt(b);

						// Message.
						System.out.print("\nValor assignat, [" + worldRules[0] + "" + worldRules[1] + "/"
								+ worldRules[2] + "]\n");

						// Set count as 998.
						count = 998;

					}

					// Filter if b is not a number.
					else {

						// Error message.
						System.out.print("\nSiusplau entra un valor valid!!\n");

					}

				}

				// Filter if count is not 999.
				if (count != 999) {

					// Message.
					System.out.print("\nEl valor sa assignat a 3\n");

					// Set worldRules[2] as 3.
					worldRules[2] = 3;

				}

				// break.
				break;

			// Put the cells in to the world.
			case "3":

				// Set cellsloop as true.
				cellsloop = true;

				// Start cells Loop.
				while (cellsloop && worldInicialize) {

					// Ask to the form of put the cells.
					System.out.print(
							"\nVols posar les cèl·lules de forma:\n[0] - - -> {Manual}\n[1] - - -> {Automatica}\n>> ");

					// Set option.
					option = scan.next();

					// Filter the option.
					switch (option) {

					// Manual option.
					case "0":

						// Initialize world.
						worldInicialize();

						// Position of the cells.
						cellposition(option);

						// Set cellsloop as false.
						cellsloop = false;

						// Set cellsInicialize as true.
						cellsInicialize = true;

						// break
						break;

					// Automatic option.
					case "1":

						// Initialize world.
						worldInicialize();

						// Position of the cells.
						cellposition(option);

						// Set cellsloop as false.
						cellsloop = false;

						// Set cellsInicialize as true.
						cellsInicialize = true;

						// break.
						break;

					// Another option.
					default:

						// Error messsage.
						System.out.print("\nCaracter no valid!\n");

						// break:
						break;

					}

				}

				// Filter if the world is not initialize.
				if (!worldInicialize) {

					// Error message.
					System.out.print("\nPrimer inicialitza el món siusplau\n");

				}

				// break.
				break;

			// Start the game,
			case "4":

				// Filter if the world is initialize.
				if (worldInicialize) {

					// Satrt game.
					game();

					// Initialize the world.
					worldInicialize();

					// Set cellsloop as true.
					cellsloop = true;

					// Set worldInicialize as false.
					worldInicialize = false;

					// Set cellsInicialize as false.
					cellsInicialize = false;

				}

				// Filter if the world is not initialize.
				else {

					// Error message.
					System.out.print("\nSiusplau primer inicialitza el mon primer\n");

				}

				// break.
				break;

			// Close the menu.
			case "5":

				// Message goodbye.
				System.out.print("\nBye!\n");

				// Set menuLoop as false.
				menuLoop = false;

				// break.
				break;

			// Another caracter.
			default:

				// Error message.
				System.out.print("\nCaracter no valid\n\n");

			}

		}

	}

}