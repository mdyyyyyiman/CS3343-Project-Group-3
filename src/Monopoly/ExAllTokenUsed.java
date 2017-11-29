package Monopoly;

public class ExAllTokenUsed extends Exception {
	private static final long serialVersionUID = 1L;
	public ExAllTokenUsed() {
		super("Unexpected Error! Try to get Token when all token has been take.");
	}

	public ExAllTokenUsed(String msg) {
		super(msg);
}
}
