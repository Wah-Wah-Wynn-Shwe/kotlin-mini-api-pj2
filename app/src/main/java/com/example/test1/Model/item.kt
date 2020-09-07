package com.example.test1.Model
import com.google.gson.annotations.SerializedName




class item {
    @SerializedName("status")
    private var status: String?= null

    @SerializedName("totalReults")
    private var totalReults: String? = null

    @SerializedName("articles")
    private var articles: String? = null



    fun getStatus(): String? {
        return status

    }

    fun setStatus(status: String) {
        this.status = status
    }

    fun getTotalresults(): String?
    {
        return totalReults
    }

    fun setTotalresults(totalresults: String) {
        this.totalReults = totalReults
    }

    fun getArticles(): String? {
        return articles

    }

    fun setArticles(articles: String) {
        this.articles = articles
    }





}