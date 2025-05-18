package com.min.edu.domain;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookmarksDto {

	private List<BookmarkDto> data;
	private long totalElements;
	private int totalPage;
	private int currentPage;
	@JsonProperty(value = "isFirst")
	private boolean isFirst;
	@JsonProperty(value = "isLast")
	private boolean isLast;
	private boolean hasNext;
	private boolean hasPrevious;
	
	public BookmarksDto(Page<BookmarkDto> bookmarkPage) {
		this.setData(bookmarkPage.getContent());
		this.setTotalElements(bookmarkPage.getTotalElements());
		this.setTotalPage(bookmarkPage.getTotalPages());
		this.setCurrentPage(bookmarkPage.getNumber()+1);
		this.setFirst(bookmarkPage.isFirst());
		this.setLast(bookmarkPage.isLast());
		this.setHasNext(bookmarkPage.hasNext());
		this.setHasPrevious(bookmarkPage.hasPrevious());
	
	}	
}
