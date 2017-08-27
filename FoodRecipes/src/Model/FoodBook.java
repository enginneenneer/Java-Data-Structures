package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FoodBook {
    private List<Food> fFoods;

    public FoodBook(){
        fFoods = new ArrayList<Food>();
    }

    public void exportFood(String fileName){
        try(
                FileOutputStream f = new FileOutputStream(fileName);
                PrintWriter writer = new PrintWriter(f);
                ){
            for(Food food : fFoods){
                writer.printf("%s-%s-%s%n",
                        food.getfName(), food.getfIngredients(), food.getfUrl());
            }
        }catch(IOException ioe){
                    System.out.printf("Error with the file %s %n", fileName);
                    ioe.printStackTrace();
        }
    }


    public void importFood(String fileName){
        try(
                FileInputStream s = new FileInputStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(s));
        ){
           String line;
           while((line = reader.readLine()) != null){
               String[] args = line.split("-");
               addFood(new Food(args[0], args[1], args[2]));
           }
        }catch(IOException ioe){
            System.out.printf("Eror with the file %s %n", fileName);
            ioe.printStackTrace();
        }
    }
    public void addFood(Food food){
        fFoods.add(food);
    }

    public int getFoodCount(){
        return fFoods.size();
    }

    //TODO loading books from file, make
}
