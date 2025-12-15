package sanji.ko.productlist.data

import android.os.Parcel
import android.os.Parcelable

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeDouble(price)
        parcel.writeString(description)
        parcel.writeString(category)
        parcel.writeString(image)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product = Product(parcel)
        override fun newArray(size: Int): Array<Product?> = arrayOfNulls(size)
    }
}
