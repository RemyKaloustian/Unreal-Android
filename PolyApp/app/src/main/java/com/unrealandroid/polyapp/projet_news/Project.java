package com.unrealandroid.polyapp.projet_news;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

/**
 * Created by Charly on 04/04/2016.
 */

/**
 * Project implements Parcelable in order to be able to put a Project into an intent's extras.
 */
public class Project implements Parcelable{

    private String title, content, imagePath, participants;
    private int id;
    private Bitmap bitmap;

    public Project(int id, String content, String imagePath, String title, String participants) {

        this.content = content;
        this.id = id;
        this.imagePath = imagePath;
        this.title = title;
        this.participants = participants;
    }

    protected Project(Parcel in) {
        title = in.readString();
        content = in.readString();
        imagePath = in.readString();
        participants = in.readString();
        id = in.readInt();
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return imagePath;
    }

    public String getParticipants() { return participants; }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        /***** Defining them in the order of declaration otherwise it's wrong *****/

        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(imagePath);
        dest.writeString(participants);
        dest.writeInt(id);
    }
}
