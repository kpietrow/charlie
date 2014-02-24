/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charlie.advisor;

import charlie.card.Card;
import charlie.card.Hand;
import charlie.plugin.IAdvisor;
import charlie.util.Play;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The BasicStrategy class implements the full 468 cell
 * Basic Strategy card. The rules are implemented so that
 * they can be re-used.
 * 
 * @author Devin Young
 */
public class BasicStrategy implements IAdvisor {
   static {
        Properties props = System.getProperties();
        props.setProperty("org.slf4j.simpleLogger.logFile", "System.out");
        props.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "info");
        props.setProperty("org.slf4j.simpleLogger.showDateTime", "true");
        props.setProperty("org.slf4j.simpleLogger.dateTimeFormat","HH:mm:ss");
    }
    protected final Logger LOG = LoggerFactory.getLogger(BasicStrategy.class);
    protected Map<String, Play> stratCard;
    
    /**
     * Instantiates stratCard to hold the
     * basic strategy card.
     */
    public BasicStrategy(){
        //LOG.info("please");
        stratCard = new HashMap<>();
        buildStratCard();
    }
    /**
     * The advise method takes as parameters the human 
     * player's hand and the dealers up card and returns
     * NONE, HIT, STAY, DOUBLE_DOWN, or SPLIT
     * 
     * @param myHand
     *          the human player's hand
     * @param upCard
     *          the dealer's up-card
     * @return Play
     *          an enumerated type in the charlie.util.package
     */
    @Override
    public Play advise(Hand myHand,Card upCard){
        //LOG.info("******************************************************");
        return getPlay(myHand, upCard);
    }
    
    /**
     * The getPlay method takes as parameters the human 
     * player's hand and the dealers up card and returns
     * NONE, HIT, STAY, DOUBLE_DOWN, or SPLIT
     * 
     * @param myHand
     *          the human player's hand
     * @param upCard
     *          the dealer's up-card
     * @return Play
     *          an enumerated type in the charlie.util.package
     */
    public Play getPlay(Hand myHand,Card upCard){
        return Play.HIT;
    }
    
    /**
     * Helper method to build the basic strategy card.
     */
    private void buildStratCard() {
        //key: playersHandValue.playersFirstCard.PlayersSecondCard.upCard
        //value: play to make
        //in the advise method, we will get the value of the players hand and 
        //the cards that are in the players hand and use that as the key to 
        //get the play to make from the hashmap. If the player is seeking
        //advice on a hand that has 3 or more cards then, advice from only
        //the top two segments (5 - 17+) of the basic stratgey chart will be used. 
        for (int i = 2; i < 12; i++)
            for (int j = 2; j < 12; j++)
                for (int k = 2; k < 12; k++){
                    int pHandValue = i + j;
                    String totalHandValue = Integer.toString(pHandValue);
                    String pCard1 = Integer.toString(i);
                    String pCard2 = Integer.toString(j);
                    String upCard = Integer.toString(k);
                    String hashKey = totalHandValue + "." + pCard1 + "." + pCard2 + "." + upCard;
                    
                    switch (pHandValue){
                        case 4:
                            if (k >= 2 && k <= 7)
                                stratCard.put(hashKey, Play.SPLIT);
                            else
                                stratCard.put(hashKey, Play.HIT);
                            break;
                        case 5:
                            stratCard.put(hashKey, Play.HIT);
                            break;
                        case 6:
                            if (i == 3 && j == 3 && k >= 2 && k <= 7)
                                stratCard.put(hashKey, Play.SPLIT);
                            else
                                stratCard.put(hashKey, Play.HIT);
                            break;
                        case 7:
                            stratCard.put(hashKey, Play.HIT);
                            break;
                        case 8:
                            if (i == 4 && j == 4 && k >= 5 && k <= 6)
                                stratCard.put(hashKey, Play.SPLIT);
                            else
                                stratCard.put(hashKey, Play.HIT);
                            break;
                        case 9:
                            if (k >= 3 && k <= 6)
                                stratCard.put(hashKey, Play.DOUBLE_DOWN);
                            else
                                stratCard.put(hashKey, Play.HIT);
                            break;
                        case 10:
                            if (k >= 2 && k <= 9)
                                stratCard.put(hashKey, Play.DOUBLE_DOWN);
                            else 
                                stratCard.put(hashKey, Play.HIT);
                            break;
                        case 11:
                            if (k >= 2 && k <= 10)
                                stratCard.put(hashKey, Play.DOUBLE_DOWN);
                            else 
                                stratCard.put(hashKey, Play.HIT);
                            break;
                        case 12:
                            if (i == 6 && j == 6 && k >= 2 && k <= 6)
                                stratCard.put(hashKey, Play.SPLIT);
                            else if (k >= 4 && k <= 6)
                                stratCard.put(hashKey, Play.STAY);
                            else 
                                stratCard.put(hashKey, Play.HIT);
                            break;
                        case 13:
                            if (i == 11 && j == 2 && k >= 5 && k <= 6)
                                stratCard.put(hashKey, Play.DOUBLE_DOWN);
                            else if (k >= 2 && k <= 6)
                                stratCard.put(hashKey, Play.STAY);
                            else 
                                stratCard.put(hashKey, Play.HIT);
                            break;
                        case 14:
                            if (i == 7 && j == 7 && k >= 2 && k <= 7)
                                stratCard.put(hashKey, Play.SPLIT);
                            else if (k >= 5 && k <= 6)
                                stratCard.put(hashKey, Play.DOUBLE_DOWN);
                            else if (k >= 2 && k <= 6)
                                stratCard.put(hashKey, Play.STAY);
                            else 
                                stratCard.put(hashKey, Play.HIT);
                            break;
                        case 15:
                            if (i == 11 && j == 4 && k >= 4 && k <= 6)
                                stratCard.put(hashKey, Play.DOUBLE_DOWN);
                            else if (k >= 2 && k <= 6)
                                stratCard.put(hashKey, Play.STAY);
                            else 
                                stratCard.put(hashKey, Play.HIT);
                            break;
                        case 16:
                            if (i == 8 && j == 8)
                                stratCard.put(hashKey, Play.SPLIT);
                            else if (i == 11 && j == 5 && k >= 4 && k <= 6)
                                stratCard.put(hashKey, Play.DOUBLE_DOWN);
                            else if (k >= 2 && k <= 6)
                                stratCard.put(hashKey, Play.STAY);
                            else 
                                stratCard.put(hashKey, Play.HIT);
                            break;
                        case 17:
                            if (i == 11 && j == 6 && k >= 3 && k <= 6)
                                stratCard.put(hashKey, Play.DOUBLE_DOWN);
                            else if (i == 11 && j == 6 && k < 3 || k > 6)
                                stratCard.put(hashKey, Play.HIT);
                            else
                                stratCard.put(hashKey, Play.STAY);
                            break;
                        case 18:
                            if (i == 9 && j == 9 && (k >= 2 && k <= 6 || k == 8 || k == 9))
                                stratCard.put(hashKey, Play.SPLIT);
                            else if (i == 11 && j == 6 && k >= 3 && k <= 6)
                                stratCard.put(hashKey, Play.DOUBLE_DOWN);
                            else if (i == 11 && j == 6 && k < 3 && k > 6)
                                stratCard.put(hashKey, Play.HIT);
                            else 
                                stratCard.put(hashKey, Play.STAY);
                            break;
                        default:
                            stratCard.put(hashKey, Play.STAY);
                            break;
                    }
                    
                    //LOG.info("***********************" + hashKey);
              
                }
    }
}
