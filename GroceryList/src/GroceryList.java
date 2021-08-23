import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GroceryList {
    public List<String> list;
    public List<Double> listNums;
    public String item;
    public int numberOfItems;

    public GroceryList(){
        //this.numberOfItems = numberOfItems;
        list = new ArrayList<>();
        listNums = new ArrayList<>();
        numberOfItems = 0;

    }

    public void printList(){
        for(int i = 0; i < list.size(); i++){
            System.out.println(listNums.get(i).intValue() + " " + list.get(i));
        }

    }
    public void addItem(String item){
        list.add(item);
        listNums.add(1.0);
    }
    public void updateItem(String item, Double value){
        int index = list.indexOf(item);
        listNums.set(index, listNums.get(index) + value);
    }
    public void deleteItem(String item){
        int index = list.indexOf(item);
        list.remove(index);
        listNums.remove(index);
    }
    public void addRecipe(GroceryList list, List<String> items, List<Double> nums){
        for(int i = 0; i < items.size(); i++){
            if(list.list.contains(items.get(i))){
                list.updateItem(items.get(i), nums.get(i));
            }
            else{
                list.addItem(items.get(i));
                list.updateItem(items.get(i), nums.get(i) - 1.0);
            }
        }
    }

    public void round(){
        for(int i = 0; i < listNums.size(); i++){
            listNums.set(i, Math.ceil(listNums.get(i)));
        }
    }

    public void writeList(String name){
        /*try{
            File file = new File(name);
            if(file.createNewFile()){
                System.out.println("Success");
            }
            else{
                System.out.println("The file already exists");
            }
        } catch (IOException e){
            System.out.println("An error occured. Try again.");
            e.printStackTrace();
        }*/
        try{
            FileWriter myWriter = new FileWriter(name + ".txt");
            myWriter.write("Grocery List" + "\n");
            for(int i = 0; i < list.size(); i++){
                myWriter.write(listNums.get(i).intValue() + " " + list.get(i) + "\n");
            }
            myWriter.close();
        }catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
