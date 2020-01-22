import java.io.*;
import java.util.Scanner;
/**
 * @author Perrin Nii Obodai Provencal
 *
 */

public class EssentialsInputScanner {


    /**
     *
     * @param args
     */


     public static void main(String[] args) {
         System.out.println("-----ESSENTIALS MANAGEMENT SYSTEM-----");
         System.out.println();
         // Creating new instance of the class
         EssentialsInputScanner temp = new EssentialsInputScanner();
          Goods[] items = new Goods[10];
         //Phase 1: Reading input for capturing stock
          for(int i =0;i<10;i++){
           // Creating new Scanner class
            Scanner input = new Scanner(System.in);
            System.out.println("What is the name of the good? ");
            String goodName = input.nextLine();
            System.out.println("What is the price of the good? ");
            float inputPrice = input.nextFloat();
            System.out.println("What is the quantity of the good? ");
            int inputQuantity = input.nextInt();
            Goods good = new Goods(goodName,inputPrice,inputQuantity);
            items[i] = good;

        }
          //Phase 2: Storing information in text file
          temp.writingTextToFile(items, "essentials_stock.txt");

          //Phase 3: Backing up to another text file
         /**
          * @throws IOException
          */
          try {
            temp.BackupFile("essentials_stock.txt");
        } catch (IOException e){
            e.getMessage();
        }
          //Phase 4: Displaying Content of text file on screen
         /**
          * @throws IOException
          */
         System.out.println();
         try {
             temp.displaytoScreen("essentials_stock.txt");
         } catch (IOException f){
             f.getMessage();
         }
     }

    /**
     * @throws FileNotFoundException
     * @param array
     * @param fileName
     */
    public void writingTextToFile(Goods[] array, String fileName) {

        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        }catch(FileNotFoundException fnfe) {
            fnfe.getMessage();
        }


        for(int i = 0;i<10;i++) {
            printWriter.println(array[i].getName() + "   " + array[i].getQuantity() + "   "  + "  GHC  "  + array[i].getPrice());
        }
        //Close Writer
        printWriter.close();
    }

    /**
     * @throws FileNotFoundException
     * @param line
     * @param fileName
     */
    public void writingTextToFile(String line, String fileName) {

        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        }catch(FileNotFoundException fnfe) {
            fnfe.getMessage();
        }

        printWriter.println(line);

        //Close Writer
        printWriter.close();
    }

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public void BackupFile(String fileName)throws IOException {
        BufferedReader bufferedReader = null;

            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    writingTextToFile(line, "backup_essentials_stock.txt");
                }
            } catch (FileNotFoundException e){
                e.getMessage();
            }


    }

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public void displaytoScreen(String fileName)throws IOException{
        BufferedReader bufferedReader = null;

        bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = "";
        try {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e){
            e.getMessage();
        }
    }
        }

