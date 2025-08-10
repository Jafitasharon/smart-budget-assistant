package model;

public class Transaction {
    private int id;
    private String type; // "income" or "expense"
    private double amount;
    private String category;
    private String date;

    public Transaction(int id, String type,double amount,String category,String date){
        this.id=id;
        this.type=type;
        this.amount=amount;
        this.category=category;
        this.date=date;
    }
    public int getId() {return id;}
    public String getType(){return type;}
    public double getAmount(){return amount;}
    public String getCategory(){return category;}
    public String getDate(){return date;}

public void setId(int id) {this.id = id;}
    public void setType(String type) {this.type = type;}
    public void setAmount(double amount) {this.amount = amount;}
    public void setCategory(String category) {this.category = category;}
    public void setDate(String date) {this.date = date;}

}