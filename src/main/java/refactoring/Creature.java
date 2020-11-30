package refactoring;

/** From the book : Java 1.4 Game programming
 * A super class. Represents some intelligent life form that can talk.
 *
 * Use IntelliJ to pull up getGreeting() from Alien class to Creature class
 */
public class Creature {
	private String greeting;

	public Creature(String greeting) {
		this.greeting = greeting;
	}

	public String getGreeting() {
		return greeting;
	}

	public void speak() {
		System.out.println("Creature says: " + greeting);
	}

}
