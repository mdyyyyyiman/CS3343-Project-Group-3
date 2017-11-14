import java.util.Scanner;

public class cmdHandler {
	private static Scanner s= new Scanner(System.in);
	
	public static String getYesNoCmd() {
//		while(true){
//			String cmd = s.next();
//			if(cmd.toUpperCase().equals("Y")){
//				return "Y";
//			}else if(cmd.toUpperCase().equals("N")){
//				return "N";
//			}else {
//				System.out.println("Incorrect Command, Please re-enter !");
//			}
//		}
		return"Y";

	}

	public static String[] getPlayerCmd() {
		String cmd = s.next();
		String[] cmdArray = cmd.split(" ");
		return cmdArray;
	}
}
