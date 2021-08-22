import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class WeisfeilerLehman {

    public static void main(String[] args) {
		Graphs graphs = new Graphs();
		graphs.read_data();
		graphs.apply_codes();
		graphs.display();
    }

}
