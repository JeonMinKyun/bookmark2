package com.min.edu.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

	
	@Query("""
			select new com.min.edu.domain.BookmarkDto(b.id, b.title, b.url, b.createdAt) from Bookmark b
			""")
	Page<BookmarkDto> findByBookmarks(Pageable pageable);
}
