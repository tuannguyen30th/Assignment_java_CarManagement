package assignment5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ADMIN
 */
public class CarFunction1 extends ArrayList<Car> {
    BrandFunction1 bList;
    Scanner sc = new Scanner(System.in);
    public CarFunction1(BrandFunction1 arr) {
        bList = arr;
    }
    public boolean readFile(String fileName){
        try {
            File f = new File(fileName);
            if (!f.exists())
                return false;
            else {
                FileReader fr = new FileReader(f);
                BufferedReader bf = new BufferedReader(fr);
                String s;
                while ((s = bf.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(s, ",");
                    String carID = stk.nextToken().trim().toUpperCase();
                    String brandID = stk.nextToken().trim().toUpperCase();
                    String color = stk.nextToken().trim();
                    String frameID = stk.nextToken().trim().toUpperCase();
                    String engineID = stk.nextToken().trim().toUpperCase();
                    Brand b = bList.get(bList.search(brandID));
                    this.add(new Car(carID, b, color, frameID, engineID));
                }
                bf.close();
                fr.close();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
    public boolean saveFile(String fileName) {
        if (this.size() == 0) { 
            System.out.println("Empty list!");
            return false;
        }
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Car i: this)
                pw.println(i.toString());
            pw.close();
            fw.close();
        }  
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
    public int searchID(String carID) {
       for (int i = 0; i < this.size(); i++)
           if (this.get(i).getCarID().equals(carID.toUpperCase()))
               return i;
       return -1;
    }
    public int searchFrame(String fID) {
       for (int i = 0; i < this.size(); i++)
           if (this.get(i).getFrameID().equals(fID.toUpperCase()))
               return i;
       return -1;
    }
    public int searchEngine(String eID) {
       for (int i = 0; i < this.size(); i++)
           if (this.get(i).getEngineID().equals(eID.toUpperCase()))
               return i;
       return -1;
    }
    public String inputColor1(){
        boolean kt;
        String newColor = null;
        do{
            try{
                newColor = sc.nextLine();
                if(newColor.compareToIgnoreCase("yellow")!=0 && newColor.compareToIgnoreCase("black")!=0)
                    throw new Exception();
                kt=true;
            }
            catch(Exception e){
                System.out.println("Enter color again!");
                kt = false;
            }
        }while(kt==false);
        return newColor;
    }
        public String inputColor2(){
        boolean kt;
        String newColor = null;
        do{
            try{
                newColor = sc.nextLine();
                if(newColor.compareToIgnoreCase("brown")!=0 && newColor.compareToIgnoreCase("black")!=0)
                    throw new Exception();
                kt=true;
            }
            catch(Exception e){
                System.out.println("Enter color again!");
                kt = false;
            }
        }while(kt==false);
        return newColor;
    }
    public void f6() {
        Collections.sort(this, new BrandNameComparator());
        for (Car o : this) {
            System.out.println(o.sString());
        }
    }
    public void f7() {
        System.out.print("Enter part of brand name: ");
        String aPartOfBrandName = sc.nextLine();
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            Car c = this.get(i);
            if (c.getBrand().getBrandName().contains(aPartOfBrandName)) {
                System.out.println(c.stf7String());
                count++;
            }
        }
        if (count == 0)
            System.out.println("No result!");
    }
    public void f8(ArrayList<Brand> arr){
        String newCarID, newColor, newFrameID, newEngineID;
        System.out.println("Enter the car detail:");
        while (true) {
            System.out.print("  Car ID: ");
            newCarID = sc.nextLine().toUpperCase();
            if (searchID(newCarID) >= 0)
                System.out.println("The car ID is duplicated!");
            else
                break;
        }
        Brand b = new Brand();
        System.out.println("  Brand:");
        int k;
        for (int i = 0; i < bList.size(); i++)
            System.out.println((i + 1) + " " + bList.get(i));
        do {
            System.out.print("Choose brand (enter number): ");
            k = Integer.parseInt(sc.nextLine());
        }
        while (k < 0 || k > bList.size());
        b = bList.get(k-1);
        do {
            System.out.print("  Color (Yellow/Black): ");
            newColor = inputColor1();
            if (newColor.length() == 0)
                System.out.println("    The color is empty!");
        }
        while (newColor.length() == 0);
        while (true) {
            System.out.print("  Frame ID (format F00000): ");
            newFrameID = sc.nextLine().toUpperCase();
            if (searchFrame(newFrameID) >= 0)
                System.out.println("    The frame ID is duplicated!");
            else
                if (!newFrameID.matches("[F][0-9]{5}"))
                    System.out.println("    The frame ID: F and 5 digits!");     
                else
                    break;
        }
        while (true) {
            System.out.print("  Engine ID (format E00000): ");
            newEngineID = sc.nextLine().toUpperCase();
            if (searchEngine(newEngineID) >= 0)
                System.out.println("    The engine ID is duplicated!");
            else
                if (!newEngineID.matches("[E][0-9]{5}"))
                    System.out.println("    The engine ID: E and 5 digits!");     
                else
                    break;
        }
        this.add(new Car(newCarID, b, newColor, newFrameID, newEngineID));
        System.out.println("New car has been added!");
    }
    public boolean f9() {
        System.out.print("Enter removed car's ID: ");
        String removedID = sc.nextLine().toUpperCase();
        if (searchID(removedID) < 0) {
            System.out.println("Not found!");
            return false;
        }
        else
            this.remove(searchID(removedID));
        System.out.println("Remove successfully.");
        return true;
    }
    public boolean f10() {
        String newColor, newFrameID, newEngineID;
        System.out.print("Enter updated car's ID: ");
        String carID = sc.nextLine().toUpperCase();
        if (searchID(carID) < 0) {
            System.out.println("Not found!");
            return false;
        }
        else {
            System.out.println("  New brand: ");
            Brand b = new Brand();
            int k;
            for (int i = 0; i < bList.size(); i++)
                System.out.println((i + 1) + " " + bList.get(i));
            do {
                System.out.print("Choose brand (enter number): ");
                k = Integer.parseInt(sc.nextLine());
            }
            while (k < 0 || k > bList.size());
            b = bList.get(k-1);
            do {
                System.out.print("  New color (black/ brown): ");
                newColor = inputColor2();
                if (newColor.length() == 0)
                    System.out.println("    The color is empty!");
            }
            while (newColor.length() == 0);
            while (true) {
                System.out.print("  Frame ID (format F00000): ");
                newFrameID = sc.nextLine().toUpperCase();
                if (searchFrame(newFrameID) >= 0)
                    System.out.println("    The frame ID is duplicated!");
                else
                    if (!newFrameID.matches("[F][0-9]{5}"))
                        System.out.println("    The frame ID: F and 5 digits!");     
                    else
                        break;
            }
            while (true) {
                System.out.print("  Engine ID (format E00000): ");
                newEngineID = sc.nextLine().toUpperCase();
                if (searchEngine(newEngineID) >= 0)
                    System.out.println("    The engine ID is duplicated!");
                else
                    if (!newEngineID.matches("[E][0-9]{5}"))
                        System.out.println("    The engine ID: E and 5 digits!");     
                    else
                        break;
            }
            this.get(searchID(carID)).setBrand(b);
            this.get(searchID(carID)).setColor(newColor);
            this.get(searchID(carID)).setFrameID(newFrameID);
            this.get(searchID(carID)).setEngineID(newEngineID);
            System.out.println("The car " + carID + " has been updated!");
            return true;
        }
}
}