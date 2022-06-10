package team2.mobileapp.gplx.Retrofit.dto;

public class HistoryItem {

    private String CategoryName;

    public HistoryItem(String CategoryName) {
        this.CategoryName = CategoryName;

    }

    public HistoryItem() {
        this.CategoryName = "No name";
    }

    public String getCategoryName() {
        return this.CategoryName;
    }

    public void setCategoryName(String fullName) {
        this.CategoryName = fullName;
    }
}
