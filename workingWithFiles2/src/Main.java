import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //createFile();
        //getFileInfo();
        readFile();
        writeFile();
        readFile();
        //Main yani ana class'ın altındaki class bloklarına ulaşmamız için main bloğunda bir üst satırdaki gibi çağırmamız lazım.
    }

    public static void createFile() {
        File file = new File("C:\\Users\\ONUR\\Desktop\\JavaWorks\\files\\students.txt");//Koduzu yazdığımız yere bir "files" olupturup uzaltısını fonsiyonumuza ekledik.
        try { //Bu blok file içinde students.txt oluşturur ve bunun yanında true yada false döndürür.
            //file.createNewFile(); //İlgili uzantıya file oluştur diyoruz. Bu checked exception olduğundan ampulden altındaki satırları otomatik oluşturduk.
            if (file.createNewFile()) {
                System.out.println("Dosya oluşturuldu.");
            } else {
                System.out.println("Dosya zaten mevcut."); //Kodu ikinciye run yaptığımızda ilkinde oluşturulduğundan else düşüp  dosya zaten mevcut yazdıracaktır.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileInfo(){
        File file = new File("C:\\Users\\ONUR\\Desktop\\JavaWorks\\files\\students.txt");
        if (file.exists()){ //Bu if fonsiyonunda exists dosya varsa şartıyla bloğu işletmektedir.
            System.out.println("Dosya adı:"+file.getName());
            System.out.println("Dosya yolu:"+file.getAbsolutePath());
            System.out.println("Dosya yazılabilir mi:"+file.canWrite());
            System.out.println("Dosya okunabilir mi:"+file.canRead());
            System.out.println("Dosya boyutu(byte):"+file.length());
        }
    }

    public static void readFile(){
        File file = new File("C:\\Users\\ONUR\\Desktop\\JavaWorks\\files\\students.txt");
        try {
            Scanner reader=new Scanner(file); //Scanner dosya okuma işlemi için kullanılan bir foksiyondur.
            while (reader.hasNextLine()){ // Burada okunacak satır varsa demek.Yani okuyabildiği sürece devam ediyor. while döngüsü true dan false'a dönene kadar devam edecektir.
                String line=reader.nextLine(); // Bu okunacak datayı line değişkenine reader.nextLine donsiyonu ile sağlamaktayız.
                System.out.println(line);
            }
            reader.close(); //Döngüden çıktıktan sonra yani işi bittiğinde bellekte açık kalmaması için uçurma yani kapatma işlemi uygulanır.
        } catch (FileNotFoundException e) { //Exception kullanılmasının nedeni bu dosya olmazsa catch ile handle et yani kontrol altına al diyor.
            e.printStackTrace();
        }
    }

    public static void writeFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ONUR\\Desktop\\JavaWorks\\files\\students.txt",true));
            //FileWriter efektif şekilde kullanabilmemiz için BufferedWriter içinde kullanılması gerekmektedir.
            writer.newLine();
            writer.write("Ahmet");
            System.out.println("Dosyaya yazıldı"+writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
