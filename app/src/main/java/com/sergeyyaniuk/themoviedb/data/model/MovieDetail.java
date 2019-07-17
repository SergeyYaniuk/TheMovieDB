package com.sergeyyaniuk.themoviedb.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

@Entity(tableName = "movie_detail")
public class MovieDetail {

    @ColumnInfo(name = "adult")
    @SerializedName("adult")
    @Expose
    private boolean adult;

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;

    @Ignore
    @SerializedName("belongs_to_collection")
    @Expose
    private BelongsToCollection belongsToCollection;

    @ColumnInfo(name = "budget")
    @SerializedName("budget")
    @Expose
    private int budget;

    @Ignore
    @SerializedName("genres")
    @Expose
    private List<Genre> genres;

    @ColumnInfo(name = "homepage")
    @SerializedName("homepage")
    @Expose
    private String homepage;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private int id;

    @ColumnInfo(name = "imdb_id")
    @SerializedName("imdb_id")
    @Expose
    private String imdbId;

    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    @Expose
    private String originalTitle;

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    @Expose
    private String overview;

    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    @Expose
    private double popularity;

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    @Ignore
    @SerializedName("production_companies")
    @Expose
    private List<ProductionCompany> productionCompanies;

    @Ignore
    @SerializedName("production_countries")
    @Expose
    private List<ProductionCountry> productionCountries;

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @ColumnInfo(name = "revenue")
    @SerializedName("revenue")
    @Expose
    private int revenue;

    @ColumnInfo(name = "runtime")
    @SerializedName("runtime")
    @Expose
    private int runtime;

    @Ignore
    @SerializedName("spoken_languages")
    @Expose
    private List<SpokenLanguage> spokenLanguages;

    @ColumnInfo(name = "status")
    @SerializedName("status")
    @Expose
    private String status;

    @ColumnInfo(name = "tagline")
    @SerializedName("tagline")
    @Expose
    private String tagline;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    private String title;

    @ColumnInfo(name = "video")
    @SerializedName("video")
    @Expose
    private boolean video;

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    @Expose
    private double voteAverage;

    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    @Expose
    private int voteCount;

    @Ignore
    public MovieDetail(boolean adult, String backdropPath, BelongsToCollection belongsToCollection,
                       int budget, List<Genre> genres, String homepage, @NonNull int id, String imdbId,
                       String originalLanguage, String originalTitle, String overview, double popularity,
                       String posterPath, List<ProductionCompany> productionCompanies, List<ProductionCountry> productionCountries,
                       String releaseDate, int revenue, int runtime, List<SpokenLanguage> spokenLanguages, String status,
                       String tagline, String title, boolean video, double voteAverage, int voteCount) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.belongsToCollection = belongsToCollection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public MovieDetail(boolean adult, String backdropPath, int budget, String homepage, int id,
                       String imdbId, String originalLanguage, String originalTitle, String overview,
                       double popularity, String posterPath, String releaseDate, int revenue, int runtime,
                       String status, String tagline, String title, boolean video, double voteAverage, int voteCount) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.budget = budget;
        this.homepage = homepage;
        this.id = id;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public BelongsToCollection getBelongsToCollection() {
        return belongsToCollection;
    }

    public int getBudget() {
        return budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getRevenue() {
        return revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDetail that = (MovieDetail) o;
        return adult == that.adult &&
                budget == that.budget &&
                id == that.id &&
                Double.compare(that.popularity, popularity) == 0 &&
                revenue == that.revenue &&
                runtime == that.runtime &&
                video == that.video &&
                Double.compare(that.voteAverage, voteAverage) == 0 &&
                voteCount == that.voteCount &&
                Objects.equals(backdropPath, that.backdropPath) &&
                Objects.equals(belongsToCollection, that.belongsToCollection) &&
                Objects.equals(genres, that.genres) &&
                Objects.equals(homepage, that.homepage) &&
                Objects.equals(imdbId, that.imdbId) &&
                Objects.equals(originalLanguage, that.originalLanguage) &&
                Objects.equals(originalTitle, that.originalTitle) &&
                Objects.equals(overview, that.overview) &&
                Objects.equals(posterPath, that.posterPath) &&
                Objects.equals(productionCompanies, that.productionCompanies) &&
                Objects.equals(productionCountries, that.productionCountries) &&
                Objects.equals(releaseDate, that.releaseDate) &&
                Objects.equals(spokenLanguages, that.spokenLanguages) &&
                Objects.equals(status, that.status) &&
                Objects.equals(tagline, that.tagline) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adult, backdropPath, belongsToCollection, budget, genres, homepage, id, imdbId, originalLanguage, originalTitle, overview, popularity, posterPath, productionCompanies, productionCountries, releaseDate, revenue, runtime, spokenLanguages, status, tagline, title, video, voteAverage, voteCount);
    }
}
