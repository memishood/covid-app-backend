package com.covidapp.model

/**
 * @author emremms35@gmail.com
 */

data class Response(
    val success_status: Boolean? = true,
    val gunluk_test: String? = null,
    val gunluk_vaka: String? = null,
    val gunluk_hasta: String? = null,
    val gunluk_vefat: String? = null,
    val gunluk_iyilesen: String? = null,
    val toplam_test: String? = null,
    val toplam_hasta: String? = null,
    val toplam_vefat: String? = null,
    val toplam_iyilesen: String? = null,
    val agir_hasta_sayisi: String? = null,
    var haberler: List<News>? = null
)