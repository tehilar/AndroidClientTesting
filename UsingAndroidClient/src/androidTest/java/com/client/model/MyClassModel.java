package com.client.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tehila.rozin on 8/1/17.
 */
public class MyClassModel implements Parcelable{
    int myClassModelInt;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.myClassModelInt);
    }

    public MyClassModel() {
    }

    protected MyClassModel(Parcel in) {
        this.myClassModelInt = in.readInt();
    }

    public static final Creator<MyClassModel> CREATOR = new Creator<MyClassModel>() {
        @Override
        public MyClassModel createFromParcel(Parcel source) {
            return new MyClassModel(source);
        }

        @Override
        public MyClassModel[] newArray(int size) {
            return new MyClassModel[size];
        }
    };
}
