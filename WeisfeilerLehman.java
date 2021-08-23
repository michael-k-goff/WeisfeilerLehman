// Information about the algorithm:
// https://davidbieber.com/post/2019-05-10-weisfeiler-lehman-isomorphism-test/

import java.util.*;

public class WeisfeilerLehman {

    public static void main(String[] args) {
		Graphs graphs = new Graphs();
		
		// Get file
		Scanner myObj = new Scanner(System.in);
		System.out.println("Which graphs? Enter 1-3.");
		String file_number = myObj.nextLine();
		String file_name = "graphs"+file_number+".dat";
		
		boolean success = graphs.read_data(file_name);
		if (success) {
			graphs.apply_codes();
			graphs.display();
		}
    }

}
