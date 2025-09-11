package me.sungJ.addToFavorites.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //PK 자동 증가
    private Long id;

    private String name;
    private String url;

    //JPA가 필수적으로 사용하는 기본 생성자
    public Bookmark() {}

    public Bookmark(String name, String url) {
        this.name = name;
        this.url = url;
    }



    public Long getId() { return id; }
    public String getName() { return name; }
    public String getUrl() { return url; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setUrl(String url) { this.url = url; }
}
