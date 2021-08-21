import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class WeisfeilerLehman {

    public static void main(String[] args) {
		Graph graph = new Graph();
		graph.read_graph();
		graph.display();
    }

}
