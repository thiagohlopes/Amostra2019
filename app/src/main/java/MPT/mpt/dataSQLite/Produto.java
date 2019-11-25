package MPT.mpt.dataSQLite;

public class Produto {

    private long id;
    private String market;
    private float price;
    private String name;
    private String type;
    private String timeStamp;
    private int amount;
    private String date_promotion;

    /*public Produto(float price, String name) {
        this.price = price;
        this.name = name;
        this.amount = amount;
        this.date_promotion= date_promotion;
    }*/

    public Produto(float price, long id, String timeStamp, String name, int amount, String date_promotion, String type, String market) {
        this.id = id;
        this.market = market;
        this.type = type;
        this.price = price;
        this.timeStamp = timeStamp;
        this.name = name;
        this.amount = amount;
        this.date_promotion=date_promotion;
    }

    public Produto() {
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate_promotion() {
        return date_promotion;
    }

    public void setDate_promotion(String date_promotion) {
        this.date_promotion = date_promotion;
    }

    public String getType() {        return type;    }

    public void setType(String type) {        this.type = type;    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", price=" + price +
                ", market=" + market +
                ", name='" + name + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", amount=" + amount +
                ", date_promotion='" + date_promotion + '\'' +
                '}';
    }
}
