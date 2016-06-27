package com.haozhang.rest.modle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HaoZhang
 * @date 2016/6/27.
 */
public class BaseData<T> implements Serializable {

    @SerializedName("error")
    @Expose
    private Boolean error;

    @SerializedName("results")
    @Expose
    private List<T> results = new ArrayList<T>();

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
    public List<T> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "error :"+error+", results : "+results;
    }
}
