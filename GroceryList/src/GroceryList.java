import java.util.ArrayList;
import java.util.List;


public class GroceryList {
    public List<String> list;
    public List<Integer> listNums;
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
            System.out.println(listNums.get(i) + " " + list.get(i));
        }

    }
    public void addItem(String item){
        list.add(item);
        listNums.add(1);
    }
    public void updateItem(String item, int value){
        int index = list.indexOf(item);
        listNums.set(index, listNums.get(index) + value);
    }
    public void deleteItem(String item){
        int index = list.indexOf(item);
        list.remove(index);
        listNums.remove(index);
    }
    public void addRecipe(GroceryList list, List<String> items, List<Integer> nums){
        for(int i = 0; i < items.size(); i++){
            if(list.list.contains(items.get(i))){
                list.updateItem(items.get(i), nums.get(i));
            }
            else{
                list.addItem(items.get(i));
                list.updateItem(items.get(i), nums.get(i) - 1);
            }
        }
    }


}
