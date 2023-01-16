package OgrenciOgretmenOtomasyon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AnaMenu {

     void menu(){
      Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n" +
       "\t ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ\n"+
       "\t ====================================\n"+
        "\t1- ÖĞRENCİ İŞLEMLERİ\n"+
        "\t2- ÖĞRETMEN İŞLEMLERİ\n"+
        "\tQ- ÇIKIŞ\n"+
                "\t SEÇİMİNİZ : ");
        try {
            int secim=scanner.nextInt();

            switch (secim){
                case 1:{
                    Ogrenciİslemler ogrenciMenu=new Ogrenciİslemler();
                }
                case 2:{
                    OgretmenIslemler ogretmenMenu=new OgretmenIslemler();
                }
            }
        }
        catch (InputMismatchException e){
            String secim= scanner.next();
            if (secim.equalsIgnoreCase("q")){
                System.out.println("Sistemden çıkılıyor");
                System.exit(0);
            }
            else {
                System.out.println("Hatalı giriş yaptınız.");
                menu();
            }

        }
    }
}
