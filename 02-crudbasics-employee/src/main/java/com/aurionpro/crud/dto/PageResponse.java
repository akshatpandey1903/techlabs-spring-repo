package com.aurionpro.crud.dto;

import java.util.List;

public class PageResponse<T> {
	
	private List<T> content;
	private int totalPages;
	private long totalElements;
	private int pageSize;
	private boolean last;
	
	public PageResponse(List<T> content, int totalPages, long totalElements, int pageSize, boolean last) {
		super();
		this.content = content;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
		this.pageSize = pageSize;
		this.last = last;
	}

	public PageResponse() {
		super();
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	@Override
	public String toString() {
		return "PageResponse [content=" + content + ", totalPages=" + totalPages + ", totalElements=" + totalElements
				+ ", pageSize=" + pageSize + ", last=" + last + "]";
	}
	
}
