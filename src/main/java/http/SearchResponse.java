package http;

import java.util.List;

public class SearchResponse {

    private int totalResults;
    private String query;
    private List<SlipDto> slips;

    public SearchResponse(int totalResults, String query, List<SlipDto> slips) {
        this.totalResults = totalResults;
        this.query = query;
        this.slips = slips;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<SlipDto> getSlips() {
        return slips;
    }

    public void setSlips(List<SlipDto> slips) {
        this.slips = slips;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "totalResults=" + totalResults +
                ", query='" + query + '\'' +
                ", slips=" + slips +
                '}';
    }
}
