package com.haozhang.rest.modle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HaoZhang
 * @date 2016/6/23.
 */
public class SearchDatas {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("results")
    @Expose
    private List<SearchItemDatas> results = new ArrayList<SearchItemDatas>();

    /**
     *
     * @return
     * The error
     */
    public Boolean getError() {
        return error;
    }

    /**
     *
     * @param error
     * The error
     */
    public void setError(Boolean error) {
        this.error = error;
    }

    /**
     *
     * @return
     * The results
     */
    public List<SearchItemDatas> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<SearchItemDatas> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "error :"+error+", results : "+results;
    }
 /*
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(error).append(results).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Example) == false) {
            return false;
        }
        SearchDatas rhs = ((SearchDatas) other);
        return new EqualsBuilder().append(error, rhs.error).append(results, rhs.results).isEquals();
    }
*/
}