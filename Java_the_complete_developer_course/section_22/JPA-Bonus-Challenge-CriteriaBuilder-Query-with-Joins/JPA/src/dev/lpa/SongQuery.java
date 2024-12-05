package dev.lpa;

import dev.lpa.music.Album;
import dev.lpa.music.Artist;
import dev.lpa.music.Song;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.*;

import java.util.List;

public class SongQuery {

    public static void main(String[] args) {

        try (
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                        "dev.lpa.music");
                EntityManager em = emf.createEntityManager();
        ) {

            String dashedString = "-".repeat(19);
            String word = "Soul";
            var matches = getMatchedSongs(em, "%" + word + "%");
            System.out.printf("%-30s %-65s %s%n", "Artist", "Album", "Song Title");
            System.out.printf("%1$-30s %1$-65s %1$s%n", dashedString);

            matches.forEach(a -> {
                String artistName = a.getArtistName();
                a.getAlbums().forEach(b -> {
                    String albumName = b.getAlbumName();
                    b.getPlayList().forEach(s -> {
                        String songTitle = s.getSongTitle();
                        if (songTitle.contains(word)) {
                            System.out.printf("%-30s %-65s %s%n",
                                    artistName, albumName, songTitle);
                        }
                    });
                });
            });

            System.out.printf("%-30s %-65s %s%n", "Artist", "Album", "Song Title");
            System.out.printf("%1$-30s %1$-65s %1$s%n", dashedString);
            var bmatches = getMatchedSongsBuilder(em,
                    "%" + word + "%");
            bmatches.forEach(m ->
                    System.out.printf("%-30s %-65s %s%n",
                            (String) m[0], (String) m[1], (String) m[2])
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Artist> getMatchedSongs(EntityManager em, String matchedValue) {

        String jpql = "SELECT a FROM Artist a JOIN albums album join playList p" +
                " WHERE p.songTitle LIKE ?1 ";
        var query = em.createQuery(jpql, Artist.class);
        query.setParameter(1, matchedValue);
        return query.getResultList();
    }

    private static List<Object[]> getMatchedSongsBuilder(EntityManager entityManager,
                                                         String matchedValue) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root<Artist> root = query.from(Artist.class);
        Join<Artist, Album> albumJoin = root.join("albums", JoinType.INNER);
        Join<Album, Song> songJoin = albumJoin.join("playList", JoinType.INNER);

        query
                .multiselect(
                        root.get("artistName"),
                        albumJoin.get("albumName"),
                        songJoin.get("songTitle")
                )
                .where(builder.like(songJoin.get("songTitle"), matchedValue))
                .orderBy(builder.asc(root.get("artistName")));

        return entityManager.createQuery(query).getResultList();
    }
}
