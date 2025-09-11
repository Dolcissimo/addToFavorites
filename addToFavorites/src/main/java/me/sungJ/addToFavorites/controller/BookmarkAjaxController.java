package me.sungJ.addToFavorites.controller;

import me.sungJ.addToFavorites.domain.Bookmark;
import me.sungJ.addToFavorites.repository.BookmarkRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookmarkAjaxController {

    private final BookmarkRepository bookmarkRepository;

    // 생성자 주입
    public BookmarkAjaxController(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    // 등록, DB 저장
    @PostMapping("/bookmark")
    public String registerBookmark(@RequestBody Bookmark bookmark) {
        bookmarkRepository.save(bookmark);   // DB에 저장
        return "등록되었습니다.";
    }

    // 조회, DB에서 가져오기
    @GetMapping("/bookmarkList")
    public List<Bookmark> getBookmarkList() {
        return bookmarkRepository.findAll(); // DB에서 조회
    }

    // 삭제, DB에서 삭제
    @DeleteMapping("/bookmark/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable Long id) {
        bookmarkRepository.deleteById(id);   // DB에서 삭제
        return ResponseEntity.ok().build();
    }

    //수정
    @PutMapping("/bookmark/{id}")
    public ResponseEntity<Bookmark> updateBookmark(@PathVariable Long id,
                                                   @RequestBody Bookmark updatedBookmark) {
        return bookmarkRepository.findById(id)
                .map(bookmark -> {
                    bookmark.setName(updatedBookmark.getName());
                    bookmark.setUrl(updatedBookmark.getUrl());
                    Bookmark saved = bookmarkRepository.save(bookmark);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }




}
