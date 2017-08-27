package Model;

public class Food {
    private String fName;
    private String fIngredients;
    private String fUrl;

    public Food (String name, String ingredients, String link){
        fName = name;
        fIngredients = ingredients;
        fUrl = link;
    }

    public String getfName(){   return fName;   }
    public String getfIngredients(){    return fIngredients;    }
    public String getfUrl(){    return fUrl;    }
}
