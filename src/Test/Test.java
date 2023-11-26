package Test;
import assignment5.Brand;
import assignment5.BrandFunction1;
import assignment5.Car;
import assignment5.CarFunction1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;        
        BrandFunction1 brandList = new BrandFunction1();
        brandList.readFile("brands.txt");
        CarFunction1 carList = new CarFunction1(brandList);
        carList.readFile("cars.txt");
        do{
            System.out.println("1- List all brands: ");
            System.out.println("2- Add a new brand: ");
            System.out.println("3- Search a brand based on its ID : ");
            System.out.println("4- Update a brand: ");
            System.out.println("5- Save brands to the file, named brands.txt : ");
            System.out.println("6- List all cars in ascending order of brand names : ");
            System.out.println("7- List cars based on a part of an input brand name: ");
            System.out.println("8- Add a car: ");
            System.out.println("9- Remove a car based on its ID: ");
            System.out.println("10- Update a car based on its ID: ");
            System.out.println("11- Save cars to file, named cars.txt: ");
            System.out.print("ENTER YOUR CHOICES: ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
            case 1:
               brandList.f1();
               break;  
            case 2:
               brandList.f2();
               break;
            case 3:
                brandList.f3(brandList);
                break;
            case 4:
               brandList.f4();
                break;
            case 5:
                brandList.saveFile("brands.txt");                  
                break; 
            case 6:
                carList.f6();
                break;
            case 7:
                carList.f7();
                break;
            case 8:
                carList.f8(brandList);
                break;
            case 9:
                carList.f9();
                break;
            case 10:
                carList.f10();
                break;
            case 11:
                carList.saveFile("cars.txt");
                break;
            default:
                System.out.println("Done!");
                return ;
        }
        }
        while(choice>=1&&choice<=11);
    }
}
