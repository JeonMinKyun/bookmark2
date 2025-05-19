package com.min.edu.domain;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
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
	
	@Transactional(readOnly = true)
	public BookmarksDto searchBookmarks(Integer page, String query) {
		int pageNo = page<1 ? 0 : page-1;
		Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC,"createdAt");
		Page<BookmarkDto> bookmarkPage = repository.searchBookmarks(query,pageable);
		
		Page<BookmarkVM> bookmarkPageVMPage = repository.findByTitleContainsIgnoreCase(query,pageable);
		System.out.println("인터페이스 기반의 프로적션 객체:"+bookmarkPageVMPage);
		System.out.println("인터페이스 기반의 프로적션 객체:"+bookmarkPageVMPage.getContent().get(0).getTitle());
		return new BookmarksDto(bookmarkPage);
	}

	public BookmarkDto createBookmark(@Valid CreatedBookRequest request) {
		Bookmark bookmark = new Bookmark(null, request.getTitle(), request.getUrl(), Instant.now());
		Bookmark saveBookmark = repository.save(bookmark);
		return bookmarkMapper.toDto(saveBookmark);
	}
}





















