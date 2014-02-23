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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The BasicStrategy class implements the full 468 cell
 * Basic Strategy card. The rules are implemented so that
 * they can be re-used.
 * 
 * @author Devin Young
 */
public class BasicStrategy implements IAdvisor {
    protected Map<ArrayList<Hand>, Play> stratCard;
    
    /**
     * Instantiates stratCard to hold the
     * basic strategy card.
     */
    public BasicStrategy(){
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
        //key: players hand/dealers up card
        //value: play to make
        //the strat card given is based on the first
        //two cards dealt and use must be altered for
        //subsequent hits after the first two cards
        //are dealt.
    }
}
