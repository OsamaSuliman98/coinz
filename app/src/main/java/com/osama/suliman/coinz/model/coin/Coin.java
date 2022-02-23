package com.osama.suliman.coinz.model.coin;

public class Coin {



    private int id ;
    private String name;
    private int img;
    private String price;
    private String trade;
    private int drawable ;


    public Coin() {
    }

    public Coin( String name, String price ) {
        this.name = name;
        this.price =price;
    }

    public Coin( String name, int img, String price  ) {
     this.name = name;
        this.img = img;
        this.price = price;
}

    public Coin( String name, int img, String price ,int drawable ) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.drawable =drawable ;
    }

    public Coin( int id ,String name, int img, String price, String trade) {
        this.id= id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.trade = trade;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }
}
