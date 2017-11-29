package Monopoly;

public class ExInvalidTotalPlayer extends Exception {
	private static final long serialVersionUID = 1L;
	public ExInvalidTotalPlayer() {
		super("Invalid Total Player.");
	}

	public ExInvalidTotalPlayer(String msg) {
		super(msg);
	}
}
