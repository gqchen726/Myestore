package com.briup.estore.bean;

import java.io.Serializable;

public class OrderLine implements Serializable {
    private Integer id;

    private Integer num;

    private Double cost;

    private Integer bookId;

    private Integer orderformId;

    private static final long serialVersionUID = 1L;

    private Book book;
    
    public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getOrderformId() {
        return orderformId;
    }

    public void setOrderformId(Integer orderformId) {
        this.orderformId = orderformId;
    }

    @Override
	public String toString() {
		return "OrderLine [id=" + id + ", num=" + num + ", cost=" + cost + ", bookId=" + bookId + ", orderformId="
				+ orderformId + ", book=" + book + "]";
	}

}