import java.util.List;

class Item {
    String name;
    String barcode; //numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){
        if (allItems == null){
            throw new RuntimeException("allItems list can't be null!");
        }

        float sum = 0;       //3
              //4.1       4.2                4.3
        for (int i = 0; i < allItems.size(); i++){
            Item item = allItems.get(i); //5
            if (item.getName() == null || item.getName().length() == 0){  //6
                item.setName("unknown"); //7
            }
             if (item.getBarcode() != null){ //8
                String allowed = "0123456789";//9
                char chars[] = item.getBarcode().toCharArray(); //10
                       //11.1           11.2                    11.3
                for (int j = 0; j < item.getBarcode().length(); j++){
                    char c = item.getBarcode().charAt(j);//12
                    if (allowed.indexOf(c) == -1)//13
                         {
                        throw new RuntimeException("Invalid character in item barcode!"); //14
                    }
                }
                if (item.getDiscount() > 0) { //15
                    sum += item.getPrice()*item.getDiscount(); //16
                }
                else {
                    sum += item.getPrice();//17
                }
            }
            else {
                throw new RuntimeException("No barcode!");//18
            }
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//19
                sum -= 30; //20
            }
        }
        if (sum <= payment){ //21
            return true; //22
        }
        else {
            return false;//23
        }
    }
}