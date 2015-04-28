/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiassignment2;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author dihan
 */
public class GA {
    private LinkedList<RenkoBlock> renkoChart = new LinkedList<RenkoBlock>();
    private final int generations;
    private final double mutationRate;
    private final double crossoverProb;
    private final int populationSize;
    private  char selectionStrategy = 'R';
    private  char crossoverStrategy = 'O';
    private final int tournamentSize;
    private LinkedList<Trader> newPopulation = new LinkedList<>();
    
    
    
    
    
    public GA(LinkedList<RenkoBlock> list, int _generations, double _mutationRate, double _crossoverProb, int _populationSize, char _selectionStrategy, char _crossoverStrategy, int _tournamentSize) {
        renkoChart = list;
        generations = _generations;
        mutationRate = _mutationRate;
        crossoverProb = _crossoverProb;
        populationSize = _populationSize;
        selectionStrategy = _selectionStrategy;
        crossoverStrategy = _crossoverStrategy;
        tournamentSize = _tournamentSize;

        for (int k = 0; k < populationSize; k++) {
            char[] chars = "BSH".toCharArray();
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < 32; i++) {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            String output = sb.toString();
            Trader trader  = new Trader();
            trader.tradeString = output;
            runTrade(trader);
            newPopulation.add(trader);
        }
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
