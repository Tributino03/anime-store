package app.repository;

import app.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}