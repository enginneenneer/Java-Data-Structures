import Model.Food;
import Model.FoodBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RecipesBook {
    private FoodBook mFoodBook;
    private BufferedReader mReader;
    private Map<String, String> mMenu;

    public RecipesBook(FoodBook foodBook){
        mFoodBook = foodBook;
        mReader = new BufferedReader(new InputStreamReader(System.in));
        mMenu = new HashMap<String, String>();
        mMenu.put("0", "Quit");
        mMenu.put("1", "Add Recipe");
        mMenu.put("2", "Choose Recipe");
        mMenu.put("3", "Add Recipe to the wishlist");
    }

    private String menu() throws IOException{
        System.out.printf("%n%s recipes available. %nChoose from menu%n");
        for(Map.Entry<String, String> option : mMenu.entrySet()){
            System.out.printf("| %s %s %n", option.getKey(), option.getValue());
        }
        System.out.println("Choose:");
        String choice = mReader.readLine();
        return choice.trim().toLowerCase();
    }

    public void run(){
        String choice = "";
        do{
            try{
                choice = menu();
                switch(choice){
                    case "1":
                        Food food = returnNewRecipe();
                        mFoodBook.addFood(food);
                        System.out.printf("%s was added %n%n", food);
                        break;
                    case "2":
                        System.out.printf("Not available yet");
                        break;
                    case "3":
                        System.out.printf("Not available yet");
                        break;
                    case "0":
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.printf("Try again%n%n");
                }
            }catch(IOException ioe){
                System.out.println("Something went wrong with the input...");
                ioe.printStackTrace();
            }
        }while(!choice.equals("0"));
    }

    private Food returnNewRecipe() throws IOException{
        System.out.print("name = ");
        String name = mReader.readLine();
        System.out.print("Ingredients = ");
        String ingredients = mReader.readLine();
        System.out.print("Link for recipe = ");
        String link = mReader.readLine();
        return new Food(name, ingredients, link);
    }

}
