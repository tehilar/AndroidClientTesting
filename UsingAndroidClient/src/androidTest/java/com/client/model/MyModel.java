package com.client.model;

import android.os.Parcel;

import com.kaltura.client.types.MediaAsset;
import com.kaltura.client.types.ObjectBase;

/**
 * Created by tehila.rozin on 8/1/17.
 */

public class MyModel extends ObjectBase {

    int myInt;
    long myLong;
    double myDouble;
    String myString;
    boolean myBoolean;

    byte[] myBytes;
    MediaAsset myAsset;

    MyClassModel myClassModel;

    MyEnumModel myEnumModel;

    public enum MyEnumModel{
        myEnum1, myEnum2
    }

    public MyModel() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.myInt);
        dest.writeLong(this.myLong);
        dest.writeDouble(this.myDouble);
        dest.writeString(this.myString);
        dest.writeByte(this.myBoolean ? (byte) 1 : (byte) 0);
        dest.writeByteArray(this.myBytes);
        //dest.writeSerializable(this.myAsset);
        dest.writeParcelable(this.myClassModel, flags);
        dest.writeInt(this.myEnumModel == null ? -1 : this.myEnumModel.ordinal());
    }

    protected MyModel(Parcel in) {
        super(in);
        this.myInt = in.readInt();
        this.myLong = in.readLong();
        this.myDouble = in.readDouble();
        this.myString = in.readString();
        this.myBoolean = in.readByte() != 0;
        this.myBytes = in.createByteArray();
        //this.myAsset = (MediaAsset) in.readSerializable();
        this.myClassModel = in.readParcelable(MyClassModel.class.getClassLoader());
        int tmpMyEnumModel = in.readInt();
        this.myEnumModel = tmpMyEnumModel == -1 ? null : MyEnumModel.values()[tmpMyEnumModel];
    }

    public static final Creator<MyModel> CREATOR = new Creator<MyModel>() {
        @Override
        public MyModel createFromParcel(Parcel source) {
            return new MyModel(source);
        }

        @Override
        public MyModel[] newArray(int size) {
            return new MyModel[size];
        }
    };
}
