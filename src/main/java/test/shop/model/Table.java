package test.shop.model;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.24  13:10
 */
public class Table {

    private int totalSpend;    //总消费金额
    private int commodity;     //日用品金额
    private int electron;      //电器金额
    private int food;          //食物金额
    private int clothes;       //衣服金额

    public int getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(int totalSpend) {
        this.totalSpend = totalSpend;
    }

    public int getCommodity() {
        return commodity;
    }

    public void setCommodity(int commodity) {
        this.commodity = commodity;
    }

    public int getElectron() {
        return electron;
    }

    public void setElectron(int electron) {
        this.electron = electron;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getClothes() {
        return clothes;
    }

    public void setClothes(int clothes) {
        this.clothes = clothes;
    }
}
