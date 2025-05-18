package com.min.edu.domain;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

	private final BookmarkService bookmarkService;
	
	@GetMapping
	public BookmarksDto /*List<Bookmark>*/ getBookmark(@RequestParam(name = "page", defaultValue = "1") Integer page){
		return bookmarkService.getBookmarks(page);
	}
}
