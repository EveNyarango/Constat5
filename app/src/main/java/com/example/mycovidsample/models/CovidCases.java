
package com.example.mycovidsample.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CovidCases implements Serializable
{

    @SerializedName("All")
    @Expose
    private All all;
    private final static long serialVersionUID = -3581141855593626492L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CovidCases() {
    }

    /**
     * 
     * @param all
     */
    public CovidCases(All all) {
        super();
        this.all = all;
    }

    public All getAll() {
        return all;
    }

    public void setAll(All all) {
        this.all = all;
    }

}
