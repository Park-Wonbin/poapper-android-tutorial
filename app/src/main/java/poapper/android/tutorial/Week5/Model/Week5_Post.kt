package poapper.android.tutorial.Week3.Model

import com.google.gson.annotations.SerializedName

data class Week5_Post (
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String? = null,
    @SerializedName("link") var link: String? = null,
    @SerializedName("items") var items: ArrayList<Week5_Item>? = null
)

data class Week5_Item (
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String,
    @SerializedName("enclosures") var enclosures: ArrayList<Week5_Enclosures>? = null
)

data class Week5_Enclosures (
    @SerializedName("url") var url: String,
    @SerializedName("type") var type: String
)