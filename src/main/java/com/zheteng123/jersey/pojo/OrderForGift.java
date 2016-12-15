package com.zheteng123.jersey.pojo;

/**
 * Created by feige_com on 2016/12/15.
 */
public class OrderForGift {


    public Integer getSore_score() {
        return sore_score;
    }

    public void setSore_score(Integer sore_score) {
        this.sore_score = sore_score;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    private Integer store_id;
    private Integer sore_score;

    public Integer getShow_score() {
        return show_score;
    }

    public void setShow_score(Integer show_score) {
        this.show_score = show_score;
    }

    public Integer getShow_me() {
        return show_me;
    }

    public void setShow_me(Integer show_me) {
        this.show_me = show_me;
    }

    private Integer show_me;
    private Integer show_score;
}
