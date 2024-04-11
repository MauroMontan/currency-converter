package models;

import java.io.Serializable;
import java.util.List;

public class Currency {
    int page;
    int totalPages;
    List results;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }

    public Currency(){

    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
