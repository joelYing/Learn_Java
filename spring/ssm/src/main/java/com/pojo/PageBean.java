package com.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @PackageName com.pojo
 * @Author joel
 * @Date 2019/3/18 17:06
 **/
public class PageBean<T> implements Serializable {
    private int pageCode;
    private int totalPage;
    private int totalCount;
    private int pageSize;
    private List<T> beanList;
}
