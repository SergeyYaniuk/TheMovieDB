package com.sergeyyaniuk.themoviedb.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

@Entity(tableName = "movie")
public class Movie {

    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    @Expose
    private int voteCount;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private int id;

    @ColumnInfo(name = "video")
    @SerializedName("video")
    @Expose
    private boolean video;

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    @Expose
    private double voteAverage;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    private String title;

    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    @Expose
    private double popularity;

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    @Expose
    private String originalTitle;

    @Ignore
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds;

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;

    @ColumnInfo(name = "adult")
    @SerializedName("adult")
    @Expose
    private boolean adult;

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    @Expose
    private String overview;

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @Ignore
    public Movie(int voteCount, int id, boolean video, double voteAverage, String title,
                 double popularity, String posterPath, String originalLanguage, String originalTitle,
                 List<Integer> genreIds, String backdropPath, boolean adult, String overview, String releaseDate) {
        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.genreIds = genreIds;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public Movie(int voteCount, int id, boolean video, double voteAverage, String title, double popularity,
                 String posterPath, String originalLanguage, String originalTitle, String backdropPath,
                 boolean adult, String overview, String releaseDate) {
        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public int getId() {
        return id;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return voteCount == movie.voteCount &&
                id == movie.id &&
                video == movie.video &&
                Double.compare(movie.voteAverage, voteAverage) == 0 &&
                Double.compare(movie.popularity, popularity) == 0 &&
                adult == movie.adult &&
                Objects.equals(title, movie.title) &&
                Objects.equals(posterPath, movie.posterPath) &&
                Objects.equals(originalLanguage, movie.originalLanguage) &&
                Objects.equals(originalTitle, movie.originalTitle) &&
                Objects.equals(genreIds, movie.genreIds) &&
                Objects.equals(backdropPath, movie.backdropPath) &&
                Objects.equals(overview, movie.overview) &&
                Objects.equals(releaseDate, movie.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voteCount, id, video, voteAverage, title, popularity, posterPath, originalLanguage, originalTitle, genreIds, backdropPath, adult, overview, releaseDate);
    }
}
