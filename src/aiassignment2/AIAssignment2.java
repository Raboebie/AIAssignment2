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
public class AIAssignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      StockForm stock = new StockForm();
      stock.show();
      Trader trader = new Trader();
      trader.buyShare(7960, 100);
        
    }
    
}
