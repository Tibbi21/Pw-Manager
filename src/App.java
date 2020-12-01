import java.util.Scanner;
import java.io.*;

public class App {
    Scanner sc = new Scanner(System.in);
    BufferedReader reader;
    BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        new App();
    }

    public App() throws IOException {
            reader = new BufferedReader(
                    new FileReader(new File("C:/Users/tibbi/Documents/workspace/java/isaak be like test/PWs.txt")));
            writer = new BufferedWriter(
                    new FileWriter(new File("C:/Users/tibbi/Documents/workspace/java/isaak be like test/PWs.txt"),true));
        System.out.println("willst du ein passwort eingeben?");
        if (sc.nextLine().equalsIgnoreCase("ja")) {
            passwort_eingabe();
        }
        System.out.println("willst du ein passwort ausgeben?");
        if (sc.nextLine().equalsIgnoreCase("ja")) {
            passwort_auslese();
        }
        System.out.println("willst du ein passwort löschen?");
        if (sc.nextLine().equalsIgnoreCase("ja")) {
            passwort_löschen();
        }
        System.out.print("Programm Ende!");
            reader.close();
            writer.close();
    }

    public void passwort_eingabe() throws IOException {
        do{
        System.out.print("wofür ist das Passwort? ");
            writer.write("platform: "+sc.nextLine()+ " ");
        System.out.print("wie lautet das Passwort? ");
            writer.write("passwort: "+sc.nextLine());
        writer.newLine();
        System.out.println("gebe um ein neues passwort einzugeben etwas beliebiges, und um zu stoppen \"stop\" ein");
        }
        while(!sc.nextLine().equalsIgnoreCase("stop"));
    }
    public void passwort_auslese() throws IOException {
        String line;
        String eingabe;
        boolean found=false;
        System.out.print("welches Passwort benötigst du? ");
        eingabe = sc.nextLine();
        while((line = reader.readLine()) != null){
            if(line.contains(eingabe)){
            System.out.print(line);
            found=true;
            }
            else {
                System.out.print("für diese Platform wurde noch nichts gespeicher!");
            }
        }
        if(!found){
            System.out.print("es ist noch kein Passwort gespeichert worden!");
        }
    }
    public void passwort_löschen() throws IOException {
        // @NicoHubrach
        String line;
        String eingabe;
        boolean found=false;
        System.out.print("welches Passwort möchtest du löschen? ");
        eingabe = sc.nextLine();
        while((line = reader.readLine()) != null){
            if(line.contains(eingabe)){
            writer.write(" ");
            found=true;
            }
            else{
                System.out.print("für diese Platform wurde noch nichts gespeicher!");
            }
        }
        if(!found){
            System.out.print("es ist noch kein Passwort gespeichert worden!");
        }
    }
}
