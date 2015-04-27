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
public class StockInfo {
    
    String _date;
    int _closingPrice;
    int _highPrice;
    int _lowPrice;
    StockInfo(String date, int closingPrice , int highPrice , int lowPrice )
    {
        //System.out.println("Date: "+date + ",closingPrice: " + closingPrice + ",hightPrice: " + highPrice + ",lowPrice: " + lowPrice);
        _date = date;
        _closingPrice = closingPrice;
        _highPrice = highPrice;
        _lowPrice = lowPrice;
    }
}
