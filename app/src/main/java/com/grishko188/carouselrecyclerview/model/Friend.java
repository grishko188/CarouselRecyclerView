package com.grishko188.carouselrecyclerview.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.grishko188.carouselrecyclerview.utils.AssetHelper;
import com.umojo.gson.annotations.SerializedName;

/**
 * Created by Unreal Mojo
 *
 * @author Grishko Nikita
 *         on 11.08.2016.
 */
public class Friend implements Parcelable {

    protected long id;
    protected String gender;
    @SerializedName("first_name")
    protected String firstName;
    @SerializedName("last_name")
    protected String lastName;
    protected String fullName;
    protected String email;
    protected String country;
    protected String phone;
    protected String photo;
    protected boolean online;
    protected boolean favorite;

    public Friend() {
    }


    protected Friend(Parcel in) {
        id = in.readLong();
        gender = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        fullName = in.readString();
        email = in.readString();
        country = in.readString();
        phone = in.readString();
        photo = in.readString();
        online = in.readByte() != 0;
        favorite = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(gender);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(fullName);
        dest.writeString(email);
        dest.writeString(country);
        dest.writeString(phone);
        dest.writeString(photo);
        dest.writeByte((byte) (online ? 1 : 0));
        dest.writeByte((byte) (favorite ? 1 : 0));
    }

    public static final Creator<Friend> CREATOR = new Creator<Friend>() {
        @Override
        public Friend createFromParcel(Parcel in) {
            return new Friend(in);
        }

        @Override
        public Friend[] newArray(int size) {
            return new Friend[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean hasPhoto() {
        return !TextUtils.isEmpty(photo);
    }

    public String getPhoto() {
        return AssetHelper.getPhotoPath(photo);
    }

    @Override
    public String toString() {
        return "Friend{" +
                "fullName='" + fullName + '\'' +
                ", id=" + id +
                ", online=" + online +
                ", favorite=" + favorite +
                '}';
    }
}

