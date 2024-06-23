package com.arjun.data.remote.dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class RegimeDto(
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
        @SerializedName("config") val config: Config?,
        @SerializedName("consumptionDisabledText") val consumptionDisabledText: Any?,
        @SerializedName("enableConsumption") val enableConsumption: Boolean?,
        @SerializedName("itemsToConsume") val itemsToConsume: List<ItemsToConsume?>?,
        @SerializedName("status") val status: String?,
        @SerializedName("statusInfo") val statusInfo: Any?
    ) {
        @Keep
        data class Config(
            @SerializedName("dock") val dock: Boolean?,
            @SerializedName("showVideo") val showVideo: Boolean?,
            @SerializedName("videoUrl") val videoUrl: String?
        )

        @Keep
        data class ItemsToConsume(
            @SerializedName("code") val code: String?,
            @SerializedName("completed") val completed: Boolean?,
            @SerializedName("items") val items: List<Item?>?,
            @SerializedName("regular") val regular: Boolean?,
            @SerializedName("title") val title: String?
        ) {
            @Keep
            data class Item(
                @SerializedName("canPause") val canPause: Boolean?,
                @SerializedName("canReorder") val canReorder: Boolean?,
                @SerializedName("consumptions") val consumptions: List<Consumption?>?,
                @SerializedName("dataNotAvailable") val dataNotAvailable: Boolean?,
                @SerializedName("fillIcon") val fillIcon: String?,
                @SerializedName("fillPct") val fillPct: Int?,
                @SerializedName("infoText") val infoText: String?,
                @SerializedName("interactions") val interactions: List<Interaction?>?,
                @SerializedName("latestConsumption") val latestConsumption: LatestConsumption?,
                @SerializedName("maxServingSize") val maxServingSize: Int?,
                @SerializedName("minServingSize") val minServingSize: Int?,
                @SerializedName("noDataResponse") val noDataResponse: Any?,
                @SerializedName("product") val product: Product?,
                @SerializedName("shippingInDays") val shippingInDays: Any?,
                @SerializedName("showInfoIcon") val showInfoIcon: Boolean?,
                @SerializedName("todayConsumption") val todayConsumption: TodayConsumption?
            ) {
                @Keep
                data class Consumption(
                    @SerializedName("date") val date: String?,
                    @SerializedName("dosage") val dosage: Int?,
                    @SerializedName("qualifier") val qualifier: Any?,
                    @SerializedName("text") val text: Any?,
                    @SerializedName("time") val time: String?,
                    @SerializedName("timestamp") val timestamp: String?,
                    @SerializedName("type") val type: String?,
                    @SerializedName("unit") val unit: String?
                )

                @Keep
                data class Interaction(
                    @SerializedName("count") val count: Int?,
                    @SerializedName("icon") val icon: String?,
                    @SerializedName("text") val text: String?,
                    @SerializedName("type") val type: String?
                )

                @Keep
                data class LatestConsumption(
                    @SerializedName("date") val date: String?,
                    @SerializedName("dosage") val dosage: Int?,
                    @SerializedName("qualifier") val qualifier: Any?,
                    @SerializedName("text") val text: Any?,
                    @SerializedName("time") val time: String?,
                    @SerializedName("timestamp") val timestamp: String?,
                    @SerializedName("type") val type: String?,
                    @SerializedName("unit") val unit: String?
                )

                @Keep
                data class Product(
                    @SerializedName("active") val active: Boolean?,
                    @SerializedName("brand") val brand: String?,
                    @SerializedName("consumed") val consumed: Boolean?,
                    @SerializedName("consumption") val consumption: List<Any?>?,
                    @SerializedName("consumptionWithType") val consumptionWithType: List<Any?>?,
                    @SerializedName("foundation") val foundation: Boolean?,
                    @SerializedName("id") val id: String?,
                    @SerializedName("image") val image: String?,
                    @SerializedName("lastSyncedAt") val lastSyncedAt: String?,
                    @SerializedName("level") val level: Any?,
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

                @Keep
                data class TodayConsumption(
                    @SerializedName("date") val date: String?,
                    @SerializedName("dosage") val dosage: Int?,
                    @SerializedName("qualifier") val qualifier: Any?,
                    @SerializedName("text") val text: Any?,
                    @SerializedName("time") val time: String?,
                    @SerializedName("timestamp") val timestamp: String?,
                    @SerializedName("type") val type: String?,
                    @SerializedName("unit") val unit: String?
                )
            }
        }
    }
}