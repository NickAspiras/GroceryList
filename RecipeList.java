import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipeList extends GroceryList{
    public HashMap<String, List<String>> recipeItems;
    public HashMap<String, List<Integer>> recipeNums;
    public List<String> recipes;
    public int numOfRecipes;

    public RecipeList(){
        recipeItems = new HashMap<>();
        recipeNums = new HashMap<>();
        recipes = new ArrayList<>();
        numOfRecipes = 0;
    }
    public void createRecipe(String name){
        List<String> recipe = new ArrayList<>();
        List<Integer> recipeVals = new ArrayList<>();
        if(recipeItems.containsKey(name)){
            System.out.println(" The following recipe already exists.");
        }
        else{
            recipeItems.put(name, recipe);
            recipeNums.put(name, recipeVals);
            numOfRecipes += 1;
            recipes.add(name);
            System.out.println("The recipe for " + name + " has been created.");
        }
    }

    public void addItem(String recipe, int value, String item){
        if(!recipeItems.containsKey(recipe)){
            System.out.println(" The following recipe does not exist.");
        }
        else{
            List<String> items = recipeItems.get(recipe);
            List<Integer> vals = recipeNums.get(recipe);
            if(items.contains(item)){
                System.out.println(item + " already exists in the recipe for " + recipe);
            }
            else{
                items.add(item);
                vals.add(value);
                recipeItems.put(recipe, items);
                recipeNums.put(recipe, vals);
                System.out.println(value + " " + item + " has been added to the " + recipe + " recipe");
            }
        }
    }

    public void removeItem(String recipe, String item){
        if(!recipeItems.containsKey(recipe)){
            System.out.println(" The following recipe does not exist.");
        }
        else{
            List<String> items = recipeItems.get(recipe);
            List<Integer> vals = recipeNums.get(recipe);
            if(!items.contains(item)){
                System.out.println(item + " does not exist in the recipe for " + recipe);
            }
            else{
                vals.remove(items.indexOf(item));
                items.remove(items.indexOf(item));
                //numOfRecipes -= 1;
                //recipes.remove(item);
                recipeItems.put(recipe, items);
                recipeNums.put(recipe, vals);
                System.out.println(item + " has been removed from the " + recipe + " recipe");
            }
        }
    }

    public void changeItemValue(String recipe, int value, String item){
        if(!recipeItems.containsKey(recipe)){
            System.out.println(" The following recipe does not exist.");
        }
        else{
            List<String> items = recipeItems.get(recipe);
            List<Integer> vals = recipeNums.get(recipe);
            int hold = 0;
            if(!items.contains(item)){
                System.out.println(item + " does not exist in the recipe for " + recipe);
            }
            else{
                hold = vals.get(items.indexOf(item));
                vals.set(items.indexOf(item), hold + value);
                recipeItems.put(recipe, items);
                recipeNums.put(recipe, vals);
                System.out.println(item + " has been removed from the " + recipe + " recipe");
            }
        }
    }
    public void printRecipe(String name){
        List<String> recipe = recipeItems.get(name);
        List<Integer> nums = recipeNums.get(name);
        System.out.println("Here is the recipe for " + name);
        for(int i = 0; i < recipe.size(); i++){
            System.out.println(nums.get(i) + " " + recipe.get(i));
        }

    }
    public static void main(String[] args){
        RecipeList recipe = new RecipeList();
        String name = "Aspa";
        recipe.createRecipe(name);
        recipe.printRecipe(name);
    }
}
