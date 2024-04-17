/* The Montagues and Capulets are two prominent families in Verona that are feuding. 
 * To settle a dispute they call a moot which consists of members of both families.
 * To settle the dispute they decided to implement the following procedure.
 * They follow a round-based procedure where each participant takes a turn.
 * On each turn, a family member can do one of the following:
 *  1) Kick – The person can make an individual lose all their rights in this and all the following rounds.
 *  2) Declare Victory – if the proceedings have reached a point where all members who still have rights
 *     are all from the same family, victory can be declared.
 * The family members and the order they take a turn are represented by a string consisting of characters 'M' and 'C',
 * representing Montagues and Capulets. That is, if there are n family members at the moot, the size of the given string will be n.
 * Each round starts with the first family member and goes to the last senator in the given order.
 * This process will last until the end of voting.
 * All family members who have lost their rights will be skipped during the procedure.
 * Suppose every participant will play the best strategy.
 * Predict which family will declare victory.
 * 
 * Example.  “MC”
 * Montague Victory!
 * 
 * Example. “MCC”
 * Capulet Victory
 */

public class Verona {
    public static void main(String[] args) {
        System.out.println("Test 1: MC");
        moot("MC");
    }

    public static void moot(String order){
        if(order.length() == 1){
            System.out.println("Winner: " + order);
        }
        else{
            String[] rights = new String[order.length()];
            for(int i = 0; i < order.length(); i++){
                rights[i] = String.valueOf(order.charAt(i));
            }
            String kill = "";
            if(rights[0].equals("M")){
                kill = "C";
            }
            else{
                kill = "M";
            }
            boolean kicked = false;
            int index = 1;
            while(!kicked && index < order.length()){
                if(rights[index].equals(kill)){
                    kicked = true;
                    order = order.substring(0, index) + order.substring(index+1);
                }
                index++;
            }
            if(kicked == false){
                System.out.println("Winner: " + rights[0]);
            }
            else{
                if(order.length() > 1){
                    order = order.substring(1) + rights[0];
                }
                moot(order);
            }
        }
    }
}
