package com.suah.shoppingmall.interfaces;

public interface IResult<T> {
    T getResult();

    String getResultName();

    void setResult(T t);
}
