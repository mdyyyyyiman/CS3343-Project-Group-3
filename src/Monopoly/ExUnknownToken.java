package Monopoly;

public class ExUnknownToken extends Exception{


	private static final long serialVersionUID = 1L;

	public ExUnknownToken() {
		super("Unknown token id");
	}

	public ExUnknownToken(String msg) {
		super(msg);
	}


}
