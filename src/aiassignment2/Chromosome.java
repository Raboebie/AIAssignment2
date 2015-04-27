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
public class Chromosome {
    String lastFive = "";
    String tradeString;
    public Chromosome(String _lastFive, String _tradeString)
    {
        lastFive = _lastFive;
        tradeString = _tradeString;
    }
    
    public char getAction()
    {
        switch(lastFive){
            case "00000" : return tradeString.charAt(0);
            case "00001" : return tradeString.charAt(1);
            case "00010" : return tradeString.charAt(2);
            case "00011" : return tradeString.charAt(3);
            case "00100" : return tradeString.charAt(4);
            case "00101" : return tradeString.charAt(5);
            case "00110" : return tradeString.charAt(6);
            case "00111" : return tradeString.charAt(7);
            case "01000" : return tradeString.charAt(8);
            case "01001" : return tradeString.charAt(9);
            case "01010" : return tradeString.charAt(10);
            case "01011" : return tradeString.charAt(11);
            case "01100" : return tradeString.charAt(12);
            case "01101" : return tradeString.charAt(13);
            case "01110" : return tradeString.charAt(14);
            case "01111" : return tradeString.charAt(15);
            case "10000" : return tradeString.charAt(16);
            case "10001" : return tradeString.charAt(17);
            case "10010" : return tradeString.charAt(18);
            case "10011" : return tradeString.charAt(19);
            case "10100" : return tradeString.charAt(20);
            case "10101" : return tradeString.charAt(21);
            case "10110" : return tradeString.charAt(22);
            case "10111" : return tradeString.charAt(23);
            case "11000" : return tradeString.charAt(24);
            case "11001" : return tradeString.charAt(25);
            case "11010" : return tradeString.charAt(26);
            case "11011" : return tradeString.charAt(27);
            case "11100" : return tradeString.charAt(28);
            case "11101" : return tradeString.charAt(29);
            case "11110" : return tradeString.charAt(30);
            case "11111" : return tradeString.charAt(31);
        }
         return 'F';
    }
   
    
}
