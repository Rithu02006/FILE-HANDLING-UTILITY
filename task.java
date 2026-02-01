import java.io.*;
import java.util.Scanner;

public class FileUtility {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== File Handling Utility ====");
            System.out.println("1. Create & Write File");
            System.out.println("2. Read File");
            System.out.println("3. Append to File");
            System.out.println("4. Delete File");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> writeFile();
                case 2 -> readFile();
                case 3 -> appendFile();
                case 4 -> deleteFile();
                case 5 -> {
                    System.out.println("Exiting... 👋");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // Create & Write File
    static void writeFile() {
        try {
            System.out.print("Enter file name: ");
            String fileName = sc.nextLine();

            FileWriter fw = new FileWriter(fileName);
            System.out.print("Enter content: ");
            String content = sc.nextLine();

            fw.write(content);
            fw.close();

            System.out.println("File written successfully ✔");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Read File
    static void readFile() {
        try {
            System.out.print("Enter file name: ");
            String fileName = sc.nextLine();

            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            System.out.println("\n--- File Content ---");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // Append to File
    static void appendFile() {
        try {
            System.out.print("Enter file name: ");
            String fileName = sc.nextLine();

            FileWriter fw = new FileWriter(fileName, true);
            System.out.print("Enter text to append: ");
            String content = sc.nextLine();

            fw.write("\n" + content);
            fw.close();

            System.out.println("Content appended successfully ✔");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Delete File
    static void deleteFile() {
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File deleted successfully ✔");
        } else {
            System.out.println("Failed to delete file!");
        }
    }
}

