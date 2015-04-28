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

    private double money = 600000; //Total money in rands
    private int shares = 0;

    public String tradeString;

    public double getMoney() {
        return money;
    }

    public void setMoney(double m) {
        money = m;
    }

    public boolean buyShare(int sharePrice) //Price is in cents
    {
        double tradeAmount;
        double STT;
        double brokerage;
        double IPL;
        double VAT;
        double STRATE = 11.58 * 60;

        double total = 0;
        int sharesBought = 0;
        boolean flag = true;

        //Ensure trader can buy at least 1 share including transaction costs
        tradeAmount = 1 * sharePrice;
        STT = tradeAmount * 0.0025;
        brokerage = tradeAmount * 0.005;
        IPL = tradeAmount * 0.000002;
        if (brokerage < 70 * 60) {
            brokerage = 70 * 60;
        }

        VAT = 0.14 * (STT + brokerage + STRATE + IPL);

        if (tradeAmount + STT + brokerage + IPL + VAT + STRATE > money) {
            return true; //Not enough money to do transaction
        }
        sharesBought++;

        while (buyHelper(sharePrice, sharesBought) < money) //determine maximum shares purchasable
        {
            sharesBought++;
        }
        shares = sharesBought;
        setMoney(buyHelper(sharePrice, sharesBought));
        return true;
    }

    public double buyHelper(int sharePrice, int sharesBought) {
        double tradeAmount = sharesBought * sharePrice;
        double STT = tradeAmount * 0.0025;
        double brokerage = tradeAmount * 0.005;
        double IPL = tradeAmount * 0.000002;
        double STRATE = 11.58 * 60;
        double VAT = 0.14 * (STT + brokerage + STRATE + IPL);

        return tradeAmount + STT + brokerage + IPL + STRATE + VAT;
    }

    public boolean sellShares(int sharePrice) {
        if (shares == 0) {
            return true;
        }

        double tradeAmount;

        double brokerage;
        double IPL;
        double VAT;
        double STRATE = 11.58 * 60;
        double total = 0;
        int sharesSold = 0;

        for (int k = 0; k < shares; k++) {
            total += sharePrice;
            sharesSold++;
        }
        shares -= sharesSold;
        tradeAmount = sharePrice * sharesSold;
        brokerage = tradeAmount * 0.005;
        STRATE = 11.58 * 60;
        IPL = tradeAmount * 0.000002;
        VAT = 0.14 * (brokerage + STRATE + IPL);
        money = tradeAmount - brokerage - STRATE - IPL - VAT;

        return true;
    }

    public boolean hold() {
        return true;
    }

    public int getShares() {
        return shares;
    }

    public double getFitness(int currentPrice) {
        return Math.round((money) + (shares * currentPrice));
    }

}
