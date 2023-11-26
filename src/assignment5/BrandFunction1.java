package assignment5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ADMIN
 */
public class BrandFunction1 extends ArrayList<Brand> {
     Scanner sc = new Scanner(System.in);
    public BrandFunction1() {
        super();
    }
    public boolean readFile(String fName) {
        try {
            File f = new File(fName);
            if (!f.exists())
                return false;
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String s;
            while ((s = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(s, ",:");
                String brandID = stk.nextToken().trim().toUpperCase();
                String brandName = stk.nextToken().trim();
                String soundBrand = stk.nextToken().trim();
                double price = Double.parseDouble(stk.nextToken());
                this.add(new Brand(brandID, brandName, soundBrand, price));
            }
            bf.close();
            fr.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
    public boolean saveFile(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty list!");
            return false;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Brand x: this)
                pw.println(x.getBrandID() + ", " + x.getBrandName() + ", " + x.getSoundBrand() + ": " + x.getPrice());
            pw.close();
            fw.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
    public int search(String id) {
        for (int i = 0; i < this.size(); i++)
            if (this.get(i).getBrandID().equals(id.toUpperCase()))
                return i;
        return -1;
    }
     public void f1() {
        if (this.size() == 0) {
            System.out.println("Empty list!");
            return ;
        }
        System.out.println("\nBRAND LIST");
        System.out.println("-----------------------------------------");
        for (Brand x: this)
            System.out.println(x.toString());
    }
     public void f2() {
        String newBrandID, newBrandName, newSoundBrand;
        double price;
        System.out.println("Enter the brand details:");
        do {
            System.out.print("  Brand ID: ");
            newBrandID = sc.nextLine().toUpperCase();
            if (search(newBrandID) >= 0)
                System.out.println("    The brand ID is duplicated!");
            else break;
        }
        while (true);
        do {
            System.out.print("  Brand name: ");
            newBrandName = sc.nextLine();
            if (newBrandName.equals(""))
                System.out.println("    The brand name is empty!");
            else break;
        }
        while (true);
        do {
            System.out.print("  Sound brand: ");
            newSoundBrand = sc.nextLine();
            if (newSoundBrand.equals(""))
                System.out.println("    The sound brand is empty!");
            else break;
        }
        while (true);
        do {
            System.out.print("  Price: ");
            price = Double.parseDouble(sc.nextLine());
            if (price <= 0)
                System.out.println("    The price is not greater than 0!");
            else break;
        }
        while (true);
        this.add(new Brand(newBrandID, newBrandName, newSoundBrand, price));
        System.out.println("New brand has been added!");
    }
     public void f3(ArrayList<Brand> arr){
        System.out.print("Brand ID = ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();      
            if(search(s) >= 0){
                System.out.println(this.get(search(s)).toString());
            }
            else{
                System.out.println("-> Not found");      
            }
        System.out.println("----------------------------------");
     }
     public void f4() {
        System.out.print("Enter the BrandID you want to updated brand: ");
        String newBrandID = sc.nextLine().toUpperCase();
        if (search(newBrandID) < 0)
            System.out.println("Not found");
        else {
            String newBrandName, newSoundBrand;
            double price;
            System.out.println("Enter the brand details:");
            do {
                System.out.print("  Brand name: ");
                newBrandName = sc.nextLine();
                if (newBrandName.equals(""))
                    System.out.println("    The brand name is empty!");
                else break;
            }
            while (true);
            do {
                System.out.print("  Sound brand: ");
                newSoundBrand = sc.nextLine();
                if (newSoundBrand.equals(""))
                    System.out.println(" The sound brand is empty!");
                else break;
            }
            while (true);
            do {
                System.out.print("  Price: ");
                price = Double.parseDouble(sc.nextLine());
                if (price <= 0)
                    System.out.println("    The price is not greater than 0!");
                else break;
            }
            while (true);
            this.get(search(newBrandID)).setBrandName(newBrandName);
            this.get(search(newBrandID)).setSoundBrand(newSoundBrand);
            this.get(search(newBrandID)).setPrice(price);
            System.out.println("The brand with ID " + newBrandID + " has been updated!");
        }
    }
}