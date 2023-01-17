package OgrenciOgretmenOtomasyon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OgretmenIslemler implements IIslemler{
    Scanner scanner=new Scanner(System.in);
  static   int sicilNo=1000;

 static ArrayList<Ogretmen> ogretmenList=new ArrayList<>();
    void ogrtMenu(){
        System.out.println("   ============= İŞLEMLER =============\n" +
                "       1-EKLEME\n" +
                "       2-ARAMA\n" +
                "       3-LİSTELEME\n" +
                "       4-SİLME\n" +
                "       Q-ÇIKIŞ\n" +
                "\n" +
                "   SEÇİMİNİZ:");
        try {
            int secim = scanner.nextInt();
            switch (secim){
                case 1 : {
                        ekleme();
                }
                case 2 : {
                        arama();
                }
                case 3 : {
                        listeleme();
                }
                case 4 : {
                    silme();
                }
            }
        }catch (InputMismatchException e){
            String secim=scanner.next();
            if (secim.equalsIgnoreCase("q")){
                AnaMenu anaMenu=new AnaMenu();
                anaMenu.menu();
            }else {
                System.out.println("HATALI GİRİŞ YAPILDI");
                ogrtMenu();
            }

        }

    }
    @Override
    public void ekleme() {
        System.out.println("ÖGRETMENİN ADINI GİRİNİZ: ");
        scanner.nextLine();
        String ad=scanner.nextLine();
        System.out.println("OGRETMENİN SOYADINI GİRİNİZ: ");
        String sAd=scanner.nextLine();
        System.out.println("OGRETMENİN TC NO'SUNU GİRİNİZ: ");
        String tcNo=scanner.next();
        System.out.println("OGRETMENİN YAŞINI GİRİNİZ: ");
        int yas=scanner.nextInt();
        System.out.println("OGRETMENİN BOLUMUNU GİRİNİZ: ");
        String bolum=scanner.next();
        Ogretmen ogretmen=new Ogretmen(ad,sAd,tcNo,yas,bolum,sicilNo++);
        ogretmenList.add(ogretmen);
        listeleme();
        ogrtMenu();


    }

    @Override
    public void arama() {
        System.out.println("Aranacak kişinin TC no sunu giriniz.");
        String tcNo=scanner.next();
        int kontrol=0;
        for (Ogretmen each:ogretmenList
             ) {
            if(each.getTcNo().equals(tcNo)){
                System.out.println(each);
                kontrol=1;
            }


        }
        if (kontrol==0){
            System.out.println(tcNo+" TC No'lu kişi bulunmamaktadır");
        }
        ogrtMenu();

    }

    @Override
    public void listeleme() {
        for (Ogretmen each:ogretmenList
             ) {
            System.out.println(each);
        }
        ogrtMenu();
    }

    @Override
    public void silme() {
        System.out.print("Silinecek kişinin TC No'sunu giriniz");
        String tcNo=scanner.next();
        boolean kontorl=false;

        for (int i = 0; i <ogretmenList.size() ; i++) {
            if(ogretmenList.get(i).getTcNo().equals(tcNo)){
                System.out.println("Silinen Kişi :"+ ogretmenList.get(i));
                ogretmenList.remove(i);
                kontorl=true;
                ogrtMenu();
            }
        }
        if (!kontorl){
            System.out.println(tcNo+ " TC No'lu kişi bulunmamaktadır");
            ogrtMenu();
        }


    }
}
