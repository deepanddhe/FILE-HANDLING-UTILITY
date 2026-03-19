import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Fileutility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- File Handling Utility ---");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify File (Append)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    writeFile(sc);
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    modifyFile(sc);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
       } while (choice != 4);
       sc.close();
    }
    public static void writeFile(Scanner sc) {
        try {
            FileWriter fw = new FileWriter("sample.txt");
            System.out.print("Enter text to write: ");
            String data = sc.nextLine();
            fw.write(data);
            fw.close();
            System.out.println("Data written successfully.");
         } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }
    public static void readFile() {
        try {
            File file = new File("sample.txt");
            Scanner reader = new Scanner(file);
            System.out.println("\nFile Content:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
         } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    public static void modifyFile(Scanner sc) {
        try {
            FileWriter fw = new FileWriter("sample.txt", true);
            System.out.print("Enter text to add: ");
            String data = sc.nextLine();
            fw.write("\n" + data);
            fw.close();
            System.out.println("Data added successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file.");
        }
    }
}
