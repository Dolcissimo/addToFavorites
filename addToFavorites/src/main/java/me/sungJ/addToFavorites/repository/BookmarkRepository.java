package me.sungJ.addToFavorites.repository;

import me.sungJ.addToFavorites.domain.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    }
