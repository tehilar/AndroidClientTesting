package com.client.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.kaltura.client.types.MediaAsset;
import com.kaltura.client.types.ObjectBase;

/**
 * Created by tehila.rozin on 8/1/17.
 */

public class MyModel extends ObjectBase implements Parcelable {

    int myInt;
    long myLong;
    double myDouble;
    String myString;
    boolean myBoolean;

    byte[] myBytes;
    MediaAsset myAsset;

    public enum MyEnumModel{
        myEnum1, myEnum2
    }

    public MyModel() {
    }

    protected MyModel(Parcel in) {
        myAsset = (MediaAsset) in.readSerializable();
    }

    public static final Creator<MyModel> CREATOR = new Creator<MyModel>() {
        @Override
        public MyModel createFromParcel(Parcel in) {
            return new MyModel(in);
        }

        @Override
        public MyModel[] newArray(int size) {
            return new MyModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {

        /*dest.writeInt(myInt);
        dest.writeDouble(myDouble);
        dest.writeLong(myLong);
        dest.writeString(myString);


        dest.writeIntArray(new int[]{});
        dest.writeByteArray(myBytes);
        dest.writeException(new APIException());*/
        dest.writeSerializable(myAsset);

    }
}
