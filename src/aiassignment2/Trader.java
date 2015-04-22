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
public class Trader {
    private double money = 100000; //Total money in rands
    private int shares = 0;
    
    
   
    public double getMoney()
    {
        return money;
    }
    
    public boolean buyShare(int sharePrice , int numberOfSharesBought) //Price is in cents
    {
        double tradeAmount = sharePrice * numberOfSharesBought;
        double STT = tradeAmount * 0.0025;
        double brokerageFee = tradeAmount * 0.005;
        double STRATE = 11.58;
        double IPL = tradeAmount * 0.0002;
        if(brokerageFee < 70)
            brokerageFee = 70;
        double VAT = 0.14 * (STT + brokerageFee + STRATE + IPL);
        
        double total = tradeAmount +STT +brokerageFee + STRATE + IPL + VAT;
        
        if(money*60 >= total )
        for(int k = 0 ; k < numberOfSharesBought ; k++)
        {
            shares++;
        }
        else
            return false;
        System.out.println(money);
        money  = (money * 60) - total;
        System.out.println(money);
        return true;
    }
    
    public boolean  sellShares()
    {
        
        
        return true;
    }
    
    public int getShares()
    {
        return shares;
    }
    
}
