
package ryan.teamproject;
/*
 Meghan Ryan
 12/16/2021
 Player custom object to store player scores.
 */
public class player {
    private String name;
    private int memoScore;
    private int fishingScore;
    private int froggerScore;
    
    public player(String n,int mscore, int fishscore, int frogscore){
        setName(n);
        setMemoScore(mscore);
        setFishingScore(fishscore);
        setFroggerScore(frogscore);
    }
    
    public String getName(){
        return name;
    }
    public int getMemoScore(){
        return memoScore;
    }
    public int getFishingScore(){
        return fishingScore;
    }
    public int getFroggerScore(){
        return froggerScore;
    }
   
    public void setName(String n){
        name=n;
    }
    public void setMemoScore(int colourScore){
        memoScore=colourScore;
    }
    public void setFishingScore(int fishScore){
        fishingScore=fishScore;
    }
    public void setFroggerScore(int frogScore){
        froggerScore=frogScore;
    }
    
}
