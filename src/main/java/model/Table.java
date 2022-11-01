package model;

public class Table {

    private Hand ourPlayerModel;

    private Hand enemyPlayerModel;

    public Hand getOurPlayerModel() {
        return ourPlayerModel;
    }

    public void setOurPlayerModel(Hand ourPlayerModel) {
        this.ourPlayerModel = ourPlayerModel;
    }

    public Hand getEnemyPlayerModel() {
        return enemyPlayerModel;
    }

    public void setEnemyPlayerModel(Hand enemyPlayerModel) {
        this.enemyPlayerModel = enemyPlayerModel;
    }

    public Table(Hand ourPlayerModel, Hand enemyPlayerModel) {
        this.ourPlayerModel = ourPlayerModel;
        this.enemyPlayerModel = enemyPlayerModel;
    }

    public Table() {

    }

}
