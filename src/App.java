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

        list = new File("./PWs.txt");
        list.createNewFile();

        reader = new BufferedReader(new FileReader(list));
        writer = new BufferedWriter(new FileWriter(list,true));

        boolean abbruch = false;
        while(!abbruch){
            System.out.println("Was willst du tun? (eingeben|auslesen|loeschen|stop)");
            switch(sc.nextLine().toUpperCase()){
                case "EINGEBEN":
                    passwort_eingabe();
                    break;
                case "AUSLESEN":
                    passwort_auslese();
                    break;
                case "LOESCHEN":
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
        writer.flush();
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
        File tmp = File.createTempFile("tmp","txt");

        System.out.println("Welches Platform löschen?");
        String eingabe = sc.nextLine();

        BufferedReader listReader = new BufferedReader(new FileReader(list));
        BufferedWriter tmpWriter = new BufferedWriter(new FileWriter(tmp));
        String listLine;

        while((listLine=listReader.readLine())!=null){
            if(!listLine.contains(eingabe)){
                tmpWriter.write(listLine);
            }
        }

        listReader.close();
        tmpWriter.close();

        BufferedReader tmpReader = new BufferedReader(new FileReader(tmp));
        BufferedWriter listWriter = new BufferedWriter(new FileWriter(list));

        String tmpLine;
        while((tmpLine=tmpReader.readLine())!=null){
            listWriter.write(tmpLine);
            listWriter.newLine();
        }

        tmpReader.close();
        listWriter.close();
    }
}