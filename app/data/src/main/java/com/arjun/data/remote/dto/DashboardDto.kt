package com.arjun.data.remote.dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class DashboardDto(
    @SerializedName("api") val api: Api?,
    @SerializedName("appVersion") val appVersion: String?,
    @SerializedName("data") val `data`: Data?,
    @SerializedName("errors") val errors: List<Any?>?,
    @SerializedName("etag") val etag: String?,
    @SerializedName("httpMethod") val httpMethod: String?,
    @SerializedName("lastModified") val lastModified: String?,
    @SerializedName("statusCode") val statusCode: Int?,
    @SerializedName("userId") val userId: String?
) {
    @Keep
    data class Api(
        @SerializedName("name") val name: String?,
        @SerializedName("version") val version: String?
    )

    @Keep
    data class Data(
        @SerializedName("today") val today: Today?,
        @SerializedName("trackerLastSyncAt") val trackerLastSyncAt: String?
    ) {
        @Keep
        data class Today(
            @SerializedName("addonStatusInfo") val addonStatusInfo: Any?,
            @SerializedName("dls") val dls: Dls?,
            @SerializedName("score") val score: Score?,
            @SerializedName("supplements") val supplements: Supplements?,
            @SerializedName("userAddedSupplements") val userAddedSupplements: List<UserAddedSupplement?>?
        ) {
            @Keep
            data class Dls(
                @SerializedName("data") val `data`: List<Data?>?,
                @SerializedName("icon") val icon: String?,
                @SerializedName("others") val others: List<Other?>?,
                @SerializedName("shouldSync") val shouldSync: Boolean?,
                @SerializedName("source") val source: String?
            ) {
                @Keep
                data class Data(
                    @SerializedName("band") val band: String?,
                    @SerializedName("icon") val icon: String?,
                    @SerializedName("measurement") val measurement: Measurement?,
                    @SerializedName("name") val name: String?,
                    @SerializedName("references") val references: List<Reference?>?,
                    @SerializedName("text") val text: Any?,
                    @SerializedName("title") val title: String?,
                    @SerializedName("unit") val unit: String?,
                    @SerializedName("value") val value: String?
                ) {
                    @Keep
                    data class Measurement(
                        @SerializedName("description") val description: String?,
                        @SerializedName("icon") val icon: String?,
                        @SerializedName("options") val options: List<Option?>?,
                        @SerializedName("title") val title: String?
                    ) {
                        @Keep
                        data class Option(
                            @SerializedName("bucket") val bucket: String?,
                            @SerializedName("selected") val selected: Boolean?,
                            @SerializedName("text") val text: String?
                        )
                    }

                    @Keep
                    data class Reference(
                        @SerializedName("icon") val icon: Any?,
                        @SerializedName("title") val title: String?,
                        @SerializedName("url") val url: String?
                    )
                }

                @Keep
                data class Other(
                    @SerializedName("band") val band: String?,
                    @SerializedName("icon") val icon: String?,
                    @SerializedName("measurement") val measurement: Measurement?,
                    @SerializedName("name") val name: String?,
                    @SerializedName("references") val references: List<Reference?>?,
                    @SerializedName("text") val text: Any?,
                    @SerializedName("title") val title: String?,
                    @SerializedName("unit") val unit: String?,
                    @SerializedName("value") val value: String?
                ) {
                    @Keep
                    data class Measurement(
                        @SerializedName("description") val description: String?,
                        @SerializedName("icon") val icon: String?,
                        @SerializedName("options") val options: List<Option?>?,
                        @SerializedName("title") val title: String?
                    ) {
                        @Keep
                        data class Option(
                            @SerializedName("bucket") val bucket: String?,
                            @SerializedName("selected") val selected: Boolean?,
                            @SerializedName("text") val text: String?
                        )
                    }

                    @Keep
                    data class Reference(
                        @SerializedName("icon") val icon: Any?,
                        @SerializedName("title") val title: String?,
                        @SerializedName("url") val url: String?
                    )
                }
            }

            @Keep
            data class Score(
                @SerializedName("consumption") val consumption: Consumption?,
                @SerializedName("dls") val dls: Dls?,
                @SerializedName("overall") val overall: Overall?,
                @SerializedName("profilePic") val profilePic: String?
            ) {
                @Keep
                data class Consumption(
                    @SerializedName("band") val band: String?,
                    @SerializedName("score") val score: Int?
                )

                @Keep
                data class Dls(
                    @SerializedName("band") val band: String?,
                    @SerializedName("score") val score: Int?
                )

                @Keep
                data class Overall(
                    @SerializedName("band") val band: String?,
                    @SerializedName("score") val score: Int?
                )
            }

            @Keep
            data class Supplements(
                @SerializedName("all") val all: List<All?>?,
                @SerializedName("foundation") val foundation: List<Any?>?,
                @SerializedName("others") val others: List<Any?>?,
                @SerializedName("supplementStatusInfo") val supplementStatusInfo: Any?
            ) {
                @Keep
                data class All(
                    @SerializedName("active") val active: Boolean?,
                    @SerializedName("brand") val brand: String?,
                    @SerializedName("consumed") val consumed: Boolean?,
                    @SerializedName("consumption") val consumption: List<Any?>?,
                    @SerializedName("consumptionWithType") val consumptionWithType: List<Any?>?,
                    @SerializedName("foundation") val foundation: Boolean?,
                    @SerializedName("id") val id: String?,
                    @SerializedName("image") val image: String?,
                    @SerializedName("lastSyncedAt") val lastSyncedAt: String?,
                    @SerializedName("level") val level: Int?,
                    @SerializedName("name") val name: String?,
                    @SerializedName("productId") val productId: String?,
                    @SerializedName("regimen") val regimen: Regimen?,
                    @SerializedName("status") val status: String?
                ) {
                    @Keep
                    data class Regimen(
                        @SerializedName("briefDesc") val briefDesc: Any?,
                        @SerializedName("category") val category: Any?,
                        @SerializedName("categoryIcon") val categoryIcon: Any?,
                        @SerializedName("description") val description: String?,
                        @SerializedName("fillPct") val fillPct: Int?,
                        @SerializedName("foodCode") val foodCode: String?,
                        @SerializedName("name") val name: String?,
                        @SerializedName("pausePct") val pausePct: Int?,
                        @SerializedName("required") val required: Boolean?,
                        @SerializedName("servingSize") val servingSize: Int?,
                        @SerializedName("servingUnit") val servingUnit: String?,
                        @SerializedName("split") val split: Boolean?,
                        @SerializedName("status") val status: String?,
                        @SerializedName("timeCode") val timeCode: String?,
                        @SerializedName("type") val type: String?,
                        @SerializedName("typeDesc") val typeDesc: String?
                    )
                }
            }

            @Keep
            data class UserAddedSupplement(
                @SerializedName("canConsume") val canConsume: Boolean?,
                @SerializedName("consumed") val consumed: Boolean?,
                @SerializedName("dataNotAvailable") val dataNotAvailable: Boolean?,
                @SerializedName("id") val id: String?,
                @SerializedName("noDataResponse") val noDataResponse: Any?,
                @SerializedName("product") val product: Product?,
                @SerializedName("regimen") val regimen: Regimen?,
                @SerializedName("showInfoIcon") val showInfoIcon: Boolean?
            ) {
                @Keep
                data class Product(
                    @SerializedName("brand") val brand: String?,
                    @SerializedName("category") val category: String?,
                    @SerializedName("id") val id: String?,
                    @SerializedName("imageLink") val imageLink: String?,
                    @SerializedName("name") val name: String?,
                    @SerializedName("netQuantity") val netQuantity: Int?,
                    @SerializedName("netQuantityUnit") val netQuantityUnit: String?,
                    @SerializedName("servingSize") val servingSize: Int?,
                    @SerializedName("servingUnit") val servingUnit: String?,
                    @SerializedName("source") val source: String?
                )

                @Keep
                data class Regimen(
                    @SerializedName("briefDesc") val briefDesc: Any?,
                    @SerializedName("category") val category: Any?,
                    @SerializedName("categoryIcon") val categoryIcon: Any?,
                    @SerializedName("description") val description: String?,
                    @SerializedName("fillPct") val fillPct: Any?,
                    @SerializedName("foodCode") val foodCode: String?,
                    @SerializedName("name") val name: String?,
                    @SerializedName("pausePct") val pausePct: Int?,
                    @SerializedName("required") val required: Boolean?,
                    @SerializedName("servingSize") val servingSize: Int?,
                    @SerializedName("servingUnit") val servingUnit: String?,
                    @SerializedName("split") val split: Boolean?,
                    @SerializedName("status") val status: String?,
                    @SerializedName("timeCode") val timeCode: String?,
                    @SerializedName("type") val type: String?,
                    @SerializedName("typeDesc") val typeDesc: String?
                )
            }
        }
    }
}