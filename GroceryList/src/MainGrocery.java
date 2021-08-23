import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainGrocery extends RecipeList{
    public static void main(String[] args){
        /* initializations of main variables*/
        GroceryList list = new GroceryList();
        RecipeList recipe = new RecipeList();
        File folder = new File("C:\\Users\\nicsl\\Desktop\\Recipes");
        File[] listOfFiles = folder.listFiles();

        /* reading all files for recipes*/
        for(int i = 0; i < listOfFiles.length; i++){
            String val = "";
            try {
                File myObj = listOfFiles[i];
                Scanner myReader = new Scanner(myObj);
                if(!myReader.hasNextLine()){
                    System.out.println("");
                }
                String recipeName = myReader.nextLine();
                recipe.createRecipe(recipeName);
                String data = myReader.nextLine();
                while (myReader.hasNextLine() && !data.equals("\n")) {
                    int counter = 0;
                    val = "";
                    while((int)data.charAt(counter) < 58 && (int)data.charAt(counter) > 47){
                        val += Character.toString(data.charAt(counter));
                        counter++;
                    }
                    int value = Integer.parseInt(val);
                    data = data.substring(counter);
                    recipe.addItem(recipeName, value, data);
                    data = myReader.nextLine();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        /* separation in between addition of recipes*/
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        /* adding recipes to grocery list*/
        System.out.println("Here is the list of recipes to choose from: ");
        Scanner input = new Scanner(System.in);
        int index = 0;
        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i < recipe.numOfRecipes; i++){
            System.out.println(i + ". " + recipe.recipes.get(i));
        }
        System.out.println("From the recipe list, please enter the index of the recipes you want for the list");
        System.out.println("Enter 0 to quit");
        index = Integer.parseInt(input.nextLine());
        while(index != 0){
            if(indices.contains(index)){
                System.out.println("You entered a recipe already on the list, if you would like continue, enter the index");
                System.out.println("If you entered it by accident, please enter the correct index");
                index = Integer.parseInt(input.nextLine());
            }
            try{
                list.addRecipe(list, recipe.recipeItems.get(recipe.recipes.get(index)), recipe.recipeNums.get(recipe.recipes.get(index)));
            }catch(IndexOutOfBoundsException e){
                System.out.println("The following index is not accepted. Please choose an index in the list");
                //e.printStackTrace();
            }
            indices.add(index);
            index = Integer.parseInt(input.nextLine());
        }
        System.out.println("");
        System.out.println("Here is your grocery list: ");
        list.printList();
    }
}
