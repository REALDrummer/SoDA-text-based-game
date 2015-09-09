import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// introduction
		System.out.println("\"SHIT!\"");
		System.out.println("Sarge: \"I swear to God, Brick, if that mortar strike gets any closer, we're gonna meet up with Miller a lot fuckin' sooner than I'd like!\"");
		System.out.println("Sarge: \"Now quit bein' a pussy and go charge that nest!\"");

		// establish the input stream
		Scanner in = new Scanner(System.in);
		byte last_choice;

		System.out.println("What's the plan, private?");

		last_choice = proposeOptions(in, "CHARGE!!", "Fuck that. I'm staying right here.", "The mortars are too close; shift to different cover.", "Shoot Sarge.");
		switch (last_choice) {
			case 1:
				System.out.println("You charge the mortar nest and get blown to bits.");
				break;
			case 2:
				System.out.println("You stay put and get blown to bits as the mortar team perfects their aim.");
				break;
			case 3:
				System.out.println("You got blown up while moving to safer cover.");
				break;
			case 4:
				System.out.println("TREACHERY WILL NOT BE TOLERATED!");
			default:
				break;
		}

		System.out.println("GAME OVER");

		in.close();
	}

	public static byte proposeOptions(Scanner in, String... options) {
		for (int i = 0; i < options.length; i++)
			System.out.println((i + 1) + ") " + options[i]);

		while (true) {
			byte input;
			try {
				input = Byte.parseByte(in.nextLine());
			} catch (NumberFormatException exception) {
				System.out.println("That's not a number! Try again.");
				continue;
			}

			if (input < 0)
				System.out.println("There are no negative options!");
			else if (input > options.length)
				System.out.println("There are only " + options.length + " options!");
			else
				return input;
		}
	}
}
