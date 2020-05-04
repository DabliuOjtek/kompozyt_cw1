import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Katalogi dyskD = new Katalogi("D");
        Katalogi zdjecia = new Katalogi( "zdjecia");

        Katalogi gta = new Katalogi( "GTA");
        Katalogi gtaOptions = new Katalogi( "settings");
        Katalogi gtaSaves = new Katalogi( "saves");

        Katalogi nfs = new Katalogi("NFS");

        gta.dodaj(new Pliki("gta", ".exe"));
        gta.dodaj(new Pliki("kody", ".txt"));
        gta.dodaj(gtaOptions);

        gtaOptions.dodaj(new Pliki("plik_settings", ".txt"));
        gtaOptions.dodaj(gtaSaves);
        gtaSaves.dodaj(new Pliki("profil_save", ".txt"));

        zdjecia.dodaj(new Pliki("zdjecie", ".txt"));

        nfs.dodaj(new Pliki("nfs", ".exe"));

        dyskD.dodaj(zdjecia);
        dyskD.dodaj(gta);
        dyskD.dodaj(nfs);
        dyskD.dodaj(new Pliki("muzyka", ".mp3"));

        Scanner scanner = new Scanner(System.in);

        String katalog = "D";
        Katalogi pomocnicza = dyskD;

        int stan = -1;
        int stanKopia = 0;
        boolean exit = true;

        while (exit != false){
            System.out.print(katalog + ":\\>");
            String scan = scanner.nextLine();
            try {
                if (scan.equals("exit")) {
                    exit = false;
                }

                if (scan.substring(0, 3).equals("dir") && scan.substring(3).equals("")) {
                    if (stan >= -1) {
                        pomocnicza.dir();
                    } else {
                        System.out.println("Katalog nie istnieje");
                    }
                }else if (scan.substring(0, 2).equals("cd")) {
                    stanKopia = stan;
                    if (scan.substring(2).equals("..")) {
                        if (pomocnicza == dyskD)
                            System.out.println("Nie mozna juz cofac");
                        else {
                            pomocnicza = pomocnicza.poprzednia;
                            katalog = pomocnicza.nazwa;
                        }
                    } else {
                        stan = pomocnicza.cd(scan.substring(3));
                        if (stan == -2) {
                            System.out.println("Katalog nie istnieje");
                            stan = stanKopia;
                        } else {
                            pomocnicza = (Katalogi) pomocnicza.skladowe.get(stan);
                            katalog = scan.substring(3);
                        }
                    }
                }else
                    System.out.println("Komenda nie istnieje");
            }catch(Exception e){
                System.out.println("Komenda nie istnieje");
            }
        }
    }
}
