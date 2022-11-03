package model;

public class Table {

    private static Player ourPlayerModel = new Player(false, true, true);

    private static Player enemyPlayerModel = new Player(true, false, false);

    public static Player getOurPlayerModel() {
        return ourPlayerModel;
    }

    public static void setOurPlayerModel(Player ourModel) {
        ourPlayerModel = ourModel;
    }

    public Player getEnemyPlayerModel() {
        return enemyPlayerModel;
    }

    public void setEnemyPlayerModel(Player enemyModel) {
        enemyPlayerModel = enemyModel;
    }

//    public Table(Hand ourPlayerModel, Hand enemyPlayerModel) {
//        this.ourPlayerModel = ourPlayerModel;
//        this.enemyPlayerModel = enemyPlayerModel;
//    }

    public Table() {

    }

}
