package me.sungJ.addToFavorites.controller;

import me.sungJ.addToFavorites.domain.Bookmark;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookmarkAjaxController {

    private List<Bookmark> bookmarkList = new ArrayList<>();

    @RequestMapping(method = RequestMethod.POST, path= "/bookmark")
    public String registerBookmark(@RequestBody Bookmark bookmark) {
        bookmarkList.add(bookmark);
        return "등록되었습니다.";
    }

    @RequestMapping(method = RequestMethod.GET, path="/bookmarkList")
    public List<Bookmark> getBookmarkList() {
        return bookmarkList;
    }
}
