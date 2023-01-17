package OgrenciOgretmenOtomasyon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ogrenciİslemler implements IIslemler {
    static  int numara=100;
    static ArrayList<Ogrenci> ogrenciList=new ArrayList<>();

    Scanner scan=new Scanner(System.in);
    void ogrenciMenu(){
        System.out.println("  ============= İŞLEMLER =============\\n\" +\n" +
                "                \"       1-EKLEME\\n\" +\n" +
                "                \"       2-ARAMA\\n\" +\n" +
                "                \"       3-LİSTELEME\\n\" +\n" +
                "                \"       4-SİLME\\n\" +\n" +
                "                \"       Q-ÇIKIŞ\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"   SEÇİMİNİZ:");
        try{
            int secim=scan.nextInt();
            switch (secim){
                case 1:{
                    ekleme();
                }
                case 2:{
                    arama();
                }
                case 3:{
                    listeleme();
                }
                case 4:{
                    silme();
                }
            }
        }catch (InputMismatchException e){
            String secim=scan.next();
            if (secim.equalsIgnoreCase("q")){
                AnaMenu anaMenu=new AnaMenu();
                anaMenu.menu();
            }else {
                System.out.println("HATALI GİRİS YAPILDI");
                ogrenciMenu();
            }

        }
    }

    @Override
    public void ekleme() {
        System.out.println("OGRENCİNİN ADINI GİRİNİZ: ");
        String ad= scan.nextLine();
        scan.next();
        System.out.println("OGRENCİNİN SOYADINI GİRİNİZ");
        String Sad= scan.nextLine();
        System.out.println("OGRENCİNİN TC NO'SUNU GİRİNİZ");
        String tcNo= scan.next();
        System.out.println("OGRENCİNİN YASINI GİRİNİZ");
        int yas= scan.nextInt();
        scan.next();
        System.out.println("OGRENCİNİN SINIFINI GİRİNİZ");
        String sinif= scan.next();
        Ogrenci ogrenci=new Ogrenci(ad,Sad,tcNo,yas,numara++,sinif);
        ogrenciList.add(ogrenci);
        listeleme();
        ogrenciMenu();


    }

    @Override
    public void arama() {
        System.out.println("ARANACAK KİŞİNİN TC'NO SUNU GİRİNİZ ");
        String tcNo=scan.next();
        int kontrol=0;
        for (Ogrenci each:ogrenciList
             ) {
            if (each.getTcNo().equals(tcNo)){
                System.out.println("ARANAN KİŞİ : "+ each);
                kontrol=1;
            }
        }
        if (kontrol==0){
            System.out.println(tcNo+ "TC No'lu kişi bulunmamaktadır");
            ogrenciMenu();
        }

    }

    @Override
    public void listeleme() {
        for (Ogrenci each:ogrenciList
             ) {
            System.out.println(each);
            ogrenciMenu();
        }

    }

    @Override
    public void silme() {
        System.out.println("Silinecek kişinin TC NO'sunu giriniz");
        String tcNo=scan.next();
        boolean kontrol=false;
        for (int i = 0; i < ogrenciList.size() ; i++) {
            if (ogrenciList.get(i).getTcNo().equals(tcNo)){
                System.out.println("Silinen kişi : "+ ogrenciList.get(i));
                ogrenciList.remove(i);
                kontrol=true;
                ogrenciMenu();
            }

        }
        if (!kontrol){
            System.out.println(tcNo+ "TC NO'Lu kişi bulunmamaktadır.");
            ogrenciMenu();
        }

    }
}
