package com.syncode.submission2.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class MoviesModel implements Parcelable {

    private String title;
    private String date;
    private String description;
    private int img;
    private int score;
    private String runtime;


    public String getRuntime() {
        return runtime;
    }

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getScore() {
        return score;
    }

    public MoviesModel(String title, int img, String date, String description, int score, String runtime) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.img = img;
        this.score = score;
        this.runtime = runtime;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.description);
        dest.writeInt(this.img);
        dest.writeInt(this.score);
        dest.writeString(this.runtime);

    }

    protected MoviesModel(Parcel in) {
        this.title = in.readString();
        this.date = in.readString();
        this.description = in.readString();
        this.img = in.readInt();
        this.score = in.readInt();
        this.runtime = in.readString();

    }


    public static final Parcelable.Creator<MoviesModel> CREATOR = new Parcelable.Creator<MoviesModel>() {
        @Override
        public MoviesModel createFromParcel(Parcel source) {
            return new MoviesModel(source);
        }

        @Override
        public MoviesModel[] newArray(int size) {
            return new MoviesModel[size];
        }
    };
}

