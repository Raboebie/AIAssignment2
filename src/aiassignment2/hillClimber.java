/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiassignment2;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Dihan
 */
public class hillClimber {

    private LinkedList<RenkoBlock> renkoChart = new LinkedList<RenkoBlock>();
    private Trader bestTrader = null;

    //  private double bestFitness = 0;

    public hillClimber() {
    }

    public hillClimber(LinkedList<RenkoBlock> _renkoList) {
        renkoChart = _renkoList;
    }

    public void run() {
        boolean flag = true;

        Trader trader = new Trader();
        trader.tradeString = generateInitialString();
        bestTrader = trader;
        runTrade(trader);
        double initialFitness = trader.getFitness(renkoChart.get(renkoChart.size() - 1).getStockInfo()._closingPrice);
        int limit = 0;

        while (flag) {
            Trader newTrader = new Trader();
            newTrader.tradeString = getNeighbour(trader.tradeString);
            runTrade(newTrader);
            if (newTrader.getFitness(renkoChart.get(renkoChart.size() - 1).getStockInfo()._closingPrice) > bestTrader.getFitness(renkoChart.get(renkoChart.size() - 1).getStockInfo()._closingPrice)) {
                //New solution found
                bestTrader = new Trader();
                bestTrader.tradeString = newTrader.tradeString;
                runTrade(bestTrader);
                System.out.println("New best trader found " + bestTrader.tradeString + " with fitness of " + bestTrader.getFitness(renkoChart.get(renkoChart.size() - 1).getStockInfo()._closingPrice) / 60);
                limit = 0;
            } else {
                limit++;
                String oldString = trader.tradeString;
                trader = new Trader();
                trader.tradeString = getNeighbour(oldString);
                runTrade(trader);

                if (limit == 200) { //Ensure this value relates to neighnourhood function limitation
                    flag = false;
                }
            }
        }

        System.out.println("The best trader was: " + bestTrader.tradeString + " with a fitness of " + bestTrader.getFitness(renkoChart.get(renkoChart.size() - 1).getStockInfo()._closingPrice) / 60);
    }

    private String generateInitialString() {
        char[] chars = "BSH".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();

        return output;
    }

    private String getNeighbour(String traderString) {

        LinkedList<Character> temp = new LinkedList<>();
        for (int k = 0; k < traderString.length(); k++) {
            temp.add(traderString.charAt(k));
        }

        Random rand = new Random();
        int randomNumber = rand.nextInt((31 - 1) + 1) + 1;

        int pos1 = randomNumber;
        int pos2 = traderString.length() - randomNumber;

        //Switch values !!
        Character stored = new Character(temp.get(pos1));
        temp.set(pos1, temp.get(pos2));
        temp.set(pos2, stored);

        //Convert back to string
        String newtraderString = "";
        for (int j = 0; j < traderString.length(); j++) {
            newtraderString += temp.get(j);
        }
        return newtraderString;
    }

    private void runTrade(Trader trader) {
        String temp = "";
        for (int k = 5; k < renkoChart.size(); k++) { //Start trading after 5 days have passed

            LinkedList<RenkoBlock> lastFive = new LinkedList<RenkoBlock>();
            for (int j = k - 5; j < k; j++) {
                lastFive.add(renkoChart.get(j));
            }
            for (RenkoBlock block : lastFive) {
                String color = block.getColor();
                if (color.equals("black")) {
                    temp += "1";
                } else if (color.equals("white")) {
                    temp += "0";
                }
            }
            Chromosome chromosome = new Chromosome(temp, trader.tradeString);
            if (chromosome.getAction() == 'B') {
                int high = renkoChart.get(k).getStockInfo()._highPrice;
                int low = renkoChart.get(k).getStockInfo()._lowPrice;
                int average = (high + low) / 2;
                trader.buyShare(average);
            } else if (chromosome.getAction() == 'S') {
                int high = renkoChart.get(k).getStockInfo()._highPrice;
                int low = renkoChart.get(k).getStockInfo()._lowPrice;
                int average = (high + low) / 2;
                trader.sellShares(average);
            } else if (chromosome.getAction() == 'H') {
                trader.hold();
            }
            temp = "";
        }
    }

}
