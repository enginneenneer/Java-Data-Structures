import Model.FoodBook;
import Recipes.RecipesBook;


public class App {
    public static void main(String[] args){
        FoodBook foodBook = new FoodBook();
        RecipesBook recipes = new RecipesBook(foodBook);
        foodBook.importFood("recipeIdeas.txt");
        recipes.run();
        foodBook.exportFood("recipeIdeas.txt");
    }
}
