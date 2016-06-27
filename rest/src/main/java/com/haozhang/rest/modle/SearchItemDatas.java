package com.haozhang.rest.modle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author HaoZhang
 * @date 2016/6/23.
 */
public class SearchItemDatas {

    @SerializedName("desc")
    @Expose
    private String desc;

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;

    @SerializedName("readability")
    @Expose
    private String readability;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("url")
    @Expose
    private String url;


    @SerializedName("used")
    @Expose
    private Boolean used;


    @SerializedName("who")
    @Expose
    private String who;


    /**
     *
     * @return
     * The desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     *
     * @param desc
     * The desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     *
     * @return
     * The publishedAt
     */
    public String getPublishedAt() {
        return publishedAt;
    }

    /**
     *
     * @param publishedAt
     * The publishedAt
     */
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The used
     */
    public Boolean getUsed() {
        return used;
    }

    /**
     *
     * @param used
     * The used
     */
    public void setUsed(Boolean used) {
        this.used = used;
    }

    /**
     *
     * @return
     * The who
     */
    public String getWho() {
        return who;
    }

    public String getReadability() {
        return readability;
    }

    public void setReadability(String readability) {
        this.readability = readability;
    }

    /**
     *
     * @param who
     * The who
     */
    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public String toString() {
        return "desc : ["+desc+"], readability : ["+readability+"] , who: ["+who+"], type : ["+type+"], ";
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