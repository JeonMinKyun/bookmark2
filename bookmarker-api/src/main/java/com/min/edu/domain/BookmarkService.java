package com.min.edu.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

	private final BookmarkRepository repository;
	
	private final BookmarkMapper bookmarkMapper; 
	
	@Transactional(readOnly = true)
	public  BookmarksDto/*List<Bookmark>*/ getBookmarks(Integer page){
		int pageNo = page<1 ? 0 : page-1;
		Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC,"createdAt");
//		return new BookmarksDto(repository.findAll(pageable));
		
//		Page<BookmarkDto> bookmarkPage = repository.findAll(pageable).map(boomark -> bookmarkMapper.toDto(boomark));
		Page<BookmarkDto> bookmarkPage = repository.findByBookmarks(pageable);
		return new BookmarksDto(bookmarkPage);
		
	}
}
