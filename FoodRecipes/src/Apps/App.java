import Model.FoodBook;

public class App {
    public static void main(String[] args){
        FoodBook foodBook = new FoodBook();
        foodBook.importFood("recipeIdeas.txt");
        System.out.printf("There are %d food ideas", foodBook.getFoodCount());
        foodBook.exportFood("recipeIdeas.txt");
    }
}
