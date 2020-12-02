import java.util.Scanner;
import java.io.*;

public class App {

    Scanner sc;
    BufferedReader reader;
    BufferedWriter writer;
    File temp;
    File list;

    public static void main(String[] args) throws IOException {
        new App();
    }

    public App() throws IOException {
        sc = new Scanner(System.in);

        temp = new File("./Temp.txt");
        temp.createNewFile();

        list = new File("./PWs.txt");
        list.createNewFile();

        reader = new BufferedReader(new FileReader(list));
        writer = new BufferedWriter(new FileWriter(temp));

        boolean abbruch = false;
        while(!abbruch){
            System.out.println("Was willst du tun? (eingeben|auslesen|löschen|stop)");
            switch(sc.nextLine().toUpperCase()){
                case "EINGEBEN":
                    passwort_eingabe();
                    break;
                case "auslesen":
                    passwort_auslese();
                    break;
                case "LÖSCHEN":
                    passwort_löschen();
                    break;
                case "STOP":
                    abbruch = true;
                    break;
            }
        }
        System.out.print("Programm Ende!");

        reader.close();
        writer.close();
    }

    public void passwort_eingabe() throws IOException {
        System.out.print("wofür ist das Passwort? ");
        writer.write("platform: " + sc.nextLine() + " ");
        System.out.print("wie lautet das Passwort? ");
        writer.write("passwort: " + sc.nextLine());
        writer.newLine();
    }
    public void passwort_auslese() throws IOException {
        String line;
        String eingabe;
        boolean found = false;
        System.out.print("welches Passwort benötigst du? ");
        eingabe = sc.nextLine();
        while ((line = reader.readLine()) != null) {
            if (line.contains(eingabe)) {
                System.out.print(line);
                found = true;
            } else {
                System.out.println("für diese Platform wurde noch nichts gespeichert!");
            }
        }
        if (!found) {
            System.out.println("es ist noch kein Passwort gespeichert worden!");
        }
    }
    public void passwort_löschen() throws IOException {
        String line;
        String eingabe;
        boolean found = false;
        System.out.print("welches Passwort möchtest du löschen? ");
        eingabe = sc.nextLine();
        while ((line = reader.readLine()) != null) {
            String tline = line.trim();
            if (tline.equals(eingabe)) {
                writer.write(line + System.getProperty("line.seperator"));
                found = true;
            } else {
                System.out.print("für diese Platform wurde noch nichts gespeicher!");
            }
        }
        if (!found) {
            System.out.print("es ist noch kein Passwort gespeichert worden!");
        }
    }
}