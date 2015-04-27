/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aiassignment2;

/**
 *
 * @author Dihan
 */
public class RenkoBlock {
    
    private String color = "";
    private String date = "";
    private double price = 0; 
    private StockInfo stockInfo;

    public void setStockInfo(StockInfo i)
    {
        stockInfo =  i;
    }
    
    public StockInfo getStockInfo()
    {
        return stockInfo;
    }
    
    public void setColor(String c)
    {
        color = c;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public void setDate(String d)
    {
        date = d;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setPrice(double p)
    {
        price = p;
    }
    
    public double getPrice()
    {
        return price;
    }
    
}
