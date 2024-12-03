package com.uade.tpo.ecommerce.dto;

import java.util.List;

public class PageDto<T> {
    private List<T> items;
    private int pageNumber;
    private int pageSize;
    private int totalPages;

    public PageDto(List<T> items, int pageNumber, int pageSize, int totalPages) {
        this.items = items;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
    }

    public List<T> getItems() {
        return items;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }
}
