package Utils;

import java.util.List;

public class CSVResult {
    private List<City> cities;
    //private int mergeCount;

    /*---------*/
    private int regularMergeCount;
    private int shuffledMergeCount;

    private int regularQuickSortCount;
    private int shuffledQuickSortCount;

    public CSVResult(List<City> cities, int regularQuickSortCount, int shuffledQuickSortCount, int regularMergeCount, int shuffledMergeCount) {
        this.cities = cities;
        //this.mergeCount = mergeCount;
        this.regularQuickSortCount = regularQuickSortCount;
        this.shuffledQuickSortCount = shuffledQuickSortCount;
        this.regularMergeCount = regularMergeCount;
        this.shuffledMergeCount = shuffledMergeCount;
    }

  /*  public CSVResult(List<City> cities, int regularMergeCount, int shuffledMergeCount){
        this.cities = cities;
        this.regularMergeCount = regularMergeCount;
        this.shuffledMergeCount = shuffledMergeCount;
    }
    public CSVResult(List<City> cities, int regularQuickSortCount, int shuffledQuickSortCount) {
        this.cities = cities;
        this.regularQuickSortCount = regularQuickSortCount;
        this.shuffledQuickSortCount = shuffledQuickSortCount;
    }*/

    public List<City> getCities() {
        return cities;
    }
    public int getRegularMergeCount(){
        return regularMergeCount;
    }
    public int getShuffledMergeCount(){
        return shuffledMergeCount;
    }
    public int getRegularQuickSortCount() {
        return regularQuickSortCount;
    }

    public int getShuffledQuickSortCount() {
        return shuffledQuickSortCount;
    }
}

